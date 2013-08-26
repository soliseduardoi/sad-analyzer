package edu.isistan.uima.unified.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;



public class XmlReader {
	
	private static final String LINK = "link";
	private List<TemplateStructure> structure;
	private List<TemplateStructure> plainStructure;
	
	private static String SECTION = "section";

	public XmlReader(){
		plainStructure = new ArrayList<TemplateStructure>();
		structure = new ArrayList<TemplateStructure>();
		loadStructureXml();
	}
	
	
	private List<TemplateStructure> createStructure(List list){
		
		List<TemplateStructure> tree = new ArrayList<TemplateStructure>();
		
		for ( int i = 0; i < list.size(); i++ ){

			Element element = (Element) list.get(i);
			TemplateStructure templateStructure = new TemplateStructure();
			templateStructure.setTitle(element.getAttributeValue("title"));
			
			plainStructure.add(templateStructure);
			if (SECTION.equals(element.getName())){
				if(null != element.getAttributeValue(LINK)){
					templateStructure.setLink(element.getAttributeValue(LINK));
				}
				templateStructure.addSubSection(createStructure(element.getChildren()));
			}
			tree.add(templateStructure);
		}
		return tree;
	}
	
	private void printStructure(){
		for (TemplateStructure templateStructure : structure) {
			System.out.print(templateStructure.print(0));
			System.out.print("\n");
		}
	} 
	
	
	public void loadStructureXml(){
		
		//Se crea un SAXBuilder para poder parsear el archivo
		SAXBuilder builder = new SAXBuilder();
//		File xmlFile = new File( "./resources/wikiSad.xml" );
		File xmlFile = new File( "./resources/sad.xml" );
		try {
			
			//Se crea el documento a traves del archivo
			Document document = (Document) builder.build( xmlFile );

//			//Se obtiene la raiz
			Element rootNode = document.getRootElement();
			
			List list = rootNode.getChildren();
			
			structure = createStructure(list);

			//printStructure();

		}catch ( IOException io ) {
			System.out.println( io.getMessage() );
		}catch ( JDOMException jdomex ) {
			System.out.println( jdomex.getMessage() );
		}
	}
	
//	
//	public boolean containsSection(String section){
//		for (TemplateStructure templateStructure : structure) {
//			if(templateStructure.containsSection(section)){
//				return true;
//			}			
//		}
//		return false;
//	}
	
	public List<TemplateStructure> getPlainStructure() {
		return plainStructure;
	}

	public List <TemplateStructure> getStructure(){
		return structure; 
	} 
	
	public Iterator<TemplateStructure> getPlainTemplateStructure(){
		
		return this.plainStructure.iterator();
		
	} 
}
