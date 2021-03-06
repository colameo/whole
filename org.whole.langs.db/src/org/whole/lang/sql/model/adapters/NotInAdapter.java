package org.whole.lang.sql.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.sql.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.sql.visitors.ISQLVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.sql.reflect.SQLEntityDescriptorEnum;
import org.whole.lang.sql.reflect.SQLFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class NotInAdapter extends AbstractEntityAdapter implements NotIn {
	private static final long serialVersionUID = 1;

	public NotInAdapter(IEntity implementor) {
		super(implementor);
	}

	public NotInAdapter() {
	}

	public void accept(ISQLVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<NotIn> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.NotIn;
	}

	public SQLExpression getLeftExpr() {
		return wGet(SQLFeatureDescriptorEnum.leftExpr).wGetAdapter(
				SQLEntityDescriptorEnum.SQLExpression);
	}

	public void setLeftExpr(SQLExpression leftExpr) {
		wSet(SQLFeatureDescriptorEnum.leftExpr, leftExpr);
	}

	public InPredicate getInPredicate() {
		return wGet(SQLFeatureDescriptorEnum.inPredicate).wGetAdapter(
				SQLEntityDescriptorEnum.InPredicate);
	}

	public void setInPredicate(InPredicate inPredicate) {
		wSet(SQLFeatureDescriptorEnum.inPredicate, inPredicate);
	}
}
