package edu.isistan.sadeditor.wizards;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

import edu.isistan.sadeditor.editor.Messages;


/**
 * The "New" wizard page allows setting the container for the new file as well
 * as the file name. The page will only accept file name without the extension
 * OR with the extension that matches the expected one (mpe).
 */

public class SadWizardNewFilePage extends WizardNewFileCreationPage {
	
	public static final String ID = "edu.isistan.sadeditor.wizards.SadWizardNewFilePage";

	/**
	 * Constructor for SampleNewWizardPage.
	 * 
	 * @param pageName
	 */
	public SadWizardNewFilePage(String id, IStructuredSelection selection) {
		super(id,selection);
		
	}
	
	@Override
	protected boolean validatePage() {
		if (super.validatePage()) {
			String extension = new Path(getFileName()).getFileExtension();
			if (extension == null || !Messages.Sad_Extension.equals(extension)) {
				String message = Messages.SadWizard_ErrorFileName;
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