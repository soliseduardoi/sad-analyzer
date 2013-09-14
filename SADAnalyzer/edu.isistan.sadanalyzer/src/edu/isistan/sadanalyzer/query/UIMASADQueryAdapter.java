package edu.isistan.sadanalyzer.query;

import java.util.Comparator;
import java.util.Iterator;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.query.conditions.eobjects.EObjectCondition;
import org.eclipse.emf.query.conditions.eobjects.EObjectTypeRelationCondition;
import org.eclipse.emf.query.conditions.eobjects.structuralfeatures.EObjectAttributeValueCondition;
import org.eclipse.emf.query.conditions.numbers.NumberCondition;
import org.eclipse.emf.query.conditions.strings.StringValue;
import org.eclipse.emf.query.statements.FROM;
import org.eclipse.emf.query.statements.IQueryResult;
import org.eclipse.emf.query.statements.SELECT;
import org.eclipse.emf.query.statements.WHERE;

import uima.cas.CasPackage;
import uima.tcas.Annotation;
import uima.tcas.TCasPackage;
import edu.isistan.uima.unified.typesystems.IdentifiableAnnotation;
import edu.isistan.uima.unified.typesystems.domain.DomainAction;
import edu.isistan.uima.unified.typesystems.domain.DomainNumber;
import edu.isistan.uima.unified.typesystems.domain.DomainPackage;
import edu.isistan.uima.unified.typesystems.nlp.Chunk;
import edu.isistan.uima.unified.typesystems.nlp.Entity;
import edu.isistan.uima.unified.typesystems.nlp.NLPPackage;
import edu.isistan.uima.unified.typesystems.nlp.SDDependency;
import edu.isistan.uima.unified.typesystems.nlp.Sentence;
import edu.isistan.uima.unified.typesystems.nlp.Token;
import edu.isistan.uima.unified.typesystems.sad.Sad;
import edu.isistan.uima.unified.typesystems.sad.SadPackage;
import edu.isistan.uima.unified.typesystems.sad.SadSection;
import edu.isistan.uima.unified.typesystems.srl.Predicate;
import edu.isistan.uima.unified.typesystems.srl.Role;
import edu.isistan.uima.unified.typesystems.srl.Structure;
import edu.isistan.uima.unified.typesystems.srs.Document;
import edu.isistan.uima.unified.typesystems.srs.Section;
import edu.isistan.uima.unified.typesystems.wordnet.Sense;
import edu.isistan.uima.unified.typesystems.wordnet.WordNetPackage;

@SuppressWarnings("unused")
public class UIMASADQueryAdapter {
	// Packages
	private final static NLPPackage nlpPackage = NLPPackage.eINSTANCE;
	
	private final static WordNetPackage wordNetPackage = WordNetPackage.eINSTANCE;
	private final static DomainPackage domainPackage = DomainPackage.eINSTANCE;
	private final static CasPackage casPackage = CasPackage.eINSTANCE;
	private final static TCasPackage tCasPackage = TCasPackage.eINSTANCE;
	//Sad
	private final static SadPackage sadPackage = SadPackage.eINSTANCE;
	// Conditions
	private final static EObjectCondition cSofa = new EObjectTypeRelationCondition(casPackage.getSofa());

	private final static EObjectCondition cSentence = new EObjectTypeRelationCondition(nlpPackage.getSentence());
	private final static EObjectCondition cToken = new EObjectTypeRelationCondition(nlpPackage.getToken());
	private final static EObjectCondition cChunk = new EObjectTypeRelationCondition(nlpPackage.getChunk());
	private final static EObjectCondition cSDDependency = new EObjectTypeRelationCondition(nlpPackage.getSDDependency());
	private final static EObjectCondition cEntity = new EObjectTypeRelationCondition(nlpPackage.getEntity());

	private final static EObjectCondition cSense = new EObjectTypeRelationCondition(wordNetPackage.getSense());
	private final static EObjectCondition cDomainNumber = new EObjectTypeRelationCondition(domainPackage.getDomainNumber());
	private final static EObjectCondition cDomainAction = new EObjectTypeRelationCondition(domainPackage.getDomainAction());
	//Sad
	private final static EObjectCondition cSad = new EObjectTypeRelationCondition(sadPackage.getSad());
	private final static EObjectCondition cSadSection = new EObjectTypeRelationCondition(sadPackage.getSadSection());
	
	// Roots
	private EList<EObject> uimaRoots;

	private EObjectCondition cStructure;
	
	public UIMASADQueryAdapter(EList<EObject> uimaRoots) {		
		this.uimaRoots = uimaRoots;
	}
	
