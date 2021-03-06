package org.whole.lang.workflows.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.workflows.model.*;
import org.whole.lang.workflows.visitors.IWorkflowsVisitor;
import org.whole.lang.workflows.reflect.WorkflowsEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.model.EnumValue;

/** 
 * @generator Whole
 */
public class ArtifactsTraversalStrategyImpl extends AbstractDataEntity
		implements ArtifactsTraversalStrategy {
	private static final long serialVersionUID = 1;
	private org.whole.lang.workflows.model.ArtifactsTraversalStrategyEnum.Value value;

	public org.whole.lang.workflows.model.ArtifactsTraversalStrategyEnum.Value getValue() {
		return notifyRequested(value);
	}

	public void setValue(
			org.whole.lang.workflows.model.ArtifactsTraversalStrategyEnum.Value value) {
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
		return WorkflowsEntityDescriptorEnum.ArtifactsTraversalStrategy_ord;
	}

	public EntityDescriptor<ArtifactsTraversalStrategy> wGetEntityDescriptor() {
		return WorkflowsEntityDescriptorEnum.ArtifactsTraversalStrategy;
	}

	public Object wGetValue() {
		return getValue();
	}

	public void wSetValue(Object value) {
		setValue((org.whole.lang.workflows.model.ArtifactsTraversalStrategyEnum.Value) value);
	}

	public String wStringValue() {
		return toString();
	}

	public void wSetValue(String value) {
		try {
			setValue(ArtifactsTraversalStrategyEnum.instance.valueOf(value));
		} catch (NumberFormatException e) {
		}
	}

	public EnumValue wEnumValue() {
		return value;
	}

	public void wSetValue(EnumValue value) {
		setValue((org.whole.lang.workflows.model.ArtifactsTraversalStrategyEnum.Value) value);
	}
}
