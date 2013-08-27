package edu.isistan.sadeditor.wizards;

import input.model.Section;
import input.parser.SadParser;
import input.parser.SadParserFactory;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
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
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.ISetSelectionTarget;

import SadModel.Sad;
import SadModel.SadModelFactory;
import SadModel.SadModelPackage;
import SadModel.SadSection;
import edu.isistan.sadeditor.editor.Messages;

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

public class SadWizard extends Wizard implements INewWizard{
	
	
	private SadWizardNewFilePage sadWizardNewFilePage;
	private SadWizardSettingsPage sadWizardSettingsPage;
	private IStructuredSelection selection;
	private IWorkbench workbench;
	private Boolean validModel;
	
	protected SadModelPackage sadModelPackage = SadModelPackage.eINSTANCE;
	protected SadModelFactory sadModelFactory = sadModelPackage.getSadModelFactory();
	/**
	 * Constructor for SadWizard.
	 */
	public SadWizard() {
		super();
		validModel = new Boolean(Boolean.TRUE);
		setNeedsProgressMonitor(true);
	}
	
	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		this.selection = selection;
		setWindowTitle(Messages.SadWizard_Windows_Title);
	}
	
	/**
	 * Adding the page to the wizard.
	 */

	public void addPages() {
		super.addPages();
		sadWizardNewFilePage = new SadWizardNewFilePage(SadWizardNewFilePage.ID,selection);
		sadWizardNewFilePage.setTitle(Messages.SadWizard_Title);
		sadWizardNewFilePage.setDescription(Messages.SadWizard_Description);
		sadWizardNewFilePage.setFileName(Messages.Sad_FilenameDefault +"."+ Messages.Sad_Extension);
		addPage(sadWizardNewFilePage);
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
					sadWizardNewFilePage.setContainerFullPath(selectedResource.getFullPath());
//					 Make up a unique new name here
					String defaultModelBaseFilename = Messages.Sad_FilenameDefault;
					String defaultModelFilenameExtension = Messages.Sad_Extension;
					String modelFilename = defaultModelBaseFilename + "." + defaultModelFilenameExtension;
					for (int i = 1; ((IContainer)selectedResource).findMember(modelFilename) != null; ++i) {
						modelFilename = defaultModelBaseFilename + i + "." + defaultModelFilenameExtension;
					}
					sadWizardNewFilePage.setFileName(modelFilename);
				}
			}
		}
		 
		sadWizardSettingsPage = new SadWizardSettingsPage(SadWizardSettingsPage.ID);
		sadWizardSettingsPage.setTitle(Messages.SadWizard_Title);
		sadWizardSettingsPage.setDescription(Messages.SadWizard_Settings_Description);
		addPage(sadWizardSettingsPage);		
	}


	/**
	 * This method is called when 'Finish' button is pressed in
	 * the wizard. We will create an operation and run it
	 * using wizard as execution context.
	 */
	public boolean performFinish() {
		try {
			// Remember the file
			final IFile modelFile = getModelFile();
			// Do the work within an operation
			WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {
				@Override
				protected void execute(IProgressMonitor progressMonitor) {
					try {
						// Create a resource set
						ResourceSet resourceSet = new ResourceSetImpl();					
						
						// Get the URI of the model file
						URI fileURI = URI.createPlatformResourceURI(modelFile.getFullPath().toString(), true);
						// Create a resource for this file
						Resource resource = resourceSet.createResource(fileURI);
						// Add the initial model object to the contents
						
						Sad sadModel = createSadModel(resource);
						if (sadModel != null) {
							sadModel.setID(sadWizardNewFilePage.getFileName());
//							sadModel.setTitle(initialObjectCreationPage.getName());
//							sadModel.setContent(sadWizardSettingsPage.getContent());
							resource.getContents().add(sadModel);
							
						}else{
							throw new Exception();
						}
						
						// Save the contents of the resource to the file system
						Map<Object, Object> options = new HashMap<Object, Object>();
						//Agregar el encoding para seleccionar en la vista
						options.put(XMLResource.OPTION_ENCODING,sadWizardSettingsPage.getComboEncoding().getText());
						resource.save(options);
					}
					catch (Exception exception) {
						MessageDialog.openError(null, "Error Model", Messages.Sad_ErrorModel);
						validModel=false;
					}
					finally {
						progressMonitor.done();
					}
				}

				private Sad createSadModel(Resource resource) {
					Sad sad = null;
					//Construyo la estructura del Sad a partir de la wiki o del pdf
					String selection=SadParserFactory.PDF;
					if(sadWizardSettingsPage.isWikiSelection()){
						selection=SadParserFactory.WIKI;
					}
						
					SadParser parser = SadParserFactory.getParser(selection);
//					String urlTraget= "https://wiki.sei.cmu.edu/sad/index.php/The_Java_Pet_Store_SAD";
					Section project=  parser.getSad(sadWizardSettingsPage.getDirectoryTemplateField().getText(),sadWizardSettingsPage.getUrl());	
					
					if((project != null)){
						sad = sadModelFactory.createSad();	
						sad.setTitle(sadWizardSettingsPage.getUrl());
						sad.setTemplatePath(sadWizardSettingsPage.getDirectoryTemplateField().getText());
						
						for(Section section : project.getSections()){
							SadSection sadSection = sadModelFactory.createSadSection();
							sadSection.setName(section.getName());
							sadSection.setText(section.getText());
							sad.getSections().add(sadSection);
							resource.getContents().add(sadSection);						
							
						}
					}
					return sad;
				}
			};
			getContainer().run(false, false, operation);
			// Select the new file resource in the current view
			IWorkbenchWindow workbenchWindow = workbench.getActiveWorkbenchWindow();
			IWorkbenchPage page = workbenchWindow.getActivePage();
			final IWorkbenchPart activePart = page.getActivePart();
			if (activePart instanceof ISetSelectionTarget) {
				final ISelection targetSelection = new StructuredSelection(modelFile);
				getShell().getDisplay().asyncExec(new Runnable() {
					public void run() {
						((ISetSelectionTarget)activePart).selectReveal(targetSelection);
					}
				});
			}
			// Open an editor on the new file
			try {
				if(validModel){
					page.openEditor(new FileEditorInput(modelFile), workbench.getEditorRegistry().getDefaultEditor(modelFile.getFullPath().toString()).getId());					
				}
								 	 
			}
			catch (PartInitException exception) {
				MessageDialog.openError(workbenchWindow.getShell(), "" /*Messages.UCSEditor_OpenEditorErrorLabel*/, exception.getMessage());
				return false;
			}
			return true;
		}
		catch (Exception exception) {
			//UCSEditorActivator.INSTANCE.log(exception);
			return false;
		}
	}	
	public IFile getModelFile() {
		return sadWizardNewFilePage.getModelFile();
	}
	

}