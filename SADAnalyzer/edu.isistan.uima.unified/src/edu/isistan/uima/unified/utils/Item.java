package edu.isistan.uima.unified.utils;



import java.util.ArrayList;
import java.util.List;

import org.apache.uima.internal.util.UUIDGenerator;


/**
 * 
 * @author Marcos Basso
 * @author Eduardo Solis
 *
 */
public class Item extends Section{
		
		
	/**
	 * @see input.model.Section#getSections()
	 */
	@Override
	public List<Section> getSections() {
		List<Section> list = new ArrayList<Section>();
		list.add(this);
		return list;
	}

	@Override
	public String getId() {
		
		return "ITEM_ID"+ UUIDGenerator.generate().toString();
	}
			
}
