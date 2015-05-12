/**
 * Copyright 2004-2015 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.scripts.ui.figures;

import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.whole.lang.ui.figures.FigurePrefs;
import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.OverLayout;

/**
 * @author Riccardo Solmi
 */
public class ScriptFigure extends ContentPaneFigure {
	public ScriptFigure() {
		super(new OverLayout().withMinorAlignment(Alignment.CENTER).withSpacing(4));
		initContentPanes(2);

		add(createContentPane(0));
		add(createContentPane(1));
	}

	protected void paintFigure(Graphics g) {
		super.paintFigure(g);

    	Rectangle nameBounds = getContentPane(0).getBounds();
    	g.setForegroundColor(FigureUtilities.darker(FigurePrefs.hostLanguageColor));
    	g.drawLine(bounds.x, nameBounds.bottom(), bounds.right(), nameBounds.bottom());
	}
}
