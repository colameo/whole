/**
 * Copyright 2004-2013 Riccardo Solmi. All rights reserved.
 * This file is part of the Whole Platform.
 *
 * The Whole Platform is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * The Whole Platform is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.lang;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.commons.parsers.CommonsDataTypePersistenceParser;
import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.AbstractFunctionLibraryDeployer;
import org.whole.lang.reflect.Descriptor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.reflect.ILanguageKit;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.resources.IResource;
import org.whole.lang.util.DataTypeUtils;
import org.whole.lang.util.IDataTypeWrapper;
import org.whole.lang.util.IRunnable;
import org.whole.lang.util.ResourceUtils;

/**
 * @author Riccardo Solmi
 */
public class ReflectLibraryDeployer extends AbstractFunctionLibraryDeployer {
	public static final String URI = "whole:org.whole.lang:ReflectLibrary";
	public static final String LANGUAGE_ED = "http://lang.whole.org/Queries#LanguageTest";
	public static final String KIND_ED = "http://lang.whole.org/Queries#KindTest";
	public static final String TYPE_ED = "http://lang.whole.org/Queries#TypeTest";
	public static final String FEATURE_ED = "http://lang.whole.org/Queries#FeatureStep";
	public static final String INT_ED = "http://lang.whole.org/Queries#IntLiteral";
	public static final String STRING_ED = "http://lang.whole.org/Queries#StringLiteral";

	//ILanguageKit, EntityDescriptor, FeatureDescriptor, IEntity APIs
	public void deploy(ReflectionFactory platform) {
		putFunctionLibrary(URI);

		putFunctionCode("languages", languagesIterator()); // -> languageURI...

		//self = DataEntity<languageURI | entityURI | featureURI | LK | ED | FD>
		putFunctionCode("languageURI", languageURIIterator());
		putFunctionCode("languageNamespace", languageNamespaceIterator());
		putFunctionCode("languageName", languageNameIterator());
		putFunctionCode("languageSimpleName", languageSimpleNameIterator());
		putFunctionCode("languageQualifiedName", languageQualifiedNameIterator());
		putFunctionCode("languageVersion", languageVersionIterator());
		putFunctionCode("languageIsDynamic", languageIsDynamicIterator());
		putFunctionCode("languageMetamodel", languageMetamodelIterator());
		putFunctionCode("languageEntities", languageEntitiesIterator()); // -> typeTest...
		putFunctionCode("languageFeatures", languageFeaturesIterator()); // -> featureStep...

		//self = DataEntity<entityURI | ED>
		putFunctionCode("entityLanguage", entityLanguageIterator());
		putFunctionCode("entityURI", entityUriIterator());
		putFunctionCode("entityOrdinal", entityOrdinalIterator());
		putFunctionCode("entityName", entityNameIterator());
		putFunctionCode("entityImplName", entityImplNameIterator());
		putFunctionCode("entityIsAbstract", entityIsAbstractIterator());
		putFunctionCode("entityIsRelationship", entityIsRelationshipIterator());
		putFunctionCode("entityIsToManyRelationship", entityIsToManyRelationshipIterator());
		putFunctionCode("entityKind", entityKindIterator());
//		putFunctionCode("entityCompositeKind", entityCompositeKindIterator());
//		putFunctionCode("entityDataKind", entityDataKindIterator());
		putFunctionCode("entitySize", entitySizeIterator());
		putFunctionCode("entityChildSize", entityChildSizeIterator());
		putFunctionCode("entityAdjacentSize", entityAdjacentSizeIterator());
		putFunctionCode("entityFeatures", entityFeaturesIterator());
		putFunctionCode("entitySupertypes", entitySupertypesIterator());
		putFunctionCode("entitySubtypes", entitySubtypesIterator());
		putFunctionCode("entityExtendedConcreteSubtypes", entityExtendedConcreteSubtypesIterator());

		//self = DataEntity<featureURI | FD>
		putFunctionCode("featureLanguage", featureLanguageIterator());
		putFunctionCode("featureURI", featureUriIterator());
		putFunctionCode("featureOrdinal", featureOrdinalIterator());
		putFunctionCode("featureName", featureNameIterator());
		putFunctionCode("featureImplName", featureImplNameIterator());
		putFunctionCode("featureIsOptional", featureIsOptionalIterator());
		putFunctionCode("featureIsId", featureIsIdIterator());
		putFunctionCode("featureIsReference", featureIsReferenceIterator());
		putFunctionCode("featureIsDerived", featureIsDerivedIterator());
		putFunctionCode("featureIsShared", featureIsSharedIterator());
		putFunctionCode("featureIsToMany", featureIsToManyIterator());
		putFunctionCode("featureParentType", featureParentTypeIterator());
		putFunctionCode("featureOpposite", featureOppositeIterator());
		putFunctionCode("featureType", featureTypeIterator());

		//self = IEntity
		putFunctionCode("language", languageIterator());
		putFunctionCode("kind", kindIterator());
		putFunctionCode("type", typeIterator());
		putFunctionCode("atType", atTypeIterator());
		putFunctionCode("atFeature", atFeatureIterator());
		putFunctionCode("supertypes", supertypesIterator());
		putFunctionCode("subtypes", subtypesIterator());
		putFunctionCode("extendedConcreteSubtypes", extendedConcreteSubtypesIterator());
		putFunctionCode("features", featuresIterator());
		putFunctionCode("aspectualFeatures", aspectualFeaturesIterator());
		putFunctionCode("size", sizeIterator());
		putFunctionCode("adjacentSize", adjacentSizeIterator());
		putFunctionCode("inverseAdjacentSize", inverseAdjacentSizeIterator());

		//self = DataEntity<resourceURI>
		putFunctionCode("uriLanguage", uriLanguageIterator());
		putFunctionCode("uriEntity", uriEntityIterator());
		putFunctionCode("uriFeature", uriFeatureIterator());
		putFunctionCode("uriResourcePart", uriResourcePartIterator());
		putFunctionCode("uriFragmentPart", uriFragmentPartIterator());
	}


