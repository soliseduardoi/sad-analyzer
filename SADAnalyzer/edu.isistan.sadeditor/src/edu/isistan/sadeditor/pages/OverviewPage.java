package edu.isistan.sadeditor.pages;

import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;

public class OverviewPage extends FormPage {
	
	public static final String ID = "edu.isistan.sadeditor.pages.OverviewPage";
	public static final String TITLE = "Overview";
	
//	private EditingDomain editingDomain;
//	private Project modelRoot;
	

	public OverviewPage(FormEditor editor) {
		super(editor, ID, TITLE);
		// TODO Auto-generated constructor stub
	}
	
	public void init(IEditorSite site, IEditorInput input) {
		super.init(site, input);
//		editingDomain = ((IEditingDomainProvider)getEditor()).getEditingDomain();
//		modelRoot = ((SadEditor)getEditor()).getModelRoot();
//		bindingContext = ((SadEditor)getEditor()).getBindingContext();
	}

}