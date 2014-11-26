package edu.isistan.sadanalyzer.providers;

import org.eclipse.jface.viewers.LabelProvider;

import edu.isistan.uima.unified.ruta.RutaScript;

public class RutaScriptLabelProvider extends LabelProvider {

	@Override
	public String getText(Object element) {
		RutaScript concern = (RutaScript) element;
		String name= "";
		if(concern.getName().contains("_")){
			name = concern.getName().replace("_", " ");
		}else{
			name = concern.getName();
		}
		return name;
	}
}