package edu.isistan.sadanalyzer.providers;


import org.eclipse.jface.viewers.LabelProvider;

import edu.isistan.sadanalyzer.query.UIMASADQueryAdapter;
import edu.isistan.uima.unified.typesystems.sad.SadSection;


public class SadSectionLabelProvider extends LabelProvider {
	@SuppressWarnings("unused")
	private UIMASADQueryAdapter uimaRoot;

	public SadSectionLabelProvider(UIMASADQueryAdapter uimaRoot) {
		super();
		this.uimaRoot = uimaRoot;
	}
	
	@Override
	public String getText(Object element) {
		SadSection section = (SadSection) element;
		return section.getName();
	}
}
