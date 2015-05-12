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
package org.whole.lang.xml.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.xml.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.xml.visitors.IXmlVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.xml.reflect.XmlEntityDescriptorEnum;
import org.whole.lang.xml.reflect.XmlFeatureDescriptorEnum;

/**
 *  @generator Whole
 */
public class SystemIdAdapter extends AbstractEntityAdapter implements SystemId {
    private static final long serialVersionUID = 1;

    public SystemIdAdapter(IEntity implementor) {
        super(implementor);
    }

    public SystemIdAdapter() {
    }

    public void accept(IXmlVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<SystemId> wGetEntityDescriptor() {
        return XmlEntityDescriptorEnum.SystemId;
    }

    public SystemLiteral getSystemLiteral() {
        return wGet(XmlFeatureDescriptorEnum.systemLiteral).wGetAdapter(XmlEntityDescriptorEnum.SystemLiteral);
    }

    public void setSystemLiteral(SystemLiteral systemLiteral) {
        wSet(XmlFeatureDescriptorEnum.systemLiteral, systemLiteral);
    }
}
