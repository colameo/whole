/**
 *  Copyright 2004-2016 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.reusables.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.reusables.model.PathWithExtension;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reusables.reflect.ReusablesEntityDescriptorEnum;
import org.whole.lang.reusables.visitors.IReusablesVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.reusables.model.Expression;
import org.whole.lang.reusables.reflect.ReusablesFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/**
 *  @generator Whole
 */
public class PathWithExtensionImpl extends AbstractSimpleEntity implements PathWithExtension {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<PathWithExtension> wGetEntityDescriptor() {
        return ReusablesEntityDescriptorEnum.PathWithExtension;
    }

    public int wGetEntityOrd() {
        return ReusablesEntityDescriptorEnum.PathWithExtension_ord;
    }

    public void accept(IReusablesVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Expression path;

    public Expression getPath() {
        return notifyRequested(ReusablesFeatureDescriptorEnum.path, path);
    }

    public void setPath(Expression path) {
        notifyChanged(ReusablesFeatureDescriptorEnum.path, this.path, this.path = path);
    }
    private Expression extension;

    public Expression getExtension() {
        return notifyRequested(ReusablesFeatureDescriptorEnum.extension, extension);
    }

    public void setExtension(Expression extension) {
        notifyChanged(ReusablesFeatureDescriptorEnum.extension, this.extension, this.extension = extension);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getPath().wGetAdaptee(false);
            case 1 :
            return getExtension().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setPath(value.wGetAdapter(ReusablesEntityDescriptorEnum.Expression));
            break;
            case 1 :
            setExtension(value.wGetAdapter(ReusablesEntityDescriptorEnum.Expression));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
