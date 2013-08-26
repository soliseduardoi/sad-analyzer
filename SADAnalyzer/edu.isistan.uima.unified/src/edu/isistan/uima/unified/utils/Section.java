package edu.isistan.uima.unified.utils;

import java.util.List;


/**
 * 
 * @author Marcos Basso
 * @author Eduardo Solis
 *
 */
public abstract class Section {

	private String name;
	private String text;

	
	public abstract List<Section> getSections();
	
	public abstract String getId();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
}
