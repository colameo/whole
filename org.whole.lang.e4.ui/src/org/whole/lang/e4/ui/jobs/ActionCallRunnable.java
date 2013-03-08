/**
 * Copyright 2004-2013 Riccardo Solmi. All rights reserved.
 * This file is part of the Whole Platform.
 *
 * The Whole Platform is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * The Whole Platform is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.lang.e4.ui.jobs;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.di.UISynchronize;
import org.eclipse.gef.commands.CommandStack;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.commons.factories.CommonsEntityFactory;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.e4.ui.handler.HandlersBehavior;
import org.whole.lang.e4.ui.util.E4Utils;
import org.whole.lang.e4.ui.viewers.E4GraphicalViewer;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.IOperationProgressMonitor;
import org.whole.lang.operations.OperationCanceledException;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.ui.commands.ModelTransactionCommand;
import org.whole.lang.util.EntityUtils;

@SuppressWarnings("restriction")
public class ActionCallRunnable extends AbstractRunnableWithProgress {

	public ActionCallRunnable(IEclipseContext context, IBindingManager bm, String label, boolean delayUpdates) {
		super(context, bm, label, delayUpdates);
	}

	@Override
	public void run(IOperationProgressMonitor pm) throws InvocationTargetException, InterruptedException {
		IEntity model = bm.wGet("self");
		boolean analyzing = bm.wBooleanValue("analyzing");
		if (analyzing) {
			// clone model if is analyzing
			model = EntityUtils.clone(model);
			CommonsEntityFactory.instance.createRootFragment(
					model.wGetAdapter(CommonsEntityDescriptorEnum.Any));
			ReflectionFactory.getHistoryManager(model).setHistoryEnabled(true);

			// map selected entities if analyzing
			IEntity tuple = bm.wGet("selectedEntities");
			int size = tuple.wSize();
			for (int i = 0; i < size; i++)
				tuple.wSet(i, EntityUtils.mapEntity(tuple.wGet(i), model));
			bm.wSet("primarySelectedEntity", EntityUtils.mapEntity(bm.wGet("primarySelectedEntity"), model));
		}

		E4GraphicalViewer viewer = (E4GraphicalViewer) bm.wGetValue("viewer");
		CommandStack commandStack = viewer.getEditDomain().getCommandStack();
		ModelTransactionCommand mtc = new ModelTransactionCommand(model, label);

		pm.beginTask("executing action", 90, IOperationProgressMonitor.TOTAL_WORK);
		try {
			mtc.begin();
			HandlersBehavior.actionCall(bm);
			mtc.commit();
			if (analyzing) {
				E4Utils.revealResultsView(context.get(UISynchronize.class), bm, bm.getResult());
			} else if (mtc.canUndo())
				commandStack.execute(mtc);
		} catch (OperationCanceledException e) {
			mtc.rollback();
		} catch (RuntimeException e) {
			mtc.rollback();
			throw e;
		} finally {
			pm.endTask();
		}
	}
}