package edu.isistan.sadeditor.editor;


import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;

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
	
	public SadEditor(){
		super();
	}
	
	
	/**
	 * @see org.eclipse.emf.edit.domain.IEditingDomainProvider#getEditingDomain()
	 */
	@Override
	public EditingDomain getEditingDomain() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see org.eclipse.ui.forms.editor.FormEditor#addPages()
	 */
	@Override
	protected void addPages() {
		int index;
		try {
			//
			FormPage overViewPage = new OverviewPage(this);
			index = addPage(overViewPage);
			setPageText(index, Messages.SadEditor_Overview);
//			//
//			FormPage problemStatementPage = new ProblemStatementPage(this);
//			index = addPage(problemStatementPage);
//			setPageText(index, Messages.UCSEditor_ProblemStatement);
			
		} catch (PartInitException e) {
			e.printStackTrace();
		}
		
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
}
