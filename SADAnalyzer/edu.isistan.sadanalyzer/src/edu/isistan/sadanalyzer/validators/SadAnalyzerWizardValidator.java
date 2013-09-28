package edu.isistan.sadanalyzer.validators;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;

public abstract class SadAnalyzerWizardValidator implements ISelectionStatusValidator{

	public static final String ID = "edu.isistan.sadanalyzer.validators.SadAnalyzerWizardValidator";
	
	@Override
	public IStatus validate(Object[] selection) {
		if (selection.length == 1 && selection[0] instanceof IFile) {
        	String[] split = selection[0].toString().split("\\.");
        	if(getMask().equals(split[1])){
        		return new Status(IStatus.OK, ID, 0, "", null);
        	}
        	return new Status(IStatus.ERROR, ID, 0, getMessages(), null);
        }
        return new Status(IStatus.ERROR, ID, 0, getMessages(), null);
	}
	
	public abstract String getMessages();
	
	public abstract String getMask();

}