	// Utilities
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static <T> EList<T> fromIQueryResultToEList(IQueryResult result, EList<T> list) {
		Iterator it = result.iterator();
		while(it.hasNext())
			list.add((T)it.next());
		sort((EList<? extends Annotation>) list);
		return list;
	}
	
	private static void sort(EList<? extends Annotation> list) {
		ECollections.sort(list, new Comparator<Annotation>() {
			@Override
			public int compare(Annotation a1, Annotation a2) {
				int comp = a1.getBegin() - a2.getBegin();
				if(comp != 0)
					return comp;
				else {
					comp = a1.getEnd() - a2.getEnd();
					if(comp != 0)
						return comp;
					else {
						comp = (a1.getEnd() - a1.getBegin()) - (a2.getEnd() - a2.getBegin());
						return comp;
					}	
				}
			}
		});
	}
	
	// Covered text
	public String getCoveredText(Annotation annotation) {
		String sofaString = annotation.getSofa().getSofaString();
		String coveredText = sofaString.substring(annotation.getBegin(), annotation.getEnd());
		return coveredText;
	}
	
	// Annotation range condition
	private EObjectCondition cRange(Annotation annotation) {
		int begin = annotation.getBegin();
		int end = annotation.getEnd();
		EObjectCondition cRangeBegin = new EObjectAttributeValueCondition(TCasPackage.Literals.ANNOTATION__BEGIN, NumberCondition.between(begin, true, end, true));
		EObjectCondition cRangeEnd = new EObjectAttributeValueCondition(TCasPackage.Literals.ANNOTATION__END, NumberCondition.between(begin, true, end, true));
		return cRangeBegin.AND(cRangeEnd);
	}
	
	private EObjectCondition cRangeInverse(Annotation annotation) {
		int begin = annotation.getBegin();
		int end = annotation.getEnd();
		EObjectCondition cRangeBegin = new EObjectAttributeValueCondition(TCasPackage.Literals.ANNOTATION__BEGIN, NumberCondition.lessThanOrEquals(begin));
		EObjectCondition cRangeEnd = new EObjectAttributeValueCondition(TCasPackage.Literals.ANNOTATION__END, NumberCondition.greaterThanOrEquals(end));
		return cRangeBegin.AND(cRangeEnd);
	}
	
	// Annotation identification
	private EObjectCondition cIdentification(EAttribute attribute, String identification) {
		EObjectCondition condition = new EObjectAttributeValueCondition(attribute, new StringValue(identification));
		return condition;
	}

	// Queries

	/**
	 * Obtiene un Sad
	 * @return
	 */
	
	public Sad getSad() {
		SELECT statement = new SELECT(new FROM(uimaRoots), new WHERE(cSad));
		IQueryResult result = statement.execute();
		return fromIQueryResultToEList(result, new BasicEList<Sad>()).get(0);
	}	
	
	
	/**
	 * Obtiene una lista de SadSection
	 * @return
	 */
	
	public EList<SadSection> getSadSection() {
		SELECT statement = new SELECT(new FROM(uimaRoots), new WHERE(cSadSection));
		IQueryResult result = statement.execute();
		return fromIQueryResultToEList(result, new BasicEList<SadSection>());
	}
	

	/**
	 * Obtiene una lista de SadSection dado un Sad
	 * @param sad
	 * @return
	 */
	
	public EList<SadSection> getSadSection(Sad sad) {
		SELECT statement = new SELECT(new FROM(uimaRoots), new WHERE(cSadSection.AND(cRange(sad))));
		IQueryResult result = statement.execute();
		return fromIQueryResultToEList(result, new BasicEList<SadSection>());
	}
	
	
	public EList<Sentence> getSentences() {
		SELECT statement = new SELECT(new FROM(uimaRoots), new WHERE(cSentence));
		IQueryResult result = statement.execute();
		return fromIQueryResultToEList(result, new BasicEList<Sentence>());
	}
	
	public EList<Sentence> getSentences(Section section) {
		SELECT statement = new SELECT(new FROM(uimaRoots), new WHERE(cSentence.AND(cRange(section))));
		IQueryResult result = statement.execute();
		return fromIQueryResultToEList(result, new BasicEList<Sentence>());
	}
	
	/**
	 * Obtiene todas las sentencias dado un Sad
	 * @param section
	 * @return
	 */
	
	public EList<Sentence> getSentences(Sad sad) {
		SELECT statement = new SELECT(new FROM(uimaRoots), new WHERE(cSentence.AND(cRange(sad))));
		IQueryResult result = statement.execute();
		return fromIQueryResultToEList(result, new BasicEList<Sentence>());
	}
	
	/**
	 * Obtiene todas las sentencias dado una SadSection
	 * @param section
	 * @return
	 */
	
