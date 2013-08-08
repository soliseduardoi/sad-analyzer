package edu.isistan.sadeditor.editor;


import java.util.EventObject;
import java.util.HashMap;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.util.EditUIUtil;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;

import SadModel.Sad;
import SadModel.provider.SadModelItemProviderAdapterFactory;
import edu.isistan.sadeditor.pages.OverviewPage;

/**
 * An example showing how to create a multi-page editor.
 * This example has 3 pages:
 * <ul>
 * <li>page 0 contains a nested text editor.
 * <li>page 1 allows you to change the font used in page 2
 * <li>page 2 shows the words in page 0 in sorted order
 * </ul>
 */
public class SadEditor extends FormEditor implements IEditingDomainProvider{
	public static final String ID = "edu.isistan.sadeditor.editor.SadEditor";
	
	
	protected ComposedAdapterFactory adapterFactory;
	protected AdapterFactoryEditingDomain editingDomain;
	protected IContentOutlinePage contentOutlinePage;

	protected DataBindingContext bindingContext;
	
	protected Sad modelRoot;
	
	public SadEditor(){
		super();
		initializeEditingDomain();
		initializeDataBindingContext();
	}
	
	
	/**
	 * @see org.eclipse.emf.edit.domain.IEditingDomainProvider#getEditingDomain()
	 */
	@Override
	public EditingDomain getEditingDomain() {
	
		return editingDomain;
	}

	/**
	 * @see org.eclipse.ui.forms.editor.FormEditor#addPages()
	 */
	@Override
	protected void addPages() {
		int index;
		createModel();
		try {
			//
			FormPage overViewPage = new OverviewPage(this);
			index = addPage(overViewPage);
			setPageText(index, Messages.SadEditor_Overview);

			
		} catch (PartInitException e) {
			e.printStackTrace();
		}
		
	}
	
	public void createModel() {
		URI resourceURI = EditUIUtil.getURI(getEditorInput());
		
		Resource resource = null;
		try {
			// Load the resource through the editing domain.
			resource = editingDomain.getResourceSet().getResource(resourceURI, true);
		}
		catch (Exception e) {
		
			resource = editingDomain.getResourceSet().getResource(resourceURI, false);
		}

		modelRoot = (Sad) resource.getContents().get(resource.getContents().size()-1);
	}
	

	
	/**
	 * @see org.eclipse.ui.forms.editor.FormEditor#init(org.eclipse.ui.IEditorSite, org.eclipse.ui.IEditorInput)
	 */
	@Override
	public void init(IEditorSite site, IEditorInput editorInput) {
		setSite(site);
		setInputWithNotify(editorInput);
		setPartName(editorInput.getName());
	}


	@Override
	public void doSave(IProgressMonitor arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void doSaveAs() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean isSaveAsAllowed() {
		// TODO Auto-generated method stub
		return false;
	}	
	
	protected void initializeEditingDomain() {
		// Create an adapter factory that yields item providers.
		adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

		adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
					
		adapterFactory.addAdapterFactory(new SadModelItemProviderAdapterFactory());

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
	
	protected void initializeDataBindingContext() {
		
		bindingContext = new EMFDataBindingContext();
	}
	
	public Sad getModelRoot() {
		return modelRoot;
	}
	
	
	public DataBindingContext getBindingContext() {
		return bindingContext;
	}
}
