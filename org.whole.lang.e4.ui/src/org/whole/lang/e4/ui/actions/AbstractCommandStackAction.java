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
package org.whole.lang.e4.ui.actions;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.gef.Disposable;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.commands.CommandStackEvent;
import org.eclipse.gef.commands.CommandStackEventListener;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.e4.ui.viewers.IEntityPartViewer;
import org.whole.lang.ui.actions.IActionRedirection;
import org.whole.lang.ui.actions.NullActionRedirection;
import org.whole.lang.ui.editparts.IEntityPart;

/**
 * @author Enrico Persiani
 */
@SuppressWarnings("restriction")
public abstract class AbstractCommandStackAction extends AbstractE4Action implements Disposable {
	protected IEntityPartViewer viewer;
	protected CommandStack trackingCommandStack;
	protected CommandStackEventListener listener;
	protected String label;

	public AbstractCommandStackAction(IEclipseContext context, String label) {
		super(context, label);
		this.label = label;
		this.viewer = context.get(IEntityPartViewer.class);
		track(viewer.getCommandStack());
	}

	public void track(CommandStack commandStack) {
		if (listener != null)
			trackingCommandStack.removeCommandStackEventListener(listener);

		trackingCommandStack = commandStack;
		trackingCommandStack.addCommandStackEventListener(listener = new CommandStackEventListener() {
			public void stackChanged(CommandStackEvent event) {
				if (event.isPostChangeEvent())
					update();
			}
		});
	}
	public void dispose() {
		if (viewer != null)
			viewer.getCommandStack().removeCommandStackEventListener(listener);
	}

	@Override
	public void run() {
		doRun(viewer);
	}

	public void update() {
		setEnabled(calculateEnabled(viewer));
		setText(calculateLabel(viewer));
	}

	protected IActionRedirection getActionRedirection() {
		Object selection = getContext().get(IServiceConstants.ACTIVE_SELECTION);
		if (!(selection instanceof IBindingManager))
			return NullActionRedirection.instance();

		IBindingManager bm = (IBindingManager) selection;
		if (!bm.wIsSet("primarySelectedEntity"))
			return NullActionRedirection.instance();

		IEntityPartViewer viewer = (IEntityPartViewer) ((IBindingManager) selection).wGetValue("viewer");
		IEntityPart entityPart = viewer.getEditPartRegistry().get(((IBindingManager) selection).wGet("primarySelectedEntity"));
		IActionRedirection actionRedirection = (IActionRedirection) entityPart.getAdapter(IActionRedirection.class);
		return actionRedirection != null ? actionRedirection : NullActionRedirection.instance();
	}

	protected abstract void doRun(IEntityPartViewer viewer);
	protected abstract boolean calculateEnabled(IEntityPartViewer viewer);
	protected abstract String calculateLabel(IEntityPartViewer viewer);
}