package edu.isistan.sadanalyzer.pages;


import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.events.ExpansionAdapter;
import org.eclipse.ui.forms.events.ExpansionEvent;
import org.eclipse.ui.forms.widgets.ColumnLayout;
import org.eclipse.ui.forms.widgets.FormText;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.wb.swt.ResourceManager;

import edu.isistan.sadanalyzer.editor.Messages;
import edu.isistan.sadanalyzer.editor.SadAnalyzerEditor;
import edu.isistan.sadanalyzer.model.CrosscuttingConcern;
import edu.isistan.sadanalyzer.model.Impact;
import edu.isistan.sadanalyzer.model.impl.CrosscuttingConcernImpl;
import edu.isistan.sadanalyzer.providers.CrosscuttingConcernLabelProvider;
import edu.isistan.sadanalyzer.providers.SadSectionLabelProvider;
import edu.isistan.sadanalyzer.query.UIMASADQueryAdapter;
import edu.isistan.uima.unified.typesystems.nlp.Sentence;
import edu.isistan.uima.unified.typesystems.sad.SadSection;
import edu.isistan.uima.unified.typesystems.sad.impl.SadSectionImpl;


public class SadAnalyzerViewerPage extends FormPage {

	public static final String ID = "edu.isistan.sadanalyzer.pages.SadAnalyzerViewerPage";
	public static final String TITLE = Messages.SadAnalyzerEditor_Viewer;
	
	private ListViewer listViewerSectionsSelected;
	private java.util.List listQualityAttributesSelected;
	private List attributes;
	private List sections;
	private ListViewer listSections;
	private ListViewer listAttributes;
	private SadSection sadSection;
	private CrosscuttingConcern crossCutting;
	private StyledText styledText;
	private int occurrences;
	private Label labelOccurrences;
	private Label labelImage;
	private Composite compositeLabel;
	
	private UIMASADQueryAdapter uimaRoot;
	
	public SadAnalyzerViewerPage(){
		super(ID, TITLE);
	}
	
	public SadAnalyzerViewerPage(FormEditor editor) {
		super(editor, ID, TITLE);
	}
	
	public SadAnalyzerViewerPage(FormEditor editor, ListViewer listViewerSectionsSelected, java.util.List listQualityAttributesSelected) {
		super(editor, ID, TITLE);
		this.listViewerSectionsSelected = listViewerSectionsSelected;	
		this.listQualityAttributesSelected=listQualityAttributesSelected;
		uimaRoot = ((SadAnalyzerEditor)getEditor()).getUimaRoot();	
		occurrences = 0;
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
		form.setText(Messages.SadAnalyzerEditor_ViewerTitle);
		
		Action deleteView = new Action("run", Action.AS_CHECK_BOX){
			public void run() {
				deleteView();
			}
		};
		deleteView.setToolTipText("Close View");
		deleteView.setEnabled(Boolean.TRUE);
		deleteView.setImageDescriptor(ResourceManager.getPluginImageDescriptor("edu.isistan.sadanalyzer", "icons/delete.gif"));
		
		form.getToolBarManager().add(deleteView);
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
		layout.maxNumColumns = 1;
		layout.minNumColumns = 1;		
	
		toolkit.paintBordersFor(body);
		managedForm.getForm().getBody().setLayout(layout);
		viewTextDetail(managedForm, Messages.SadAnalyzerEditor_ViewerDetail, Messages.SadAnalyzerEditor_ViewerDetailDescription);
		viewMatches(managedForm);
	}
	
	private void deleteView(){
		IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		IWorkbenchPage page = window.getActivePage();
		for(IEditorReference reference : page.getEditorReferences()){
		  if(reference .getId().equals(SadAnalyzerEditor.ID)){
		    EditorPart part = (EditorPart) reference.getEditor(true);
		    SadAnalyzerEditor editor = (SadAnalyzerEditor)part;
		    editor.removePage(editor.getActivePage());
		  }
		}
		this.dispose();
	}
	
	private void viewMatches(IManagedForm managedForm){
		
		FormToolkit toolkit = managedForm.getToolkit();
		
		compositeLabel = new Composite(managedForm.getForm().getBody(), SWT.NONE);
		compositeLabel.setLayout(new FillLayout(SWT.HORIZONTAL));
		toolkit.adapt(compositeLabel);
		toolkit.paintBordersFor(compositeLabel);		
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		compositeLabel.setLayout(layout);
		
		GridData gd = new GridData();
		gd.widthHint = 15;
		gd.heightHint = 20;
		
		labelImage = toolkit.createLabel(compositeLabel, "");
		labelImage.setImage(ResourceManager.getPluginImage("edu.isistan.sadanalyzer", "icons/warning.gif"));
		labelImage.setVisible(false);
		labelImage.setLayoutData(gd);
		
		GridData gd1 = new GridData();
		gd1.widthHint = 150;
		gd1.heightHint = 20;
		labelOccurrences = toolkit.createLabel(compositeLabel, "");		
		labelOccurrences.setVisible(false);
		labelOccurrences.setLayoutData(gd1);
	}
	
