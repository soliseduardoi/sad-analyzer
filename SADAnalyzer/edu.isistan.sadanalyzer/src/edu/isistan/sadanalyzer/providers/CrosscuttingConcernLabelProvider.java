package edu.isistan.sadanalyzer.providers;

import org.eclipse.jface.viewers.LabelProvider;

import edu.isistan.sadanalyzer.model.CrosscuttingConcern;
import edu.isistan.sadanalyzer.model.impl.CrosscuttingConcernImpl;

public class CrosscuttingConcernLabelProvider extends LabelProvider {

	@Override
	public String getText(Object element) {
		CrosscuttingConcern crosscutting = (CrosscuttingConcernImpl) element;
		return crosscutting.getName();
	}

	

}