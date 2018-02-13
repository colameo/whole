package org.whole.lang.pojo.util;

import org.whole.lang.builders.IBuilderOperation;
import org.whole.lang.templates.AbstractTemplateFactory;

public class SimplePojoMappedModel extends AbstractTemplateFactory {


    public void apply(IBuilderOperation op) {
        org.whole.lang.models.builders.IModelsBuilder b0 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
        b0.Model_();
        b0.SimpleName("SimplePojo");
        b0.TypeRelations();
        b0.ModelDeclarations_(18);
        b0.SimpleEntity_();
        b0.EntityModifiers();
        b0.SimpleName("SimplePojo");
        b0.Types();
        b0.Features_(15);
        b0.Feature_();
        b0.FeatureModifiers();
        b0.SimpleName("BooleanData");
        b0.SimpleName("fBoolean");
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers();
        b0.SimpleName("ByteData");
        b0.SimpleName("fByte");
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers();
        b0.SimpleName("CharData");
        b0.SimpleName("fChar");
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers();
        b0.SimpleName("DoubleData");
        b0.SimpleName("fDouble");
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers();
        b0.SimpleName("FloatData");
        b0.SimpleName("fFloat");
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers();
        b0.SimpleName("IntData");
        b0.SimpleName("fInt");
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers();
        b0.SimpleName("LongData");
        b0.SimpleName("fLong");
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers();
        b0.SimpleName("ShortData");
        b0.SimpleName("fShort");
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers();
        b0.SimpleName("StringData");
        b0.SimpleName("fString");
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers();
        b0.SimpleName("SimplePojo");
        b0.SimpleName("leftPojo");
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers();
        b0.SimpleName("SimplePojo");
        b0.SimpleName("rightPojo");
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers();
        b0.SimpleName("Pattern");
        b0.SimpleName("pattern");
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers();
        b0.SimpleName("AbstractPojo1");
        b0.SimpleName("abstractPojo");
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers();
        b0.SimpleName("EnumPojo");
        b0.SimpleName("enumPojo");
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers();
        b0.SimpleName("PatternSetArray");
        b0.SimpleName("fSet");
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.DataEntity_();
        b0.EntityModifiers();
        b0.SimpleName("BooleanData");
        b0.Types();
        b0.DataType("boolean");
        b0._DataEntity();
        b0.DataEntity_();
        b0.EntityModifiers();
        b0.SimpleName("ByteData");
        b0.Types();
        b0.DataType("byte");
        b0._DataEntity();
        b0.DataEntity_();
        b0.EntityModifiers();
        b0.SimpleName("CharData");
        b0.Types();
        b0.DataType("char");
        b0._DataEntity();
        b0.DataEntity_();
        b0.EntityModifiers();
        b0.SimpleName("DoubleData");
        b0.Types();
        b0.DataType("double");
        b0._DataEntity();
        b0.DataEntity_();
        b0.EntityModifiers();
        b0.SimpleName("FloatData");
        b0.Types();
        b0.DataType("float");
        b0._DataEntity();
        b0.DataEntity_();
        b0.EntityModifiers();
        b0.SimpleName("IntData");
        b0.Types();
        b0.DataType("int");
        b0._DataEntity();
        b0.DataEntity_();
        b0.EntityModifiers();
        b0.SimpleName("LongData");
        b0.Types();
        b0.DataType("long");
        b0._DataEntity();
        b0.DataEntity_();
        b0.EntityModifiers();
        b0.SimpleName("ShortData");
        b0.Types();
        b0.DataType("short");
        b0._DataEntity();
        b0.DataEntity_();
        b0.EntityModifiers();
        b0.SimpleName("StringData");
        b0.Types();
        b0.DataType("String");
        b0._DataEntity();
        b0.DataEntity_();
        b0.EntityModifiers();
        b0.SimpleName("Pattern");
        b0.Types();
        b0.DataType("java.util.regex.Pattern");
        b0._DataEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(1);
        b0.EntityModifier("abstract");
        b0._EntityModifiers();
        b0.SimpleName("AbstractPojo1");
        b0.Types();
        b0.Features_(1);
        b0.Feature_();
        b0.FeatureModifiers();
        b0.SimpleName("Pattern");
        b0.SimpleName("pattern");
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(1);
        b0.EntityModifier("abstract");
        b0._EntityModifiers();
        b0.SimpleName("AbstractPojo2");
        b0.Types_(1);
        b0.SimpleName("AbstractPojo1");
        b0._Types();
        b0.Features_(1);
        b0.Feature_();
        b0.FeatureModifiers();
        b0.SimpleName("BooleanData");
        b0.SimpleName("valid");
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers();
        b0.SimpleName("ConcretePojo1");
        b0.Types_(1);
        b0.SimpleName("AbstractPojo1");
        b0._Types();
        b0.Features_(1);
        b0.Feature_();
        b0.FeatureModifiers();
        b0.SimpleName("StringData");
        b0.SimpleName("name");
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers();
        b0.SimpleName("ConcretePojo2");
        b0.Types_(1);
        b0.SimpleName("AbstractPojo2");
        b0._Types();
        b0.Features_(1);
        b0.Feature_();
        b0.FeatureModifiers();
        b0.SimpleName("IntData");
        b0.SimpleName("number");
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.EnumEntity_();
        b0.EntityModifiers();
        b0.SimpleName("EnumPojo");
        b0.Types();
        b0.EnumValues_(3);
        b0.EnumValue("VALUE1");
        b0.EnumValue("VALUE2");
        b0.EnumValue("VALUE3");
        b0._EnumValues();
        b0._EnumEntity();
        b0.CompositeEntity_();
        b0.EntityModifiers();
        b0.SimpleName("PatternSet");
        b0.Types();
        b0.ComponentModifiers_(1);
        b0.ComponentModifier("unique");
        b0._ComponentModifiers();
        b0.SimpleName("Pattern");
        b0._CompositeEntity();
        b0.CompositeEntity_();
        b0.EntityModifiers();
        b0.SimpleName("PatternSetArray");
        b0.Types();
        b0.ComponentModifiers_(1);
        b0.ComponentModifier("ordered");
        b0._ComponentModifiers();
        b0.SimpleName("PatternSet");
        b0._CompositeEntity();
        b0._ModelDeclarations();
        b0._Model();
    }
}
