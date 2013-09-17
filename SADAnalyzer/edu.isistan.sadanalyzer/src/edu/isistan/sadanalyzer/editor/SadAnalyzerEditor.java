package edu.isistan.sadanalyzer.editor;


import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;

import edu.isistan.sadanalyzer.pages.SadAnalyzerSetUpPage;

/**
 * An example showing how to create a multi-page editor.
 * This example has 3 pages:
 * <ul>
 * <li>page 0 contains a nested text editor.
 * <li>page 1 allows you to change the font used in page 2
 * <li>page 2 shows the words in page 0 in sorted order
 * </ul>
 */
public class SadAnalyzerEditor extends FormEditor {
	
	public static final String ID = "edu.isistan.sadanalyzer.editor.SadAnalyzerEditor";
	
	public SadAnalyzerEditor(){
		super();
	}

	/**
	 * @see org.eclipse.ui.forms.editor.FormEditor#addPages()
	 */
	@Override
	protected void addPages() {
		int index;
		try {
			FormPage SadAnalyzerSetUpPage = new SadAnalyzerSetUpPage(this);
			index = addPage(SadAnalyzerSetUpPage);
			setPageText(index, Messages.SadAnalyzerEditor_Configuration);

			
		} catch (PartInitException e) {
			e.printStackTrace();
		}
		
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
