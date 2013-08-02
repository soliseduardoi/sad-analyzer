package input.model.impl;

import input.model.Section;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import net.htmlparser.jericho.Attribute;
import net.htmlparser.jericho.Renderer;
import net.htmlparser.jericho.Source;

/**
 * 
 * @author Marcos Basso
 * @author Eduardo Solis
 *
 */
public class UrlSection extends Section{
	private static final String SECTION_ID = "URL_SECTION_ID";

	private String urlBase;
	
	private Attribute attribute;

	public UrlSection(String urlBase) {
		this.urlBase= urlBase;
	}

	public String getUrlBase() {
		return urlBase;
	}

	public void setUrlBase(String urlBase) {
		this.urlBase = urlBase;
	}

	/**
	 * @param att the att to set
	 */
	public void setAtt(Attribute att) {
		this.attribute = att;
		this.setText();	
		
	}	
	private void setText() {
		URL url=null;
		try {
			String sectionUrl= this.attribute.getValue();
			
			url= new URL(getUrlBase()+sectionUrl);
			Source source=new Source(url);			
			Renderer renderBody = source.getRenderer();	
			super.setText(renderBody.toString());			
			
		}
			catch (Exception e) {
				super.setText("Sin Datos");
			}
		
	}

	@Override
	public List<Section> getSections() {
		List<Section> list = new ArrayList<Section>();
		list.add(this);
		return list;
	}

	public String getId() {
		
		return SECTION_ID + UUID.randomUUID().toString();
	}
	
	
	
	
}
