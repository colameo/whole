package org.whole.lang.patterns.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.patterns.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.patterns.reflect.PatternsEntityDescriptorEnum;
import org.whole.lang.patterns.visitors.IPatternsVisitor;
import org.whole.lang.patterns.reflect.PatternsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/**
 *  @generator  Whole
 */
public class InsertionPointImpl extends AbstractSimpleEntity implements InsertionPoint {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<InsertionPoint> wGetEntityDescriptor() {
        return PatternsEntityDescriptorEnum.InsertionPoint;
    }

    public int wGetEntityOrd() {
        return PatternsEntityDescriptorEnum.InsertionPoint_ord;
    }

    public void accept(IPatternsVisitor visitor) {
        visitor.visit(this);
    }
    private Name name;

    public Name getName() {
        return notifyRequested(PatternsFeatureDescriptorEnum.name, name);
    }

    public void setName(Name name) {
        notifyChanged(PatternsFeatureDescriptorEnum.name, this.name, this.name = name);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getName().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setName(value.wGetAdapter(PatternsEntityDescriptorEnum.Name));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 1;
    }
}
