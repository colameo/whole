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
package org.whole.lang.java.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.java.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.java.visitors.IJavaVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;
import org.whole.lang.java.reflect.JavaFeatureDescriptorEnum;

/**
 *  @generator Whole
 */
public class ArrayAccessAdapter extends AbstractEntityAdapter implements ArrayAccess {
    private static final long serialVersionUID = 1;

    public ArrayAccessAdapter(IEntity implementor) {
        super(implementor);
    }

    public ArrayAccessAdapter() {
    }

    public void accept(IJavaVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<ArrayAccess> wGetEntityDescriptor() {
        return JavaEntityDescriptorEnum.ArrayAccess;
    }

    public Expression getArray() {
        return wGet(JavaFeatureDescriptorEnum.array).wGetAdapter(JavaEntityDescriptorEnum.Expression);
    }

    public void setArray(Expression array) {
        wSet(JavaFeatureDescriptorEnum.array, array);
    }

    public Expression getIndex() {
        return wGet(JavaFeatureDescriptorEnum.index).wGetAdapter(JavaEntityDescriptorEnum.Expression);
    }

    public void setIndex(Expression index) {
        wSet(JavaFeatureDescriptorEnum.index, index);
    }
}
