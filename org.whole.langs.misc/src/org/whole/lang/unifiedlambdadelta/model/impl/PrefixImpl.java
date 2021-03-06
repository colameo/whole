package org.whole.lang.unifiedlambdadelta.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.unifiedlambdadelta.model.*;
import org.whole.lang.unifiedlambdadelta.visitors.IUnifiedLambdaDeltaVisitor;
import org.whole.lang.unifiedlambdadelta.reflect.UnifiedLambdaDeltaEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class PrefixImpl extends AbstractDataEntity implements Prefix {
	private static final long serialVersionUID = 1;
	private String value;

	public String getValue() {
		return notifyRequested(value);
	}

	public void setValue(String value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(IUnifiedLambdaDeltaVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	public int wGetEntityOrd() {
		return UnifiedLambdaDeltaEntityDescriptorEnum.Prefix_ord;
	}

	public EntityDescriptor<Prefix> wGetEntityDescriptor() {
		return UnifiedLambdaDeltaEntityDescriptorEnum.Prefix;
	}

	public Object wGetValue() {
		return getValue();
	}

	public void wSetValue(Object value) {
		setValue((String) value);
	}

	public String wStringValue() {
		return getValue();
	}

	public void wSetValue(String value) {
		setValue(value);
	}
}
