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
package org.whole.lang.model.impl;

import org.whole.lang.commons.factories.CommonsEntityAdapterFactory;
import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.model.EnumValue;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.visitors.IVisitor;

/** 
 * @author Riccardo Solmi
 */
public class EnumValueDataEntityImpl extends AbstractDataEntity {
	private static final long serialVersionUID = 1;

	private EnumValue value;

	public EnumValueDataEntityImpl() {}
	public EnumValueDataEntityImpl(EntityDescriptor<?> ed) {
		wSetEntityDescriptor(ed);
	}

	public EnumValue getValue() {
		return notifyRequested(value);
	}

	public void setValue(EnumValue value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(IVisitor visitor) {
		visitor.visit(this);//FIXME
	}

    @SuppressWarnings("unchecked")
	public <T extends IEntity> T wGetAdapter(EntityDescriptor<T> targetEd) {
    	EntityDescriptor<?> ed = wGetEntityDescriptor();
    	if (targetEd.isLanguageSupertypeOf(ed)) {
			if (targetEd.getEntityType().isAssignableFrom(getClass()))
				return (T) this;
			else if (targetEd.getEntityType().isAssignableFrom(ed.getEntityType()))
	    		return (T) CommonsEntityAdapterFactory.create(ed, this);
			else
				return (T) CommonsEntityAdapterFactory.create(
						targetEd.getEntityDescriptorEnum().valueOf(ed.getName()), this);
	    }
		return CommonsEntityAdapterFactory.create(targetEd, this);
    }

    private EntityDescriptor<?> entityDescriptor;
	public EntityDescriptor<?> wGetEntityDescriptor() {
		return entityDescriptor;
	}
	public void wSetEntityDescriptor(EntityDescriptor<?> entityDescriptor) {
		this.entityDescriptor = entityDescriptor;
	}

	public Object wGetValue() {
		return getValue();
	}

	public void wSetValue(Object value) {
		setValue((EnumValue) value);
	}

	public String wStringValue() {
		return toString();
	}

	public void wSetValue(String value) {
		try {
			setValue(this.value.getEnumType().valueOf(value));
		} catch (NumberFormatException e) {
		}
	}

	public EnumValue wEnumValue() {
		return value;
	}

	public void wSetValue(EnumValue value) {
		setValue(value);
	}
}