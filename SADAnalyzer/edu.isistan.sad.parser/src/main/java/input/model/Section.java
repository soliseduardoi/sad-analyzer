package input.model;

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
	private String id;
	
	
	public abstract String getId();
	/**
	 * Return the list of Sections
	 * 
	 * @return List<Section>
	 */
	public abstract List<Section> getSections();
	
	/**
	 * Return the name of Section
	 * @return String 
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Set the name of Section
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Return the Text of Section
	 * @return String
	 */
	public String getText() {
		return text;
	}
	
	/**
	 * Set the text of Section
	 * @param text
	 */
	public void setText(String text) {
		this.text = text;
	}
}
