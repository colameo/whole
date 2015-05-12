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
package org.whole.lang.queries.ui.figures;

import org.eclipse.draw2d.Label;
import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.figures.IQualifiedFigure;
import org.whole.lang.ui.figures.LabelFactory;
import org.whole.lang.ui.layout.OverLayout;
import org.whole.lang.ui.layout.RowLayout;

/**
 * @author Riccardo Solmi
 */
public class AsVariableTestFigure extends ContentPaneFigure implements IQualifiedFigure{
	private Label environmentLabel;

	public AsVariableTestFigure(String label) {
		super(new RowLayout().withSpacing(4));
		initContentPanes(1);
		
		addContentLight(label);
		addKeyword("as");
		
		EntityFigure variableFigure = new EntityFigure(new OverLayout());
		variableFigure.add(createContentPane(0, LabelFactory.createIdentifier()));
		variableFigure.add(environmentLabel = LabelFactory.createModule());
		add(variableFigure);
		
		environmentLabel.setVisible(false);
	}

	public void setQualifierName(String name) {
		if (name != null) {
			environmentLabel.setVisible(true);
			environmentLabel.setText(name);
		} else
			environmentLabel.setVisible(false);
	}
	public Label getNameLabel() {
		return (Label) getContentPane(0);
	}
}
