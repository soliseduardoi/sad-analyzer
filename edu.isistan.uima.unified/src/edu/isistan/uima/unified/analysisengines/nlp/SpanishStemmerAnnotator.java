package edu.isistan.uima.unified.analysisengines.nlp;

import org.apache.uima.UimaContext;
import org.apache.uima.resource.ResourceInitializationException;
import org.tartarus.snowball.ext.spanishStemmer;

public class SpanishStemmerAnnotator  extends StemmerAnnotator{
	protected spanishStemmer stemmer;
	//
	
	@Override
	public void initialize(UimaContext aContext) throws ResourceInitializationException {
		super.initialize(aContext);
		stemmer = new spanishStemmer();
	}
	
	@Override
	public void destroy() {
		stemmer = null;
		super.destroy();
	}

	@Override
	protected String getStem(String coveredText) {
		stemmer.setCurrent(coveredText);
		stemmer.stem();
		return stemmer.getCurrent();
	}
}