package edu.isistan.uima.unified.analysisengines.stanfordnlp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.text.AnnotationIndex;
import org.apache.uima.fit.descriptor.ConfigurationParameter;
import org.apache.uima.fit.descriptor.ExternalResource;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;
import org.apache.uima.resource.ResourceInitializationException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;

import edu.isistan.uima.unified.analysisengines.AnnotationGenerator;
import edu.isistan.uima.unified.sharedresources.ProgressMonitorResource;
import edu.isistan.uima.unified.typesystems.nlp.Sentence;
import edu.isistan.uima.unified.typesystems.nlp.Token;
import edu.stanford.nlp.ie.AbstractSequenceClassifier;
import edu.stanford.nlp.ie.crf.CRFClassifier;
import edu.stanford.nlp.ling.CoreAnnotations.AnswerAnnotation;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.ling.HasWord;

public class EntityAnnotator extends JCasAnnotator_ImplBase {
	@ConfigurationParameter(name="model")
	private String modelName;
	protected AbstractSequenceClassifier<CoreLabel> cf;
	//
	@ExternalResource(key="monitor")
	private ProgressMonitorResource monitorResource;
	private IProgressMonitor subMonitor;
	
	@SuppressWarnings("unchecked")
	@Override
	public void initialize(UimaContext aContext) throws ResourceInitializationException {
		super.initialize(aContext);
		try {
			//modelName = (String) aContext.getConfigParameterValue("model");
			cf = CRFClassifier.getClassifier(modelName);
		} catch (Exception e) { 
			e.printStackTrace();
		}
	}
	
	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		if(cf == null)
			return;
		//
		subMonitor = new SubProgressMonitor(monitorResource.getMonitor(), 1, SubProgressMonitor.PREPEND_MAIN_LABEL_TO_SUBTASK);
		subMonitor.subTask("Annotating entities (Stanford)");
		//
		//String docText = aJCas.getDocumentText();
		AnnotationIndex<Annotation> sAnnotations = aJCas.getAnnotationIndex(Sentence.type);
		AnnotationIndex<Annotation> tAnnotations = aJCas.getAnnotationIndex(Token.type);
		//
		subMonitor.beginTask(this.getClass().getSimpleName(), sAnnotations.size());
		//
		for(Annotation sAnnotation : sAnnotations) {
			//Sentence sentenceAnnotation = (Sentence) sAnnotation;
			//String sentence = sAnnotation.getCoveredText();
			
			Iterator<Annotation> tokenIterator = tAnnotations.subiterator(sAnnotation);
			List<Token> tokenList = new LinkedList<Token>();
			List<String> wordList = new LinkedList<String>();
			while(tokenIterator.hasNext()) {
				Annotation tAnnotation = tokenIterator.next();
				Token token = (Token) tAnnotation;
				tokenList.add(token);
				wordList.add(token.getCoveredText());
			}
						
			ArrayList<? extends HasWord> sentence = edu.stanford.nlp.ling.Sentence.toUntaggedList(wordList);
			List<CoreLabel> classification = cf.classifySentence(sentence);
			
			int current = 0;
			String currentAnswer = "O";
			Token beginToken = null;
			Token endToken = null;
			while(current < classification.size()) {
				CoreLabel cl = classification.get(current);
				String answer = cl.get(AnswerAnnotation.class);
				
				if(answer.equals("O")) {
					if(beginToken != null && endToken != null) {
						AnnotationGenerator.generateEntity(beginToken.getBegin(), endToken.getEnd(), currentAnswer, aJCas);
						beginToken = null;
						endToken = null;
					}
				}
				else {
					if(answer.equals(currentAnswer)) {
						endToken = tokenList.get(current);
					}
					else {
						if(beginToken != null && endToken != null) {
							AnnotationGenerator.generateEntity(beginToken.getBegin(), endToken.getEnd(), currentAnswer, aJCas);
						}
						currentAnswer = answer;
						beginToken = tokenList.get(current);
						endToken = beginToken;
					}
				}				
				current++;
			}
			//
			subMonitor.worked(1);
		}
		//
		subMonitor.done();
	}
	
	@Override
	public void destroy() {
		cf = null;
		super.destroy();
	}
}