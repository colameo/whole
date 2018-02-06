package org.whole.examples.xml;

import org.whole.lang.builders.IBuilderOperation;
import org.whole.lang.templates.AbstractTemplateFactory;

public class XmlActions extends AbstractTemplateFactory<org.whole.lang.actions.model.LanguageActionFactory> {

    public void apply(IBuilderOperation op) {
        org.whole.lang.actions.builders.IActionsBuilder b0 = (org.whole.lang.actions.builders.IActionsBuilder) op.wGetBuilder(org.whole.lang.actions.reflect.ActionsLanguageKit.URI);
        b0.LanguageActionFactory_();
        b0.URI("whole:org.whole.examples.xml:XmlActions");
        b0.Namespace("org.whole.examples.xml");
        b0.Name("XmlActions");
        org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
        b1.Resolver();
        b0.URI("http://lang.whole.org/Xml");
        b0.ToolbarActions_();
        b1.Resolver();
        b1.Resolver();
        b1.Resolver();
        b1.Resolver();
        b1.Resolver();
        b0._ToolbarActions();
        b0.ContextMenuActions_();
        b0.MenuActions_(0);
        b0._MenuActions();
        b0.MenuActions_(0);
        b0._MenuActions();
        b0.MenuActions_(0);
        b0._MenuActions();
        b0.MenuActions_(1);
        b0.GuardedAction_();
        b0.Label("generate xhtml");
        org.whole.lang.queries.builders.IQueriesBuilder b2 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
        b2.Block_(5);
        b2.QueryDeclaration_();
        b2.Name("element");
        b2.Names_(1);
        b2.Name("name");
        b2._Names();
        b2.Choose_(2);
        b2.Path_(2);
        b2.FeatureStep("content");
        b2.Choose_(2);
        b2.Path_(2);
        b2.Filter_();
        b2.SelfStep();
        b2.TypeTest("Content");
        b2._Filter();
        b2.Filter_();
        b2.ChildStep();
        b2.ExpressionTest_();
        b2.Call_();
        b2.Name("tag");
        b2.Expressions_(1);
        b2.VariableRefStep("name");
        b2._Expressions();
        b2._Call();
        b2._ExpressionTest();
        b2._Filter();
        b2._Path();
        b2.Filter_();
        b2.SelfStep();
        b2.ExpressionTest_();
        b2.Call_();
        b2.Name("tag");
        b2.Expressions_(1);
        b2.VariableRefStep("name");
        b2._Expressions();
        b2._Call();
        b2._ExpressionTest();
        b2._Filter();
        b2._Choose();
        b2._Path();
        b2.Filter_();
        b2.FeatureStep("element");
        b2.ExpressionTest_();
        b2.Call_();
        b2.Name("tag");
        b2.Expressions_(1);
        b2.VariableRefStep("name");
        b2._Expressions();
        b2._Call();
        b2._ExpressionTest();
        b2._Filter();
        b2._Choose();
        b2._QueryDeclaration();
        b2.QueryDeclaration_();
        b2.Name("tag");
        b2.Names_(1);
        b2.Name("name");
        b2._Names();
        b2.Filter_();
        b2.FeatureStep("tag");
        b2.Or_(2);
        b2.ExpressionTest_();
        b2.Equals_();
        b2.Singleton_();
        b2.SelfStep();
        b2._Singleton();
        b2.VariableRefStep("name");
        b2._Equals();
        b2._ExpressionTest();
        b2.ExpressionTest_();
        b2.Equals_();
        b2.Singleton_();
        b2.FeatureStep("name");
        b2._Singleton();
        b2.VariableRefStep("name");
        b2._Equals();
        b2._ExpressionTest();
        b2._Or();
        b2._Filter();
        b2._QueryDeclaration();
        b2.QueryDeclaration_();
        b2.Name("attribute");
        b2.Names_(1);
        b2.Name("name");
        b2._Names();
        b2.Path_(3);
        b2.FeatureStep("attributes");
        b2.Filter_();
        b2.ChildStep();
        b2.Or_(2);
        b2.ExpressionTest_();
        b2.Equals_();
        b2.Singleton_();
        b2.FeatureStep("name");
        b2._Singleton();
        b2.VariableRefStep("name");
        b2._Equals();
        b2._ExpressionTest();
        b2.ExpressionTest_();
        b2.Equals_();
        b2.Singleton_();
        b2.Path_(2);
        b2.FeatureStep("name");
        b2.FeatureStep("name");
        b2._Path();
        b2._Singleton();
        b2.VariableRefStep("name");
        b2._Equals();
        b2._ExpressionTest();
        b2._Or();
        b2._Filter();
        b2.FeatureStep("value");
        b2._Path();
        b2._QueryDeclaration();
        b2.QueryDeclaration_();
        b2.Name("chardata");
        b1.Resolver();
        b2.Path_(2);
        b2.FeatureStep("content");
        b2.Choose_(2);
        b2.Filter_();
        b2.SelfStep();
        b2.TypeTest("CharData");
        b2._Filter();
        b2.Filter_();
        b2.ChildStep();
        b2.TypeTest("CharData");
        b2._Filter();
        b2._Choose();
        b2._Path();
        b2._QueryDeclaration();
        b2.Select_();
        b1.StageUpFragment_();
        org.whole.lang.xml.builders.IXmlBuilder b3 = (org.whole.lang.xml.builders.IXmlBuilder) op.wGetBuilder(org.whole.lang.xml.reflect.XmlLanguageKit.URI);
        b3.Element_();
        b3.Name("html");
        b3.Attributes_(0);
        b3._Attributes();
        b3.Content_(1);
        b3.Element_();
        b3.Name("body");
        b3.Attributes_(0);
        b3._Attributes();
        b3.Content_(1);
        b1.StageDownFragment_();
        b2.Path_(2);
        b2.Select_();
        b1.StageUpFragment_();
        b3.Content_(4);
        b3.Element_();
        b3.Name("hr");
        b1.Resolver();
        b1.Resolver();
        b3._Element();
        b3.Element_();
        b3.Name("b");
        b1.Resolver();
        b3.CharData("Section:");
        b3._Element();
        b1.Variable_();
        b1.VarType("http://lang.whole.org/Xml#CharData");
        b1.VarName("sectionName");
        b1.Quantifier("!");
        b1._Variable();
        b1.StageDownFragment_();
        b2.Select_();
        b1.StageUpFragment_();
        b3.Element_();
        b3.Name("blockquote");
        b1.Resolver();
        b1.Variable_();
        b1.VarType("http://lang.whole.org/Xml#CharData");
        b1.VarName("pdata");
        b1.Quantifier("!");
        b1._Variable();
        b3._Element();
        b1._StageUpFragment();
        b2.Path_(2);
        b2.Call_();
        b2.Name("element");
        b2.Expressions_(1);
        b2.StringLiteral("p");
        b2._Expressions();
        b2._Call();
        b2.Filter_();
        b2.Call_();
        b2.Name("chardata");
        b1.Resolver();
        b2._Call();
        b2.VariableTest("pdata");
        b2._Filter();
        b2._Path();
        b1.Resolver();
        b2.TemplateNames();
        b2._Select();
        b1._StageDownFragment();
        b3._Content();
        b1._StageUpFragment();
        b2.Call_();
        b2.Name("element");
        b2.Expressions_(1);
        b2.StringLiteral("section");
        b2._Expressions();
        b2._Call();
        b2.Filter_();
        b2.Call_();
        b2.Name("attribute");
        b2.Expressions_(1);
        b2.StringLiteral("name");
        b2._Expressions();
        b2._Call();
        b2.VariableTest("sectionName");
        b2._Filter();
        b2.TemplateNames();
        b2._Select();
        b2.ChildStep();
        b2._Path();
        b1._StageDownFragment();
        b3._Content();
        b3._Element();
        b3._Content();
        b3._Element();
        b1._StageUpFragment();
        b2.Call_();
        b2.Name("element");
        b2.Expressions_(1);
        b2.StringLiteral("document");
        b2._Expressions();
        b2._Call();
        b1.Resolver();
        b2.TemplateNames();
        b2._Select();
        b2._Block();
        b2.ExpressionTest_();
        b2.Path_(1);
        b2.Filter_();
        b2.SelfStep();
        b2.TypeTest("Document");
        b2._Filter();
        b2._Path();
        b2._ExpressionTest();
        b0._GuardedAction();
        b0._MenuActions();
        b0.MenuActions_(0);
        b0._MenuActions();
        b1.Resolver();
        b0._ContextMenuActions();
        b0._LanguageActionFactory();
    }
}
