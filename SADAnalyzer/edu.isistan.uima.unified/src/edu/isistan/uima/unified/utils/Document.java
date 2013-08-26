package edu.isistan.uima.unified.utils;

import java.util.ArrayList;
import java.util.List;


/**
 * 
 * @author Marcos Basso
 * @author Eduardo Solis
 *
 */
public class Document {
	
	private List<Section> sections;
	
	public Document(){
		sections = new ArrayList<Section>();
	}

	/**
	 * 
	 * @return
	 */
	public List<Section> getSections() {
		return sections;
	}
	
	/**
	 * 
	 * @param sections
	 */
	public void setSections(List<Section> sections) {
		this.sections = sections;
	}

}
