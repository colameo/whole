package org.whole.lang.firstorderlogic.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.firstorderlogic.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.firstorderlogic.visitors.IFirstOrderLogicVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.firstorderlogic.reflect.FirstOrderLogicEntityDescriptorEnum;
import org.whole.lang.firstorderlogic.reflect.FirstOrderLogicFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class ExistAdapter extends AbstractEntityAdapter implements Exist {
	private static final long serialVersionUID = 1;

	public ExistAdapter(IEntity implementor) {
		super(implementor);
	}

	public ExistAdapter() {
	}

	public void accept(IFirstOrderLogicVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Exist> wGetEntityDescriptor() {
		return FirstOrderLogicEntityDescriptorEnum.Exist;
	}

	public Parameters getParameters() {
		return wGet(FirstOrderLogicFeatureDescriptorEnum.parameters)
				.wGetAdapter(FirstOrderLogicEntityDescriptorEnum.Parameters);
	}

	public void setParameters(Parameters parameters) {
		wSet(FirstOrderLogicFeatureDescriptorEnum.parameters, parameters);
	}

	public Formula getFormula() {
		return wGet(FirstOrderLogicFeatureDescriptorEnum.formula).wGetAdapter(
				FirstOrderLogicEntityDescriptorEnum.Formula);
	}

	public void setFormula(Formula formula) {
		wSet(FirstOrderLogicFeatureDescriptorEnum.formula, formula);
	}
}
