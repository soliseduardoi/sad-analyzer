package edu.isistan.uima.unified.analysisengines.matetools;

import is2.data.SentenceData09;
import is2.lemmatizer.Lemmatizer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.text.AnnotationIndex;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;
import org.apache.uima.resource.ResourceInitializationException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.uimafit.component.JCasAnnotator_ImplBase;
import org.uimafit.descriptor.ConfigurationParameter;
import org.uimafit.descriptor.ExternalResource;

import edu.isistan.uima.unified.analysisengines.AnnotationGenerator;
import edu.isistan.uima.unified.sharedresources.ProgressMonitorResource;
import edu.isistan.uima.unified.typesystems.nlp.Sentence;
import edu.isistan.uima.unified.typesystems.nlp.Token;

public class LemmaAnnotator extends JCasAnnotator_ImplBase {
	@ConfigurationParameter(name="model")
	private String modelName;
	//
	private Lemmatizer lemmatizer;
	//
	@ExternalResource(key="monitor")
	private ProgressMonitorResource monitorResource;
	private IProgressMonitor subMonitor;
	
	@Override
	public void initialize(UimaContext aContext) throws ResourceInitializationException {
		super.initialize(aContext);
		try {
			//modelName = (String) aContext.getConfigParameterValue("model");
			//Aca da error. El model que baje se llamaba distinto
			lemmatizer = new Lemmatizer(modelName);
		}
		catch (Exception e) { 
			e.printStackTrace();
		}
	}
	
	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		if(lemmatizer == null)
			return;
		//
		subMonitor = new SubProgressMonitor(monitorResource.getMonitor(), 1, SubProgressMonitor.PREPEND_MAIN_LABEL_TO_SUBTASK);
		subMonitor.subTask("Annotating token lemmas (Matetools)");
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
			while(tokenIterator.hasNext()) {
				Annotation tAnnotation = tokenIterator.next();
				tokenList.add((Token)tAnnotation);
			}			
			Token[] tokenAnnotations = new Token[tokenList.size()];
			for(int i = 0; i < tokenList.size(); i++)
				tokenAnnotations[i] = tokenList.get(i);
			String[] tokensArray = new String[tokenAnnotations.length];
			for(int i = 0; i < tokenAnnotations.length; i++)
				tokensArray[i] = tokenAnnotations[i].getCoveredText();
			
			ArrayList<String> forms = new ArrayList<String>();
			forms.add("<ROOT>");
			for(int i = 0; i < tokensArray.length; i++)
				forms.add(tokensArray[i]);
			
			SentenceData09 sentence = new SentenceData09();
			sentence.init(forms.toArray(new String[0]));

			lemmatizer.apply(sentence);
			
			for(int tokenNumber = 0; tokenNumber < tokenAnnotations.length; tokenNumber++) {
				Token token = tokenAnnotations[tokenNumber];
				String lemma = sentence.lemmas[tokenNumber + 1];			
				AnnotationGenerator.generateLemma(token, lemma, aJCas);
			}
			//
			subMonitor.worked(1);
		}
		//
		subMonitor.done();
	}
	
	@Override
	public void destroy() {
		lemmatizer = null;
		super.destroy();
	}
}
