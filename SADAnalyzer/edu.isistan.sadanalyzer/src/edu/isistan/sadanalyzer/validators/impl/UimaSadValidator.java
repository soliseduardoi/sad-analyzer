package edu.isistan.sadanalyzer.validators.impl;

import edu.isistan.sadanalyzer.editor.Messages;
import edu.isistan.sadanalyzer.validators.SadAnalyzerWizardValidator;

public class UimaSadValidator extends SadAnalyzerWizardValidator{
	
	private static final String FILE_IMPORT_UIMASAD_MASK = "uimasad";

	@Override
	public String getMessages() {
		return Messages.SadAnalyzerWizard_ErrorMaskFile + " ." + FILE_IMPORT_UIMASAD_MASK;
	}

	@Override
	public String getMask() {
		return FILE_IMPORT_UIMASAD_MASK;
	}

}
