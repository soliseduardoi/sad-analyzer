package edu.isistan.sadanalyzer.wizards;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWizard;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;

import edu.isistan.sadanalyzer.editor.Messages;


/**
 * This is a sample new wizard. Its role is to create a new file 
 * resource in the provided container. If the container resource
 * (a folder or a project) is selected in the workspace 
 * when the wizard is opened, it will accept it as the target
 * container. The wizard creates one file with the extension
 * "mpe". If a sample multi-page editor (also available
 * as a template) is registered for the same extension, it will
 * be able to open it.
 */

public class SadAnalyzerWizard extends Wizard implements INewWizard {
	
	protected IStructuredSelection selection;
	protected IWorkbench workbench;
	private Boolean validModel;
	private SadAnalyzerNewFilePage sadAnalyzerNewFilePage;
	private SadAnalyzerSettingsPage sadAnalyzerSettingsPage;
	
	/**
	 * Constructor for SampleNewWizard.
	 */
	public SadAnalyzerWizard() {
		super();
		validModel = new Boolean(Boolean.TRUE);
		setNeedsProgressMonitor(true);
	}
	
	/**
	 * We will accept the selection in the workbench to see if
	 * we can initialize from it.
	 * @see IWorkbenchWizard#init(IWorkbench, IStructuredSelection)
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		this.selection = selection;
		setWindowTitle(Messages.SadAnalyzerWizard_Windows_Title);
	}
	
	/**
	 * Adding the page to the wizard.
	 */

	public void addPages() {
		super.addPages();
		sadAnalyzerNewFilePage = new SadAnalyzerNewFilePage(SadAnalyzerNewFilePage.ID,selection);
		sadAnalyzerNewFilePage.setTitle(Messages.SadAnalyzerWizard_Title);
		sadAnalyzerNewFilePage.setDescription(Messages.SadAnalyzerWizard_Description);
		sadAnalyzerNewFilePage.setFileName(Messages.SadAnalyzer_FilenameDefault +"."+ Messages.SadAnalyzer_Extension);
		addPage(sadAnalyzerNewFilePage);
		
		// Try and get the resource selection to determine a current directory for the file dialog
				if (selection != null && !selection.isEmpty()) {
					// Get the resource...
					Object selectedElement = selection.iterator().next();
					if (selectedElement instanceof IResource) {
						// Get the resource parent, if its a file
						IResource selectedResource = (IResource)selectedElement;
						if (selectedResource.getType() == IResource.FILE) {
							selectedResource = selectedResource.getParent();
						}
						// This gives us a directory...
						if (selectedResource instanceof IFolder || selectedResource instanceof IProject) {
							// Set this for the container
							sadAnalyzerNewFilePage.setContainerFullPath(selectedResource.getFullPath());
//							 Make up a unique new name here
							String defaultModelBaseFilename = Messages.SadAnalyzer_FilenameDefault;
							String defaultModelFilenameExtension = Messages.SadAnalyzer_Extension;
							String modelFilename = defaultModelBaseFilename + "." + defaultModelFilenameExtension;
							for (int i = 1; ((IContainer)selectedResource).findMember(modelFilename) != null; ++i) {
								modelFilename = defaultModelBaseFilename + i + "." + defaultModelFilenameExtension;
							}
							sadAnalyzerNewFilePage.setFileName(modelFilename);
						}
					}
				}
		
		sadAnalyzerSettingsPage = new SadAnalyzerSettingsPage(selection);
		sadAnalyzerSettingsPage.setTitle(Messages.SadAnalyzerWizard_Windows_Title);
		sadAnalyzerSettingsPage.setDescription(Messages.SadAnalyzerWizard_Description);
		addPage(sadAnalyzerSettingsPage);
	}

	/**
	 * This method is called when 'Finish' button is pressed in
	 * the wizard. We will create an operation and run it
	 * using wizard as execution context.
	 */
	public boolean performFinish() {
//		final String containerName = sadAnalyzerNewFilePage.getContainerName();
//		final String fileName = sadAnalyzerNewFilePage.getFileName();
//		IRunnableWithProgress op = new IRunnableWithProgress() {
//			public void run(IProgressMonitor monitor) throws InvocationTargetException {
//				try {
//					doFinish(containerName, fileName, monitor);
//				} catch (CoreException e) {
//					throw new InvocationTargetException(e);
//				} finally {
//					monitor.done();
//				}
//			}
//		};
//		try {
//			getContainer().run(true, false, op);
//		} catch (InterruptedException e) {
//			return false;
//		} catch (InvocationTargetException e) {
//			Throwable realException = e.getTargetException();
//			MessageDialog.openError(getShell(), "Error", realException.getMessage());
//			return false;
//		}
		return true;
	}	
}