package edu.isistan.sadanalyzer.pages;

import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.SWT;
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

import edu.isistan.reassistant.ccdetector.model.CrosscuttingConcernRule;
import edu.isistan.reassistant.ccdetector.model.CrosscuttingConcernRuleSet;
import edu.isistan.sadanalyzer.editor.Messages;
import edu.isistan.sadanalyzer.editor.SadAnalyzerEditor;
import edu.isistan.sadanalyzer.query.UIMASADQueryAdapter;
import edu.isistan.uima.unified.typesystems.sad.SadSection;


public class SadAnalyzerSetUpPage extends FormPage {

	public static final String ID = "edu.isistan.sadanalyzer.pages.SadAnalyzerSetUpPage";
	public static final String TITLE = Messages.SadAnalyzerEditor_Configuration;
	public static final String IMAGE_PATH ="../../../../icons";
	
	private ListViewer listViewerSections;
	private ListViewer listQualityAttributesSource;
	private ListViewer listQualityAttributesSelected;
	private List listQualityAtributes1;
	private List listQualityAtributes2;
	private String quality = "";
	private String qualityRemove = "";
	
	private String modelURI;
	
	protected CrosscuttingConcernRuleSet rulesModelRoot;
	
	private EditingDomain editingDomain;
	
	private UIMASADQueryAdapter uimaRoot;
	
	public SadAnalyzerSetUpPage(){
		super(ID, TITLE);
	}
	
	public SadAnalyzerSetUpPage(FormEditor editor) {
		super(editor, ID, TITLE);
		editingDomain = ((IEditingDomainProvider)getEditor()).getEditingDomain();
		rulesModelRoot =((SadAnalyzerEditor)getEditor()).getRulesModelRoot();
		uimaRoot = ((SadAnalyzerEditor)getEditor()).getUimaRoot();
		
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
		form.setText(Messages.SadAnalyzerEditor_ConfigurationTitle);
		
		Action executionAnalyzer = new Action("run", Action.AS_CHECK_BOX){
			public void run() {
//				executeUimaSadProcesor();
			}
		};
		executionAnalyzer.setToolTipText("Run"); //$NON-NLS-1$
		executionAnalyzer.setEnabled(Boolean.TRUE);
		executionAnalyzer.setImageDescriptor(ImageDescriptor.createFromFile(this.getClass(),IMAGE_PATH + "/run.gif"));
		
		form.getToolBarManager().add(executionAnalyzer);
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
		
		createDetailAnalyzer(managedForm, Messages.SadAnalyzerEditor_ConfigurationDetail, Messages.SadAnalyzerEditor_ConfigurationDetailDescription);
		createQualityAttributes(managedForm, Messages.SadAnalyzerEditor_ConfigurationModelTree, Messages.SadAnalyzerEditor_ConfigurationModelTreeDescription);
		createTreeModel(managedForm, Messages.SadAnalyzerEditor_ConfigurationModelTree, Messages.SadAnalyzerEditor_ConfigurationModelTreeDescription);
		createRunUimasad(managedForm, Messages.SadAnalyzerEditor_ConfigurationRun, Messages.SadAnalyzerEditor_ConfigurationRunDescription);
	}
	
