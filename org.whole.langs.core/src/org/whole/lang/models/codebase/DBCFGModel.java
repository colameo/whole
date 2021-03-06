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
package org.whole.lang.models.codebase;

import org.whole.lang.builders.IBuilderOperation;
import org.whole.lang.templates.AbstractTemplateFactory;

public class DBCFGModel extends AbstractTemplateFactory<org.whole.lang.models.model.Model> {

    public void apply(IBuilderOperation op) {
        org.whole.lang.models.builders.IModelsBuilder b0 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
        b0.Model_();
        b0.SimpleName("DBCFG");
        b0.TypeRelations();
        b0.ModelDeclarations_(18);
        b0.SimpleEntity_();
        b0.EntityModifiers();
        b0.SimpleName("DBConfiguration");
        b0.Types();
        b0.Features_(3);
        b0.Feature_();
        b0.FeatureModifiers();
        b0.SimpleName("JDBCDrivers");
        b0.SimpleName("drivers");
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers();
        b0.SimpleName("DataSources");
        b0.SimpleName("dataSources");
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers();
        b0.SimpleName("Index");
        b0.SimpleName("dataSourceIndex");
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.CompositeEntity_();
        b0.EntityModifiers();
        b0.SimpleName("JDBCDrivers");
        b0.Types();
        b0.ComponentModifiers_(1);
        b0.ComponentModifier("unique");
        b0._ComponentModifiers();
        b0.SimpleName("JDBCDriver");
        b0._CompositeEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers();
        b0.SimpleName("JDBCDriver");
        b0.Types();
        b0.Features_(4);
        b0.Feature_();
        b0.FeatureModifiers_(1);
        b0.FeatureModifier("id");
        b0._FeatureModifiers();
        b0.SimpleName("DriverName");
        b0.SimpleName("driverName");
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers();
        b0.SimpleName("ClassName");
        b0.SimpleName("driverClassName");
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers();
        b0.SimpleName("Files");
        b0.SimpleName("files");
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers();
        b0.SimpleName("Dialect");
        b0.SimpleName("dialect");
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.CompositeEntity_();
        b0.EntityModifiers();
        b0.SimpleName("Files");
        b0.Types();
        b0.ComponentModifiers();
        b0.SimpleName("FilePath");
        b0._CompositeEntity();
        b0.CompositeEntity_();
        b0.EntityModifiers();
        b0.SimpleName("DataSources");
        b0.Types();
        b0.ComponentModifiers_(1);
        b0.ComponentModifier("ordered");
        b0._ComponentModifiers();
        b0.SimpleName("DataSource");
        b0._CompositeEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers();
        b0.SimpleName("DataSource");
        b0.Types();
        b0.Features_(8);
        b0.Feature_();
        b0.FeatureModifiers();
        b0.SimpleName("DriverName");
        b0.SimpleName("driverName");
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers();
        b0.SimpleName("Url");
        b0.SimpleName("url");
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers();
        b0.SimpleName("ServerName");
        b0.SimpleName("serverName");
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers();
        b0.SimpleName("PortNumber");
        b0.SimpleName("portNumber");
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers();
        b0.SimpleName("DatabaseName");
        b0.SimpleName("databaseName");
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers();
        b0.SimpleName("DatabaseSchema");
        b0.SimpleName("databaseSchema");
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers();
        b0.SimpleName("UserName");
        b0.SimpleName("userName");
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers();
        b0.SimpleName("Password");
        b0.SimpleName("password");
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.DataEntity_();
        b0.EntityModifiers();
        b0.SimpleName("Index");
        b0.Types();
        b0.DataType("int");
        b0._DataEntity();
        b0.EnumEntity_();
        b0.EntityModifiers();
        b0.SimpleName("Dialect");
        b0.Types();
        b0.EnumValues_(6);
        b0.EnumValue("ORACLE");
        b0.EnumValue("DB2");
        b0.EnumValue("DB2_UDB");
        b0.EnumValue("MSSQL");
        b0.EnumValue("PGSQL");
        b0.EnumValue("MYSQL");
        b0._EnumValues();
        b0._EnumEntity();
        b0.DataEntity_();
        b0.EntityModifiers();
        b0.SimpleName("Url");
        b0.Types();
        b0.DataType("String");
        b0._DataEntity();
        b0.DataEntity_();
        b0.EntityModifiers();
        b0.SimpleName("ServerName");
        b0.Types();
        b0.DataType("String");
        b0._DataEntity();
        b0.DataEntity_();
        b0.EntityModifiers();
        b0.SimpleName("PortNumber");
        b0.Types();
        b0.DataType("int");
        b0._DataEntity();
        b0.DataEntity_();
        b0.EntityModifiers();
        b0.SimpleName("DatabaseName");
        b0.Types();
        b0.DataType("String");
        b0._DataEntity();
        b0.DataEntity_();
        b0.EntityModifiers();
        b0.SimpleName("DatabaseSchema");
        b0.Types();
        b0.DataType("String");
        b0._DataEntity();
        b0.DataEntity_();
        b0.EntityModifiers();
        b0.SimpleName("UserName");
        b0.Types();
        b0.DataType("String");
        b0._DataEntity();
        b0.DataEntity_();
        b0.EntityModifiers();
        b0.SimpleName("Password");
        b0.Types();
        b0.DataType("String");
        b0._DataEntity();
        b0.DataEntity_();
        b0.EntityModifiers();
        b0.SimpleName("DriverName");
        b0.Types();
        b0.DataType("String");
        b0._DataEntity();
        b0.DataEntity_();
        b0.EntityModifiers();
        b0.SimpleName("ClassName");
        b0.Types();
        b0.DataType("String");
        b0._DataEntity();
        b0.DataEntity_();
        b0.EntityModifiers();
        b0.SimpleName("FilePath");
        b0.Types();
        b0.DataType("String");
        b0._DataEntity();
        b0._ModelDeclarations();
        b0.Namespace("org.whole.lang.dbcfg");
        org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
        b1.Resolver();
        b0.URI("http://lang.whole.org/DBCFG");
        b0._Model();
    }
}