	private void viewTextDetail(IManagedForm managedForm, String title, String desc) {
		Composite client = createSection(managedForm, title, desc, 3);
		
		listSections = new ListViewer(client, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);		
		listSections.setLabelProvider(new SadSectionLabelProvider(uimaRoot));
				
		setListViewer(listViewerSectionsSelected, listSections);
				
		GridData gd = new GridData();
		gd.widthHint = 250;
		gd.heightHint = 400;
		sections = listSections.getList();
		sections.setLayoutData(gd);	
		
		listAttributes = new ListViewer(client, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);		
		listAttributes.setLabelProvider(new CrosscuttingConcernLabelProvider());
		
		setListViewerAttribute(listQualityAttributesSelected, listAttributes);
		
		attributes = listAttributes.getList();
		attributes.setLayoutData(gd);
		
		gd = new GridData(GridData.VERTICAL_ALIGN_BEGINNING);		
		gd = new GridData();
		gd.widthHint = 600;
		gd.heightHint= 400;
		styledText = new StyledText(client, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP | SWT.V_SCROLL | SWT.H_SCROLL | SWT.MULTI);
		styledText.setBlockSelection(true);
		styledText.setLayoutData(gd);
		managedForm.getToolkit().adapt(styledText);
		managedForm.getToolkit().paintBordersFor(styledText);
		
		
		listSections.addSelectionChangedListener(new ISelectionChangedListener(){
			public void selectionChanged(SelectionChangedEvent event) {
				IStructuredSelection selection = (IStructuredSelection)event.getSelection();			
				if(!selection.isEmpty()) {
					sadSection = (SadSectionImpl)selection.getFirstElement();
					viewQueryText();
				}
			}
		});
		
		listAttributes.addSelectionChangedListener(new ISelectionChangedListener(){
			public void selectionChanged(SelectionChangedEvent event) {
				IStructuredSelection selection = (IStructuredSelection)event.getSelection();			
				if(!selection.isEmpty()) {
					crossCutting = (CrosscuttingConcernImpl)selection.getFirstElement();
					viewQueryText();
				}
			}
		});
	}
	
		
	private Composite createSection(IManagedForm mform, String title,
			String desc, int numColumns) {
		final ScrolledForm form = mform.getForm();
		FormToolkit toolkit = mform.getToolkit();
		
		Composite compositeDetails = new Composite(mform.getForm().getBody(), SWT.NONE);
		compositeDetails.setLayout(new FillLayout(SWT.HORIZONTAL));
		toolkit.adapt(compositeDetails);
		toolkit.paintBordersFor(compositeDetails);		
		
		Section section = toolkit.createSection(compositeDetails, Section.TITLE_BAR 
				| Section.DESCRIPTION | Section.EXPANDED);
		section.setText(title);
		section.setDescription(desc);
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
	
	private void setListViewer(ListViewer source, ListViewer list){
		for(int i=0; list.getList().getItems().length > 0;){
			Object o = list.getElementAt(i);
			list.remove(o);
		}
		for(int i = 0; i < source.getList().getItems().length; i++){
			list.add(source.getElementAt(i));
		}
	}
	private void setListViewerAttribute(java.util.List source, ListViewer list){
		for(int i=0; list.getList().getItems().length > 0;){
			Object o = list.getElementAt(i);
			list.remove(o);
		}
		for(int i = 0; i < source.size(); i++){
			list.add(source.get(i));
		}
	}
	
	public void refresh(ListViewer listViewerSectionsSelected, java.util.List listQualityAttributesSelected){
		
		setListViewer(listViewerSectionsSelected, listSections);
		setListViewerAttribute(listQualityAttributesSelected, listAttributes);
		styledText.setText("");
		styledText.update();
		attributes.update();
		sections.update();
		
		labelImage.setVisible(false);
		labelOccurrences.setVisible(false);
		labelOccurrences.update();
		labelImage.update();
		compositeLabel.update();
	}
	
	private void viewQueryText(){
		if(null != sadSection && null != crossCutting){	
			occurrences = 0;
			styledText.setText(uimaRoot.getCoveredText(sadSection));
			for(Impact impact : crossCutting.getImpacts()) {
				Sentence sentence = impact.getSentence();
				Color color = new Color(Display.getDefault(),255, 255, 51);
				StyleRange newStyleRange = createStyleRange(sentence, color);
				setStyledRange(newStyleRange);
			}	
			setOccurrences();		
		}
	}
	
	private void setOccurrences(){	
		labelImage.setVisible(true);
		labelOccurrences.setText(Messages.SadAnalyzerEditor_ViewerOccurences+ ": "+occurrences);
		labelOccurrences.setVisible(true);
		labelOccurrences.update();
		labelImage.update();
		compositeLabel.update();
	}
	
	private StyleRange createStyleRange(Sentence sentence, Color color) {
		StyleRange styleRange = new StyleRange();
		styleRange.start = sentence.getBegin() - sadSection.getBegin();
		styleRange.length = sentence.getEnd() - sentence.getBegin();
		styleRange.fontStyle = SWT.BOLD;
		styleRange.background = color;
		return styleRange;
	}
	
	private void setStyledRange(StyleRange newStyleRange) {
		try{			
			StyleRange[] existingStyleRanges = 	styledText.getStyleRanges(newStyleRange.start, newStyleRange.length, true);			
			if(existingStyleRanges != null && existingStyleRanges.length > 0) {
				int existingStyleRangesSize = existingStyleRanges.length;
				int increment = newStyleRange.length / (existingStyleRangesSize + 1);
				int incrementRest = newStyleRange.length % (existingStyleRangesSize + 1);
				int lastStart = newStyleRange.start;
				for(int i = 0; i < existingStyleRangesSize; i++) {
					StyleRange styleRange = existingStyleRanges[i];
					styleRange.start = lastStart;
					styleRange.length = increment;
					lastStart = lastStart + increment;
				}
				styledText.replaceStyleRanges(newStyleRange.start, newStyleRange.length, existingStyleRanges);
				newStyleRange.start = lastStart;
				newStyleRange.length = increment + incrementRest;
				
			}
			styledText.setStyleRange(newStyleRange);
			occurrences = occurrences + 1;
		}catch(Exception e){}
	}
	
}
