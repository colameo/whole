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
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.requests.LocationRequest;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.e4.ui.viewers.E4GraphicalViewer;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.editparts.IEntityPart;

/**
 * @author Enrico Persiani
 */
@SuppressWarnings("restriction")
public final class DirectEditAction extends AbstractE4Action {
	private static final  Request request = new LocationRequest(RequestConstants.REQ_DIRECT_EDIT);

	public DirectEditAction(IEclipseContext context) {
		super(context);
	}

	@Override
	public void update() {
		setEnabled(false);

		ESelectionService selectionService = getContext().get(ESelectionService.class);
		if (selectionService.getSelection() instanceof IBindingManager) {
			IBindingManager bm = (IBindingManager) selectionService.getSelection();
			if (bm.wIsSet("viewer")) {
				E4GraphicalViewer viewer = (E4GraphicalViewer) bm.wGetValue("viewer");
				IEntity primarySelectedEntity = bm.wGet("primarySelectedEntity");
				IEntityPart entityPart = viewer.getEditPartRegistry().get(primarySelectedEntity);
				setEnabled(entityPart.understandsRequest(request));
			}
		}
	}

	@Override
	public void run() {
		ESelectionService selectionService = getContext().get(ESelectionService.class);
		IBindingManager bm = (IBindingManager) selectionService.getSelection();
		E4GraphicalViewer viewer = (E4GraphicalViewer) bm.wGetValue("viewer");
		IEntity primarySelectedEntity = bm.wGet("primarySelectedEntity");
		IEntityPart entityPart = viewer.getEditPartRegistry().get(primarySelectedEntity);
		try {
			entityPart.performRequest(request);
		} catch (Exception e) {
			e.getCause();
		}
	}
}