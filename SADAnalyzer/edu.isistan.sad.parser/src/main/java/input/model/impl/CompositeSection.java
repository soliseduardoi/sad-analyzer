package input.model.impl;



import input.model.Section;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;



/**
 * 
 * @author Marcos Basso
 * @author Eduardo Solis
 *
 */
public class CompositeSection extends Section{
	
	private static final String SECTION_ID = "COMPOSITE_SECTION_ID";
	private List<Section> subSections;
	
	
	public CompositeSection(){
		subSections = new ArrayList<Section>();
	}
	
	
	/**
	 * Add section in the list of Sections
	 * @param Section s
	 */
	public void addSection(Section s){
		subSections.add(s);
	}
	
	/**
	 * Remove section
	 * @param Section s
	 */
	public void removeSection(Section s){
		subSections.remove(s);
	}
	
	/**
	 * Return the subSections
	 * @return
	 */
	public List<Section> getSubSections(){
		return subSections;
	}


	/**
	 * @see input.model.Section#getSections()
	 */
	@Override
	public List<Section> getSections() {
		List<Section> list = new ArrayList<Section>();
		Item item = new Item();
		item.setName(this.getName());
		item.setText(this.getText());
		list.add(item);
		for(int i=0; i < subSections.size();i++){			
			Section s = subSections.get(i);
			list.addAll(s.getSections());
		}
		return list;
		
	}


	@Override
	public String getId() {
	
		return SECTION_ID + UUID.randomUUID().toString();
	}
}
