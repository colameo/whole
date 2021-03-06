package org.whole.lang.javascript.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.javascript.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.javascript.visitors.IJavaScriptVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.javascript.reflect.JavaScriptEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class IdentifierAdapter extends AbstractEntityAdapter implements
		Identifier {
	private static final long serialVersionUID = 1;

	public IdentifierAdapter(IEntity implementor) {
		super(implementor);
	}

	public IdentifierAdapter() {
	}

	public void accept(IJavaScriptVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Identifier> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.Identifier;
	}

	public String getValue() {
		return wStringValue();
	}

	public void setValue(String value) {
		wSetValue(value);
	}
}
