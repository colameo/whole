package org.whole.lang.firstorderlogic.codebase;

import org.whole.lang.templates.AbstractTemplateFactory;
import org.whole.lang.builders.IBuilderOperation;
import org.whole.lang.firstorderlogic.reflect.FirstOrderLogicLanguageKit;
import org.whole.lang.firstorderlogic.builders.IFirstOrderLogicBuilder;

/**
 * @generator Whole
 */
public class Rdf2TmTheory extends AbstractTemplateFactory {
	public void apply(IBuilderOperation op) {
		IFirstOrderLogicBuilder b0 = (IFirstOrderLogicBuilder) op
				.wGetBuilder(FirstOrderLogicLanguageKit.URI);
		b0.Theory_();
		b0.Name("rdftm");
		b0.ImportTheories_(2);
		b0.ImportDeclaration_();
		b0.TheoryName("RDF");
		b0.Name("rdf");
		b0._ImportDeclaration();
		b0.ImportDeclaration_();
		b0.TheoryName("TopicMaps");
		b0.Name("tm");
		b0._ImportDeclaration();
		b0._ImportTheories();
		b0.Declarations_(4);
		b0.NameDeclaration_();
		b0.Name("IDtm");
		b0.SortType();
		b0.FeatureName_();
		b0.LanguageName("TopicMaps");
		b0.Name("Topic");
		b0.SimpleFeature("Identifiers");
		b0._FeatureName();
		b0._NameDeclaration();
		b0.NameDeclaration_();
		b0.Name("IDrdf");
		b0.SortType();
		b0.FeatureName_();
		b0.LanguageName("RDF");
		b0.Name("ResourceImpl");
		b0.SimpleFeature("AnonId");
		b0._FeatureName();
		b0._NameDeclaration();
		b0.NameDeclaration_();
		b0.Name("idrdf");
		b0.PredicateType_();
		b0.Parameters_(1);
		b0.VariableDeclaration_();
		b0.Name("idrdf");
		b0.Name("Resource");
		b0._VariableDeclaration();
		b0._Parameters();
		b0._PredicateType();
		b0.FeatureName_();
		b0.LanguageName("RDF");
		b0.Name("ResourceImpl");
		b0.SimpleFeature("AnonId");
		b0._FeatureName();
		b0._NameDeclaration();
		b0.NameDeclaration_();
		b0.Name("idtm");
		b0.PredicateType_();
		b0.Parameters_(1);
		b0.VariableDeclaration_();
		b0.Name("idtm");
		b0.Name("Topic");
		b0._VariableDeclaration();
		b0._Parameters();
		b0._PredicateType();
		b0.FeatureName_();
		b0.LanguageName("TopicMaps");
		b0.Name("Topic");
		b0.SimpleFeature("Identifiers");
		b0._FeatureName();
		b0._NameDeclaration();
		b0._Declarations();
		b0.Assertions_(14);
		b0.PredicateDefinition_();
		b0.SimplePredicate("IDrdftm");
		b0.Parameters_(1);
		b0.Variable("id");
		b0._Parameters();
		b0.Or_();
		b0.PredicateApplication_();
		b0.QualifiedPredicate_();
		b0.Name("rdf");
		b0.SimplePredicate("ID");
		b0._QualifiedPredicate();
		b0.Arguments_(1);
		b0.Variable("id");
		b0._Arguments();
		b0._PredicateApplication();
		b0.PredicateApplication_();
		b0.QualifiedPredicate_();
		b0.Name("tm");
		b0.SimplePredicate("ID");
		b0._QualifiedPredicate();
		b0.Arguments_(1);
		b0.Variable("id");
		b0._Arguments();
		b0._PredicateApplication();
		b0._Or();
		b0._PredicateDefinition();
		b0.PredicateDefinition_();
		b0.SimplePredicate("Resourcerdftm");
		b0.Parameters_(1);
		b0.VariableDeclaration_();
		b0.Name("res");
		b0.Name("Resource");
		b0._VariableDeclaration();
		b0._Parameters();
		b0.Or_();
		b0.PredicateApplication_();
		b0.QualifiedPredicate_();
		b0.Name("rdf");
		b0.SimplePredicate("Resource");
		b0._QualifiedPredicate();
		b0.Arguments_(1);
		b0.Variable("res");
		b0._Arguments();
		b0._PredicateApplication();
		b0.PredicateApplication_();
		b0.QualifiedPredicate_();
		b0.Name("tm");
		b0.SimplePredicate("Subject");
		b0._QualifiedPredicate();
		b0.Arguments_(1);
		b0.Variable("res");
		b0._Arguments();
		b0._PredicateApplication();
		b0._Or();
		b0._PredicateDefinition();
		b0.Axiom_();
		b0.Name("ResourceSubject");
		b0.Coimplication_();
		b0.PredicateApplication_();
		b0.QualifiedPredicate_();
		b0.Name("rdf");
		b0.SimplePredicate("Resource");
		b0._QualifiedPredicate();
		b0.Arguments_(1);
		b0.Variable("res");
		b0._Arguments();
		b0._PredicateApplication();
		b0.PredicateApplication_();
		b0.QualifiedPredicate_();
		b0.Name("tm");
		b0.SimplePredicate("Subject");
		b0._QualifiedPredicate();
		b0.Arguments_(1);
		b0.Variable("res");
		b0._Arguments();
		b0._PredicateApplication();
		b0._Coimplication();
		b0._Axiom();
		b0.Axiom_();
		b0.Name("Topic");
		b0.Implication_();
		b0.PredicateApplication_();
		b0.QualifiedPredicate_();
		b0.Name("tm");
		b0.SimplePredicate("Topic");
		b0._QualifiedPredicate();
		b0.Arguments_(1);
		b0.Variable("sub");
		b0._Arguments();
		b0._PredicateApplication();
		b0.And_();
		b0.PredicateApplication_();
		b0.QualifiedPredicate_();
		b0.Name("rdf");
		b0.SimplePredicate("Resource");
		b0._QualifiedPredicate();
		b0.Arguments_(1);
		b0.Variable("sub");
		b0._Arguments();
		b0._PredicateApplication();
		b0.Not_();
		b0.PredicateApplication_();
		b0.QualifiedPredicate_();
		b0.Name("rdf");
		b0.SimplePredicate("Literal");
		b0._QualifiedPredicate();
		b0.Arguments_(1);
		b0.Variable("sub");
		b0._Arguments();
		b0._PredicateApplication();
		b0._Not();
		b0._And();
		b0._Implication();
		b0._Axiom();
		b0.Axiom_();
		b0.Name("InformationResource");
		b0.Implication_();
		b0.PredicateApplication_();
		b0.QualifiedPredicate_();
		b0.Name("rdf");
		b0.SimplePredicate("InformationResource");
		b0._QualifiedPredicate();
		b0.Arguments_(1);
		b0.Variable("res");
		b0._Arguments();
		b0._PredicateApplication();
		b0.Exist_();
		b0.Parameters_(2);
		b0.VariableDeclaration_();
		b0.Name("top");
		b0.Name("Topic");
		b0._VariableDeclaration();
		b0.VariableDeclaration_();
		b0.Name("uri");
		b0.Name("URI");
		b0._VariableDeclaration();
		b0._Parameters();
		b0.And_();
		b0.PredicateApplication_();
		b0.QualifiedPredicate_();
		b0.Name("tm");
		b0.SimplePredicate("SubjectLocators");
		b0._QualifiedPredicate();
		b0.Arguments_(2);
		b0.Variable("top");
		b0.Variable("uri");
		b0._Arguments();
		b0._PredicateApplication();
		b0.And_();
		b0.PredicateApplication_();
		b0.QualifiedPredicate_();
		b0.Name("tm");
		b0.SimplePredicate("Ref");
		b0._QualifiedPredicate();
		b0.Arguments_(2);
		b0.Variable("uri");
		b0.Variable("res");
		b0._Arguments();
		b0._PredicateApplication();
		b0.PredicateApplication_();
		b0.QualifiedPredicate_();
		b0.Name("tm");
		b0.SimplePredicate("IdentifierOf");
		b0._QualifiedPredicate();
		b0.Arguments_(2);
		b0.Variable("id");
		b0.Variable("top");
		b0._Arguments();
		b0._PredicateApplication();
		b0._And();
		b0._And();
		b0._Exist();
		b0._Implication();
		b0._Axiom();
		b0.PredicateDefinition_();
		b0.SimplePredicate("Rdftm_itemID");
		b0.Parameters_(2);
		b0.VariableDeclaration_();
		b0.Name("id");
		b0.Name("IDrdftm");
		b0._VariableDeclaration();
		b0.VariableDeclaration_();
		b0.Name("res");
		b0.Name("Resource");
		b0._VariableDeclaration();
		b0._Parameters();
		b0.And_();
		b0.PredicateApplication_();
		b0.SimplePredicate("Resourcerdftm");
		b0.Arguments_(1);
		b0.Variable("res");
		b0._Arguments();
		b0._PredicateApplication();
		b0.PredicateApplication_();
		b0.SimplePredicate("IDrdftm");
		b0.Arguments_(1);
		b0.Variable("res");
		b0._Arguments();
		b0._PredicateApplication();
		b0._And();
		b0._PredicateDefinition();
		b0.PredicateDefinition_();
		b0.SimplePredicate("SI");
		b0.Parameters_(2);
		b0.VariableDeclaration_();
		b0.Name("top");
		b0.Name("Topic");
		b0._VariableDeclaration();
		b0.VariableDeclaration_();
		b0.Name("uri1");
		b0.Name("URItm");
		b0._VariableDeclaration();
		b0._Parameters();
		b0.Exist_();
		b0.Parameters_(3);
		b0.VariableDeclaration_();
		b0.Name("res1");
		b0.Name("Resource");
		b0._VariableDeclaration();
		b0.VariableDeclaration_();
		b0.Name("res2");
		b0.Name("Resource");
		b0._VariableDeclaration();
		b0.VariableDeclaration_();
		b0.Name("uri2");
		b0.Name("URItm");
		b0._VariableDeclaration();
		b0._Parameters();
		b0.And_();
		b0.PredicateApplication_();
		b0.QualifiedPredicate_();
		b0.Name("rdf");
		b0.SimplePredicate("InformationResource");
		b0._QualifiedPredicate();
		b0.Arguments_(1);
		b0.Variable("res1");
		b0._Arguments();
		b0._PredicateApplication();
		b0.And_();
		b0.PredicateApplication_();
		b0.QualifiedPredicate_();
		b0.Name("rdf");
		b0.SimplePredicate("NonInformationResource");
		b0._QualifiedPredicate();
		b0.Arguments_(1);
		b0.Variable("res2");
		b0._Arguments();
		b0._PredicateApplication();
		b0.And_();
		b0.PredicateApplication_();
		b0.QualifiedPredicate_();
		b0.Name("tm");
		b0.SimplePredicate("SubjectIndicators");
		b0._QualifiedPredicate();
		b0.Arguments_(2);
		b0.Variable("res1");
		b0.Variable("res2");
		b0._Arguments();
		b0._PredicateApplication();
		b0.And_();
		b0.PredicateApplication_();
		b0.QualifiedPredicate_();
		b0.Name("tm");
		b0.SimplePredicate("ID");
		b0._QualifiedPredicate();
		b0.Arguments_(2);
		b0.Variable("uri1");
		b0.Variable("res1");
		b0._Arguments();
		b0._PredicateApplication();
		b0.PredicateApplication_();
		b0.QualifiedPredicate_();
		b0.Name("tm");
		b0.SimplePredicate("IdentifierOf");
		b0._QualifiedPredicate();
		b0.Arguments_(2);
		b0.Variable("uri2");
		b0.Variable("res2");
		b0._Arguments();
		b0._PredicateApplication();
		b0._And();
		b0._And();
		b0._And();
		b0._And();
		b0._Exist();
		b0._PredicateDefinition();
		b0.Axiom_();
		b0.Name("InfRes");
		b0.ForAll_();
		b0.Parameters_(2);
		b0.VariableDeclaration_();
		b0.Name("res");
		b0.Name("Resource");
		b0._VariableDeclaration();
		b0.VariableDeclaration_();
		b0.Name("id");
		b0.Name("IDrdftm");
		b0._VariableDeclaration();
		b0._Parameters();
		b0.And_();
		b0.PredicateApplication_();
		b0.QualifiedPredicate_();
		b0.Name("rdf");
		b0.SimplePredicate("InformationResource");
		b0._QualifiedPredicate();
		b0.Arguments_(1);
		b0.Variable("res");
		b0._Arguments();
		b0._PredicateApplication();
		b0.Implication_();
		b0.PredicateApplication_();
		b0.SimplePredicate("Rdftm_itemID");
		b0.Arguments_(2);
		b0.Variable("id");
		b0.Variable("res");
		b0._Arguments();
		b0._PredicateApplication();
		b0.Exist_();
		b0.Parameters_(2);
		b0.VariableDeclaration_();
		b0.Name("top");
		b0.Name("Topic");
		b0._VariableDeclaration();
		b0.VariableDeclaration_();
		b0.Name("uri");
		b0.Name("URI");
		b0._VariableDeclaration();
		b0._Parameters();
		b0.And_();
		b0.PredicateApplication_();
		b0.QualifiedPredicate_();
		b0.Name("tm");
		b0.SimplePredicate("SubjectLocator");
		b0._QualifiedPredicate();
		b0.Arguments_(2);
		b0.Variable("top");
		b0.Variable("uri");
		b0._Arguments();
		b0._PredicateApplication();
		b0.And_();
		b0.PredicateApplication_();
		b0.QualifiedPredicate_();
		b0.Name("tm");
		b0.SimplePredicate("Ref");
		b0._QualifiedPredicate();
		b0.Arguments_(2);
		b0.Variable("uri");
		b0.Variable("res");
		b0._Arguments();
		b0._PredicateApplication();
		b0.PredicateApplication_();
		b0.QualifiedPredicate_();
		b0.Name("tm");
		b0.SimplePredicate("ID");
		b0._QualifiedPredicate();
		b0.Arguments_(2);
		b0.Variable("id");
		b0.Variable("top");
		b0._Arguments();
		b0._PredicateApplication();
		b0._And();
		b0._And();
		b0._Exist();
		b0._Implication();
		b0._And();
		b0._ForAll();
		b0._Axiom();
		b0.Axiom_();
		b0.Name("NonInformationResource");
		b0.Implication_();
		b0.PredicateApplication_();
		b0.QualifiedPredicate_();
		b0.Name("rdf");
		b0.SimplePredicate("NonInformationResource");
		b0._QualifiedPredicate();
		b0.Arguments_(1);
		b0.Variable("res1");
		b0._Arguments();
		b0._PredicateApplication();
		b0.Exist_();
		b0.Parameters_(4);
		b0.VariableDeclaration_();
		b0.Name("top");
		b0.Name("Topic");
		b0._VariableDeclaration();
		b0.VariableDeclaration_();
		b0.Name("uri");
		b0.Name("URI");
		b0._VariableDeclaration();
		b0.VariableDeclaration_();
		b0.Name("id");
		b0.Name("IDrdftm");
		b0._VariableDeclaration();
		b0.VariableDeclaration_();
		b0.Name("res2");
		b0.Name("Resource");
		b0._VariableDeclaration();
		b0._Parameters();
		b0.And_();
		b0.PredicateApplication_();
		b0.QualifiedPredicate_();
		b0.Name("tm");
		b0.SimplePredicate("SI");
		b0._QualifiedPredicate();
		b0.Arguments_(2);
		b0.Variable("top");
		b0.Variable("uri");
		b0._Arguments();
		b0._PredicateApplication();
		b0.And_();
		b0.And_();
		b0.PredicateApplication_();
		b0.QualifiedPredicate_();
		b0.Name("tm");
		b0.SimplePredicate("Ref");
		b0._QualifiedPredicate();
		b0.Arguments_(2);
		b0.Variable("uri");
		b0.Variable("res2");
		b0._Arguments();
		b0._PredicateApplication();
		b0.PredicateApplication_();
		b0.QualifiedPredicate_();
		b0.Name("tm");
		b0.SimplePredicate("IdentifierOf");
		b0._QualifiedPredicate();
		b0.Arguments_(2);
		b0.Variable("id");
		b0.Variable("top");
		b0._Arguments();
		b0._PredicateApplication();
		b0._And();
		b0.PredicateApplication_();
		b0.QualifiedPredicate_();
		b0.Name("tm");
		b0.SimplePredicate("SubjectIndicator");
		b0._QualifiedPredicate();
		b0.Arguments_(2);
		b0.Variable("res2");
		b0.Variable("res1");
		b0._Arguments();
		b0._PredicateApplication();
		b0._And();
		b0._And();
		b0._Exist();
		b0._Implication();
		b0._Axiom();
		b0.Axiom_();
		b0.Name("NonInfRes");
		b0.Implication_();
		b0.ForAll_();
		b0.Parameters_(2);
		b0.VariableDeclaration_();
		b0.Name("res");
		b0.Name("Resource");
		b0._VariableDeclaration();
		b0.VariableDeclaration_();
		b0.Name("id");
		b0.Name("IDrdftm");
		b0._VariableDeclaration();
		b0._Parameters();
		b0.And_();
		b0.PredicateApplication_();
		b0.QualifiedPredicate_();
		b0.Name("rdf");
		b0.SimplePredicate("NonInformationResource");
		b0._QualifiedPredicate();
		b0.Arguments_(1);
		b0.Variable("res1");
		b0._Arguments();
		b0._PredicateApplication();
		b0.PredicateApplication_();
		b0.SimplePredicate("Rdftm_itemID");
		b0.Arguments_(2);
		b0.Variable("id");
		b0.Variable("res1");
		b0._Arguments();
		b0._PredicateApplication();
		b0._And();
		b0._ForAll();
		b0.Exist_();
		b0.Parameters_(3);
		b0.VariableDeclaration_();
		b0.Name("top");
		b0.Name("Topic");
		b0._VariableDeclaration();
		b0.VariableDeclaration_();
		b0.Name("uri");
		b0.Name("URI");
		b0._VariableDeclaration();
		b0.VariableDeclaration_();
		b0.Name("res2");
		b0.Name("Resource");
		b0._VariableDeclaration();
		b0._Parameters();
		b0.And_();
		b0.PredicateApplication_();
		b0.QualifiedPredicate_();
		b0.Name("tm");
		b0.SimplePredicate("SI");
		b0._QualifiedPredicate();
		b0.Arguments_(2);
		b0.Variable("top");
		b0.Variable("uri");
		b0._Arguments();
		b0._PredicateApplication();
		b0.And_();
		b0.PredicateApplication_();
		b0.QualifiedPredicate_();
		b0.Name("tm");
		b0.SimplePredicate("Ref");
		b0._QualifiedPredicate();
		b0.Arguments_(2);
		b0.Variable("uri");
		b0.Variable("res2");
		b0._Arguments();
		b0._PredicateApplication();
		b0.And_();
		b0.PredicateApplication_();
		b0.QualifiedPredicate_();
		b0.Name("tm");
		b0.SimplePredicate("IdentifierOf");
		b0._QualifiedPredicate();
		b0.Arguments_(2);
		b0.Variable("id");
		b0.Variable("top");
		b0._Arguments();
		b0._PredicateApplication();
		b0.PredicateApplication_();
		b0.QualifiedPredicate_();
		b0.Name("tm");
		b0.SimplePredicate("SubjectIndicator");
		b0._QualifiedPredicate();
		b0.Arguments_(2);
		b0.Variable("res2");
		b0.Variable("res1");
		b0._Arguments();
		b0._PredicateApplication();
		b0._And();
		b0._And();
		b0._And();
		b0._Exist();
		b0._Implication();
		b0._Axiom();
		b0.Axiom_();
		b0.Name("IdentifiedTopicId");
		b0.Implication_();
		b0.ForAll_();
		b0.Parameters_(2);
		b0.VariableDeclaration_();
		b0.Name("top");
		b0.Name("Topic");
		b0._VariableDeclaration();
		b0.VariableDeclaration_();
		b0.Name("id");
		b0.Name("IDrdftm");
		b0._VariableDeclaration();
		b0._Parameters();
		b0.And_();
		b0.PredicateApplication_();
		b0.QualifiedPredicate_();
		b0.Name("tm");
		b0.SimplePredicate("IdentifiedTopic");
		b0._QualifiedPredicate();
		b0.Arguments_(1);
		b0.Variable("top");
		b0._Arguments();
		b0._PredicateApplication();
		b0.And_();
		b0.PredicateApplication_();
		b0.QualifiedPredicate_();
		b0.Name("tm");
		b0.SimplePredicate("ID");
		b0._QualifiedPredicate();
		b0.Arguments_(1);
		b0.Variable("id");
		b0._Arguments();
		b0._PredicateApplication();
		b0.PredicateApplication_();
		b0.QualifiedPredicate_();
		b0.Name("tm");
		b0.SimplePredicate("IdentifierOf");
		b0._QualifiedPredicate();
		b0.Arguments_(2);
		b0.Variable("id");
		b0.Variable("top");
		b0._Arguments();
		b0._PredicateApplication();
		b0._And();
		b0._And();
		b0._ForAll();
		b0.Exist_();
		b0.Parameters_(1);
		b0.VariableDeclaration_();
		b0.Name("res");
		b0.Name("Resource");
		b0._VariableDeclaration();
		b0._Parameters();
		b0.And_();
		b0.PredicateApplication_();
		b0.QualifiedPredicate_();
		b0.Name("rdf");
		b0.SimplePredicate("Resource");
		b0._QualifiedPredicate();
		b0.Arguments_(1);
		b0.Variable("res");
		b0._Arguments();
		b0._PredicateApplication();
		b0.And_();
		b0.Not_();
		b0.PredicateApplication_();
		b0.QualifiedPredicate_();
		b0.Name("rdf");
		b0.SimplePredicate("Blank");
		b0._QualifiedPredicate();
		b0.Arguments_(1);
		b0.Variable("res");
		b0._Arguments();
		b0._PredicateApplication();
		b0._Not();
		b0.PredicateApplication_();
		b0.SimplePredicate("Rdftm_itemID");
		b0.Arguments_(2);
		b0.Variable("id");
		b0.Variable("res1");
		b0._Arguments();
		b0._PredicateApplication();
		b0._And();
		b0._And();
		b0._Exist();
		b0._Implication();
		b0._Axiom();
		b0.PredicateDefinition_();
		b0.SimplePredicate("SL");
		b0.Parameters_(2);
		b0.VariableDeclaration_();
		b0.Name("top");
		b0.Name("Topic");
		b0._VariableDeclaration();
		b0.VariableDeclaration_();
		b0.Name("uri1");
		b0.Name("URIrdftm");
		b0._VariableDeclaration();
		b0._Parameters();
		b0.Exist_();
		b0.Parameters_(1);
		b0.VariableDeclaration_();
		b0.Name("res");
		b0.Name("Resource");
		b0._VariableDeclaration();
		b0._Parameters();
		b0.And_();
		b0.PredicateApplication_();
		b0.QualifiedPredicate_();
		b0.Name("rdf");
		b0.SimplePredicate("InformationResource");
		b0._QualifiedPredicate();
		b0.Arguments_(1);
		b0.Variable("res");
		b0._Arguments();
		b0._PredicateApplication();
		b0.PredicateApplication_();
		b0.QualifiedPredicate_();
		b0.Name("tm");
		b0.SimplePredicate("Ref");
		b0._QualifiedPredicate();
		b0.Arguments_(2);
		b0.Variable("uri");
		b0.Variable("res");
		b0._Arguments();
		b0._PredicateApplication();
		b0._And();
		b0._Exist();
		b0._PredicateDefinition();
		b0.Axiom_();
		b0.Name("UnidentifiedTopicUri");
		b0.Implication_();
		b0.ForAll_();
		b0.Parameters_(2);
		b0.VariableDeclaration_();
		b0.Name("top");
		b0.Name("Topic");
		b0._VariableDeclaration();
		b0.VariableDeclaration_();
		b0.Name("id");
		b0.Name("IDrdftm");
		b0._VariableDeclaration();
		b0._Parameters();
		b0.And_();
		b0.PredicateApplication_();
		b0.QualifiedPredicate_();
		b0.Name("tm");
		b0.SimplePredicate("UnidentifiedTopic");
		b0._QualifiedPredicate();
		b0.Arguments_(1);
		b0.Variable("top");
		b0._Arguments();
		b0._PredicateApplication();
		b0.And_();
		b0.PredicateApplication_();
		b0.QualifiedPredicate_();
		b0.Name("tm");
		b0.SimplePredicate("ID");
		b0._QualifiedPredicate();
		b0.Arguments_(1);
		b0.Variable("id");
		b0._Arguments();
		b0._PredicateApplication();
		b0.PredicateApplication_();
		b0.QualifiedPredicate_();
		b0.Name("tm");
		b0.SimplePredicate("IdentifierOf");
		b0._QualifiedPredicate();
		b0.Arguments_(2);
		b0.Variable("id");
		b0.Variable("top");
		b0._Arguments();
		b0._PredicateApplication();
		b0._And();
		b0._And();
		b0._ForAll();
		b0.ExistUnique_();
		b0.Parameters_(1);
		b0.VariableDeclaration_();
		b0.Name("sub");
		b0.Name("Subject");
		b0._VariableDeclaration();
		b0._Parameters();
		b0.And_();
		b0.And_();
		b0.PredicateApplication_();
		b0.QualifiedPredicate_();
		b0.Name("rdf");
		b0.SimplePredicate("Blank");
		b0._QualifiedPredicate();
		b0.Arguments_(1);
		b0.Variable("sub");
		b0._Arguments();
		b0._PredicateApplication();
		b0.Not_();
		b0.Exist_();
		b0.Parameters_(1);
		b0.VariableDeclaration_();
		b0.Name("uri");
		b0.Name("URItm");
		b0._VariableDeclaration();
		b0._Parameters();
		b0.And_();
		b0.PredicateApplication_();
		b0.QualifiedPredicate_();
		b0.Name("tm");
		b0.SimplePredicate("URI");
		b0._QualifiedPredicate();
		b0.Arguments_(1);
		b0.Variable("uri");
		b0._Arguments();
		b0._PredicateApplication();
		b0.And_();
		b0.PredicateApplication_();
		b0.QualifiedPredicate_();
		b0.Name("tm");
		b0.SimplePredicate("Ref");
		b0._QualifiedPredicate();
		b0.Arguments_(2);
		b0.Variable("uri");
		b0.Variable("sub");
		b0._Arguments();
		b0._PredicateApplication();
		b0.Or_();
		b0.PredicateApplication_();
		b0.QualifiedPredicate_();
		b0.Name("tm");
		b0.SimplePredicate("SI");
		b0._QualifiedPredicate();
		b0.Arguments_(2);
		b0.Variable("top");
		b0.Variable("uri");
		b0._Arguments();
		b0._PredicateApplication();
		b0.PredicateApplication_();
		b0.QualifiedPredicate_();
		b0.Name("tm");
		b0.SimplePredicate("SL");
		b0._QualifiedPredicate();
		b0.Arguments_(2);
		b0.Variable("top");
		b0.Variable("uri");
		b0._Arguments();
		b0._PredicateApplication();
		b0._Or();
		b0._And();
		b0._And();
		b0._Exist();
		b0._Not();
		b0._And();
		b0.And_();
		b0.PredicateApplication_();
		b0.QualifiedPredicate_();
		b0.Name("rdf");
		b0.SimplePredicate("Blank");
		b0._QualifiedPredicate();
		b0.Arguments_(1);
		b0.Variable("sub");
		b0._Arguments();
		b0._PredicateApplication();
		b0.Not_();
		b0.Exist_();
		b0.Parameters_(1);
		b0.VariableDeclaration_();
		b0.Name("uri");
		b0.Name("URItm");
		b0._VariableDeclaration();
		b0._Parameters();
		b0.And_();
		b0.PredicateApplication_();
		b0.QualifiedPredicate_();
		b0.Name("tm");
		b0.SimplePredicate("URI");
		b0._QualifiedPredicate();
		b0.Arguments_(1);
		b0.Variable("uri");
		b0._Arguments();
		b0._PredicateApplication();
		b0.And_();
		b0.PredicateApplication_();
		b0.QualifiedPredicate_();
		b0.Name("tm");
		b0.SimplePredicate("Ref");
		b0._QualifiedPredicate();
		b0.Arguments_(2);
		b0.Variable("uri");
		b0.Variable("sub");
		b0._Arguments();
		b0._PredicateApplication();
		b0.Or_();
		b0.PredicateApplication_();
		b0.QualifiedPredicate_();
		b0.Name("tm");
		b0.SimplePredicate("SI");
		b0._QualifiedPredicate();
		b0.Arguments_(2);
		b0.Variable("top");
		b0.Variable("uri");
		b0._Arguments();
		b0._PredicateApplication();
		b0.PredicateApplication_();
		b0.QualifiedPredicate_();
		b0.Name("tm");
		b0.SimplePredicate("SL");
		b0._QualifiedPredicate();
		b0.Arguments_(2);
		b0.Variable("top");
		b0.Variable("uri");
		b0._Arguments();
		b0._PredicateApplication();
		b0._Or();
		b0._And();
		b0._And();
		b0._Exist();
		b0._Not();
		b0._And();
		b0._And();
		b0._ExistUnique();
		b0._Implication();
		b0._Axiom();
		b0.Axiom_();
		b0.Name("BlankId");
		b0.ForAll_();
		b0.Parameters_(2);
		b0.VariableDeclaration_();
		b0.Name("res");
		b0.Name("Resource");
		b0._VariableDeclaration();
		b0.VariableDeclaration_();
		b0.Name("id");
		b0.Name("IDrdftm");
		b0._VariableDeclaration();
		b0._Parameters();
		b0.Implication_();
		b0.And_();
		b0.PredicateApplication_();
		b0.QualifiedPredicate_();
		b0.Name("rdf");
		b0.SimplePredicate("Blank");
		b0._QualifiedPredicate();
		b0.Arguments_(1);
		b0.Variable("res");
		b0._Arguments();
		b0._PredicateApplication();
		b0.And_();
		b0.PredicateApplication_();
		b0.QualifiedPredicate_();
		b0.Name("rdf");
		b0.SimplePredicate("ID");
		b0._QualifiedPredicate();
		b0.Arguments_(1);
		b0.Variable("id");
		b0._Arguments();
		b0._PredicateApplication();
		b0.PredicateApplication_();
		b0.QualifiedPredicate_();
		b0.Name("tm");
		b0.SimplePredicate("IdentifierOf");
		b0._QualifiedPredicate();
		b0.Arguments_(2);
		b0.Variable("id");
		b0.Variable("res");
		b0._Arguments();
		b0._PredicateApplication();
		b0._And();
		b0._And();
		b0.Exist_();
		b0.Parameters_(1);
		b0.VariableDeclaration_();
		b0.Name("top");
		b0.Name("Topic");
		b0._VariableDeclaration();
		b0._Parameters();
		b0.And_();
		b0.PredicateApplication_();
		b0.QualifiedPredicate_();
		b0.Name("tm");
		b0.SimplePredicate("UnidentifiedTopic");
		b0._QualifiedPredicate();
		b0.Arguments_(1);
		b0.Variable("top");
		b0._Arguments();
		b0._PredicateApplication();
		b0.PredicateApplication_();
		b0.QualifiedPredicate_();
		b0.Name("tm");
		b0.SimplePredicate("IdentifierOf");
		b0._QualifiedPredicate();
		b0.Arguments_(2);
		b0.Variable("id");
		b0.Variable("top");
		b0._Arguments();
		b0._PredicateApplication();
		b0._And();
		b0._Exist();
		b0._Implication();
		b0._ForAll();
		b0._Axiom();
		b0._Assertions();
		b0._Theory();
	}
}