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

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.e4.ui.draw2d.DelayableUpdateManager;
import org.whole.lang.e4.ui.viewers.E4GraphicalViewer;
import org.whole.lang.operations.IOperationProgressMonitor;
import org.whole.lang.operations.OperationProgressMonitorAdapter;
import org.whole.lang.ui.util.AnimableRunnable;

/**
 * @author Enrico Persiani
 */
@SuppressWarnings("restriction")
public abstract class AbstractRunnableWithProgress implements IRunnableWithProgress {
	protected IEclipseContext context;
	protected IBindingManager bm;
	protected String label;
	protected boolean delayUpdates;

	public AbstractRunnableWithProgress(IEclipseContext context, IBindingManager bm, String label, boolean delayUpdates) {
		this.context = context;
		this.bm = bm;
		this.label = label;
		this.delayUpdates = delayUpdates;
	}
	
	@Override
	public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
		E4GraphicalViewer viewer = (E4GraphicalViewer) bm.wGetValue("viewer");
		boolean delayUpdates = delayUpdates(viewer, this.delayUpdates);
		boolean enableAnimation = AnimableRunnable.enableAnimation(!this.delayUpdates);
		try {
			final IOperationProgressMonitor pm = new OperationProgressMonitorAdapter(monitor);
			bm.wDefValue("progressMonitor", pm);
			run(pm);
		} finally {
			AnimableRunnable.enableAnimation(enableAnimation);
			delayUpdates(viewer, delayUpdates);
			monitor.done();
		}
	}

	protected boolean delayUpdates(E4GraphicalViewer viewer, boolean enable) {
		Boolean oldDelayUpdates = (Boolean) viewer.getProperty(DelayableUpdateManager.PROPERTY_DELAY_UPDATES);
		viewer.setProperty(DelayableUpdateManager.PROPERTY_DELAY_UPDATES, enable);
		return oldDelayUpdates != null && oldDelayUpdates;
	}

	public abstract void run(IOperationProgressMonitor pm) throws InvocationTargetException, InterruptedException;
}