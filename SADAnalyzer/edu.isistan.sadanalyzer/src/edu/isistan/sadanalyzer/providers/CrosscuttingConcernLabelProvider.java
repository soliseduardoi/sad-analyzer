package edu.isistan.sadanalyzer.providers;

import org.eclipse.jface.viewers.LabelProvider;

import edu.isistan.uima.unified.ruta.CrosscuttingConcernAdapted;

public class CrosscuttingConcernLabelProvider extends LabelProvider {

	@Override
	public String getText(Object element) {
		CrosscuttingConcernAdapted crosscutting = (CrosscuttingConcernAdapted) element;
		return crosscutting.getName();
	}

	

}