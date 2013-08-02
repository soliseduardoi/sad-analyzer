package input.parser;

import input.parser.impl.PdfParser;
import input.parser.impl.WikiParser;

public class SadParserFactory {
	
	public final static  String PDF="pdf";
	public final static String WIKI="wiki";
	

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
