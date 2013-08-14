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
package org.whole.lang.e4.ui.compatibility;

import org.eclipse.gef.commands.CommandStack;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.PartInitException;
import org.whole.lang.e4.ui.actions.ILinkViewerListener;
import org.whole.lang.e4.ui.actions.LinkToEditorAction;
import org.whole.lang.e4.ui.parts.AbstractE4DerivedGraphicalPart;
import org.whole.lang.e4.ui.viewers.IEntityPartViewer;
import org.whole.lang.model.IEntity;

/**
 * @author Enrico Persiani
 */
public class E3DerivedViewPart<C extends AbstractE4DerivedGraphicalPart> extends E3ViewPart<C> {
	protected LinkToEditorAction linkToEditorAction;
	protected boolean disableEditing;

	public E3DerivedViewPart(String partId, Class<C> partClass, boolean disableEditing) {
		super(partId, partClass);
		this.disableEditing = disableEditing;
	}

	@Override
	public void init(IViewSite site) throws PartInitException {
		super.init(site);
		IActionBars actionBars = site.getActionBars();
		IToolBarManager toolBarManager = actionBars.getToolBarManager();
		toolBarManager.add(linkToEditorAction = new LinkToEditorAction());
	}

	@Override
	public void createPartControl(Composite parent) {
		super.createPartControl(parent);

		getComponent().addLinkViewerListener(new ILinkViewerListener() {
			public void viewerLinked(IEntityPartViewer viewer, IEntityPartViewer toViewer) {
				trackCommandStack(viewer);
			}
			public void viewerUnlinked(IEntityPartViewer viewer) {
				trackCommandStack(viewer);
			}
			protected void trackCommandStack(IEntityPartViewer viewer) {
				CommandStack commandStack = viewer.getCommandStack();
				undoAction.track(commandStack);
				redoAction.track(commandStack);
			}
			public void condentsDerived(IEntityPartViewer viewer, IEntity result) {
				if (disableEditing)
					viewer.setInteractive(result, false, true, false);
			}
		});

		linkToEditorAction.setLinkable(getComponent().getSelectionLinkable());
	}
}
