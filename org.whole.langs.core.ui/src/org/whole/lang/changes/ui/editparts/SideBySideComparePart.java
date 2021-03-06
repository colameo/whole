/**
 *  Copyright 2004-2016 Riccardo Solmi. All rights reserved.
 *  This file is part of the Whole Platform.
 *  The Whole Platform is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  The Whole Platform is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *  GNU Lesser General Public License for more details.
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.lang.changes.ui.editparts;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.whole.lang.changes.model.SideBySideCompare;
import org.whole.lang.changes.reflect.ChangesFeatureDescriptorEnum;
import org.whole.lang.changes.ui.figures.SideBySideCompareFigure;
import org.whole.lang.model.IEntity;
import org.whole.lang.util.EntityUtils;

/**
 *  @author  Riccardo Solmi
 */
public class SideBySideComparePart extends AbstractComparePart {
	protected CompareMapper leftMapper = new CompareMapper();
	protected CompareMapper rightMapper = new CompareMapper();

    protected IFigure createFigure() {
        return new SideBySideCompareFigure(leftMapper, rightMapper);
    }
    @Override
    public SideBySideCompareFigure getFigure() {
    	return (SideBySideCompareFigure) super.getFigure();
    }

    protected List<IEntity> getModelSpecificChildren() {
        SideBySideCompare entity = getModelEntity();
        List<IEntity> children = new ArrayList<IEntity>(3);
        children.add(entity.getBaseContent());
        children.add(entity.getFirstRevisedContent());
        children.add(entity.getSecondRevisedContent());
        return children;
    }

	protected void propertyChangeUI(PropertyChangeEvent evt) {
		if (evt.getPropertyName().equals(ChangesFeatureDescriptorEnum.baseContent.getName()))
			refreshVisuals();
		super.propertyChangeUI(evt);
	}

	@Override
	protected void refreshVisuals() {
		SideBySideCompare entity = getModelEntity();
		getFigure().showBaseRevision(!EntityUtils.isResolver(entity.getBaseContent()));
	}

    @Override
    public void refreshChildren() {
    	super.refreshChildren();
    	
    	SideBySideCompare entity = getModelEntity();
        leftMapper.rebuildRevisionMap(entity, 0);
        if (!EntityUtils.isResolver(entity.getBaseContent()))
        	rightMapper.rebuildRevisionMap(entity, 1);
    }
}
