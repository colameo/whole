package org.whole.lang.models.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.models.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.models.reflect.ModelsEntityDescriptorEnum;
import org.whole.lang.models.visitors.IModelsVisitor;
import org.whole.lang.models.reflect.ModelsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class MapEntityImpl extends AbstractSimpleEntity implements MapEntity {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<MapEntity> wGetEntityDescriptor() {
		return ModelsEntityDescriptorEnum.MapEntity;
	}

	public int wGetEntityOrd() {
		return ModelsEntityDescriptorEnum.MapEntity_ord;
	}

	public void accept(IModelsVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private EntityModifiers modifiers;

	public EntityModifiers getModifiers() {
		return notifyRequested(ModelsFeatureDescriptorEnum.modifiers, modifiers);
	}

	public void setModifiers(EntityModifiers modifiers) {
		notifyChanged(ModelsFeatureDescriptorEnum.modifiers, this.modifiers,
				this.modifiers = modifiers);
	}

	public int wHashCode() {
		return getName().wHashCode();
	}

	public boolean wEquals(IEntity entity) {
		if (this == entity)
			return true;
		if (!wGetEntityDescriptor().equals(entity.wGetEntityDescriptor()))
			return false;
		try {
			return getName().wEquals(
					entity.wGet(ModelsFeatureDescriptorEnum.name));
		} catch (Exception e) {
			return false;
		}
	}

	protected void toString(StringBuffer buffer) {
		buffer.append("name=");
		buffer.append(name);
	}

	private SimpleName name;

	public SimpleName getName() {
		return notifyRequested(ModelsFeatureDescriptorEnum.name, name);
	}

	public void setName(SimpleName name) {
		notifyChanged(ModelsFeatureDescriptorEnum.name, this.name,
				this.name = name);
	}

	private Types types;

	public Types getTypes() {
		return notifyRequested(ModelsFeatureDescriptorEnum.types, types);
	}

	public void setTypes(Types types) {
		notifyChanged(ModelsFeatureDescriptorEnum.types, this.types,
				this.types = types);
	}

	private Type keyType;

	public Type getKeyType() {
		return notifyRequested(ModelsFeatureDescriptorEnum.keyType, keyType);
	}

	public void setKeyType(Type keyType) {
		notifyChanged(ModelsFeatureDescriptorEnum.keyType, this.keyType,
				this.keyType = keyType);
	}

	private Type valueType;

	public Type getValueType() {
		return notifyRequested(ModelsFeatureDescriptorEnum.valueType, valueType);
	}

	public void setValueType(Type valueType) {
		notifyChanged(ModelsFeatureDescriptorEnum.valueType, this.valueType,
				this.valueType = valueType);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getModifiers().wGetAdaptee(false);
		case 1:
			return getName().wGetAdaptee(false);
		case 2:
			return getTypes().wGetAdaptee(false);
		case 3:
			return getKeyType().wGetAdaptee(false);
		case 4:
			return getValueType().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setModifiers(value
					.wGetAdapter(ModelsEntityDescriptorEnum.EntityModifiers));
			break;
		case 1:
			setName(value.wGetAdapter(ModelsEntityDescriptorEnum.SimpleName));
			break;
		case 2:
			setTypes(value.wGetAdapter(ModelsEntityDescriptorEnum.Types));
			break;
		case 3:
			setKeyType(value.wGetAdapter(ModelsEntityDescriptorEnum.Type));
			break;
		case 4:
			setValueType(value.wGetAdapter(ModelsEntityDescriptorEnum.Type));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 5;
	}
}
