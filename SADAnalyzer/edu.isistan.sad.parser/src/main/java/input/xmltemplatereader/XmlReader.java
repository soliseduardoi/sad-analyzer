package input.xmltemplatereader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;




public class XmlReader {
	
	private static final String LINK = "link";
	private List<TemplateStructure> structure;
	private List<TemplateStructure> plainStructure;
	
	private static String SECTION = "section";
	private static String ITEM = "item";
	
	private static String WRITTEN= "written";
	private static String CHILDLINK="childLink";

	public XmlReader(String url){
		plainStructure = new ArrayList<TemplateStructure>();
		structure = new ArrayList<TemplateStructure>();
		loadStructureXml(url);
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
				if( null != element.getAttributeValue(WRITTEN) ){					
					templateStructure.setWritten(false);					
				}
				templateStructure.addSubSection(createStructure(element.getChildren()));
			}
			else{
				if(ITEM.equals(element.getName())){
						if( null != element.getAttributeValue(CHILDLINK) ){
							
							templateStructure.setChildLink(true);
							templateStructure.addSubSection(createStructure(element.getChildren()));
						}else
						
							{
							 if(null != element.getAttributeValue(WRITTEN)){
								templateStructure.setWritten(false);
							}
							
						}
						
				}else{
					if(LINK.equals(element.getName())){
						templateStructure.setLinkType(true);
					}
					
				}
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
	
	
	public void loadStructureXml(String url){
		
		//Se crea un SAXBuilder para poder parsear el archivo
		SAXBuilder builder = new SAXBuilder();
		File xmlFile = new File( url );
//		File xmlFile = new File( "src/input/xmltemplatereader/resources/sad.xml" );
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
