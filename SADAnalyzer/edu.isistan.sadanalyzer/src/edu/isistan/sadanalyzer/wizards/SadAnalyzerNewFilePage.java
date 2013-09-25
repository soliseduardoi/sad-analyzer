package edu.isistan.sadanalyzer.wizards;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

import edu.isistan.sadanalyzer.editor.Messages;


/**
 * The "New" wizard page allows setting the container for the new file as well
 * as the file name. The page will only accept file name without the extension
 * OR with the extension that matches the expected one (mpe).
 */

public class SadAnalyzerNewFilePage extends WizardNewFileCreationPage {
	
	public static final String ID = "edu.isistan.sadanalyzer.wizards.SadAnalyzerNewFilePage";

	/**
	 * Constructor for SadAnalyzerNewFilePage.
	 * 
	 * @param pageName
	 */
	public SadAnalyzerNewFilePage(String id, IStructuredSelection selection) {
		super(id,selection);
		
	}
	
	@Override
	protected boolean validatePage() {
		if (super.validatePage()) {
			String extension = new Path(getFileName()).getFileExtension();
			if (extension == null || !Messages.SadAnalyzer_Extension.equals(extension)) {
				String message = Messages.SadAnalyzerWizard_ErrorFileName;
				setErrorMessage(String.format(message));
				return false;
			}
			return true;
		}
		return false;
	}

	public IFile getModelFile() {
		return ResourcesPlugin.getWorkspace().getRoot().getFile(getContainerFullPath().append(getFileName()));
	}

	
}