	public static IEntityIterator<IEntity> languagesIterator() {
		return IteratorFactory.multiValuedRunnableIterator(new IRunnable() {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
				bm.setResultIterator(IteratorFactory.collectionIterator(
						ReflectionFactory.getLanguageKits(false, ResourceUtils.SIMPLE_COMPARATOR),
						new IDataTypeWrapper.CustomDatatypeWrapper(LANGUAGE_ED) {
							@Override
							public <E extends IEntity> E createEntity(Object value) {
								return super.createEntity(((IResource) value).getURI());
							}
						}));
			}
		});
	}


	public static IEntityIterator<IEntity> languageURIIterator() {
		return IteratorFactory.singleValuedRunnableIterator(new LanguageSingleValuedPropertyRunnable() {
			protected IEntity getProperty(ILanguageKit languageKit) {
				return BindingManagerFactory.instance.createValue(languageKit.getURI());
			}
		});
	}
	public static IEntityIterator<IEntity> languageNamespaceIterator() {
		return IteratorFactory.singleValuedRunnableIterator(new LanguageSingleValuedPropertyRunnable() {
			protected IEntity getProperty(ILanguageKit languageKit) {
				return BindingManagerFactory.instance.createValue(languageKit.getNamespace());
			}
		});
	}
	public static IEntityIterator<IEntity> languageNameIterator() {
		return IteratorFactory.singleValuedRunnableIterator(new LanguageSingleValuedPropertyRunnable() {
			protected IEntity getProperty(ILanguageKit languageKit) {
				return BindingManagerFactory.instance.createValue(languageKit.getName());
			}
		});
	}
	public static IEntityIterator<IEntity> languageSimpleNameIterator() {
		return IteratorFactory.singleValuedRunnableIterator(new LanguageSingleValuedPropertyRunnable() {
			protected IEntity getProperty(ILanguageKit languageKit) {
				return BindingManagerFactory.instance.createValue(ResourceUtils.getSimpleName(languageKit));
			}
		});
	}
	public static IEntityIterator<IEntity> languageQualifiedNameIterator() {
		return IteratorFactory.singleValuedRunnableIterator(new LanguageSingleValuedPropertyRunnable() {
			protected IEntity getProperty(ILanguageKit languageKit) {
				return BindingManagerFactory.instance.createValue(ResourceUtils.getQualifiedName(languageKit));
			}
		});
	}
	public static IEntityIterator<IEntity> languageVersionIterator() {
		return IteratorFactory.singleValuedRunnableIterator(new LanguageSingleValuedPropertyRunnable() {
			protected IEntity getProperty(ILanguageKit languageKit) {
				return languageKit.getVersion() != null ?
						BindingManagerFactory.instance.createValue(languageKit.getVersion()) : null;
			}
		});
	}
	public static IEntityIterator<IEntity> languageIsDynamicIterator() {
		return IteratorFactory.singleValuedRunnableIterator(new LanguageSingleValuedPropertyRunnable() {
			protected IEntity getProperty(ILanguageKit languageKit) {
				return BindingManagerFactory.instance.createValue(languageKit.isDynamic());
			}
		});
	}
	public static IEntityIterator<IEntity> languageMetamodelIterator() {
		return IteratorFactory.singleValuedRunnableIterator(new LanguageSingleValuedPropertyRunnable() {
			protected IEntity getProperty(ILanguageKit languageKit) {
				return languageKit.getMetaModel();
			}
		});
	}
	public static IEntityIterator<IEntity> languageEntitiesIterator() {
		return IteratorFactory.multiValuedRunnableIterator(new LanguageMultiValuedPropertyRunnable() {
			protected IEntityIterator<?> getPropertyIterator(ILanguageKit languageKit) {
				return IteratorFactory.collectionIterator(
						languageKit.getEntityDescriptorEnum(),
						new IDataTypeWrapper.CustomDatatypeWrapper(TYPE_ED) {
							@Override
							public <E extends IEntity> E createEntity(Object value) {
								return super.createEntity(((Descriptor) value).getURI());
							}
						});
			}
		});
	}
	public static IEntityIterator<IEntity> languageFeaturesIterator() {
		return IteratorFactory.multiValuedRunnableIterator(new LanguageMultiValuedPropertyRunnable() {
			protected IEntityIterator<?> getPropertyIterator(ILanguageKit languageKit) {
				return IteratorFactory.collectionIterator(
						languageKit.getFeatureDescriptorEnum(),
						new IDataTypeWrapper.CustomDatatypeWrapper(FEATURE_ED) {
							@Override
							public <E extends IEntity> E createEntity(Object value) {
								return super.createEntity(((Descriptor) value).getURI());
							}
						});
			}
		});
	}
	protected abstract static class LanguagePropertyRunnable implements IRunnable {
		public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
			ILanguageKit languageKit = null;

			if (DataTypeUtils.getDataKind(selfEntity).isString()) {
				String languageUri = ResourceUtils.stripResourceFragmentName(selfEntity.wStringValue());
				String contextUri = bm.wIsSet("contextURI") ? bm.wStringValue("contextURI") : null;
				languageKit = ReflectionFactory.getLanguageKit(languageUri, true, contextUri);
			} else if (DataTypeUtils.getDataKind(selfEntity).isEnumValue() && selfEntity.wEnumValue() instanceof Descriptor)
				languageKit = ((Descriptor) selfEntity.wEnumValue()).getLanguageKit();
			else if (DataTypeUtils.getDataKind(selfEntity).isObject()) {
				if (selfEntity.wGetValue() instanceof ILanguageKit)
					languageKit = (ILanguageKit) selfEntity.wGetValue();
				else if (selfEntity.wGetValue() instanceof Descriptor)
					languageKit = ((Descriptor) selfEntity.wGetValue()).getLanguageKit();
			}

			if (languageKit != null)
				setResult(bm, languageKit);
			else
				bm.setResult(null);
		}
		protected abstract void setResult(IBindingManager bm, ILanguageKit languageKit);
	}
	protected abstract static class LanguageSingleValuedPropertyRunnable extends LanguagePropertyRunnable {
		protected void setResult(IBindingManager bm, ILanguageKit languageKit) {
			bm.setResult(getProperty(languageKit));
		}
		protected abstract IEntity getProperty(ILanguageKit languageKit);
	}
	protected abstract static class LanguageMultiValuedPropertyRunnable extends LanguagePropertyRunnable {
		protected void setResult(IBindingManager bm, ILanguageKit languageKit) {
			bm.setResultIterator(getPropertyIterator(languageKit));
		}
		protected abstract IEntityIterator<?> getPropertyIterator(ILanguageKit languageKit);
	}


	public static IEntityIterator<IEntity> entityLanguageIterator() {
		return IteratorFactory.singleValuedRunnableIterator(new EntitySingleValuedPropertyRunnable() {
			protected IEntity getProperty(EntityDescriptor<?> ed) {
				return BindingManagerFactory.instance.createValue(ed.getLanguageKit());
			}
		});
	}
	public static IEntityIterator<IEntity> entityUriIterator() {
		return IteratorFactory.singleValuedRunnableIterator(new EntitySingleValuedPropertyRunnable() {
			protected IEntity getProperty(EntityDescriptor<?> ed) {
				return BindingManagerFactory.instance.createValue(ed.getURI());
			}
		});
	}
	public static IEntityIterator<IEntity> entityOrdinalIterator() {
		return IteratorFactory.singleValuedRunnableIterator(new EntitySingleValuedPropertyRunnable() {
			protected IEntity getProperty(EntityDescriptor<?> ed) {
				return BindingManagerFactory.instance.createValue(ed.getOrdinal());
			}
		});
	}
	public static IEntityIterator<IEntity> entityNameIterator() {
		return IteratorFactory.singleValuedRunnableIterator(new EntitySingleValuedPropertyRunnable() {
			protected IEntity getProperty(EntityDescriptor<?> ed) {
				return BindingManagerFactory.instance.createValue(ed.getName());
			}
		});
	}
	public static IEntityIterator<IEntity> entityImplNameIterator() {
		return IteratorFactory.singleValuedRunnableIterator(new EntitySingleValuedPropertyRunnable() {
			protected IEntity getProperty(EntityDescriptor<?> ed) {
				return BindingManagerFactory.instance.createValue(ed.getImplName());
			}
		});
	}
	public static IEntityIterator<IEntity> entityIsAbstractIterator() {
		return IteratorFactory.singleValuedRunnableIterator(new EntitySingleValuedPropertyRunnable() {
			protected IEntity getProperty(EntityDescriptor<?> ed) {
				return BindingManagerFactory.instance.createValue(ed.isAbstract());
			}
		});
	}
	public static IEntityIterator<IEntity> entityIsRelationshipIterator() {
		return IteratorFactory.singleValuedRunnableIterator(new EntitySingleValuedPropertyRunnable() {
			protected IEntity getProperty(EntityDescriptor<?> ed) {
				return BindingManagerFactory.instance.createValue(ed.isRelationship());
			}
		});
	}
	public static IEntityIterator<IEntity> entityIsToManyRelationshipIterator() {
		return IteratorFactory.singleValuedRunnableIterator(new EntitySingleValuedPropertyRunnable() {
			protected IEntity getProperty(EntityDescriptor<?> ed) {
				return BindingManagerFactory.instance.createValue(ed.isToManyRelationship());
			}
		});
	}
	public static IEntityIterator<IEntity> entityKindIterator() {
		return IteratorFactory.singleValuedRunnableIterator(new EntitySingleValuedPropertyRunnable() {
			protected IEntity getProperty(EntityDescriptor<?> ed) {
				EntityDescriptor<?> kindEd = CommonsDataTypePersistenceParser.getEntityDescriptor(KIND_ED, false, null);
				return GenericEntityFactory.instance.create(
						kindEd, kindEd.getDataEnumType().valueOf(ed.getEntityKind().toString()));
			}
		});
	}
	public static IEntityIterator<IEntity> entitySizeIterator() {
		return IteratorFactory.singleValuedRunnableIterator(new EntitySingleValuedPropertyRunnable() {
			protected IEntity getProperty(EntityDescriptor<?> ed) {
				return BindingManagerFactory.instance.createValue(ed.featureSize());
			}
		});
	}
	public static IEntityIterator<IEntity> entityChildSizeIterator() {
		return IteratorFactory.singleValuedRunnableIterator(new EntitySingleValuedPropertyRunnable() {
			protected IEntity getProperty(EntityDescriptor<?> ed) {
				return BindingManagerFactory.instance.createValue(ed.childFeatureSize());
			}
		});
	}
	public static IEntityIterator<IEntity> entityAdjacentSizeIterator() {
		return IteratorFactory.singleValuedRunnableIterator(new EntitySingleValuedPropertyRunnable() {
			protected IEntity getProperty(EntityDescriptor<?> ed) {
				return BindingManagerFactory.instance.createValue(ed.adjacentFeatureSize());
			}
		});
	}
	public static IEntityIterator<IEntity> entityFeaturesIterator() {
		return IteratorFactory.multiValuedRunnableIterator(new EntityMultiValuedPropertyRunnable() {
			protected IEntityIterator<?> getPropertyIterator(EntityDescriptor<?> ed) {
				return IteratorFactory.collectionIterator(
						ed.getEntityFeatureDescriptors(),
						new IDataTypeWrapper() {
							@SuppressWarnings("unchecked")
							public <E extends IEntity> E createEntity(Object value) {
								return (E) BindingManagerFactory.instance.createValue((Descriptor) value);
							}
						});
			}
		});
	}
	public static IEntityIterator<IEntity> entitySupertypesIterator() {
		return IteratorFactory.multiValuedRunnableIterator(new EntityMultiValuedPropertyRunnable() {
			protected IEntityIterator<?> getPropertyIterator(EntityDescriptor<?> ed) {
				return supertypesIterator(ed, TYPE_ED);
			}
		});
	}
	public static IEntityIterator<IEntity> entitySubtypesIterator() {
		return IteratorFactory.multiValuedRunnableIterator(new EntityMultiValuedPropertyRunnable() {
			protected IEntityIterator<?> getPropertyIterator(EntityDescriptor<?> ed) {
				return subtypesIterator(ed, TYPE_ED);
			}
		});
	}
	public static IEntityIterator<IEntity> entityExtendedConcreteSubtypesIterator() {
		return IteratorFactory.multiValuedRunnableIterator(new EntityMultiValuedPropertyRunnable() {
			protected IEntityIterator<?> getPropertyIterator(EntityDescriptor<?> ed) {
				return extendedConcreteSubtypesIterator(ed, TYPE_ED);
			}
		});
	}
	protected abstract static class EntityPropertyRunnable implements IRunnable {
		public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
			EntityDescriptor<?> ed = null;

			if (DataTypeUtils.getDataKind(selfEntity).isString()) {
				String uri = selfEntity.wStringValue();
				if (ResourceUtils.hasResourceFragmentUri(uri)) {
					String languageUri = ResourceUtils.stripResourceFragmentName(uri);
					String descriptorName = ResourceUtils.getResourceFragmentName(uri);
					String contextUri = bm.wIsSet("contextURI") ? bm.wStringValue("contextURI") : null;
					ILanguageKit languageKit = ReflectionFactory.getLanguageKit(languageUri, true, contextUri);
					if (languageKit != null)
						ed = languageKit.getEntityDescriptorEnum().valueOf(descriptorName);
				}
			} else if (DataTypeUtils.getDataKind(selfEntity).isEnumValue() && selfEntity.wEnumValue() instanceof EntityDescriptor)
				ed = (EntityDescriptor<?>) selfEntity.wEnumValue();
			else if (DataTypeUtils.getDataKind(selfEntity).isObject() && selfEntity.wGetValue() instanceof EntityDescriptor)
				ed = (EntityDescriptor<?>) selfEntity.wGetValue();


			if (ed != null)
				setResult(bm, ed);
			else
				bm.setResult(null);
		}
		protected abstract void setResult(IBindingManager bm, EntityDescriptor<?> ed);
	}
	protected abstract static class EntitySingleValuedPropertyRunnable extends EntityPropertyRunnable {
		protected void setResult(IBindingManager bm, EntityDescriptor<?> ed) {
			bm.setResult(getProperty(ed));
		}
		protected abstract IEntity getProperty(EntityDescriptor<?> ed);
	}
	protected abstract static class EntityMultiValuedPropertyRunnable extends EntityPropertyRunnable {
		protected void setResult(IBindingManager bm, EntityDescriptor<?> ed) {
			bm.setResultIterator(getPropertyIterator(ed));
		}
		protected abstract IEntityIterator<?> getPropertyIterator(EntityDescriptor<?> ed);
	}


	public static IEntityIterator<IEntity> featureLanguageIterator() {
		return IteratorFactory.singleValuedRunnableIterator(new FeatureSingleValuedPropertyRunnable() {
			protected IEntity getProperty(FeatureDescriptor fd) {
				return BindingManagerFactory.instance.createValue(fd.getLanguageKit());
			}
		});
	}
	public static IEntityIterator<IEntity> featureUriIterator() {
		return IteratorFactory.singleValuedRunnableIterator(new FeatureSingleValuedPropertyRunnable() {
			protected IEntity getProperty(FeatureDescriptor fd) {
				return BindingManagerFactory.instance.createValue(fd.getURI());
			}
		});
	}
	public static IEntityIterator<IEntity> featureOrdinalIterator() {
		return IteratorFactory.singleValuedRunnableIterator(new FeatureSingleValuedPropertyRunnable() {
			protected IEntity getProperty(FeatureDescriptor fd) {
				return BindingManagerFactory.instance.createValue(fd.getOrdinal());
			}
		});
	}
	public static IEntityIterator<IEntity> featureNameIterator() {
		return IteratorFactory.singleValuedRunnableIterator(new FeatureSingleValuedPropertyRunnable() {
			protected IEntity getProperty(FeatureDescriptor fd) {
				return BindingManagerFactory.instance.createValue(fd.getName());
			}
		});
	}
	public static IEntityIterator<IEntity> featureImplNameIterator() {
		return IteratorFactory.singleValuedRunnableIterator(new FeatureSingleValuedPropertyRunnable() {
			protected IEntity getProperty(FeatureDescriptor fd) {
				return BindingManagerFactory.instance.createValue(fd.getImplName());
			}
		});
	}
	public static IEntityIterator<IEntity> featureIsOptionalIterator() {
		return IteratorFactory.singleValuedRunnableIterator(new FeatureSingleValuedPropertyRunnable() {
			protected IEntity getProperty(FeatureDescriptor fd) {
				try {
					return BindingManagerFactory.instance.createValue(fd.isOptional());
				} catch(UnsupportedOperationException e) {
					return null;
				}
			}
		});
	}
	public static IEntityIterator<IEntity> featureIsIdIterator() {
		return IteratorFactory.singleValuedRunnableIterator(new FeatureSingleValuedPropertyRunnable() {
			protected IEntity getProperty(FeatureDescriptor fd) {
				try {
					return BindingManagerFactory.instance.createValue(fd.isId());
				} catch(UnsupportedOperationException e) {
					return null;
				}
			}
		});
	}
	public static IEntityIterator<IEntity> featureIsReferenceIterator() {
		return IteratorFactory.singleValuedRunnableIterator(new FeatureSingleValuedPropertyRunnable() {
			protected IEntity getProperty(FeatureDescriptor fd) {
				try {
					return BindingManagerFactory.instance.createValue(fd.isReference());
				} catch(UnsupportedOperationException e) {
					return null;
				}
			}
		});
	}
	public static IEntityIterator<IEntity> featureIsDerivedIterator() {
		return IteratorFactory.singleValuedRunnableIterator(new FeatureSingleValuedPropertyRunnable() {
			protected IEntity getProperty(FeatureDescriptor fd) {
				try {
					return BindingManagerFactory.instance.createValue(fd.isDerived());
				} catch(UnsupportedOperationException e) {
					return null;
				}
			}
		});
	}
	public static IEntityIterator<IEntity> featureIsSharedIterator() {
		return IteratorFactory.singleValuedRunnableIterator(new FeatureSingleValuedPropertyRunnable() {
			protected IEntity getProperty(FeatureDescriptor fd) {
				try {
					return BindingManagerFactory.instance.createValue(fd.isShared());
				} catch(UnsupportedOperationException e) {
					return null;
				}
			}
		});
	}
	public static IEntityIterator<IEntity> featureIsToManyIterator() {
		return IteratorFactory.singleValuedRunnableIterator(new FeatureSingleValuedPropertyRunnable() {
			protected IEntity getProperty(FeatureDescriptor fd) {
				try {
					return BindingManagerFactory.instance.createValue(fd.isToMany());
				} catch(UnsupportedOperationException e) {
					return null;
				}
			}
		});
	}
	public static IEntityIterator<IEntity> featureParentTypeIterator() {
		return IteratorFactory.singleValuedRunnableIterator(new FeatureSingleValuedPropertyRunnable() {
			protected IEntity getProperty(FeatureDescriptor fd) {
				try {
					return BindingManagerFactory.instance.createValue(fd.getParentEntityDescriptor());
				} catch(UnsupportedOperationException e) {
					return null;
				}
			}
		});
	}
	public static IEntityIterator<IEntity> featureOppositeIterator() {
		return IteratorFactory.singleValuedRunnableIterator(new FeatureSingleValuedPropertyRunnable() {
			protected IEntity getProperty(FeatureDescriptor fd) {
				try {
					return BindingManagerFactory.instance.createValue(fd.getOppositeFeatureDescriptor());
				} catch(UnsupportedOperationException e) {
					return null;
				}
			}
		});
	}
	public static IEntityIterator<IEntity> featureTypeIterator() {
		return IteratorFactory.singleValuedRunnableIterator(new FeatureSingleValuedPropertyRunnable() {
			protected IEntity getProperty(FeatureDescriptor fd) {
				try {
					return BindingManagerFactory.instance.createValue(fd.getEntityDescriptor());
				} catch(UnsupportedOperationException e) {
					return null;
				}
			}
		});
	}
	protected abstract static class FeatureSingleValuedPropertyRunnable implements IRunnable {
		public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
			FeatureDescriptor fd = null;

			if (DataTypeUtils.getDataKind(selfEntity).isString()) {
				String uri = selfEntity.wStringValue();
				if (ResourceUtils.hasResourceFragmentUri(uri)) {
					String languageUri = ResourceUtils.stripResourceFragmentName(uri);
					String descriptorName = ResourceUtils.getResourceFragmentName(uri);
					String contextUri = bm.wIsSet("contextURI") ? bm.wStringValue("contextURI") : null;
					ILanguageKit languageKit = ReflectionFactory.getLanguageKit(languageUri, true, contextUri);
					if (languageKit != null)
						fd = languageKit.getFeatureDescriptorEnum().valueOf(descriptorName);
				}
			} else if (DataTypeUtils.getDataKind(selfEntity).isEnumValue() && selfEntity.wEnumValue() instanceof FeatureDescriptor)
				fd = (FeatureDescriptor) selfEntity.wEnumValue();
			else if (DataTypeUtils.getDataKind(selfEntity).isObject() && selfEntity.wGetValue() instanceof FeatureDescriptor)
				fd = (FeatureDescriptor) selfEntity.wGetValue();

			bm.setResult(fd != null ? getProperty(fd) : null);
		}
		protected abstract IEntity getProperty(FeatureDescriptor d);
	}

	public static IEntityIterator<IEntity> languageIterator() {
		return IteratorFactory.singleValuedRunnableIterator(new IRunnable() {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
				EntityDescriptor<?> ed = CommonsDataTypePersistenceParser.getEntityDescriptor(LANGUAGE_ED, false, null);
				bm.setResult(GenericEntityFactory.instance.create(
						ed, selfEntity.wGetLanguageKit().getURI()));
			}
		});
	}

	public static IEntityIterator<IEntity> kindIterator() {
		return IteratorFactory.singleValuedRunnableIterator(new IRunnable() {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
				EntityDescriptor<?> ed = CommonsDataTypePersistenceParser.getEntityDescriptor(KIND_ED, false, null);
				bm.setResult(GenericEntityFactory.instance.create(
						ed, ed.getDataEnumType().valueOf(selfEntity.wGetEntityKind().toString())));
			}
		});
	}

	public static IEntityIterator<IEntity> typeIterator() {
		return IteratorFactory.singleValuedRunnableIterator(new IRunnable() {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
				EntityDescriptor<?> ed = CommonsDataTypePersistenceParser.getEntityDescriptor(TYPE_ED, false, null);
				bm.setResult(GenericEntityFactory.instance.create(
						ed, selfEntity.wGetEntityDescriptor().getURI()));
			}
		});
	}

	public static IEntityIterator<IEntity> atTypeIterator() {
		return IteratorFactory.singleValuedRunnableIterator(new IRunnable() {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
				bm.setResult(BindingManagerFactory.instance.createValue(
						selfEntity.wGetParent().wGetEntityDescriptor(selfEntity)));
			}
		});
	}
	public static IEntityIterator<IEntity> atFeatureIterator() {
		return IteratorFactory.singleValuedRunnableIterator(new IRunnable() {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
				bm.setResult(BindingManagerFactory.instance.createValue(
						selfEntity.wGetParent().wGetFeatureDescriptor(selfEntity)));
			}
		});
	}

	public static IEntityIterator<IEntity> subtypesIterator() {
		return IteratorFactory.multiValuedRunnableIterator(new IRunnable() {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
				bm.setResultIterator(subtypesIterator(selfEntity.wGetEntityDescriptor(), TYPE_ED));
			}
		});
	}
	public static IEntityIterator<IEntity> subtypesIterator(EntityDescriptor<?> ed, String entityTypeUri) {
		return IteratorFactory.collectionIterator(
				ed.languageSubtypesIterable(), new IDataTypeWrapper.CustomDatatypeWrapper(entityTypeUri) {
					@Override
					public <E extends IEntity> E createEntity(Object value) {
						return super.createEntity(((Descriptor) value).getURI());
					}
				});
	}

	public static IEntityIterator<IEntity> supertypesIterator() {
		return IteratorFactory.multiValuedRunnableIterator(new IRunnable() {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
				bm.setResultIterator(supertypesIterator(selfEntity.wGetEntityDescriptor(), TYPE_ED));
			}
		});
	}
	public static IEntityIterator<IEntity> supertypesIterator(EntityDescriptor<?> ed, String entityTypeUri) {
		return IteratorFactory.collectionIterator(
				ed.languageSupertypesIterable(), new IDataTypeWrapper.CustomDatatypeWrapper(entityTypeUri) {
					@Override
					public <E extends IEntity> E createEntity(Object value) {
						return super.createEntity(((Descriptor) value).getURI());
					}
				});
	}
