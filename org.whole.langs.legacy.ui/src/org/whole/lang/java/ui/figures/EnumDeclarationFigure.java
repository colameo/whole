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
package org.whole.lang.java.ui.figures;

import org.eclipse.draw2d.IFigure;
import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.figures.EntityLabel;
import org.whole.lang.ui.layout.ColumnLayout;
import org.whole.lang.ui.layout.RowLayout;

/**
 *  @author Riccardo Solmi
 */
public class EnumDeclarationFigure extends ContentPaneFigure {
	private IFigure f1;

	public EnumDeclarationFigure() {
		super(new ColumnLayout());
		initContentPanes(6);
		EntityFigure row;
		add(createContentPane(0));
		add(row = new EntityFigure(new RowLayout().withSpacing(4)));
		row.add(createFoldingToggle(5));
		row.add(createContentPane(1));
		row.addKeyword("enum");
		row.add(createContentPane(2));
		f1 = row.addKeyword("implements");
		row.add(createContentPane(3));
		row.addContentLighter("{");
		add(row = new EntityFigure(new RowLayout().withSpacing(4)));
		row.add(new EntityLabel("    "));
		row.add(createContentPane(4));
		add(row = new EntityFigure(new RowLayout().withSpacing(4)));
		row.add(new EntityLabel("    "));
		row.add(createContentPane(5));
		addContentLighter("}");
	}

	public void hideSuperInterfaceTypes(boolean value) {
		f1.setVisible(!value);
	}
}
