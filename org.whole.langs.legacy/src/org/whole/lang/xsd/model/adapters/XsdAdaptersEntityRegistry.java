package org.whole.lang.xsd.model.adapters;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.xsd.reflect.XsdEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class XsdAdaptersEntityRegistry extends AbstractEntityRegistry {
	public XsdAdaptersEntityRegistry() {
		super(XsdEntityDescriptorEnum.instance);
	}

	protected void createPrototypes() {
		put(new SchemaAdapter());
		put(new XMLLanguageTypeAdapter());
		put(new SchemaDirectivesAdapter());
		put(new SchemaDirectiveAdapter());
		put(new IncludeAdapter());
		put(new RedefineAdapter());
		put(new RedefineComponentsAdapter());
		put(new RedefineComponentAdapter());
		put(new ImportAdapter());
		put(new AnnotationAdapter());
		put(new AnnotationListAdapter());
		put(new AnnotationTypeAdapter());
		put(new AppinfoAdapter());
		put(new DocumentationAdapter());
		put(new AnyContentAdapter());
		put(new AnnotationContentsAdapter());
		put(new AnnotationContentAdapter());
		put(new SchemaComponentsAdapter());
		put(new SchemaComponentAdapter());
		put(new NotationDeclAdapter());
		put(new ElementDeclAdapter());
		put(new ElementRefAdapter());
		put(new IdentityConstraintDefsAdapter());
		put(new XPathExpressionAdapter());
		put(new FieldsAdapter());
		put(new SelectorAdapter());
		put(new FieldAdapter());
		put(new IdentityConstraintDefAdapter());
		put(new UniqueAdapter());
		put(new KeyAdapter());
		put(new KeyrefAdapter());
		put(new TypeDefAdapter());
		put(new SimpleTypeContentAdapter());
		put(new SimpleTypeDefsAdapter());
		put(new SimpleTypeDefAdapter());
		put(new ComplexTypeContentAdapter());
		put(new ComplexTypeDefAdapter());
		put(new AttributeDeclAdapter());
		put(new AttributeUseOrGroupsAdapter());
		put(new AttributeUseOrGroupAdapter());
		put(new AttributeUseAdapter());
		put(new AttributeUseDeclAdapter());
		put(new AttributeUseRefAdapter());
		put(new AnyAttributeAdapter());
		put(new AttributeGroupDefAdapter());
		put(new AttributeGroupRefAdapter());
		put(new ModelGroupAdapter());
		put(new ModelGroupDefAdapter());
		put(new ModelGroupRefAdapter());
		put(new ParticlesAdapter());
		put(new ParticleAdapter());
		put(new ListAdapter());
		put(new UnionAdapter());
		put(new SimpleTypeRestrictionAdapter());
		put(new FacetsAdapter());
		put(new FacetAdapter());
		put(new StringFacetAdapter());
		put(new FixedFacetAdapter());
		put(new IntegerFacetAdapter());
		put(new WhiteSpaceAdapter());
		put(new LengthAdapter());
		put(new MinLengthAdapter());
		put(new MaxLengthAdapter());
		put(new MinInclusiveAdapter());
		put(new MaxInclusiveAdapter());
		put(new MinExclusiveAdapter());
		put(new MaxExclusiveAdapter());
		put(new TotalDigitsAdapter());
		put(new FractionDigitsAdapter());
		put(new PatternAdapter());
		put(new EnumerationAdapter());
		put(new SimpleContentAdapter());
		put(new ComplexDerivationAdapter());
		put(new ComplexRestrictionAdapter());
		put(new ComplexExtensionAdapter());
		put(new SimpleDerivationAdapter());
		put(new SimpleRestrictionAdapter());
		put(new SimpleExtensionAdapter());
		put(new ComplexContentAdapter());
		put(new DeclaredContentAdapter());
		put(new ModelGroupWithParticlesAdapter());
		put(new SequenceAdapter());
		put(new ChoiceAdapter());
		put(new AllAdapter());
		put(new AnyAdapter());
		put(new WildcardAdapter());
		put(new BoundedAdapter());
		put(new UnboundedAdapter());
		put(new OccurrenceAdapter());
		put(new MemberTypesAdapter());
		put(new NameAdapter());
		put(new QNameAdapter());
		put(new AnyURIAdapter());
		put(new NamespaceDeclAdapter());
		put(new NamespaceDeclsAdapter());
		put(new NSContainerAdapter());
		put(new AttributesAdapter());
		put(new AttributeAdapter());
		put(new NamedComponentAdapter());
		put(new ReferenceAdapter());
		put(new AnnotatedAdapter());
		put(new ProcessContentsAdapter());
		put(new NamespaceSpecsAdapter());
		put(new AnyNamespaceSpecsAdapter());
		put(new OtherNamespaceSpecsAdapter());
		put(new NamespaceSpecsListAdapter());
		put(new NamespaceSpecAdapter());
		put(new TargetNamespaceSpecAdapter());
		put(new LocalNamespaceSpecAdapter());
		put(new DerivationSetAdapter());
		put(new DerivationAllAdapter());
		put(new DerivationListAdapter());
		put(new DerivationControlAdapter());
		put(new UseAdapter());
		put(new WhiteSpaceProcessingAdapter());
		put(new MixedTextAdapter());
		put(new XPathStringAdapter());
		put(new StringDataAdapter());
		put(new IntegerDataAdapter());
		put(new BooleanDataAdapter());
		put(new QualifyAdapter());
		put(new XPathAdapter());
	}
}
