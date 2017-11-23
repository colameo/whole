package org.whole.lang.rdb;

import org.whole.lang.builders.IBuilderOperation;
import org.whole.lang.templates.AbstractTemplateFactory;

public class RDBSchemaToSQLStatementsQuery extends AbstractTemplateFactory<org.whole.lang.queries.model.Block> {

    public void apply(IBuilderOperation op) {
        org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
        b0.Block_(2);
        b0.Filter_();
        b0.BooleanLiteral(true);
        b0.VariableTest("generateDropStatements");
        b0._Filter();
        b0.Select_();
        b0.Filter_();
        org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
        b1.StageUpFragment_();
        org.whole.lang.sql.builders.ISQLBuilder b2 = (org.whole.lang.sql.builders.ISQLBuilder) op.wGetBuilder(org.whole.lang.sql.reflect.SQLLanguageKit.URI);
        b2.SQLStatements_(3);
        b1.InlineVariable_();
        b1.VarType("http://lang.whole.org/SQL#SQLStatement");
        b1.VarName("tableCreationStatements");
        b1.Quantifier("*");
        b1._InlineVariable();
        b1.Variable_();
        b1.VarType("http://lang.whole.org/SQL#SQLStatement");
        b1.VarName("tableAlterStatement");
        b1.Quantifier("*");
        b1._Variable();
        b1.InlineVariable_();
        b1.VarType("http://lang.whole.org/SQL#SQLStatement");
        b1.VarName("indexCreationStatements");
        b1.Quantifier("*");
        b1._InlineVariable();
        b2._SQLStatements();
        b1._StageUpFragment();
        b0.VariableTest("sqlStatements");
        b0._Filter();
        b0.Filter_();
        b0.SelfStep();
        b0.TypeTest("Schema");
        b0._Filter();
        b0.Sequence_(3);
        b0.Select_();
        b0.Filter_();
        b1.StageUpFragment_();
        b2.SQLStatements_(2);
        b1.Variable_();
        b1.VarType("http://lang.whole.org/SQL#Drop");
        b1.VarName("dropTable");
        b1.Quantifier("?");
        b1._Variable();
        b2.Create_();
        b1.Variable_();
        b1.VarType("http://lang.whole.org/SQL#TableName");
        b1.VarName("tableName");
        b1.Quantifier("!");
        b1._Variable();
        b2.DeclarationOrConstraints_(2);
        b1.Variable_();
        b1.VarType("http://lang.whole.org/SQL#ColumnDeclaration");
        b1.VarName("columnDeclaration");
        b1.Quantifier("+");
        b1._Variable();
        b1.Variable_();
        b1.VarType("http://lang.whole.org/SQL#PrimaryKeyTableConstraint");
        b1.VarName("primaryKey");
        b1.Quantifier("?");
        b1._Variable();
        b2._DeclarationOrConstraints();
        b2._Create();
        b2._SQLStatements();
        b1._StageUpFragment();
        b0.VariableTest("tableCreationStatements");
        b0._Filter();
        b0.Path_(2);
        b0.FeatureStep("tables");
        b0.ChildStep();
        b0._Path();
        b0.Sequence_(5);
        b0.Filter_();
        b0.FeatureStep("name");
        b0.VariableTest("tableName");
        b0._Filter();
        b0.Filter_();
        b0.FeatureStep("indices");
        b0.VariableTest("indices");
        b0._Filter();
        b0.If_();
        b0.VariableRefStep("generateDropStatements");
        b0.Filter_();
        b1.StageUpFragment_();
        b2.Drop_();
        b1.Variable_();
        b1.VarType("http://lang.whole.org/SQL#TableName");
        b1.VarName("tableName");
        b1.Quantifier("!");
        b1._Variable();
        b2._Drop();
        b1._StageUpFragment();
        b0.VariableTest("dropTable");
        b0._Filter();
        b0._If();
        b0.Select_();
        b0.Filter_();
        b1.StageUpFragment_();
        b2.ColumnDeclaration_();
        b1.Variable_();
        b1.VarType("http://lang.whole.org/SQL#ColumnName");
        b1.VarName("columnName");
        b1.Quantifier("!");
        b1._Variable();
        b2.ColumnType_();
        b1.Variable_();
        b1.VarType("http://lang.whole.org/SQL#Type");
        b1.VarName("columnType");
        b1.Quantifier("!");
        b1._Variable();
        b1.Variable_();
        b1.VarType("http://lang.whole.org/SQL#IntValue");
        b1.VarName("size");
        b1.Quantifier("!");
        b1._Variable();
        b1.Resolver();
        b2._ColumnType();
        b2.ColumnConstraints_(2);
        b1.Variable_();
        b1.VarType("http://lang.whole.org/SQL#ColumnConstraint");
        b1.VarName("notNull");
        b1.Quantifier("?");
        b1._Variable();
        b1.Variable_();
        b1.VarType("http://lang.whole.org/SQL#ColumnConstraint");
        b1.VarName("unique");
        b1.Quantifier("?");
        b1._Variable();
        b2._ColumnConstraints();
        b2._ColumnDeclaration();
        b1._StageUpFragment();
        b0.VariableTest("columnDeclaration");
        b0._Filter();
        b0.Path_(2);
        b0.FeatureStep("columns");
        b0.ChildStep();
        b0._Path();
        b0.Sequence_(5);
        b0.Filter_();
        b0.FeatureStep("name");
        b0.VariableTest("columnName");
        b0._Filter();
        b0.Filter_();
        b0.FeatureStep("type");
        b0.VariableTest("columnType");
        b0._Filter();
        b0.Filter_();
        b0.FeatureStep("size");
        b0.VariableTest("size");
        b0._Filter();
        b0.If_();
        b0.Not_();
        b0.Singleton_();
        b0.FeatureStep("nullable");
        b0._Singleton();
        b0._Not();
        b0.Filter_();
        b1.StageUpFragment_();
        b2.SimpleColumnConstraint("NOT_NULL");
        b1._StageUpFragment();
        b0.VariableTest("notNull");
        b0._Filter();
        b0._If();
        b0.If_();
        b0.Some_();
        b0.Path_(2);
        b0.VariableRefStep("indices");
        b0.Filter_();
        b0.ChildStep();
        b0.Some_();
        b0.Path_(2);
        b0.FeatureStep("columnIndices");
        b0.Filter_();
        b0.ChildStep();
        b0.And_(3);
        b0.IndexTest_();
        b0.IntLiteral(0);
        b0._IndexTest();
        b0.PointwiseEquals_();
        b0.FeatureStep("name");
        b0.VariableRefStep("columnName");
        b0._PointwiseEquals();
        b0.Not_();
        b0.Some_();
        b0.FollowingSiblingStep();
        b1.Resolver();
        b0._Some();
        b0._Not();
        b0._And();
        b0._Filter();
        b0._Path();
        b1.Resolver();
        b0._Some();
        b0._Filter();
        b0._Path();
        b1.Resolver();
        b0._Some();
        b0.Filter_();
        b1.StageUpFragment_();
        b2.SimpleColumnConstraint("UNIQUE");
        b1._StageUpFragment();
        b0.VariableTest("unique");
        b0._Filter();
        b0._If();
        b0._Sequence();
        b0.TemplateNames();
        b0._Select();
        b0.Select_();
        b0.Filter_();
        b1.StageUpFragment_();
        b2.PrimaryKeyTableConstraint_();
        b2.ColumnNames_(1);
        b1.Variable_();
        b1.VarType("http://lang.whole.org/SQL#ColumnName");
        b1.VarName("columnName");
        b1.Quantifier("+");
        b1._Variable();
        b2._ColumnNames();
        b2._PrimaryKeyTableConstraint();
        b1._StageUpFragment();
        b0.VariableTest("primaryKey");
        b0._Filter();
        b0.Filter_();
        b0.FeatureStep("primaryKey");
        b0.KindTest("IMPL");
        b0._Filter();
        b0.Path_(2);
        b0.FeatureStep("columnNames");
        b0.Filter_();
        b0.ChildStep();
        b0.VariableTest("columnName");
        b0._Filter();
        b0._Path();
        b0.TemplateNames();
        b0._Select();
        b0._Sequence();
        b0.TemplateNames();
        b0._Select();
        b0.Select_();
        b0.Filter_();
        b1.StageUpFragment_();
        b2.AlterTable_();
        b1.Variable_();
        b1.VarType("http://lang.whole.org/SQL#TableName");
        b1.VarName("tableName");
        b1.Quantifier("!");
        b1._Variable();
        b2.AddAction_();
        b2.ForeignKeyTableConstraint_();
        b2.ColumnNames_(1);
        b1.Variable_();
        b1.VarType("http://lang.whole.org/SQL#ColumnName");
        b1.VarName("columnName");
        b1.Quantifier("+");
        b1._Variable();
        b2._ColumnNames();
        b1.Variable_();
        b1.VarType("http://lang.whole.org/SQL#TableName");
        b1.VarName("foreignTableName");
        b1.Quantifier("!");
        b1._Variable();
        b2.ColumnNames_(1);
        b1.Variable_();
        b1.VarType("http://lang.whole.org/SQL#ColumnName");
        b1.VarName("foreignColumnName");
        b1.Quantifier("*");
        b1._Variable();
        b2._ColumnNames();
        b1.Resolver();
        b1.Variable_();
        b1.VarType("http://lang.whole.org/SQL#Action");
        b1.VarName("onDelete");
        b1.Quantifier("?");
        b1._Variable();
        b1.Variable_();
        b1.VarType("http://lang.whole.org/SQL#Action");
        b1.VarName("onUpdate");
        b1.Quantifier("?");
        b1._Variable();
        b1.Variable_();
        b1.VarType("http://lang.whole.org/SQL#Deferrable");
        b1.VarName("deferrable");
        b1.Quantifier("?");
        b1._Variable();
        b1.Variable_();
        b1.VarType("http://lang.whole.org/SQL#DeferCheck");
        b1.VarName("deferCheck");
        b1.Quantifier("?");
        b1._Variable();
        b2._ForeignKeyTableConstraint();
        b2._AddAction();
        b2._AlterTable();
        b1._StageUpFragment();
        b0.VariableTest("tableAlterStatement");
        b0._Filter();
        b0.Path_(4);
        b0.FeatureStep("tables");
        b0.Filter_();
        b0.ChildStep();
        b0.And_(2);
        b0.Some_();
        b0.Path_(2);
        b0.FeatureStep("foreignKeys");
        b0.ChildStep();
        b0._Path();
        b1.Resolver();
        b0._Some();
        b0.Some_();
        b0.Filter_();
        b0.FeatureStep("name");
        b0.VariableTest("tableName");
        b0._Filter();
        b1.Resolver();
        b0._Some();
        b0._And();
        b0._Filter();
        b0.FeatureStep("foreignKeys");
        b0.ChildStep();
        b0._Path();
        b0.Sequence_(5);
        b0.Filter_();
        b0.FeatureStep("targetTable");
        b0.VariableTest("foreignTableName");
        b0._Filter();
        b0.Select_();
        b0.Tuple_(2);
        b0.Filter_();
        b0.FeatureStep("source");
        b0.VariableTest("columnName");
        b0._Filter();
        b0.Filter_();
        b0.FeatureStep("target");
        b0.VariableTest("foreignColumnName");
        b0._Filter();
        b0._Tuple();
        b0.Path_(2);
        b0.FeatureStep("columnReferences");
        b0.ChildStep();
        b0._Path();
        b1.Resolver();
        b0.TemplateNames();
        b0._Select();
        b0.Filter_();
        b0.Choose_(2);
        b0.Filter_();
        b0.FeatureStep("deleteAction");
        b0.KindTest("IMPL");
        b0._Filter();
        b0.Do_();
        b1.StageUpFragment_();
        b2.Action("NO_ACTION");
        b1._StageUpFragment();
        b0._Do();
        b0._Choose();
        b0.VariableTest("onDelete");
        b0._Filter();
        b0.Filter_();
        b0.Choose_(2);
        b0.Filter_();
        b0.FeatureStep("updateAction");
        b0.KindTest("IMPL");
        b0._Filter();
        b0.Do_();
        b1.StageUpFragment_();
        b2.Action("NO_ACTION");
        b1._StageUpFragment();
        b0._Do();
        b0._Choose();
        b0.VariableTest("onUpdate");
        b0._Filter();
        b0.Filter_();
        b0.FeatureStep("deferrability");
        b0.Or_(2);
        b0.And_(2);
        b0.MatchTest_();
        b1.StageUpFragment_();
        b2.Deferrable("DEFERRABLE");
        b1._StageUpFragment();
        b0._MatchTest();
        b0.VariableTest("deferrable");
        b0._And();
        b0.And_(2);
        b0.MatchTest_();
        b1.StageUpFragment_();
        b2.DeferCheck("INITIALLY_DEFERRED");
        b1._StageUpFragment();
        b0._MatchTest();
        b0.VariableTest("deferCheck");
        b0._And();
        b0._Or();
        b0._Filter();
        b0._Sequence();
        b0.TemplateNames();
        b0._Select();
        b0.Select_();
        b0.Filter_();
        b1.StageUpFragment_();
        b2.SQLStatements_(2);
        b1.Variable_();
        b1.VarType("http://lang.whole.org/SQL#DropIndex");
        b1.VarName("dropIndex");
        b1.Quantifier("?");
        b1._Variable();
        b2.CreateIndex_();
        b1.Variable_();
        b1.VarType("http://lang.whole.org/SQL#UniqueIndex");
        b1.VarName("unique");
        b1.Quantifier("?");
        b1._Variable();
        b1.Variable_();
        b1.VarType("http://lang.whole.org/SQL#IndexName");
        b1.VarName("indexName");
        b1.Quantifier("!");
        b1._Variable();
        b1.Variable_();
        b1.VarType("http://lang.whole.org/SQL#TableName");
        b1.VarName("tableName");
        b1.Quantifier("!");
        b1._Variable();
        b2.IndexDeclarations_(1);
        b1.Variable_();
        b1.VarType("http://lang.whole.org/SQL#IndexDeclaration");
        b1.VarName("indexDeclaration");
        b1.Quantifier("+");
        b1._Variable();
        b2._IndexDeclarations();
        b2._CreateIndex();
        b2._SQLStatements();
        b1._StageUpFragment();
        b0.VariableTest("indexCreationStatements");
        b0._Filter();
        b0.Path_(4);
        b0.FeatureStep("tables");
        b0.Filter_();
        b0.ChildStep();
        b0.Some_();
        b0.Filter_();
        b0.FeatureStep("name");
        b0.VariableTest("tableName");
        b0._Filter();
        b1.Resolver();
        b0._Some();
        b0._Filter();
        b0.FeatureStep("indices");
        b0.Filter_();
        b0.ChildStep();
        b0.Some_();
        b0.Filter_();
        b0.FeatureStep("name");
        b0.VariableTest("indexName");
        b0._Filter();
        b1.Resolver();
        b0._Some();
        b0._Filter();
        b0._Path();
        b0.Sequence_(3);
        b0.If_();
        b0.VariableRefStep("generateDropStatements");
        b0.Filter_();
        b1.StageUpFragment_();
        b2.DropIndex_();
        b1.Variable_();
        b1.VarType("http://lang.whole.org/SQL#IndexName");
        b1.VarName("indexName");
        b1.Quantifier("!");
        b1._Variable();
        b2._DropIndex();
        b1._StageUpFragment();
        b0.VariableTest("dropIndex");
        b0._Filter();
        b0._If();
        b0.If_();
        b0.Singleton_();
        b0.FeatureStep("unique");
        b0._Singleton();
        b0.Filter_();
        b1.StageUpFragment_();
        b2.UniqueIndex();
        b1._StageUpFragment();
        b0.VariableTest("unique");
        b0._Filter();
        b0._If();
        b0.Select_();
        b0.Filter_();
        b1.StageUpFragment_();
        b2.IndexDeclaration_();
        b1.Variable_();
        b1.VarType("http://lang.whole.org/SQL#ColumnName");
        b1.VarName("columnName");
        b1.Quantifier("!");
        b1._Variable();
        b1.Variable_();
        b1.VarType("http://lang.whole.org/SQL#OrderType");
        b1.VarName("orderType");
        b1.Quantifier("?");
        b1._Variable();
        b1.Resolver();
        b2._IndexDeclaration();
        b1._StageUpFragment();
        b0.VariableTest("indexDeclaration");
        b0._Filter();
        b0.Path_(2);
        b0.FeatureStep("columnIndices");
        b0.Filter_();
        b0.ChildStep();
        b0.Some_();
        b0.Filter_();
        b0.FeatureStep("name");
        b0.VariableTest("columnName");
        b0._Filter();
        b1.Resolver();
        b0._Some();
        b0._Filter();
        b0._Path();
        b0.Path_(2);
        b0.FeatureStep("order");
        b0.Filter_();
        b0.Choose_(2);
        b0.If_();
        b0.MatchTest_();
        b1.StageUpFragment_();
        org.whole.lang.rdb.builders.IRDBBuilder b3 = (org.whole.lang.rdb.builders.IRDBBuilder) op.wGetBuilder(org.whole.lang.rdb.reflect.RDBLanguageKit.URI);
        b3.Order("ASCENDING");
        b1._StageUpFragment();
        b0._MatchTest();
        b1.StageUpFragment_();
        b2.OrderType("ASC");
        b1._StageUpFragment();
        b0._If();
        b0.If_();
        b0.MatchTest_();
        b1.StageUpFragment_();
        b3.Order("DESCENDING");
        b1._StageUpFragment();
        b0._MatchTest();
        b1.StageUpFragment_();
        b2.OrderType("DESC");
        b1._StageUpFragment();
        b0._If();
        b0._Choose();
        b0.VariableTest("orderType");
        b0._Filter();
        b0._Path();
        b0.TemplateNames();
        b0._Select();
        b0._Sequence();
        b0.TemplateNames();
        b0._Select();
        b0._Sequence();
        b0.TemplateNames();
        b0._Select();
        b0._Block();
    }
}
