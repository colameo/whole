package org.whole.lang.changes.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.changes.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.changes.visitors.IChangesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.changes.reflect.ChangesEntityDescriptorEnum;

/**
 *  @generator  Whole
 */
public class NothingAdapter extends AbstractEntityAdapter implements Nothing {
    private static final long serialVersionUID = 1;

    public NothingAdapter(IEntity implementor) {
        super(implementor);
    }

    public NothingAdapter() {
    }

    public void accept(IChangesVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<Nothing> wGetEntityDescriptor() {
        return ChangesEntityDescriptorEnum.Nothing;
    }
}
