package org.whole.lang.models.codebase;

import org.whole.lang.builders.IBuilderOperation;
import org.whole.lang.templates.AbstractTemplateFactory;

public class VariantsModel extends AbstractTemplateFactory<org.whole.lang.models.model.Model> {

    public void apply(IBuilderOperation op) {
        org.whole.lang.models.builders.IModelsBuilder b0 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
        b0.Model_();
        b0.SimpleName("Variants");
        b0.TypeRelations();
        b0.ModelDeclarations_(17);
        b0.SimpleEntity_();
        b0.EntityModifiers();
        b0.SimpleName("Context");
        b0.Types();
        b0.Features_(7);
        b0.Feature_();
        b0.FeatureModifiers();
        b0.SimpleName("URI");
        b0.SimpleName("uri");
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers();
        b0.SimpleName("Name");
        b0.SimpleName("name");
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers();
        b0.SimpleName("Imports");
        b0.SimpleName("imports");
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers();
        b0.SimpleName("BehaviorSet");
        b0.SimpleName("behaviorSet");
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers();
        b0.SimpleName("VariabilitySet");
        b0.SimpleName("variabilitySet");
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers();
        b0.SimpleName("VariabilityVars");
        b0.SimpleName("variabilityVars");
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers_(1);
        b0.FeatureModifier("optional");
        b0._FeatureModifiers();
        b0.SimpleName("Name");
        b0.SimpleName("currentVariability");
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.CompositeEntity_();
        b0.EntityModifiers();
        b0.SimpleName("Imports");
        b0.Types();
        b0.ComponentModifiers();
        b0.SimpleName("URI");
        b0._CompositeEntity();
        b0.CompositeEntity_();
        b0.EntityModifiers();
        b0.SimpleName("VariabilitySet");
        b0.Types();
        b0.ComponentModifiers();
        b0.SimpleName("Variability");
        b0._CompositeEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers();
        b0.SimpleName("Variability");
        b0.Types();
        b0.Features_(4);
        b0.Feature_();
        b0.FeatureModifiers();
        b0.SimpleName("Name");
        b0.SimpleName("name");
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers();
        b0.SimpleName("BindingStrategy");
        b0.SimpleName("bindingStrategy");
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers();
        b0.SimpleName("Variants");
        b0.SimpleName("variants");
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers();
        b0.SimpleName("Variations");
        b0.SimpleName("variations");
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.EnumEntity_();
        b0.EntityModifiers();
        b0.SimpleName("BindingStrategy");
        b0.Types();
        b0.EnumValues_(3);
        b0.EnumValue("GENERATION_TIME");
        b0.EnumValue("CLOSED_RUNTIME");
        b0.EnumValue("OPEN_RUNTIME");
        b0._EnumValues();
        b0._EnumEntity();
        b0.CompositeEntity_();
        b0.EntityModifiers();
        b0.SimpleName("Variants");
        b0.Types();
        b0.ComponentModifiers_(1);
        b0.ComponentModifier("ordered");
        b0._ComponentModifiers();
        b0.SimpleName("Variant");
        b0._CompositeEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers();
        b0.SimpleName("Variant");
        b0.Types();
        b0.Features_(2);
        b0.Feature_();
        b0.FeatureModifiers();
        b0.SimpleName("Name");
        b0.SimpleName("name");
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers();
        b0.SimpleName("BehaviorSet");
        b0.SimpleName("behaviorSet");
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.CompositeEntity_();
        b0.EntityModifiers();
        b0.SimpleName("BehaviorSet");
        b0.Types();
        b0.ComponentModifiers();
        b0.SimpleName("BehaviorDecl");
        b0._CompositeEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers();
        b0.SimpleName("BehaviorDecl");
        b0.Types();
        b0.Features_(2);
        b0.Feature_();
        b0.FeatureModifiers();
        b0.SimpleName("Name");
        b0.SimpleName("name");
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers();
        b0.SimpleName("Behavior");
        b0.SimpleName("behavior");
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.CompositeEntity_();
        b0.EntityModifiers();
        b0.SimpleName("Variations");
        b0.Types();
        b0.ComponentModifiers();
        b0.SimpleName("Variation");
        b0._CompositeEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers();
        b0.SimpleName("Variation");
        b0.Types();
        b0.Features_(1);
        b0.Feature_();
        b0.FeatureModifiers();
        b0.SimpleName("Name");
        b0.SimpleName("name");
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.CompositeEntity_();
        b0.EntityModifiers();
        b0.SimpleName("VariabilityVars");
        b0.Types();
        b0.ComponentModifiers();
        b0.SimpleName("DeclareVariability");
        b0._CompositeEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers();
        b0.SimpleName("DeclareVariability");
        b0.Types_(1);
        b0.SimpleName("Behavior");
        b0._Types();
        b0.Features_(3);
        b0.Feature_();
        b0.FeatureModifiers();
        b0.SimpleName("Name");
        b0.SimpleName("variabilityName");
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers();
        b0.SimpleName("Name");
        b0.SimpleName("variabilityVar");
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers_(1);
        b0.FeatureModifier("optional");
        b0._FeatureModifiers();
        b0.SimpleName("Name");
        b0.SimpleName("initialVariant");
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers();
        b0.SimpleName("SelectVariant");
        b0.Types_(1);
        b0.SimpleName("Behavior");
        b0._Types();
        b0.Features_(2);
        b0.Feature_();
        b0.FeatureModifiers();
        b0.SimpleName("Name");
        b0.SimpleName("variabilityVar");
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers_(1);
        b0.FeatureModifier("optional");
        b0._FeatureModifiers();
        b0.SimpleName("Name");
        b0.SimpleName("variant");
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers();
        b0.SimpleName("VariationPoint");
        b0.Types_(1);
        b0.SimpleName("Behavior");
        b0._Types();
        b0.Features_(2);
        b0.Feature_();
        b0.FeatureModifiers();
        b0.SimpleName("Name");
        b0.SimpleName("variabilityVar");
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers();
        b0.SimpleName("Name");
        b0.SimpleName("variationName");
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.DataEntity_();
        b0.EntityModifiers();
        b0.SimpleName("URI");
        b0.Types();
        b0.DataType("String");
        b0._DataEntity();
        b0.DataEntity_();
        b0.EntityModifiers();
        b0.SimpleName("Name");
        b0.Types();
        b0.DataType("String");
        b0._DataEntity();
        b0._ModelDeclarations();
        b0.Namespace("org.whole.lang.variants");
        org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
        b1.Resolver();
        b0.URI("http://lang.whole.org/Variants");
        b0._Model();
    }
}
