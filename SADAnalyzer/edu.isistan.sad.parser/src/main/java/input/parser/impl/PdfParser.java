package input.parser.impl;

import input.model.Section;
import input.model.impl.CompositeSection;
import input.model.impl.Item;
import input.parser.SadParser;
import input.xmltemplatereader.TemplateStructure;
import input.xmltemplatereader.XmlReader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.interactive.action.type.PDAction;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.PDDestination;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDDocumentOutline;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem;
import org.apache.pdfbox.util.PDFTextStripper;

/**
 * 
 * @author Marcos Basso
 *
 */
public class PdfParser implements SadParser {

	
	private XmlReader structureXml;
	
	public static void main(String[] args){
//		String path = "D:\\MSLite architecture.pdf";
		String path = "D:\\Resumen de Mak.pdf";
//		String path = "D:\\Nokia_N8-00.pdf";
		String pathTemplate="";
		
		PdfParser parser = new PdfParser();
		Section section = parser.getSad(pathTemplate,path);		
		List<Section> list = section.getSections();
	}
	/**
	 * @see input.parser.SadParser#getSad(java.lang.String)
	 */
	public Section getSad(String pathTemplate, String urlSad) {
		Section section = new CompositeSection();	
		if(!pathTemplate.isEmpty()){
			structureXml = new XmlReader(pathTemplate);
		}
		
		 try {
			 File input = new File(urlSad);
	         	          
			 PDDocument doc;
			 doc = PDDocument.load(input);         
		     PDDocumentOutline root = doc.getDocumentCatalog().getDocumentOutline();
		     if(root!=null){  
			     // Se pide el primer nodo del arbol
			     PDOutlineItem item = root.getFirstChild();
			     if(structureXml != null){
				     if(validateTemplate(item)){
				    	 section = parserSections(item, doc);
				     }else{
				       	section = null;
				     }
				 }else{
					 section = parserSections(item, doc);
				 }
		     }else{
		    	 	Item s = new Item();
					s.setText(extractText(0, doc, doc.getNumberOfPages()));
					s.setName(input.getName());				
					((CompositeSection) section).addSection(s);		    	
		     }
		     return section;
		 } catch (IOException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
	 	}
		return null;
	}
	
	private boolean validateTemplate(PDOutlineItem item){
		boolean validate=true;
     	if(item != null && structureXml != null){
     		validate = validateStructure(item, structureXml.getStructure());
		}else{
			validate = false;
		}				
		return validate;
	}
	
	private boolean validateStructure(PDOutlineItem item, List<TemplateStructure> structure ){
		boolean validate=true;
		int i;
		for(i=0; i < structure.size() && item != null && validate; i++){
			TemplateStructure ts = structure.get(i);
			if(item.getTitle().equals(ts.getTitle())){
				if(item.getFirstChild() != null  && ((ts.getStrcture() != null) && (ts.getStrcture().size() > 0))){
					validate = validateStructure(item.getFirstChild(), ts.getStrcture());
				}
			}else{
				validate = false;
			}
			item = item.getNextSibling();
		}
		if((i < structure.size())||(i == structure.size()&& item != null)){
			validate = false;
		}
		return validate;
	}
	
	private CompositeSection parserSections(PDOutlineItem item, PDDocument doc){
		CompositeSection pdfDocument = new CompositeSection();		
		try{
			parse(item, doc,pdfDocument, item.getNextSibling());
			doc.close();
			return pdfDocument;
		}catch(Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	private void parse(PDOutlineItem item, PDDocument doc, CompositeSection pdfSection, PDOutlineItem tope) {
		try {
			if(item != null){	
				PDOutlineItem aux = null;
				int t = getPage(tope, doc);
				int i = getPage(item, doc);
				if(item.getFirstChild() != null){
					CompositeSection s = null;
					s = new CompositeSection();
					aux = item.getFirstChild();
					int pageChild = getPage(aux, doc);
					int inicialPage = getPage(item, doc);
					if(inicialPage < pageChild){						
						s.setText(extractText(inicialPage, doc, pageChild));
					}
					s.setName(item.getTitle());
					if(item.getNextSibling() != null){
						parse(aux,doc,s,item.getNextSibling());						
					}else{
						parse(aux,doc,s,aux.getNextSibling());
					}
					pdfSection.addSection(s);					
				}else{
					Item s = new Item();
					aux = item;
					s.setText(extractText(getPage(aux, doc), doc, getPaginaFinal(item,doc, tope)));
					s.setName(item.getTitle());				
					pdfSection.addSection(s);
//					tope = tope.getNextSibling();
				}
				parse(item.getNextSibling(), doc, pdfSection, tope);			
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private String extractText(int inicialPage, PDDocument doc, int finalPage) {
		PDFTextStripper stripper;
		try {
			if(inicialPage == finalPage){
				finalPage++;
			}
			 stripper = new PDFTextStripper();	
			 stripper.setStartPage(inicialPage);
			 stripper.setEndPage(finalPage-1);
			 String original = stripper.getText(doc);
			 return original;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	protected int getPaginaFinal(PDOutlineItem item, PDDocument doc, PDOutlineItem tope) {
		int page = 0;
		if(item.getNextSibling() != null){
			page = getPage(item.getNextSibling(), doc);					
		}else{
			if((tope != null) && (getPage(item, doc) <= getPage(tope, doc))){
				page = getPage(tope, doc);
			}else{
				page = doc.getNumberOfPages()+1;
			}
		}
		return page;
	}
	
	public int getPage(PDOutlineItem current, PDDocument doc){
		 
		try{
	        if (current != null) {
	        	PDDestination  dest = current.getDestination();
	        	PDAction pdAction = current.getAction();
	            if (pdAction != null) {
	                // From BM-Thread
	                COSObject targetPageRef = (COSObject) ((COSArray) current.getAction().getCOSDictionary().getDictionaryObject("D")).get(0);
	                String objStr = String.valueOf(targetPageRef.getObjectNumber().intValue());
	                String genStr = String.valueOf(targetPageRef.getGenerationNumber().intValue());
	                return (Integer) doc.getPageMap().get(objStr + "," + genStr);
	            } else if (dest != null) {
	                // From PDP-Thread
	                PDPage pdp = current.findDestinationPage(doc);
	                List allpages = new ArrayList();
	                doc.getDocumentCatalog().getPages().getAllKids(allpages);
	                return allpages.indexOf(pdp) + 1;
	            }
	        }
		}catch(Exception e){
			// TODO Auto-generated catch block
			e.printStackTrace();	   
		}
		return 0;
	}

}
