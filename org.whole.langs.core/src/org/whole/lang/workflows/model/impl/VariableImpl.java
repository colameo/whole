package org.whole.lang.workflows.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.workflows.model.*;
import org.whole.lang.workflows.visitors.IWorkflowsVisitor;
import org.whole.lang.workflows.reflect.WorkflowsEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class VariableImpl extends AbstractDataEntity implements Variable {
	private static final long serialVersionUID = 1;
	private String value;

	public String getValue() {
		return notifyRequested(value);
	}

	public void setValue(String value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(IWorkflowsVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	public int wGetEntityOrd() {
		return WorkflowsEntityDescriptorEnum.Variable_ord;
	}

	public EntityDescriptor<Variable> wGetEntityDescriptor() {
		return WorkflowsEntityDescriptorEnum.Variable;
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
