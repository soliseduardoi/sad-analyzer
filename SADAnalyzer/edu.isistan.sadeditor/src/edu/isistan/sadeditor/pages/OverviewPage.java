package edu.isistan.sadeditor.pages;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.ui.util.EditUIUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.events.ExpansionAdapter;
import org.eclipse.ui.forms.events.ExpansionEvent;
import org.eclipse.ui.forms.widgets.ColumnLayout;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

import SadModel.Sad;
import edu.isistan.sadeditor.editor.Messages;
import edu.isistan.sadeditor.editor.SadEditor;
import edu.isistan.uima.unified.UIMAProcessor;


public class OverviewPage extends FormPage {
	
	public static final String ID = "edu.isistan.sadeditor.pages.OverviewPage";
	public static final String TITLE = "Overview";
	private EditingDomain editingDomain;
	private Sad modelRoot;
	private DataBindingContext bindingContext;
	
	
	

	/**
	 * Create the form page.
	 * @param id
	 * @param title
	 */
	public OverviewPage() {
		super(ID, TITLE);
	}

	/**
	 * @param editor
	 */
	public OverviewPage(FormEditor editor) {
		super(editor, ID, TITLE);
		editingDomain = ((IEditingDomainProvider)getEditor()).getEditingDomain();
		modelRoot = ((SadEditor)getEditor()).getModelRoot();
		bindingContext = ((SadEditor)getEditor()).getBindingContext();
	}
	
	/**
	 * @see org.eclipse.ui.forms.editor.FormPage#init(org.eclipse.ui.IEditorSite, org.eclipse.ui.IEditorInput)
	 */
	@Override
	public void init(IEditorSite site, IEditorInput input) {
		super.init(site, input);
		
	}
			

	/**
	 * Create contents of the form.
	 * @param managedForm
	 */
	@Override
	protected void createFormContent(IManagedForm managedForm) {
			
		ScrolledForm form = managedForm.getForm();
		Composite body = form.getBody();
		FormToolkit toolkit = managedForm.getToolkit();
		form.setText(Messages.SadEditor_OverviewTitle);	
		toolkit.decorateFormHeading(form.getForm());
		toolkit.paintBordersFor(body);
		ColumnLayout layout = new ColumnLayout();
		layout.topMargin = 10;
		layout.bottomMargin = 5;
		layout.leftMargin = 10;
		layout.rightMargin = 10;
		layout.horizontalSpacing = 10;
		layout.verticalSpacing = 10;
		layout.maxNumColumns = 2;
		layout.minNumColumns = 1;
		toolkit.paintBordersFor(body);
		managedForm.getForm().getBody().setLayout(layout);
		
		createDetailSection(managedForm, Messages.Sad_OverviewDetail, Messages.Sad_OverviewDescription1);
		
//		createDetailSection(managedForm, Messages.Sad_OverviewDetail, Messages.Sad_OverviewDescription1);
		
//		createTreeModel(managedForm, "Seccion2","Descripcion2"); 
	}

		
	private void createDetailSection(IManagedForm mform, String title, String desc) {
		Composite client = createSection(mform, title, desc, 2);
		FormToolkit toolkit = mform.getToolkit();
		
		GridData gd = new GridData();		
		// Text source
		toolkit.createLabel(client, Messages.SadEditor_OverviewSource+":");
		String overviewSource = modelRoot.getTitle();
		Text overviewSourceText = toolkit.createText(client, overviewSource, SWT.SINGLE);
		overviewSourceText.setEditable(false);
		gd = new GridData();
		gd.widthHint = 500;
		overviewSourceText.setLayoutData(gd);
		
		
		// Text Template Sad
		toolkit.createLabel(client, Messages.SadEditor_OverviewTemplate+":");
		String overviewTemplate = modelRoot.getTemplatePath();
		Text overviewTemplateText = toolkit.createText(client, overviewTemplate, SWT.SINGLE);
		overviewTemplateText.setEditable(false);
		gd = new GridData();
		gd.widthHint = 500;
		overviewTemplateText.setLayoutData(gd);
		
		// Run
		Button btnAdd= toolkit.createButton(client, Messages.Sad_OverviewRun,SWT.BUTTON1);
		gd = new GridData();
		gd.widthHint = 500;
		//toolkit.paintBordersFor(client);
		btnAdd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				
				URI resourceURI = EditUIUtil.getURI(getEditorInput());
				//ver como obtener el imput full path
				
				String inputFile =resourceURI.toString();
				String outputFile = "file:///G:/out.xml";
				
				UIMAProcessor processor = UIMAProcessor.getInstance();
				processor.execute(inputFile, outputFile);				
				
			}
		});
	}
	
	
	private void createTreeModel(IManagedForm managedForm, String title, String desc) {
		
	}
	
	
	private Composite createSection(IManagedForm mform, String title,
			String desc, int numColumns) {
		final ScrolledForm form = mform.getForm();
		FormToolkit toolkit = mform.getToolkit();
		Section section = toolkit.createSection(form.getBody(), Section.TWISTIE
				| Section.TITLE_BAR | Section.DESCRIPTION | Section.EXPANDED);
		section.setText(title);
		section.setDescription(desc);
		//toolkit.createCompositeSeparator(section);
		Composite client = toolkit.createComposite(section);
		GridLayout layout = new GridLayout();
		layout.marginWidth = layout.marginHeight = 0;
		layout.numColumns = numColumns;
		client.setLayout(layout);
		section.setClient(client);
		section.addExpansionListener(new ExpansionAdapter() {
			public void expansionStateChanged(ExpansionEvent e) {
				form.reflow(false);
			}
		});
		return client;
	}		

	
	@Override
	public void setActive(boolean active) {
		super.setActive(active);
	}
	
	
}