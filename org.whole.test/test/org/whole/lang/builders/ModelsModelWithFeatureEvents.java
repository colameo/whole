/**
 * Copyright 2004-2016 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.builders;

import org.whole.lang.templates.AbstractTemplateFactory;

public class ModelsModelWithFeatureEvents extends AbstractTemplateFactory<org.whole.lang.models.model.Model> {


    public void apply(IBuilderOperation op) {
        org.whole.lang.models.builders.IModelsBuilder b0 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
        b0.Model_();
        b0.SimpleName("Models");
        b0.TypeRelations();
        b0.ModelDeclarations_(23);
        b0.SimpleEntity_();
        b0.EntityModifiers();
        b0.SimpleName("Model");
        b0.Types();
        b0.Features_(3);
        b0.Feature_();
        b0.FeatureModifiers_(1);
        b0.FeatureModifier("id");
        b0._FeatureModifiers();
        // use feature api
        b0.name();
        b0.SimpleName("name");
        b0.type();
        b0.SimpleName("SimpleName");
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers_(1);
        b0.FeatureModifier("optional");
        b0._FeatureModifiers();
        // use feature api
        b0.name();
        b0.SimpleName("typeRelations");
        b0.type();
        b0.SimpleName("TypeRelations");
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers();
        // use feature api
        b0.name();
        b0.SimpleName("declarations");
        b0.type();
        b0.SimpleName("ModelDeclarations");
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.CompositeEntity_();
        b0.EntityModifiers();
        b0.SimpleName("ModelDeclarations");
        b0.Types();
        b0.ComponentModifiers_(1);
        b0.ComponentModifier("ordered");
        b0._ComponentModifiers();
        b0.SimpleName("ModelDeclaration");
        b0._CompositeEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(1);
        b0.EntityModifier("abstract");
        b0._EntityModifiers();
        b0.SimpleName("ModelDeclaration");
        b0.Types();
        b0.Features_(3);
        b0.Feature_();
        b0.FeatureModifiers_(1);
        b0.FeatureModifier("optional");
        b0._FeatureModifiers();
        // use feature api
        b0.name();
        b0.SimpleName("modifiers");
        b0.type();
        b0.SimpleName("EntityModifiers");
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers_(1);
        b0.FeatureModifier("id");
        b0._FeatureModifiers();
        // use feature api
        b0.name();
        b0.SimpleName("name");
        b0.type();
        b0.SimpleName("SimpleName");
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers_(1);
        b0.FeatureModifier("optional");
        b0._FeatureModifiers();
        // use feature api
        b0.name();
        b0.SimpleName("types");
        b0.type();
        b0.SimpleName("Types");
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers();
        b0.SimpleName("SimpleEntity");
        b0.Types_(1);
        b0.SimpleName("ModelDeclaration");
        b0._Types();
        b0.Features_(1);
        b0.Feature_();
        b0.FeatureModifiers_(1);
        b0.FeatureModifier("optional");
        b0._FeatureModifiers();
        // use feature api
        b0.name();
        b0.SimpleName("features");
        b0.type();
        b0.SimpleName("Features");
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers();
        b0.SimpleName("CompositeEntity");
        b0.Types_(1);
        b0.SimpleName("ModelDeclaration");
        b0._Types();
        b0.Features_(2);
        b0.Feature_();
        b0.FeatureModifiers_(1);
        b0.FeatureModifier("optional");
        b0._FeatureModifiers();
        // use feature api
        b0.name();
        b0.SimpleName("componentModifiers");
        b0.type();
        b0.SimpleName("ComponentModifiers");
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers();
        // use feature api
        b0.name();
        b0.SimpleName("componentType");
        b0.type();
        b0.SimpleName("Type");
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers();
        b0.SimpleName("MapEntity");
        b0.Types_(1);
        b0.SimpleName("ModelDeclaration");
        b0._Types();
        b0.Features_(2);
        b0.Feature_();
        b0.FeatureModifiers();
        // use feature api
        b0.name();
        b0.SimpleName("keyType");
        b0.type();
        b0.SimpleName("Type");
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers();
        // use feature api
        b0.name();
        b0.SimpleName("valueType");
        b0.type();
        b0.SimpleName("Type");
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers();
        b0.SimpleName("DataEntity");
        b0.Types_(1);
        b0.SimpleName("ModelDeclaration");
        b0._Types();
        b0.Features_(1);
        b0.Feature_();
        b0.FeatureModifiers();
        // use feature api
        b0.name();
        b0.SimpleName("dataType");
        b0.type();
        b0.SimpleName("DataType");
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers();
        b0.SimpleName("EnumEntity");
        b0.Types_(1);
        b0.SimpleName("ModelDeclaration");
        b0._Types();
        b0.Features_(1);
        b0.Feature_();
        b0.FeatureModifiers();
        // use feature api
        b0.name();
        b0.SimpleName("values");
        b0.type();
        b0.SimpleName("EnumValues");
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.CompositeEntity_();
        b0.EntityModifiers();
        b0.SimpleName("EntityModifiers");
        b0.Types();
        b0.ComponentModifiers_(1);
        b0.ComponentModifier("unique");
        b0._ComponentModifiers();
        b0.SimpleName("EntityModifier");
        b0._CompositeEntity();
        b0.EnumEntity_();
        b0.EntityModifiers();
        b0.SimpleName("EntityModifier");
        b0.Types();
        b0.EnumValues_(1);
        b0.EnumValue("abstract");
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
        b0.Features_(3);
        b0.Feature_();
        b0.FeatureModifiers_(1);
        b0.FeatureModifier("optional");
        b0._FeatureModifiers();
        // use feature api
        b0.name();
        b0.SimpleName("modifiers");
        b0.type();
        b0.SimpleName("FeatureModifiers");
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers();
        // use feature api
        b0.name();
        b0.SimpleName("type");
        b0.type();
        b0.SimpleName("Type");
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers();
        // use feature api
        b0.name();
        b0.SimpleName("name");
        b0.type();
        b0.SimpleName("SimpleName");
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.CompositeEntity_();
        b0.EntityModifiers();
        b0.SimpleName("FeatureModifiers");
        b0.Types();
        b0.ComponentModifiers_(1);
        b0.ComponentModifier("unique");
        b0._ComponentModifiers();
        b0.SimpleName("FeatureModifier");
        b0._CompositeEntity();
        b0.EnumEntity_();
        b0.EntityModifiers();
        b0.SimpleName("FeatureModifier");
        b0.Types();
        b0.EnumValues_(7);
        b0.EnumValue("optional");
        b0.EnumValue("id");
        b0.EnumValue("shared");
        b0.EnumValue("transient");
        b0.EnumValue("reference");
        b0.EnumValue("final");
        b0.EnumValue("derived");
        b0._EnumValues();
        b0._EnumEntity();
        b0.CompositeEntity_();
        b0.EntityModifiers();
        b0.SimpleName("ComponentModifiers");
        b0.Types();
        b0.ComponentModifiers_(1);
        b0.ComponentModifier("unique");
        b0._ComponentModifiers();
        b0.SimpleName("ComponentModifier");
        b0._CompositeEntity();
        b0.EnumEntity_();
        b0.EntityModifiers();
        b0.SimpleName("ComponentModifier");
        b0.Types();
        b0.EnumValues_(6);
        b0.EnumValue("ordered");
        b0.EnumValue("unique");
        b0.EnumValue("sorted");
        b0.EnumValue("shared");
        b0.EnumValue("transient");
        b0.EnumValue("reference");
        b0._EnumValues();
        b0._EnumEntity();
        b0.DataEntity_();
        b0.EntityModifiers();
        b0.SimpleName("DataType");
        b0.Types();
        b0.DataType("String");
        b0._DataEntity();
        b0.CompositeEntity_();
        b0.EntityModifiers();
        b0.SimpleName("EnumValues");
        b0.Types();
        b0.ComponentModifiers_(2);
        b0.ComponentModifier("ordered");
        b0.ComponentModifier("unique");
        b0._ComponentModifiers();
        b0.SimpleName("EnumValue");
        b0._CompositeEntity();
        b0.DataEntity_();
        b0.EntityModifiers();
        b0.SimpleName("EnumValue");
        b0.Types();
        b0.DataType("String");
        b0._DataEntity();
        b0.CompositeEntity_();
        b0.EntityModifiers();
        b0.SimpleName("Types");
        b0.Types();
        b0.ComponentModifiers_(1);
        b0.ComponentModifier("ordered");
        b0._ComponentModifiers();
        b0.SimpleName("Type");
        b0._CompositeEntity();
        b0.CompositeEntity_();
        b0.EntityModifiers();
        b0.SimpleName("TypeRelations");
        b0.Types();
        b0.ComponentModifiers_(1);
        b0.ComponentModifier("unique");
        b0._ComponentModifiers();
        b0.SimpleName("Type");
        b0._CompositeEntity();
        b0.DataEntity_();
        b0.EntityModifiers();
        b0.SimpleName("SimpleName");
        b0.Types_(1);
        b0.SimpleName("Type");
        b0._Types();
        b0.DataType("String");
        b0._DataEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers();
        b0.SimpleName("QualifiedName");
        b0.Types_(1);
        b0.SimpleName("Type");
        b0._Types();
        b0.Features_(2);
        b0.Feature_();
        b0.FeatureModifiers_(1);
        b0.FeatureModifier("id");
        b0._FeatureModifiers();
        // use feature api
        b0.name();
        b0.SimpleName("qualifier");
        b0.type();
        b0.SimpleName("Type");
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers_(1);
        b0.FeatureModifier("id");
        b0._FeatureModifiers();
        // use feature api
        b0.name();
        b0.SimpleName("name");
        b0.type();
        b0.SimpleName("SimpleName");
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0._ModelDeclarations();
        b0._Model();
    }
}