//	new IDataTypeWrapper() {
//		@SuppressWarnings("unchecked")
//		public <E extends IEntity> E createEntity(Object value) {
//			return (E) BindingManagerFactory.instance.createValue((Descriptor) value);
//		}
//	}

	public static IEntityIterator<IEntity> extendedConcreteSubtypesIterator() {
		return IteratorFactory.multiValuedRunnableIterator(new IRunnable() {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
				bm.setResultIterator(extendedConcreteSubtypesIterator(selfEntity.wGetEntityDescriptor(), TYPE_ED));
			}
		});
	}
	public static IEntityIterator<IEntity> extendedConcreteSubtypesIterator(EntityDescriptor<?> ed, String entityTypeUri) {
		return IteratorFactory.collectionIterator(
				ed.getEntityDescriptorEnum().getExtendedLanguageConcreteSubtypesOf(ed), new IDataTypeWrapper.CustomDatatypeWrapper(entityTypeUri) {
					@Override
					public <E extends IEntity> E createEntity(Object value) {
						return super.createEntity(((Descriptor) value).getURI());
					}
				});
	}

	public static IEntityIterator<IEntity> featuresIterator() {
		return IteratorFactory.multiValuedRunnableIterator(new IRunnable() {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
				bm.setResultIterator(featuresIterator(selfEntity.wGetEntityDescriptor(), FEATURE_ED));
			}
		});
	}
	public static IEntityIterator<IEntity> featuresIterator(EntityDescriptor<?> ed, String entityTypeUri) {
		return IteratorFactory.collectionIterator(
				ed.getEntityFeatureDescriptors(), new IDataTypeWrapper.CustomDatatypeWrapper(entityTypeUri) {
					@Override
					public <E extends IEntity> E createEntity(Object value) {
						return super.createEntity(((Descriptor) value).getURI());
					}
				});
	}
	public static IEntityIterator<IEntity> aspectualFeaturesIterator() {
		return IteratorFactory.multiValuedRunnableIterator(new IRunnable() {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
				bm.setResultIterator(IteratorFactory.collectionIterator(
						selfEntity.wGetAspectualFeatureDescriptors(), new IDataTypeWrapper.CustomDatatypeWrapper(FEATURE_ED) {
							@Override
							public <E extends IEntity> E createEntity(Object value) {
								return super.createEntity(((Descriptor) value).getURI());
							}
						}));
			}
		});
	}

	public static IEntityIterator<IEntity> sizeIterator() {
		return IteratorFactory.singleValuedRunnableIterator(new IRunnable() {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
				EntityDescriptor<?> ed = CommonsDataTypePersistenceParser.getEntityDescriptor(INT_ED, false, null);
				bm.setResult(GenericEntityFactory.instance.create(ed, selfEntity.wSize()));
			}
		});
	}

	public static IEntityIterator<IEntity> adjacentSizeIterator() {
		return IteratorFactory.singleValuedRunnableIterator(new IRunnable() {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
				EntityDescriptor<?> ed = CommonsDataTypePersistenceParser.getEntityDescriptor(INT_ED, false, null);
				bm.setResult(GenericEntityFactory.instance.create(ed, selfEntity.wAdjacentSize()));
			}
		});
	}

	public static IEntityIterator<IEntity> inverseAdjacentSizeIterator() {
		return IteratorFactory.singleValuedRunnableIterator(new IRunnable() {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
				EntityDescriptor<?> ed = CommonsDataTypePersistenceParser.getEntityDescriptor(INT_ED, false, null);
				bm.setResult(GenericEntityFactory.instance.create(ed, selfEntity.wInverseAdjacentSize()));
			}
		});
	}

	public static IEntityIterator<IEntity> uriLanguageIterator() {
		return IteratorFactory.singleValuedRunnableIterator(new IRunnable() {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
				IEntity result = null;

				if (DataTypeUtils.getDataKind(selfEntity).isString()) {
					String languageUri = ResourceUtils.stripResourceFragmentName(selfEntity.wStringValue());
					String contextUri = bm.wIsSet("contextURI") ? bm.wStringValue("contextURI") : null;
					ILanguageKit languageKit = ReflectionFactory.getLanguageKit(languageUri, true, contextUri);
					if (languageKit != null)
						result = BindingManagerFactory.instance.createValue(languageKit);
				}

				bm.setResult(result);
			}
		});
	}
	public static IEntityIterator<IEntity> uriEntityIterator() {
		return IteratorFactory.singleValuedRunnableIterator(new IRunnable() {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
				IEntity result = null;

				if (DataTypeUtils.getDataKind(selfEntity).isString()) {
					String uri = selfEntity.wStringValue();
					String contextUri = bm.wIsSet("contextURI") ? bm.wStringValue("contextURI") : null;
			    	EntityDescriptor<?> ed = CommonsDataTypePersistenceParser.getEntityDescriptor(uri, true, contextUri);
					if (ed != null)
						result = BindingManagerFactory.instance.createValue(ed);
				}

				bm.setResult(result);
			}
		});
	}
	public static IEntityIterator<IEntity> uriFeatureIterator() {
		return IteratorFactory.singleValuedRunnableIterator(new IRunnable() {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
				IEntity result = null;

				if (DataTypeUtils.getDataKind(selfEntity).isString()) {
					String uri = selfEntity.wStringValue();
					String contextUri = bm.wIsSet("contextURI") ? bm.wStringValue("contextURI") : null;
			    	FeatureDescriptor fd = CommonsDataTypePersistenceParser.getFeatureDescriptor(uri, true, contextUri);
					if (fd != null)
						result = BindingManagerFactory.instance.createValue(fd);
				}

				bm.setResult(result);
			}
		});
	}
	public static IEntityIterator<IEntity> uriResourcePartIterator() {
		return IteratorFactory.singleValuedRunnableIterator(new IRunnable() {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
				IEntity result = null;

				if (DataTypeUtils.getDataKind(selfEntity).isString()) {
					String uri = selfEntity.wStringValue();
					EntityDescriptor<?> ed = CommonsDataTypePersistenceParser.getEntityDescriptor(STRING_ED, false, null);
					result = GenericEntityFactory.instance.create(ed, ResourceUtils.getResourceFragmentUri(uri));
				}
				bm.setResult(result);
			}
		});
	}
	public static IEntityIterator<IEntity> uriFragmentPartIterator() {
		return IteratorFactory.singleValuedRunnableIterator(new IRunnable() {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
				IEntity result = null;

				if (DataTypeUtils.getDataKind(selfEntity).isString()) {
					String uri = selfEntity.wStringValue();
					EntityDescriptor<?> ed = CommonsDataTypePersistenceParser.getEntityDescriptor(STRING_ED, false, null);
					result = GenericEntityFactory.instance.create(ed, ResourceUtils.getResourceFragmentName(uri));
				}
				bm.setResult(result);
			}
		});
	}
}
