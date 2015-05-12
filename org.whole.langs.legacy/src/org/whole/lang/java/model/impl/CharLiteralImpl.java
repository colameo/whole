/**
 *  Copyright 2004-2015 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.java.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.java.model.CharLiteral;
import org.whole.lang.java.visitors.IJavaVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/**
 *  @generator Whole
 */
public class CharLiteralImpl extends AbstractDataEntity implements CharLiteral {
    private static final long serialVersionUID = 1;
    private char value;

    public char getValue() {
        return notifyRequested(value);
    }

    public void setValue(char value) {
        notifyChanged(this.value, this.value = value);
    }

    public void accept(IJavaVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }

    public int wGetEntityOrd() {
        return JavaEntityDescriptorEnum.CharLiteral_ord;
    }

    public EntityDescriptor<CharLiteral> wGetEntityDescriptor() {
        return JavaEntityDescriptorEnum.CharLiteral;
    }

    public Object wGetValue() {
        return new Character(getValue());
    }

    public void wSetValue(Object value) {
        setValue(((Character) value).charValue());
    }

    public String wStringValue() {
        return toString();
    }

    public void wSetValue(String value) {
        try {
            setValue((value).charAt(0));
        } catch (NumberFormatException e) {
        }
    }

    public char wCharValue() {
        return getValue();
    }

    public void wSetValue(char value) {
        setValue(value);
    }
}
