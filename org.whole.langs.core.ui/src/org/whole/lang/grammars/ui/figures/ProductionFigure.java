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
package org.whole.lang.grammars.ui.figures;

import org.eclipse.draw2d.MarginBorder;
import org.whole.lang.ui.PreferenceConstants;
import org.whole.lang.ui.figures.ArrowFigure;
import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.figures.ArrowFactory.ArrowKind;
import org.whole.lang.ui.layout.RowLayout;

/**
 * @author Riccardo Solmi
 */
public class ProductionFigure extends ContentPaneFigure {
	public ProductionFigure() {
		super(new RowLayout());
		initContentPanes(3);

		add(createFoldingToggle(1));
		add(createContentPane(0, new MarginBorder(0,4,0,0)));
		addContentLight(":");
		add(createContentPane(2, new MarginBorder(0,0,0,4)));
		add(new ArrowFigure(0f, ArrowKind.INVERTED_TRIANGLE, ArrowKind.NONE, PreferenceConstants.RELATIONS_CATEGORY, true));
		add(createContentPane(1));
	    add(new ArrowFigure(0f, ArrowKind.NONE, ArrowKind.BAR, PreferenceConstants.RELATIONS_CATEGORY, true));
	}
}
