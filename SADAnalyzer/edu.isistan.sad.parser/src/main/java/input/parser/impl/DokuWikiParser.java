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
	public final static String DOKUWIKI_PATH="/data/pages/";
	public final static String DOKUWIKI_PATHWIN="\\data\\pages\\";
	public static final String[] FILTERED_PAGES = new String[] { "dokuwiki.txt", "syntax.txt", "template.txt", "start.txt", "index.txt", "navigation.txt", "site_notice.txt", "directorio.txt" };

	public DokuWikiParser(){
		filteredPages = new HashSet<String>(Arrays.asList(FILTERED_PAGES));
	}
	
	
	/**
	 * @see input.parser.SadParser#getSad(java.lang.String, java.lang.String)
	 */
	@Override
	public Section getSad(String pathTemplate, String urlSad) {		
		String dokiwikiPath=DOKUWIKI_PATHWIN;
		if(!urlSad.contains(":"))
			dokiwikiPath=DOKUWIKI_PATH;
			
		Section section = new CompositeSection();
		if(null != urlSad && urlSad.length() > 0){			
			urlSad = urlSad + dokiwikiPath;
			File rootDirectoryDokuWiki = new File(urlSad);
			section = parseDokuWiki(rootDirectoryDokuWiki);
			return section;
		}
		return null;
	}

	private Section parseDokuWiki(File rootDirectoryDokuWiki) {		
		return parseDokuWiki(rootDirectoryDokuWiki, rootDirectoryDokuWiki);
	}

	private Section parseDokuWiki(File currentFile, File rootTreeDirectory) {
		
		String dash= "\\";
		if (!currentFile.getAbsolutePath().contains(":"))
			dash="/";
			
			
		if (currentFile.isDirectory()) {
			CompositeSection compositeSection = new CompositeSection();
			if(!rootTreeDirectory.getName().equals(currentFile.getName())){
				compositeSection.setName(currentFile.getName());
			}			
			for (File file : currentFile.listFiles()) {
				Section child = parseDokuWiki(file, rootTreeDirectory);
				if (child != null) {
					compositeSection.addSection(child);
				}
			}
			File compositeSectionLink=null;
			try {
				compositeSectionLink = new File(currentFile.getParentFile()+dash+currentFile.getName()+".txt");
				if(!compositeSectionLink.isDirectory()){				
					compositeSection.setText(FileUtils.readFileToString(compositeSectionLink, "utf8"));
				}
			} catch (Exception e) {
							
			}			
			return compositeSection;
		} else {
			if (filteredPages.contains(currentFile.getName()))
				return null;
			try {
				File directory = new File(currentFile.getParentFile()+dash+currentFile.getName().split("\\.")[0]);
				if(!directory.isDirectory()){			
					Item item = new Item();
					item.setName(currentFile.getName().split("\\.")[0]);
					item.setText(FileUtils.readFileToString(currentFile, "utf8"));
					return item;
				}				
			} catch (IOException e) {
								
			}	
			return null;
		}
	}
	
	public static void main(String[] args){
		String path = "D:/web/xampp/htdocs/dokuwiki-ctas";
		
		DokuWikiParser parser = new DokuWikiParser();
		Section section = parser.getSad(null,path);		
		List<Section> list = section.getSections();
	}
	
}
