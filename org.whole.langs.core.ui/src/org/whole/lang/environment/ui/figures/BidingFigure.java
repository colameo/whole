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
package org.whole.lang.environment.ui.figures;

import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.figures.IEntityFigure;
import org.whole.lang.ui.layout.MonoLayout;
import org.whole.lang.ui.layout.RowLayout;
import org.whole.lang.ui.layout.TableRowLayout;
import org.whole.lang.ui.layout.ViewportTracking;

/**
 * @author Enrico Persiani
 */
public class BidingFigure extends ContentPaneFigure {

	public BidingFigure() {
		initContentPanes(4);
		setLayoutManager(new TableRowLayout().withMargin(4,4,4,4));

		add(createContentPane(0));
		add(createContentPane(1));
		add(createContentPane(2, ViewportTracking.BOTH));
		IEntityFigure valueFigure = new EntityFigure(new RowLayout().withSpacing(5).withMinorAutoresizeWeight(1.0f));
		IEntityFigure toggleFigure = new EntityFigure(new MonoLayout().withAutoresizeWeight(1.0f))
				.withViewportTracking(ViewportTracking.HORIZONTAL);
		toggleFigure.add(createFoldingToggle(3));
		valueFigure.add(toggleFigure);
		valueFigure.add(createContentPane(3));
		add(valueFigure);
		clickFoldingToggle(0);
	}
}
