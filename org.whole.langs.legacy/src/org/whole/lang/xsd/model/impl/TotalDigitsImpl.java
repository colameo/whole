package org.whole.lang.xsd.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.xsd.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.xsd.reflect.XsdEntityDescriptorEnum;
import org.whole.lang.xsd.visitors.IXsdVisitor;
import org.whole.lang.xsd.reflect.XsdFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class TotalDigitsImpl extends AbstractSimpleEntity implements
		TotalDigits {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<TotalDigits> wGetEntityDescriptor() {
		return XsdEntityDescriptorEnum.TotalDigits;
	}

	public int wGetEntityOrd() {
		return XsdEntityDescriptorEnum.TotalDigits_ord;
	}

	public void accept(IXsdVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private NamespaceDecls namespaces;

	public NamespaceDecls getNamespaces() {
		return notifyRequested(XsdFeatureDescriptorEnum.namespaces, namespaces);
	}

	public void setNamespaces(NamespaceDecls namespaces) {
		notifyChanged(XsdFeatureDescriptorEnum.namespaces, this.namespaces,
				this.namespaces = namespaces);
	}

	private StringData id;

	public StringData getId() {
		return notifyRequested(XsdFeatureDescriptorEnum.id, id);
	}

	public void setId(StringData id) {
		notifyChanged(XsdFeatureDescriptorEnum.id, this.id, this.id = id);
	}

	private Attributes attributes;

	public Attributes getAttributes() {
		return notifyRequested(XsdFeatureDescriptorEnum.attributes, attributes);
	}

	public void setAttributes(Attributes attributes) {
		notifyChanged(XsdFeatureDescriptorEnum.attributes, this.attributes,
				this.attributes = attributes);
	}

	private BooleanData fixed;

	public BooleanData getFixed() {
		return notifyRequested(XsdFeatureDescriptorEnum.fixed, fixed);
	}

	public void setFixed(BooleanData fixed) {
		notifyChanged(XsdFeatureDescriptorEnum.fixed, this.fixed,
				this.fixed = fixed);
	}

	private IntegerData value;

	public IntegerData getValue() {
		return notifyRequested(XsdFeatureDescriptorEnum.value, value);
	}

	public void setValue(IntegerData value) {
		notifyChanged(XsdFeatureDescriptorEnum.value, this.value,
				this.value = value);
	}

	private Annotation annotation;

	public Annotation getAnnotation() {
		return notifyRequested(XsdFeatureDescriptorEnum.annotation, annotation);
	}

	public void setAnnotation(Annotation annotation) {
		notifyChanged(XsdFeatureDescriptorEnum.annotation, this.annotation,
				this.annotation = annotation);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getNamespaces().wGetAdaptee(false);
		case 1:
			return getId().wGetAdaptee(false);
		case 2:
			return getAttributes().wGetAdaptee(false);
		case 3:
			return getFixed().wGetAdaptee(false);
		case 4:
			return getValue().wGetAdaptee(false);
		case 5:
			return getAnnotation().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setNamespaces(value
					.wGetAdapter(XsdEntityDescriptorEnum.NamespaceDecls));
			break;
		case 1:
			setId(value.wGetAdapter(XsdEntityDescriptorEnum.StringData));
			break;
		case 2:
			setAttributes(value.wGetAdapter(XsdEntityDescriptorEnum.Attributes));
			break;
		case 3:
			setFixed(value.wGetAdapter(XsdEntityDescriptorEnum.BooleanData));
			break;
		case 4:
			setValue(value.wGetAdapter(XsdEntityDescriptorEnum.IntegerData));
			break;
		case 5:
			setAnnotation(value.wGetAdapter(XsdEntityDescriptorEnum.Annotation));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 6;
	}
}
