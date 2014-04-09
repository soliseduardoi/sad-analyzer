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


	// Queries


	
	/**
	 * Obtiene una lista de SadSection
	 * @return
	 */
	
	public EList<SadSection> getSadSection() {
		SELECT statement = new SELECT(new FROM(uimaRoots), new WHERE(cSadSection));
		IQueryResult result = statement.execute();
		return fromIQueryResultToEList(result, new BasicEList<SadSection>());
	}
	

	//
	public void test() {
//		Sad sad = getSad();
//		EList<SadSection> sadSection = getSadSection(sad);
//		sort(sadSection);
//		
//		EList<Sentence> sentences = getSentences(sadSection.get(0));
//		sort(sentences);
//		EList<Token> tokens = getTokens(sentences.get(0));
//		sort(tokens);
//		for(Token token : tokens) {
//			String text = getCoveredText(token);
//			if(text != null)
//				System.out.println(text);
//		}
	}
}
