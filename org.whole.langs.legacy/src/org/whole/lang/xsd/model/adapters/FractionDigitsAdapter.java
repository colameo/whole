package org.whole.lang.xsd.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.xsd.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.xsd.visitors.IXsdVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.xsd.reflect.XsdEntityDescriptorEnum;
import org.whole.lang.xsd.reflect.XsdFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class FractionDigitsAdapter extends AbstractEntityAdapter implements
		FractionDigits {
	private static final long serialVersionUID = 1;

	public FractionDigitsAdapter(IEntity implementor) {
		super(implementor);
	}

	public FractionDigitsAdapter() {
	}

	public void accept(IXsdVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<FractionDigits> wGetEntityDescriptor() {
		return XsdEntityDescriptorEnum.FractionDigits;
	}

	public NamespaceDecls getNamespaces() {
		return wGet(XsdFeatureDescriptorEnum.namespaces).wGetAdapter(
				XsdEntityDescriptorEnum.NamespaceDecls);
	}

	public void setNamespaces(NamespaceDecls namespaces) {
		wSet(XsdFeatureDescriptorEnum.namespaces, namespaces);
	}

	public StringData getId() {
		return wGet(XsdFeatureDescriptorEnum.id).wGetAdapter(
				XsdEntityDescriptorEnum.StringData);
	}

	public void setId(StringData id) {
		wSet(XsdFeatureDescriptorEnum.id, id);
	}

	public Attributes getAttributes() {
		return wGet(XsdFeatureDescriptorEnum.attributes).wGetAdapter(
				XsdEntityDescriptorEnum.Attributes);
	}

	public void setAttributes(Attributes attributes) {
		wSet(XsdFeatureDescriptorEnum.attributes, attributes);
	}

	public BooleanData getFixed() {
		return wGet(XsdFeatureDescriptorEnum.fixed).wGetAdapter(
				XsdEntityDescriptorEnum.BooleanData);
	}

	public void setFixed(BooleanData fixed) {
		wSet(XsdFeatureDescriptorEnum.fixed, fixed);
	}

	public IntegerData getValue() {
		return wGet(XsdFeatureDescriptorEnum.value).wGetAdapter(
				XsdEntityDescriptorEnum.IntegerData);
	}

	public void setValue(IntegerData value) {
		wSet(XsdFeatureDescriptorEnum.value, value);
	}

	public Annotation getAnnotation() {
		return wGet(XsdFeatureDescriptorEnum.annotation).wGetAdapter(
				XsdEntityDescriptorEnum.Annotation);
	}

	public void setAnnotation(Annotation annotation) {
		wSet(XsdFeatureDescriptorEnum.annotation, annotation);
	}
}
