package edu.isistan.sadeditor.pages;

import java.util.Iterator;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.ui.util.EditUIUtil;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.List;
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
import org.eclipse.wb.swt.ResourceManager;

import SadModel.Sad;
import SadModel.SadSection;
import edu.isistan.sadeditor.editor.Messages;
import edu.isistan.sadeditor.editor.SadEditor;
import edu.isistan.uima.unified.SadUIMAProcessor;


public class OverviewPage extends FormPage {
	
	public static final String ID = "edu.isistan.sadeditor.pages.OverviewPage";
	public static final String TITLE = "Overview";
	private static final String UIMA_EXTENSION = "uimasad";
	
	private EditingDomain editingDomain;
	private Sad modelRoot;
	private DataBindingContext bindingContext;	
	private ListViewer listViewerSections;
	private StyledText styledText;

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
		
		Action execution = new Action("run", Action.AS_CHECK_BOX){
			public void run() {
				executeUimaSadProcesor();
			}
		};
		execution.setToolTipText("Run"); //$NON-NLS-1$
		execution.setEnabled(Boolean.TRUE);		
		execution.setImageDescriptor(ResourceManager.getPluginImageDescriptor("edu.isistan.sadeditor", "icons/run.gif"));
		
		form.getToolBarManager().add(execution);
		form.getToolBarManager().update(true);
		
		toolkit.decorateFormHeading(form.getForm());
		toolkit.paintBordersFor(body);
		
		ColumnLayout layout = new ColumnLayout();		
		layout.topMargin = 10;
		layout.bottomMargin = 5;
		layout.leftMargin = 10;
		layout.rightMargin = 10;
		layout.horizontalSpacing = 20;
		layout.verticalSpacing = 20;
		layout.maxNumColumns = 2;
		layout.minNumColumns = 2;
		
	
		toolkit.paintBordersFor(body);
		managedForm.getForm().getBody().setLayout(layout);
		
		createDetailSection(managedForm, Messages.Sad_OverviewDetail, Messages.Sad_OverviewDescription1);
		createExecutionSection(managedForm, Messages.Sad_OverviewRunSection, Messages.Sad_OverviewDescription3);	
		createTreeModel(managedForm, Messages.Sad_OverviewModelTree,Messages.Sad_OverviewDescription2); 			
		createViewSection(managedForm, Messages.Sad_OverviewViewSection, Messages.Sad_OverviewDescription4);
	}
	
	private void createViewSection(IManagedForm managedForm, String title, String desc) {
				
		Composite client = createSection(managedForm, title, desc, 2);
				
		FormToolkit toolkit = managedForm.getToolkit();
		
		
	
		GridData gd = new GridData(GridData.FILL_BOTH);	
		
		toolkit.paintBordersFor(client);
		
		gd = new GridData(GridData.VERTICAL_ALIGN_BEGINNING);		
		toolkit.createLabel(client,"");
		
		gd = new GridData();
		gd.widthHint = 450;
		gd.heightHint= 450;	
		styledText = new StyledText(client, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP | SWT.V_SCROLL | SWT.H_SCROLL | SWT.MULTI);
		styledText.setBlockSelection(true);
		styledText.setLayoutData(gd);
		managedForm.getToolkit().adapt(styledText);
		managedForm.getToolkit().paintBordersFor(styledText);
							
		listViewerSections.addSelectionChangedListener(new ISelectionChangedListener(){
			public void selectionChanged(SelectionChangedEvent event) {
				IStructuredSelection selection = (IStructuredSelection)event.getSelection();			
				for(Iterator<SadSection> it = modelRoot.getSections().iterator();it.hasNext();){
					SadSection section = it.next();
					if(null != section.getText() && section.getName().equals(selection.getFirstElement())){
						styledText.setText(section.getText());
						styledText.update();
					}
				}			
			}
		});
		
	}
	
	private void createExecutionSection(IManagedForm mform, String title, String desc) {
		Composite client = createSection(mform, title, desc, 2);
		FormToolkit toolkit = mform.getToolkit();
		
		// Run
		Button btnAdd=  toolkit.createButton(client, Messages.Sad_OverviewRun,SWT.BUTTON1);
		btnAdd.setImage(ResourceManager.getPluginImage("edu.isistan.sadeditor", "icons/run.gif"));
		btnAdd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				executeUimaSadProcesor();			
			}
		});
	}

	private void executeUimaSadProcesor() {
		URI resourceURI = EditUIUtil.getURI(getEditorInput());
			
		String inputFile =resourceURI.toString();
		 		
		IFile file =(IFile)getEditorInput().getAdapter(IFile.class);
		String outputFile = file.getLocationURI().toString();
		outputFile= (String) outputFile.subSequence(0, outputFile.length()-3);
		
		outputFile+=UIMA_EXTENSION;
		SadUIMAProcessor processor = SadUIMAProcessor.getInstance();
		processor.execute(inputFile, outputFile);
		try {
			file.getParent().refreshLocal(IResource.DEPTH_ONE, null);
		} catch (CoreException e) {
			
			e.printStackTrace();
		}
		pruebaLevantarModelo(file);
		
		
	}

		
	private void pruebaLevantarModelo(IFile file) {

		String reaURI = file.getFullPath().toString();
		ResourceSet resourceSet = new ResourceSetImpl();
		URI fileURI = URI.createPlatformResourceURI(reaURI, true);
		Resource resource = resourceSet.createResource(fileURI);
		resource.getContents();
//		REAssistantProject rootModel = createInitialModel();
		
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
		gd.widthHint = 350;
		overviewSourceText.setLayoutData(gd);
		
		
		// Text Template Sad
		toolkit.createLabel(client, Messages.SadEditor_OverviewTemplate+":");
		String overviewTemplate = modelRoot.getTemplatePath();
		Text overviewTemplateText = toolkit.createText(client, overviewTemplate, SWT.SINGLE);
		overviewTemplateText.setEditable(false);
		gd = new GridData();
		gd.widthHint = 350;
		overviewTemplateText.setLayoutData(gd);		
		
	}
	
	
		
	private void createTreeModel(IManagedForm managedForm, String title, String desc) {
		Composite client = createSection(managedForm, title, desc, 2);
				
		listViewerSections = new ListViewer(client, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		
				
		for(Iterator<SadSection> it = modelRoot.getSections().iterator();it.hasNext();){
			SadSection section = it.next();
			if(null != section.getName()){
				listViewerSections.add(section.getName());
			}
		}
		
		GridData gd = new GridData();
		gd.widthHint = 350;
		gd.heightHint = 250;		
		List listSections = listViewerSections.getList();
		listSections.setLayoutData(gd);		
		
	}	
			
	private Composite createSection(IManagedForm mform, String title,
			String desc, int numColumns) {
		final ScrolledForm form = mform.getForm();
		FormToolkit toolkit = mform.getToolkit();
		
		Composite compositeDetails = new Composite(mform.getForm().getBody(), SWT.NONE);
		compositeDetails.setLayout(new FillLayout(SWT.HORIZONTAL));
		toolkit.adapt(compositeDetails);
		toolkit.paintBordersFor(compositeDetails);		
		
		Section section = toolkit.createSection(compositeDetails, Section.TITLE_BAR | 
				Section.DESCRIPTION | Section.EXPANDED | Section.CLIENT_INDENT);
		section.setSize(5, 100);
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
				form.reflow(true);
			}
		});
		return client;
	}		

	
	@Override
	public void setActive(boolean active) {
		super.setActive(active);
	}
	
	
}