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
import org.eclipse.jface.viewers.StructuredSelection;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.e4.ui.viewers.E4GraphicalViewer;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.editparts.ITextualEntityPart;
import org.whole.lang.ui.tools.Tools;

/**
 * @author Enrico Persiani
 */
@SuppressWarnings("restriction")
public final class ActivateToolAction extends AbstractE4Action {
	private final Tools tool;

	public ActivateToolAction(IEclipseContext context, Tools tool) {
		super(context);
		this.tool = tool;
	}

	@Override
	public void update() {
		setEnabled(false);

		ESelectionService selectionService = getContext().get(ESelectionService.class);
		if (selectionService.getSelection() instanceof IBindingManager) {
			IBindingManager bm = (IBindingManager) selectionService.getSelection();
			setEnabled(bm.wIsSet("viewer"));
		}
	}

	@Override
	public void run() {
		ESelectionService selectionService = getContext().get(ESelectionService.class);
		IBindingManager bm = (IBindingManager) selectionService.getSelection();
		E4GraphicalViewer viewer = (E4GraphicalViewer) bm.wGetValue("viewer");
		boolean clearCaret = Tools.TEXTUAL != tool && Tools.TEXTUAL.isActive(viewer);
		if (tool.ensureActive(viewer) && clearCaret) {
			IEntity focusEntity = bm.wGet("focusEntity");
			ITextualEntityPart focusPart = (ITextualEntityPart) viewer.getEditPartRegistry().get(focusEntity);
			focusPart.setCaretVisible(false);
			viewer.setSelection(new StructuredSelection(focusPart));
		}
	}
}