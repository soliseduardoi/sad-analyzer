package edu.isistan.sadanalyzer.pages;

import java.util.Iterator;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.StructuredSelection;
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
	private ListViewer listViewerSectionsSelected;
	private ListViewer listQualityAttributesSource;
	private ListViewer listQualityAttributesSelected;
	private List listQualityAtributes1;
	private List listQualityAtributes2;
	private List listSections;
	private List listSectionsSelected;
	
	
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
				executeUimaSadProcesor();
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
		createTreeModel(managedForm, Messages.SadAnalyzerEditor_ConfigurationModelTree, Messages.SadAnalyzerEditor_ConfigurationModelTreeDescription);
		createRunUimasad(managedForm, Messages.SadAnalyzerEditor_ConfigurationRun, Messages.SadAnalyzerEditor_ConfigurationRunDescription);
		createQualityAttributes(managedForm, Messages.SadAnalyzerEditor_ConfigurationModelTree, Messages.SadAnalyzerEditor_ConfigurationModelTreeDescription);
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
				executeUimaSadProcesor();			
			}
		});
	}
	
	private void executeUimaSadProcesor(){
		//TODO la manganeta para visualizar las porquerias
		
	}
	
	private void createQualityAttributes(IManagedForm managedForm, String title, String desc) {
		Composite client = createSection(managedForm, title, desc, 3);
		FormToolkit toolkit = managedForm.getToolkit();
		
		listQualityAttributesSource = new ListViewer(client, SWT.BORDER | SWT.V_SCROLL);
		
		Iterator<CrosscuttingConcernRule> rules = rulesModelRoot.getRules().iterator();
		
		for ( ;rules.hasNext();) {
			CrosscuttingConcernRule rule = rules.next();
			
			listQualityAttributesSource.add(rule);
		}	
				
		GridData gd = new GridData();
		gd.widthHint = 250;
		gd.heightHint = 200;
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
		
		Button btnAddAll = toolkit.createButton(compositeBtn, ">> Add All", SWT.NONE);
		
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
		
		Button btnRemoveAll = toolkit.createButton(compositeBtn, "<< Remove All", SWT.NONE);
		
		btnAddAll.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {				
				for(int i = 0; listQualityAttributesSource.getList().getItems().length > 0; ){
					CrosscuttingConcernRule crossC = (CrosscuttingConcernRule)listQualityAttributesSource.getElementAt(i);
					listQualityAttributesSelected.add(crossC);
					listQualityAttributesSource.remove(crossC);
				}				
				refreshList();
				
			}
		});
		
		btnRemoveAll.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				for(int i = 0; listQualityAttributesSelected.getList().getItems().length > 0; ){
					CrosscuttingConcernRule crossC = (CrosscuttingConcernRule)listQualityAttributesSelected.getElementAt(i);
					listQualityAttributesSource.add(crossC);
					listQualityAttributesSelected.remove(crossC);
				}				
				refreshList();
			}
		});
		
		btnAdd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				StructuredSelection selection = (StructuredSelection)listQualityAttributesSource.getSelection();
				if(!selection.isEmpty()) {
					CrosscuttingConcernRule crossCutting = (CrosscuttingConcernRule)selection.getFirstElement();
					listQualityAttributesSource.remove(crossCutting);
					listQualityAttributesSelected.add(crossCutting);
					refreshList();
				}
			}
		});	
		
		btnRemove.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				StructuredSelection selection = (StructuredSelection)listQualityAttributesSelected.getSelection();
				if(!selection.isEmpty()) {
					CrosscuttingConcernRule crossCutting = (CrosscuttingConcernRule)selection.getFirstElement();
					listQualityAttributesSelected.remove(crossCutting);
					listQualityAttributesSource.add(crossCutting);
					refreshList();
				}
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
		Composite client = createSection(managedForm, title, desc, 3);
		FormToolkit toolkit = managedForm.getToolkit();
		
		listViewerSections = new ListViewer(client, SWT.BORDER | SWT.V_SCROLL);		
		EList<SadSection> sections = uimaRoot.getSadSection();
		
		for(Iterator<SadSection> it = sections.iterator();it.hasNext();){
			SadSection section = it.next();
			if(null != section.getName()){
				listViewerSections.add(section);
			}
		}
				
		GridData gd = new GridData();
		gd.widthHint = 250;
		gd.heightHint = 200;
		listSections = listViewerSections.getList();
		listSections.setLayoutData(gd);	
		
		Composite compositeBtn = toolkit.createComposite(client, SWT.NONE);
		compositeBtn.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		toolkit.paintBordersFor(compositeBtn);
		FillLayout fl_compositeBtn = new FillLayout(SWT.VERTICAL);
		fl_compositeBtn.marginWidth = 5;
		fl_compositeBtn.marginHeight = 5;
		fl_compositeBtn.spacing = 5;
		compositeBtn.setLayout(fl_compositeBtn);
		
		Button btnAddAll = toolkit.createButton(compositeBtn, ">> Add All", SWT.NONE);
		
		ImageDescriptor imageAdd = ImageDescriptor.createFromFile(this.getClass(),IMAGE_PATH + "/add.gif");
		Button btnAdd = toolkit.createButton(compositeBtn, "Add", SWT.NONE);
		btnAdd.setImage(imageAdd.createImage());
		btnAdd.setToolTipText("Add Quality attribute");
			
		
		ImageDescriptor imageRemove = ImageDescriptor.createFromFile(this.getClass(),IMAGE_PATH + "/delete.gif");
		Button btnRemove = toolkit.createButton(compositeBtn, "Remove", SWT.NONE);
		btnRemove.setImage(imageRemove.createImage());
		btnRemove.setToolTipText("Remove Quality attribute");
		
		listViewerSectionsSelected = new ListViewer(client, SWT.BORDER | SWT.V_SCROLL);
		listSectionsSelected = listViewerSectionsSelected.getList();
		listSectionsSelected.setLayoutData(gd);
		
		Button btnRemoveAll = toolkit.createButton(compositeBtn, "<< Remove All", SWT.NONE);
		
		btnAddAll.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {	
				for(int i = 0; listViewerSections.getList().getItems().length > 0; ){
					SadSection sad = (SadSection)listViewerSections.getElementAt(i);
					listViewerSectionsSelected.add(sad);
					listViewerSections.remove(sad);
				}				
				refreshList();
			}
		});
		
		btnRemoveAll.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				for(int i = 0; listViewerSectionsSelected.getList().getItems().length > 0; ){
					SadSection sad = (SadSection)listViewerSectionsSelected.getElementAt(i);
					listViewerSections.add(sad);
					listViewerSectionsSelected.remove(sad);
				}				
				refreshList();
			}
		});
		
		btnAdd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				StructuredSelection selection = (StructuredSelection)listViewerSections.getSelection();
				if(!selection.isEmpty()) {
					SadSection sadSection = (SadSection)selection.getFirstElement();
					listViewerSections.remove(sadSection);
					listViewerSectionsSelected.add(sadSection);
					refreshList();
				}
			}
		});	
		
		btnRemove.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				StructuredSelection selection = (StructuredSelection)listViewerSectionsSelected.getSelection();
				if(!selection.isEmpty()) {
					SadSection sadSection = (SadSection)selection.getFirstElement();
					listViewerSectionsSelected.remove(sadSection);
					listViewerSections.add(sadSection);
					refreshList();
				}
			}
		});	
	}	
	
	private void refreshList(){
		listSections.update();
		listSectionsSelected.update();
		listQualityAtributes1.update();
		listQualityAtributes2.update();
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
