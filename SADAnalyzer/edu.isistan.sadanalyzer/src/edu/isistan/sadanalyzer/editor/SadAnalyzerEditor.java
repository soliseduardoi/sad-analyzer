package edu.isistan.sadanalyzer.editor;


import java.util.EventObject;
import java.util.HashMap;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.util.EditUIUtil;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;

import SadModel.Sad;
import edu.isistan.reassistant.ccdetector.model.CrosscuttingConcernRuleSet;
import edu.isistan.sadanalyzer.model.SadAnalyzerProject;
import edu.isistan.sadanalyzer.pages.SadAnalyzerSetUpPage;
import edu.isistan.sadanalyzer.query.UIMASADQueryAdapter;

/**
 * An example showing how to create a multi-page editor.
 * This example has 3 pages:
 * <ul>
 * <li>page 0 contains a nested text editor.
 * <li>page 1 allows you to change the font used in page 2
 * <li>page 2 shows the words in page 0 in sorted order
 * </ul>
 */
public class SadAnalyzerEditor extends FormEditor implements IEditingDomainProvider{
	
	public static final String ID = "edu.isistan.sadanalyzer.editor.SadAnalyzerEditor";
	protected ComposedAdapterFactory adapterFactory;
	protected AdapterFactoryEditingDomain editingDomain;
	
	private CrosscuttingConcernRuleSet rulesModelRoot;	
	private UIMASADQueryAdapter uimaRoot;
	private SadAnalyzerProject modelRoot;
	private Sad sadModelRoot;
	
	
	
	public SadAnalyzerEditor(){
		super();
		initializeEditingDomain();
	}

	/**
	 * @see org.eclipse.ui.forms.editor.FormEditor#addPages()
	 */
	@Override
	protected void addPages() {
		createModel();
		
		int index;
		try {
			FormPage sadAnalyzerSetUpPage = new SadAnalyzerSetUpPage(this);
			index = addPage(sadAnalyzerSetUpPage);
			setPageText(index, Messages.SadAnalyzerEditor_Configuration);
			
		} catch (PartInitException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void doSave(IProgressMonitor arg0) {
		
		
	}

	@Override
	public void doSaveAs() {
		
		
	}

	@Override
	public boolean isSaveAsAllowed() {
		
		return false;
	}
	
	protected void initializeEditingDomain() {
		// Create an adapter factory that yields item providers.
		adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

		adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());	
		adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
	

		// Create the command stack that will notify this editor as commands are executed.
		BasicCommandStack commandStack = new BasicCommandStack();

		// Add a listener to set the most recent command's affected objects to be the selection of the viewer with focus.
		commandStack.addCommandStackListener(new CommandStackListener() {
			public void commandStackChanged(final EventObject event) {
				getContainer().getDisplay().asyncExec(new Runnable() {
					public void run() {
						firePropertyChange(IEditorPart.PROP_DIRTY);
					}
				});
			}
		});

		// Create the editing domain with a special command stack.
		editingDomain = new AdapterFactoryEditingDomain(adapterFactory, commandStack, new HashMap<Resource, Boolean>());
	}
	
	public EditingDomain getEditingDomain() {
		
		return editingDomain;
	}
	
	private void createModel() {
		ResourceSet resourceSet = new ResourceSetImpl();
		URI resourceURI = EditUIUtil.getURI(getEditorInput());
		Resource resource = null;
		try {
			resource = resourceSet.getResource(resourceURI, true);
		}
		catch (Exception e) {
			resource = resourceSet.getResource(resourceURI, true);
		}
		
		modelRoot = (SadAnalyzerProject) resource.getContents().get(0);

		createUIMAModel();

		createSadModel();
		
			 
	}
	


	
	private void createUIMAModel() {
		ResourceSet resourceSet = new ResourceSetImpl();
		URI fileURI = URI.createFileURI(modelRoot.getUimaURI());
		Resource resource = null;
		try {
			resource = resourceSet.getResource(fileURI, true);
		}
		catch (Exception e) {
			resource = resourceSet.getResource(fileURI, true);
		}
		uimaRoot = new UIMASADQueryAdapter(resource.getContents());
	}
	
	private void createSadModel() {
		ResourceSet resourceSet = new ResourceSetImpl();
		URI fileURI = URI.createFileURI(modelRoot.getSadURI());
		Resource resource = null;
		try {
			resource = resourceSet.getResource(fileURI, true);
		}
		catch (Exception e) {
			resource = resourceSet.getResource(fileURI, true);
		}
		sadModelRoot = (Sad) resource.getContents().get(resource.getContents().size()-1);
	}
	
	
	public CrosscuttingConcernRuleSet getRulesModelRoot() {
			
			return rulesModelRoot;
		}
	
	public UIMASADQueryAdapter getUimaRoot() {
		
		return uimaRoot;
	}

	public Sad getSadModel(){
		return sadModelRoot;
	}
	
	public SadAnalyzerProject getSadProjectModel(){
		return modelRoot;
	}


		
}