	public EList<Sentence> getSentences(SadSection sadSection) {
		SELECT statement = new SELECT(new FROM(uimaRoots), new WHERE(cSentence.AND(cRange(sadSection))));
		IQueryResult result = statement.execute();
		return fromIQueryResultToEList(result, new BasicEList<Sentence>());
	}
	
	public EList<Sentence> getSentences(Document document) {
		SELECT statement = new SELECT(new FROM(uimaRoots), new WHERE(cSentence.AND(cRange(document))));
		IQueryResult result = statement.execute();
		return fromIQueryResultToEList(result, new BasicEList<Sentence>());
	}
	
	public EList<Token> getTokens() {
		SELECT statement = new SELECT(new FROM(uimaRoots), new WHERE(cToken));
		IQueryResult result = statement.execute();
		return fromIQueryResultToEList(result, new BasicEList<Token>());
	}
	
	public EList<Token> getTokens(Sentence sentence) {
		SELECT statement = new SELECT(new FROM(uimaRoots), new WHERE(cToken.AND(cRange(sentence))));
		IQueryResult result = statement.execute();
		return fromIQueryResultToEList(result, new BasicEList<Token>());
	}
	
	public EList<Token> getTokens(Chunk chunk) {
		SELECT statement = new SELECT(new FROM(uimaRoots), new WHERE(cToken.AND(cRange(chunk))));
		IQueryResult result = statement.execute();
		return fromIQueryResultToEList(result, new BasicEList<Token>());
	}
	
	public EList<Token> getTokens(Role role) {
		
		return null;
	}
	
	public EList<Token> getTokens(SDDependency dependency) {
		SELECT statement = new SELECT(new FROM(uimaRoots), new WHERE(
				cToken.AND(cRange(dependency.getDep()).OR(cRange(dependency.getGov())))));
		IQueryResult result = statement.execute();
		return fromIQueryResultToEList(result, new BasicEList<Token>());
	}
	
	public Token getTokenDep(SDDependency dependency) {
		SELECT statement = new SELECT(new FROM(uimaRoots), new WHERE(cToken.AND(cRange(dependency.getDep()))));
		IQueryResult result = statement.execute();
		if(result.size() > 0)
			return fromIQueryResultToEList(result, new BasicEList<Token>()).get(0);
		else
			return null;
	}
	
	public Token getTokenGov(SDDependency dependency) {
		SELECT statement = new SELECT(new FROM(uimaRoots), new WHERE(cToken.AND(cRange(dependency.getGov()))));
		IQueryResult result = statement.execute();
		if(result.size() > 0)
			return fromIQueryResultToEList(result, new BasicEList<Token>()).get(0);
		else
			return null;
	}
	
	public Token getToken(Sense sense) {
		SELECT statement = new SELECT(new FROM(uimaRoots), new WHERE(cToken.AND(cRange(sense))));
		IQueryResult result = statement.execute();
		if(result.size() > 0)
			return fromIQueryResultToEList(result, new BasicEList<Token>()).get(0);
		else
			return null;
	}
	
	public EList<Chunk> getChunks() {
		SELECT statement = new SELECT(new FROM(uimaRoots), new WHERE(cChunk));
		IQueryResult result = statement.execute();
		return fromIQueryResultToEList(result, new BasicEList<Chunk>());
	}
	
	public EList<Chunk> getChunks(Sentence sentence) {
		SELECT statement = new SELECT(new FROM(uimaRoots), new WHERE(cChunk.AND(cRange(sentence))));
		IQueryResult result = statement.execute();
		return fromIQueryResultToEList(result, new BasicEList<Chunk>());
	}
	
	public EList<SDDependency> getDependencies() {
		SELECT statement = new SELECT(new FROM(uimaRoots), new WHERE(cSDDependency));
		IQueryResult result = statement.execute();
		return fromIQueryResultToEList(result, new BasicEList<SDDependency>());
	}
	
	public EList<SDDependency> getDependencies(Sentence sentence) {
		SELECT statement = new SELECT(new FROM(uimaRoots), new WHERE(cSDDependency.AND(cRange(sentence))));
		IQueryResult result = statement.execute();
		return fromIQueryResultToEList(result, new BasicEList<SDDependency>());
	}
	
	public EList<Entity> getEntities() {
		SELECT statement = new SELECT(new FROM(uimaRoots), new WHERE(cEntity));
		IQueryResult result = statement.execute();
		return fromIQueryResultToEList(result, new BasicEList<Entity>());
	}
	
	public EList<Entity> getEntities(Sentence sentence) {
		SELECT statement = new SELECT(new FROM(uimaRoots), new WHERE(cEntity.AND(cRange(sentence))));
		IQueryResult result = statement.execute();
		return fromIQueryResultToEList(result, new BasicEList<Entity>());
	}
	