	private void createRunUimasad(IManagedForm mform, String title, String desc) {
		Composite client = createSection(mform, title, desc, 2);
		FormToolkit toolkit = mform.getToolkit();
			
		ImageDescriptor image = ImageDescriptor.createFromFile(this.getClass(),IMAGE_PATH + "/run.gif");
		
		// Run
		Button btnAdd=  toolkit.createButton(client, Messages.SadAnalyzerEditor_ConfigurationRunButton,SWT.BUTTON1);
		btnAdd.setImage(image.createImage());
		btnAdd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
//				executeUimaSadProcesor();			
			}
		});
	}
	
	private void createQualityAttributes(IManagedForm managedForm, String title, String desc) {
		Composite client = createSection(managedForm, title, desc, 3);
		FormToolkit toolkit = managedForm.getToolkit();
		
		listQualityAttributesSource = new ListViewer(client, SWT.BORDER | SWT.V_SCROLL);
		
//		listQualityAttributesSource.add("AtributoCalidad1");
//		listQualityAttributesSource.add("AtributoCalidad2");
//		listQualityAttributesSource.add("AtributoCalidad3");
//		listQualityAttributesSource.add("AtributoCalidad4");
//		listQualityAttributesSource.add("AtributoCalidad5");
			
		
		Iterator<CrosscuttingConcernRule> rules = rulesModelRoot.getRules().iterator();
		
		for ( ;rules.hasNext();) {
			CrosscuttingConcernRule rule = rules.next();
			
			listQualityAttributesSource.add(rule.getName());
		}
		
	
		
				
		GridData gd = new GridData();
		gd.widthHint = 250;
		gd.heightHint = 100;
		listQualityAtributes1 = listQualityAttributesSource.getList();
		listQualityAtributes1.setLayoutData(gd);
		
		
		Composite compositeBtn = toolkit.createComposite(client, SWT.NONE);
		compositeBtn.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		toolkit.paintBordersFor(compositeBtn);
		FillLayout fl_compositeBtn = new FillLayout(SWT.VERTICAL);
		fl_compositeBtn.marginWidth = 5;
		fl_compositeBtn.marginHeight = 5;
		fl_compositeBtn.spacing = 5;
		compositeBtn.setLayout(fl_compositeBtn);
		
		ImageDescriptor imageAdd = ImageDescriptor.createFromFile(this.getClass(),IMAGE_PATH + "/add.gif");
		Button btnAdd = toolkit.createButton(compositeBtn, "Add", SWT.NONE);
		btnAdd.setImage(imageAdd.createImage());
		btnAdd.setToolTipText("Add Quality attribute");
			
		
		ImageDescriptor imageRemove = ImageDescriptor.createFromFile(this.getClass(),IMAGE_PATH + "/delete.gif");
		Button btnRemove = toolkit.createButton(compositeBtn, "Remove", SWT.NONE);
		btnRemove.setImage(imageRemove.createImage());
		btnRemove.setToolTipText("Remove Quality attribute");
		
		
		listQualityAttributesSelected = new ListViewer(client, SWT.BORDER | SWT.V_SCROLL);
		
		listQualityAtributes2 = listQualityAttributesSelected.getList();
		listQualityAtributes2.setLayoutData(gd);
		
		
		listQualityAttributesSource.addSelectionChangedListener(new ISelectionChangedListener(){
			public void selectionChanged(SelectionChangedEvent event) {
				IStructuredSelection selection = (IStructuredSelection)event.getSelection();			
				quality = selection.getFirstElement().toString();
			}
		});
		
		listQualityAttributesSelected.addSelectionChangedListener(new ISelectionChangedListener(){
			public void selectionChanged(SelectionChangedEvent event) {
				IStructuredSelection selection = (IStructuredSelection)event.getSelection();			
				qualityRemove = selection.getFirstElement().toString();
			}
		});
		
		btnAdd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				listQualityAtributes1.remove(quality);
				listQualityAtributes2.add(quality);
				listQualityAtributes1.update();
				listQualityAtributes2.update();
			}
		});	
		
		btnRemove.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				listQualityAtributes2.remove(qualityRemove);
				listQualityAtributes1.add(qualityRemove);
				listQualityAtributes1.update();
				listQualityAtributes2.update();
			}
		});	
		
	}	
	
	private void createDetailAnalyzer(IManagedForm mform, String title, String desc) {
		Composite client = createSection(mform, title, desc, 2);
		FormToolkit toolkit = mform.getToolkit();
		
		GridData gd = new GridData();		
		// Text source
		toolkit.createLabel(client, Messages.SadAnalyzerEditor_SadSource+":");
		String overviewSource = "";/* = modelRoot.getTitle();*/
		Text overviewSourceText = toolkit.createText(client, overviewSource, SWT.SINGLE);
		overviewSourceText.setEditable(false);
		gd = new GridData();
		gd.widthHint = 500;
		overviewSourceText.setLayoutData(gd);
				
		toolkit.createLabel(client, Messages.SadAnalyzerEditor_UIMASadFile+":");
		String overviewTemplate = ""; /*= modelRoot.getTemplatePath();*/
		Text overviewTemplateText = toolkit.createText(client, overviewTemplate, SWT.SINGLE);
		overviewTemplateText.setEditable(false);
		gd = new GridData();
		gd.widthHint = 500;
		overviewTemplateText.setLayoutData(gd);		
	}
	
	private void createTreeModel(IManagedForm managedForm, String title, String desc) {
		Composite client = createSection(managedForm, title, desc, 2);
		
		listViewerSections = new ListViewer(client, SWT.BORDER | SWT.V_SCROLL);
		listViewerSections.add(Messages.SadAnalyzerEditor_ConfigurationModelTreeAllSection);
		EList<SadSection> sections = uimaRoot.getSadSection();
		
		for(Iterator<SadSection> it = sections.iterator();it.hasNext();){
			SadSection section = it.next();
			if(null != section.getName()){
				listViewerSections.add(section.getName());
			}
		}
		
		
//		listViewerSections.add("Seccion1");
//		listViewerSections.add("Seccion2");
//		listViewerSections.add("Seccion3");
//		listViewerSections.add("Seccion4");
//		listViewerSections.add("Seccion5");
		
		GridData gd = new GridData();
		gd.widthHint = 500;
		gd.heightHint = 100;
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
		
		Section section = toolkit.createSection(compositeDetails, Section.TWISTIE
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
