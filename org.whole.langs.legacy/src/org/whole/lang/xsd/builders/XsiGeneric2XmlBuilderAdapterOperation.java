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
package org.whole.lang.xsd.builders;

import org.whole.lang.builders.AbstractBuilderOperation;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.builders.IBuilderOperation;

/**
 * @author Riccardo Solmi
 */
public class XsiGeneric2XmlBuilderAdapterOperation extends AbstractBuilderOperation {
	public static final String ID = "XsiGeneric2XmlBuilderAdapterOperation";

	private final IBuilderOperation targetOperation;

	public XsiGeneric2XmlBuilderAdapterOperation(IBuilderOperation targetOperation) {
		this.targetOperation = targetOperation;
	}

	public String wGetOperationId() {
		return ID;
	}

	protected IBuilder createGenericBuilder() {
		return new XsiGeneric2XmlBuilderAdapter(targetOperation, null, null);//FIXME
	}
}
