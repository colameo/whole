package org.whole.lang.patterns.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.patterns.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.patterns.visitors.IPatternsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.patterns.reflect.PatternsEntityDescriptorEnum;

/**
 *  @generator  Whole
 */
public class PathExpressionAdapter extends AbstractEntityAdapter implements PathExpression {
    private static final long serialVersionUID = 1;

    public PathExpressionAdapter(IEntity implementor) {
        super(implementor);
    }

    public PathExpressionAdapter() {
    }

    public void accept(IPatternsVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<PathExpression> wGetEntityDescriptor() {
        return PatternsEntityDescriptorEnum.PathExpression;
    }
}
