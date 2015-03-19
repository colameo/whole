/**
 *  Copyright 2004-2014 Riccardo Solmi. All rights reserved.
 *  This file is part of the Whole Platform.
 *  
 *  The Whole Platform is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  The Whole Platform is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *  GNU Lesser General Public License for more details.
 *  
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.lang.queries.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.queries.model.StageTest;
import org.whole.lang.queries.visitors.IQueriesVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.queries.model.StageTestEnum;
import org.whole.lang.model.EnumValue;

/**
 *  @generator Whole
 */
public class StageTestImpl extends AbstractDataEntity implements StageTest {
    private static final long serialVersionUID = 1;
    private org.whole.lang.queries.model.StageTestEnum.Value value;

    public org.whole.lang.queries.model.StageTestEnum.Value getValue() {
        return notifyRequested(value);
    }

    public void setValue(org.whole.lang.queries.model.StageTestEnum.Value value) {
        notifyChanged(this.value, this.value = value);
    }

    public void accept(IQueriesVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }

    public int wGetEntityOrd() {
        return QueriesEntityDescriptorEnum.StageTest_ord;
    }

    public EntityDescriptor<StageTest> wGetEntityDescriptor() {
        return QueriesEntityDescriptorEnum.StageTest;
    }

    public Object wGetValue() {
        return getValue();
    }

    public void wSetValue(Object value) {
        setValue((org.whole.lang.queries.model.StageTestEnum.Value) value);
    }

    public String wStringValue() {
        return toString();
    }

    public void wSetValue(String value) {
        try {
            setValue(StageTestEnum.instance.valueOf(value));
        } catch (NumberFormatException e) {
        }
    }

    public EnumValue wEnumValue() {
        return value;
    }

    public void wSetValue(EnumValue value) {
        setValue((org.whole.lang.queries.model.StageTestEnum.Value) value);
    }
}
