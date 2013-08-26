package edu.isistan.uima.unified.utils;

import org.apache.uima.cas.CASException;
import org.apache.uima.cas.ConstraintFactory;
import org.apache.uima.cas.FSIntConstraint;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.cas.FSMatchConstraint;
import org.apache.uima.cas.FSStringConstraint;
import org.apache.uima.cas.FeaturePath;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;

public class SadParserFactory {
	
	final static String PDF="pdf";
	final static String WIKI="wiki";
	

	public static  SadParser getParser(String type) {
		
		SadParser parser = null;
		if(PDF.equals(type)){
			parser= new PdfParser();			
		}else
		{
		if(WIKI.equals(type)){
			parser= new WikiParser();
		 }	
		}		
		return parser;
	}	
	
}
