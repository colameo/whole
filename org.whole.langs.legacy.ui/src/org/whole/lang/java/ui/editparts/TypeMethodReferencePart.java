/**
 * Copyright 2004-2016 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.java.ui.editparts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.whole.lang.java.model.TypeMethodReference;
import org.whole.lang.java.ui.figures.TypeMethodReferenceFigure;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.editparts.AbstractContentPanePart;

/**
 * @author Enrico Persiani
 */
public class TypeMethodReferencePart extends AbstractContentPanePart {
	protected IFigure createFigure() {
		return new TypeMethodReferenceFigure();
	}

	protected List<IEntity> getModelSpecificChildren() {
		TypeMethodReference entity = getModelEntity();
		((TypeMethodReferenceFigure) getFigure()).hideTypeArguments(entity.getTypeArguments().wIsEmpty());

		List<IEntity> list = new ArrayList<IEntity>(3);
		list.add(entity.getType());
		list.add(entity.getTypeArguments());
		list.add(entity.getName());
		return list;
	}
}