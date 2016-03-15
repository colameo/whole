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
package org.whole.lang.types.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.types.model.TypeRule;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.types.reflect.TypesEntityDescriptorEnum;
import org.whole.lang.types.visitors.ITypesVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.types.model.DomainType;
import org.whole.lang.types.reflect.TypesFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.types.model.Type;

/**
 *  @generator Whole
 */
public class TypeRuleImpl extends AbstractSimpleEntity implements TypeRule {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<TypeRule> wGetEntityDescriptor() {
        return TypesEntityDescriptorEnum.TypeRule;
    }

    public int wGetEntityOrd() {
        return TypesEntityDescriptorEnum.TypeRule_ord;
    }

    public void accept(ITypesVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private DomainType domain;

    public DomainType getDomain() {
        return notifyRequested(TypesFeatureDescriptorEnum.domain, domain);
    }

    public void setDomain(DomainType domain) {
        notifyChanged(TypesFeatureDescriptorEnum.domain, this.domain, this.domain = domain);
    }
    private Type type;

    public Type getType() {
        return notifyRequested(TypesFeatureDescriptorEnum.type, type);
    }

    public void setType(Type type) {
        notifyChanged(TypesFeatureDescriptorEnum.type, this.type, this.type = type);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getDomain().wGetAdaptee(false);
            case 1 :
            return getType().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setDomain(value.wGetAdapter(TypesEntityDescriptorEnum.DomainType));
            break;
            case 1 :
            setType(value.wGetAdapter(TypesEntityDescriptorEnum.Type));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
