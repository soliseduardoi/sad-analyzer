package input.parser;

import input.model.Section;


/**
 * 
 * @author Marcos Basso
 * @author Eduardo Solis
 *
 */
public interface SadParser {
	
	Section getSad(String pathTemplate, String urlSad);

}
