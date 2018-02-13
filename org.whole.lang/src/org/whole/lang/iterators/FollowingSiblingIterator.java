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
package org.whole.lang.iterators;

import org.whole.lang.model.IEntity;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi
 */
public class FollowingSiblingIterator<E extends IEntity> extends AbstractByIndexIterator<E> {
	protected boolean includeSelf;

	public FollowingSiblingIterator(boolean forward, boolean includeSelf) {
		super(forward);
		this.includeSelf = includeSelf;
	}

	private int startIndex;
    @Override
    protected final int startIndex() {
    	return startIndex;
    }
    @Override
    protected final int endIndex() {
    	return entity.wSize()-1;
    }

	@Override
    public void reset(IEntity entity) {
		//workaround for composeIterator init behavior
		if (entity == null || !EntityUtils.hasParent(entity)) {
			super.reset(null);
			return;
		}

		IEntity parentEntity = entity.wGetParent();
		startIndex = parentEntity.wIndexOf(entity) + (includeSelf ? 0 : 1);
		super.reset(parentEntity);
	}

    @Override
	public void toString(StringBuilder sb) {
		sb.append(includeSelf ? "following-siblings-or-self" : "following-siblings");
		sb.append(forward ? "()" : "-reverse()");
    }
}