	public EList<Structure> getStructures() {
		SELECT statement = new SELECT(new FROM(uimaRoots), new WHERE(cStructure));
		IQueryResult result = statement.execute();
		return fromIQueryResultToEList(result, new BasicEList<Structure>());
	}
	
	public EList<Structure> getStructures(Sentence sentence) {
		SELECT statement = new SELECT(new FROM(uimaRoots), new WHERE(cStructure.AND(cRange(sentence))));
		IQueryResult result = statement.execute();
		return fromIQueryResultToEList(result, new BasicEList<Structure>());
	}
	

	
	
	public EList<Sense> getSenses() {
		SELECT statement = new SELECT(new FROM(uimaRoots), new WHERE(cSense));
		IQueryResult result = statement.execute();
		return fromIQueryResultToEList(result, new BasicEList<Sense>());
	}
	
	public EList<Sense> getSenses(Sentence sentence) {
		SELECT statement = new SELECT(new FROM(uimaRoots), new WHERE(cSense.AND(cRange(sentence))));
		IQueryResult result = statement.execute();
		return fromIQueryResultToEList(result, new BasicEList<Sense>());
	}
	
	public Sense getSense(Token token) {
		SELECT statement = new SELECT(new FROM(uimaRoots), new WHERE(cSense.AND(cRange(token))));
		IQueryResult result = statement.execute();
		if(result.size() > 0)
			return fromIQueryResultToEList(result, new BasicEList<Sense>()).get(0);
		else
			return null;
	}
	//

	
	public Sentence getParentSentence(Structure structure) {
		SELECT statement = new SELECT(new FROM(uimaRoots), new WHERE(cSentence.AND(cRangeInverse(structure))));
		IQueryResult result = statement.execute();
		if(result.size() > 0)
			return fromIQueryResultToEList(result, new BasicEList<Sentence>()).get(0);
		else
			return null;
	}
	
	public EList<Sentence> getContext(Document document, Section section, Sentence sentence) {
		EList<Sentence> context = getSentences(section);
		EList<Sentence> result = new BasicEList<Sentence>();
		if(context.size() > 3) {
			int index = context.indexOf(sentence);
			if(index - 1 >= 0 && index + 1 < context.size()) {
				result.add(context.get(index - 1));
				result.add(sentence);
				result.add(context.get(index + 1));
			}
			else if(index - 1 >= 0 && index - 2 >= 0) {
				result.add(context.get(index - 2));
				result.add(context.get(index - 1));
				result.add(sentence);
			}
			else {
				result.add(sentence);
				result.add(context.get(index + 1));
				result.add(context.get(index + 2));
			}
		}
		return result;
	}
	//
	public EList<DomainNumber> getDomainNumbers() {
		SELECT statement = new SELECT(new FROM(uimaRoots), new WHERE(cDomainNumber));
		IQueryResult result = statement.execute();
		return fromIQueryResultToEList(result, new BasicEList<DomainNumber>());
	}

	public EList<DomainAction> getDomainActions() {
		SELECT statement = new SELECT(new FROM(uimaRoots), new WHERE(cDomainAction));
		IQueryResult result = statement.execute();
		return fromIQueryResultToEList(result, new BasicEList<DomainAction>());
	}
	
	public EList<DomainAction> getDomainActions(Predicate predicate) {
		SELECT statement = new SELECT(new FROM(uimaRoots), new WHERE(cDomainAction.AND(cRange(predicate))));
		IQueryResult result = statement.execute();
		return fromIQueryResultToEList(result, new BasicEList<DomainAction>());
	}
	
	public EList<DomainAction> getDomainActions(Token token) {
		SELECT statement = new SELECT(new FROM(uimaRoots), new WHERE(cDomainAction.AND(cRange(token))));
		IQueryResult result = statement.execute();
		return fromIQueryResultToEList(result, new BasicEList<DomainAction>());
	}
	//
	public int indexOf(IdentifiableAnnotation annotation, EList<? extends IdentifiableAnnotation> annotations) {
		int index = 0;
		for(IdentifiableAnnotation ann : annotations) {
			if(ann.getIdentification().equals(annotation.getIdentification()))
				return index;
			index++;
		}
		return -1;
	}
	//
	public void test() {
		Sad sad = getSad();
		EList<SadSection> sadSection = getSadSection(sad);
		sort(sadSection);
		
		EList<Sentence> sentences = getSentences(sadSection.get(0));
		sort(sentences);
		EList<Token> tokens = getTokens(sentences.get(0));
		sort(tokens);
		for(Token token : tokens) {
			String text = getCoveredText(token);
			if(text != null)
				System.out.println(text);
		}
	}
}
