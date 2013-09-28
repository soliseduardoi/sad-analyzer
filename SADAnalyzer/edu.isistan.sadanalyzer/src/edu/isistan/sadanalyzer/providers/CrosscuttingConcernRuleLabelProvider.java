package edu.isistan.sadanalyzer.providers;

import org.eclipse.jface.viewers.LabelProvider;

import edu.isistan.reassistant.ccdetector.model.CrosscuttingConcernRule;

public class CrosscuttingConcernRuleLabelProvider extends LabelProvider {

	@Override
	public String getText(Object element) {
		CrosscuttingConcernRule rule = (CrosscuttingConcernRule) element;
		return rule.getName();
	}

	

}
