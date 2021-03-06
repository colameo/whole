package org.whole.lang.pojo.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.pojo.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.pojo.visitors.IPojoVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.pojo.reflect.PojoEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class StringDataAdapter extends AbstractEntityAdapter implements
		StringData {
	private static final long serialVersionUID = 1;

	public StringDataAdapter(IEntity implementor) {
		super(implementor);
	}

	public StringDataAdapter() {
	}

	public void accept(IPojoVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<StringData> wGetEntityDescriptor() {
		return PojoEntityDescriptorEnum.StringData;
	}

	public String getValue() {
		return wStringValue();
	}

	public void setValue(String value) {
		wSetValue(value);
	}
}
