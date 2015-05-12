/**
 * Copyright 2004-2015 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.models.codebase;

import org.whole.lang.builders.IBuilderOperation;
import org.whole.lang.templates.AbstractTemplateFactory;

public class ParsersModel extends AbstractTemplateFactory<org.whole.lang.models.model.Model> {


    public void apply(IBuilderOperation op) {
        org.whole.lang.models.builders.IModelsBuilder b0 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
        b0.Model_();
        b0.SimpleName("Parsers");
        org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
        b1.Resolver();
        b0.ModelDeclarations_(15);
        b0.SimpleEntity_();
        b0.EntityModifiers();
        b0.SimpleName("TextData");
        b0.Types();
        b0.Features_(3);
        b0.Feature_();
        b1.Resolver();
        b0.SimpleName("StringData");
        b0.SimpleName("encoding");
        b0._Feature();
        b0.Feature_();
        b1.Resolver();
        b0.SimpleName("IntData");
        b0.SimpleName("tabSize");
        b0._Feature();
        b0.Feature_();
        b1.Resolver();
        b0.SimpleName("ParseStep");
        b0.SimpleName("parseStep");
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers();
        b0.SimpleName("RepeatedSplitStep");
        b0.Types_(1);
        b0.SimpleName("ParseStep");
        b0._Types();
        b0.Features_(3);
        b0.Feature_();
        b1.Resolver();
        b0.SimpleName("Mode");
        b0.SimpleName("mode");
        b0._Feature();
        b0.Feature_();
        b1.Resolver();
        b0.SimpleName("IntData");
        b0.SimpleName("splitLineOffset");
        b0._Feature();
        b0.Feature_();
        b1.Resolver();
        b0.SimpleName("ParseStep");
        b0.SimpleName("parseStep");
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers();
        b0.SimpleName("SplitOnceStep");
        b0.Types_(1);
        b0.SimpleName("ParseStep");
        b0._Types();
        b0.Features_(4);
        b0.Feature_();
        b1.Resolver();
        b0.SimpleName("Mode");
        b0.SimpleName("mode");
        b0._Feature();
        b0.Feature_();
        b1.Resolver();
        b0.SimpleName("IntData");
        b0.SimpleName("splitLine");
        b0._Feature();
        b0.Feature_();
        b1.Resolver();
        b0.SimpleName("ParseStep");
        b0.SimpleName("parseStep1");
        b0._Feature();
        b0.Feature_();
        b1.Resolver();
        b0.SimpleName("ParseStep");
        b0.SimpleName("parseStep2");
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers();
        b0.SimpleName("SwitchStep");
        b0.Types_(1);
        b0.SimpleName("ParseStep");
        b0._Types();
        b0.Features_(2);
        b0.Feature_();
        b1.Resolver();
        b0.SimpleName("Cases");
        b0.SimpleName("cases");
        b0._Feature();
        b0.Feature_();
        b1.Resolver();
        b0.SimpleName("ParseStep");
        b0.SimpleName("defaultParseStep");
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.CompositeEntity_();
        b0.EntityModifiers();
        b0.SimpleName("Cases");
        b0.Types();
        b0.ComponentModifiers_(1);
        b0.ComponentModifier("ordered");
        b0._ComponentModifiers();
        b0.SimpleName("Case");
        b0._CompositeEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers();
        b0.SimpleName("Case");
        b0.Types();
        b0.Features_(3);
        b0.Feature_();
        b1.Resolver();
        b0.SimpleName("Condition");
        b0.SimpleName("conditionTest");
        b0._Feature();
        b0.Feature_();
        b1.Resolver();
        b0.SimpleName("StringData");
        b0.SimpleName("conditionData");
        b0._Feature();
        b0.Feature_();
        b1.Resolver();
        b0.SimpleName("ParseStep");
        b0.SimpleName("parseStep");
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.DataEntity_();
        b0.EntityModifiers();
        b0.SimpleName("LiteralStep");
        b0.Types_(1);
        b0.SimpleName("ParseStep");
        b0._Types();
        b0.DataType("String");
        b0._DataEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers();
        b0.SimpleName("IgnoreStep");
        b0.Types_(1);
        b0.SimpleName("ParseStep");
        b0._Types();
        b0.Features();
        b0._SimpleEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers();
        b0.SimpleName("DelimitedEntitiesStep");
        b0.Types_(1);
        b0.SimpleName("ParseStep");
        b0._Types();
        b0.Features_(7);
        b0.Feature_();
        b1.Resolver();
        b0.SimpleName("StringData");
        b0.SimpleName("entitySeparator");
        b0._Feature();
        b0.Feature_();
        b1.Resolver();
        b0.SimpleName("StringData");
        b0.SimpleName("featureSeparator");
        b0._Feature();
        b0.Feature_();
        b1.Resolver();
        b0.SimpleName("StringData");
        b0.SimpleName("quoteCharacter");
        b0._Feature();
        b0.Feature_();
        b1.Resolver();
        b0.SimpleName("StringData");
        b0.SimpleName("escapeCharacter");
        b0._Feature();
        b0.Feature_();
        b1.Resolver();
        b0.SimpleName("BooleanData");
        b0.SimpleName("skipFirstRow");
        b0._Feature();
        b0.Feature_();
        b1.Resolver();
        b0.SimpleName("Name");
        b0.SimpleName("entityName");
        b0._Feature();
        b0.Feature_();
        b1.Resolver();
        b0.SimpleName("Features");
        b0.SimpleName("entityFeatures");
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers();
        b0.SimpleName("DataEntityStep");
        b0.Types_(1);
        b0.SimpleName("ParseStep");
        b0._Types();
        b0.Features_(3);
        b0.Feature_();
        b1.Resolver();
        b0.SimpleName("Name");
        b0.SimpleName("entityName");
        b0._Feature();
        b0.Feature_();
        b1.Resolver();
        b0.SimpleName("Type");
        b0.SimpleName("datatype");
        b0._Feature();
        b0.Feature_();
        b1.Resolver();
        b0.SimpleName("BooleanData");
        b0.SimpleName("trim");
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.EnumEntity_();
        b1.Resolver();
        b0.SimpleName("Condition");
        b1.Resolver();
        b0.EnumValues_(3);
        b0.EnumValue("STARTS_WITH");
        b0.EnumValue("ENDS_WITH");
        b0.EnumValue("CONTAINS");
        b0._EnumValues();
        b0._EnumEntity();
        b0.EnumEntity_();
        b1.Resolver();
        b0.SimpleName("Mode");
        b1.Resolver();
        b0.EnumValues_(2);
        b0.EnumValue("FIXED_LENGTH");
        b0.EnumValue("DELIMITED_LINE_BASED");
        b0._EnumValues();
        b0._EnumEntity();
        b0.CompositeEntity_();
        b0.EntityModifiers();
        b0.SimpleName("Features");
        b0.Types();
        b0.ComponentModifiers_(1);
        b0.ComponentModifier("ordered");
        b0._ComponentModifiers();
        b0.SimpleName("Feature");
        b0._CompositeEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers();
        b0.SimpleName("Feature");
        b0.Types();
        b0.Features_(2);
        b0.Feature_();
        b1.Resolver();
        b0.SimpleName("DataType");
        b0.SimpleName("datatype");
        b0._Feature();
        b0.Feature_();
        b1.Resolver();
        b0.SimpleName("Name");
        b0.SimpleName("name");
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.EnumEntity_();
        b1.Resolver();
        b0.SimpleName("DataType");
        b1.Resolver();
        b0.EnumValues_(2);
        b0.EnumValue("int");
        b0.EnumValue("string");
        b0._EnumValues();
        b0._EnumEntity();
        b0._ModelDeclarations();
        b0.Namespace("org.whole.lang.parsers");
        b1.Resolver();
        b0.URI("http://lang.whole.org/Parsers");
        b0._Model();
    }
}
