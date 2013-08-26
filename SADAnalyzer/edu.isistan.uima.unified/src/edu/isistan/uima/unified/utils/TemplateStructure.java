package edu.isistan.uima.unified.utils;

import java.util.List;

public class TemplateStructure {

	
	private String title;
	private List<TemplateStructure> subItems;	
	private boolean link=true;
	
	
	public TemplateStructure(){
		subItems = null;
	}
	
	/**
	 * @return the link
	 */
	public boolean hasLink() {
		return link;
	}
	
	public void setTitle(String t){
		this.title = t;
	}
	
	public String getTitle(){
		return this.title;
	}
	
	public void setStructure(List<TemplateStructure> list){
		this.subItems = list;
	}
	
	public List<TemplateStructure> getStrcture(){
		return this.subItems;
	}
	
	public void addSubSection(List<TemplateStructure> list){
		subItems = list;
	}
	
	public String print(int nivel){
		String text = this.title;
		
		if(this.subItems != null){
			nivel++;
			text = text + "\n";
			for (TemplateStructure struct : subItems) {
				for(int i=0; i < nivel;i++){ 
					text = text + "   ";
				}
				 text = text + struct.print(nivel) + "\n";
			}
		}
		return text;
	}
	
	public boolean isItem(){
		return subItems ==null;
		
	}
	
	public int getCantSections() {
		
		int cant = 0;
		if (!isItem()){
			cant++;
			for (int i = 0; i < this.subItems.size(); i++) {
				
				TemplateStructure structure= this.subItems.get(i);
				cant+=structure.getCantSections();
			}
			
			
		}
		return cant;
	}

	public int getCantItems() {
		int cant=0;
		if(isItem() || this.subItems.isEmpty() ){
			return 1;
		}else{
			
			for (int i = 0; i < this.subItems.size(); i++) {
				
				TemplateStructure structure= this.subItems.get(i);
				cant+=structure.getCantItems();
			}
		}
			
		return cant;
	}

	public void setLink(String attributeValue) {
		this.link= Boolean.valueOf(attributeValue);
		
	}

	public boolean isEmpty() {
		
		return subItems!=null && subItems.size()==0;
	}
	
}
