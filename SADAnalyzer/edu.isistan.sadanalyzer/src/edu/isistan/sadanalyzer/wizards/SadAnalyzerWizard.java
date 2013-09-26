package edu.isistan.sadanalyzer.wizards;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWizard;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.ISetSelectionTarget;

import edu.isistan.sadanalyzer.editor.Messages;
import edu.isistan.sadanalyzer.model.SadAnalyzerModelFactory;
import edu.isistan.sadanalyzer.model.SadAnalyzerModelPackage;
import edu.isistan.sadanalyzer.model.SadAnalyzerProject;


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
	
	protected SadAnalyzerModelPackage sadAnalyzerModelPackage = SadAnalyzerModelPackage.eINSTANCE;
	protected SadAnalyzerModelFactory sadAnalyzerModelFactory = sadAnalyzerModelPackage.getSadAnalyzerModelFactory();
	
	
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
		
		try {
			// SAD File
			final String sadURI = sadAnalyzerSettingsPage.getTextSadPath().getText();
			//UimaSad File
			final String uimaSadURI = sadAnalyzerSettingsPage.getTextUimaSadPath().getText();
					
			// SADA
			final IFile sadaFile = sadAnalyzerNewFilePage.getModelFile();
			
			// Do the work within an operation
			WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {
				@Override
				protected void execute(IProgressMonitor progressMonitor) {
					try {
												
						// SADA
						String sadaURI = sadaFile.getFullPath().toString();
						ResourceSet resourceSet = new ResourceSetImpl();
						URI fileURI = URI.createPlatformResourceURI(sadaURI, true);
						Resource resource = resourceSet.createResource(fileURI);
						
						SadAnalyzerProject rootModel = createInitialModel();
						if (rootModel != null) {
//							rootModel.setName(reaPage.getName());
							rootModel.setSadURI(sadURI);
							rootModel.setUimaURI(uimaSadURI);
							resource.getContents().add(rootModel);
						}
						// Save the contents of the resource to the file system
						Map<Object, Object> options = new HashMap<Object, Object>();
						options.put(XMLResource.OPTION_ENCODING, "UTF-8");
						resource.save(options);
					}
					catch (Exception e) {
						e.printStackTrace();
					}
					finally {
						//Refresh workbench
						try {
							sadaFile.getParent().refreshLocal(IResource.DEPTH_ONE, null);
						} catch (CoreException e) {
							e.printStackTrace();
						}
						progressMonitor.done();
					}
				}
			};
			
			getContainer().run(false, false, operation);
			
			// Select the new file resource in the current view
			IWorkbenchWindow workbenchWindow = workbench.getActiveWorkbenchWindow();
			IWorkbenchPage page = workbenchWindow.getActivePage();
			final IWorkbenchPart activePart = page.getActivePart();
			if (activePart instanceof ISetSelectionTarget) {
				final ISelection targetSelection = new StructuredSelection(sadaFile);
				getShell().getDisplay().asyncExec(new Runnable() {
					public void run() {
						((ISetSelectionTarget)activePart).selectReveal(targetSelection);
					}
				});
			}
			
			// Open an editor on the new file
			try {
				page.openEditor(new FileEditorInput(sadaFile), workbench.getEditorRegistry().getDefaultEditor(sadaFile.getFullPath().toString()).getId());					 	 
			}
			catch (PartInitException exception) {
				MessageDialog.openError(workbenchWindow.getShell(), "Error opening the editor.", exception.getMessage());
				return false;
			}
			
			return true;
		}
		catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}	
	
	protected SadAnalyzerProject createInitialModel() {
		SadAnalyzerProject project = sadAnalyzerModelFactory.createSadAnalyzerProject();
		return project;
	}
}