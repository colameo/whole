package org.whole.lang.java.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.java.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;
import org.whole.lang.java.visitors.IJavaVisitor;
import org.whole.lang.java.reflect.JavaFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class TypeMethodReferenceImpl extends AbstractSimpleEntity implements
		TypeMethodReference {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<TypeMethodReference> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.TypeMethodReference;
	}

	public int wGetEntityOrd() {
		return JavaEntityDescriptorEnum.TypeMethodReference_ord;
	}

	public void accept(IJavaVisitor visitor) {
		visitor.visit(this);
	}

	private Type type;

	public Type getType() {
		return notifyRequested(JavaFeatureDescriptorEnum.type, type);
	}

	public void setType(Type type) {
		notifyChanged(JavaFeatureDescriptorEnum.type, this.type,
				this.type = type);
	}

	private Types typeArguments;

	public Types getTypeArguments() {
		return notifyRequested(JavaFeatureDescriptorEnum.typeArguments,
				typeArguments);
	}

	public void setTypeArguments(Types typeArguments) {
		notifyChanged(JavaFeatureDescriptorEnum.typeArguments,
				this.typeArguments, this.typeArguments = typeArguments);
	}

	private SimpleName name;

	public SimpleName getName() {
		return notifyRequested(JavaFeatureDescriptorEnum.name, name);
	}

	public void setName(SimpleName name) {
		notifyChanged(JavaFeatureDescriptorEnum.name, this.name,
				this.name = name);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getType().wGetAdaptee(false);
		case 1:
			return getTypeArguments().wGetAdaptee(false);
		case 2:
			return getName().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setType(value.wGetAdapter(JavaEntityDescriptorEnum.Type));
			break;
		case 1:
			setTypeArguments(value.wGetAdapter(JavaEntityDescriptorEnum.Types));
			break;
		case 2:
			setName(value.wGetAdapter(JavaEntityDescriptorEnum.SimpleName));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 3;
	}
}