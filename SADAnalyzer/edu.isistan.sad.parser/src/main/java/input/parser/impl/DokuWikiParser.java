package input.parser.impl;

import input.model.Section;
import input.model.impl.CompositeSection;
import input.model.impl.Item;
import input.parser.SadParser;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class DokuWikiParser implements SadParser {
	
	private HashSet<String> filteredPages;
	public final static String DOKUWIKI_PATH="\\data\\pages\\";
	public static final String[] FILTERED_PAGES = new String[] { "dokuwiki.txt", "syntax.txt", "template.txt", "start.txt", "index.txt", "navigation.txt", "site_notice.txt", "directorio.txt" };

	public DokuWikiParser(){
		filteredPages = new HashSet<String>(Arrays.asList(FILTERED_PAGES));
	}
	
	
	/**
	 * @see input.parser.SadParser#getSad(java.lang.String, java.lang.String)
	 */
	@Override
	public Section getSad(String pathTemplate, String urlSad) {		
		Section section = new CompositeSection();
		if(null != urlSad && urlSad.length() > 0){
			urlSad = urlSad + DOKUWIKI_PATH;
			File rootDirectoryDokuWiki = new File(urlSad);
			section = parseDokuWiki(rootDirectoryDokuWiki);
			return section;
		}
		return null;
	}

	private Section parseDokuWiki(File rootDirectoryDokuWiki) {
		CompositeSection dokuWiki = new CompositeSection();
		String s=null;
		try {
			s = FileUtils.readFileToString(new File(rootDirectoryDokuWiki+"\\start.txt"), "utf8");
			String[] split = s.split("\n");
			dokuWiki.setName(split[0]);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		dokuWiki.addSection(parseDokuWiki(rootDirectoryDokuWiki, rootDirectoryDokuWiki));
		return dokuWiki;
	}

	private Section parseDokuWiki(File currentFile, File rootTreeDirectory) {
		if (currentFile.isDirectory()) {
			CompositeSection compositeSection = new CompositeSection();
			compositeSection.setName(currentFile.getName());
			for (File file : currentFile.listFiles()) {
				Section child = parseDokuWiki(file, rootTreeDirectory);
				if (child != null) {
					compositeSection.addSection(child);
				}
			}
			return compositeSection;
		} else {
			if (filteredPages.contains(currentFile.getName()))
				return null;
			try {
			Item item = new Item();
			item.setName(currentFile.getName());
				item.setText(FileUtils.readFileToString(currentFile, "utf8"));
				return item;
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}			
		}
	}
	
	public static void main(String[] args){
		String path = "D:/web/xampp/htdocs/dokuwiki-ctas/data/pages/";
		
		DokuWikiParser parser = new DokuWikiParser();
		Section section = parser.getSad(null,path);		
		List<Section> list = section.getSections();
	}
	
}
