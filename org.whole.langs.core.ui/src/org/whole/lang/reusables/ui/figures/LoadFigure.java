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
package org.whole.lang.reusables.ui.figures;

import org.eclipse.draw2d.ActionListener;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.LineBorder;
import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.figures.EntityButton;
import org.whole.lang.ui.layout.RowLayout;

/**
 *  @generator Whole
 */
public class LoadFigure extends ContentPaneFigure {

    public LoadFigure(ActionListener linkListener) {
        initContentPanes(1);
        setLayoutManager(new RowLayout().withSpacing(4));
        add(createContentPane(0));
        add(new EntityButton(linkListener));
        setBorder(new LineBorder(ColorConstants.orange));
    }
}