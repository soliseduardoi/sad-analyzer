package edu.isistan.sadanalyzer.wizards;


import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.wb.swt.ResourceManager;

import edu.isistan.sadanalyzer.editor.Messages;
import edu.isistan.sadanalyzer.validators.SadAnalyzerWizardValidator;
import edu.isistan.sadanalyzer.validators.impl.SadValidator;
import edu.isistan.sadanalyzer.validators.impl.UimaSadValidator;


public class SadAnalyzerSettingsPage extends WizardPage {

	public static final String ID = "edu.isistan.sadanalyzer.wizards.SadAnalyzerSettingsPage";
	
	private Label labelSad;
	private Text textSad;
	private Button browseSadButton;
	private Label labelUimaSad;
	private Text textUimaSad;
	private Button browseUimaSadButton;
	private	ImageDescriptor image;
	
	/**
	 * Create the wizard.
	 * @param pageName
	 */
	protected SadAnalyzerSettingsPage(IStructuredSelection selection) {
		super(ID);
		image = ResourceManager.getPluginImageDescriptor("edu.isistan.sadanalyzer", "icons/add.gif");
	}
	
	public Text getTextSadPath() {
		return textSad;
	}


	public Text getTextUimaSadPath() {
		return textUimaSad;
	}
	
	/**
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE); {
			GridLayout layout = new GridLayout();
			layout.numColumns = 3;
			layout.verticalSpacing = 12;
			composite.setLayout(layout);

			GridData data = new GridData();
			data.verticalAlignment = GridData.FILL;
			data.grabExcessVerticalSpace = true;
			data.horizontalAlignment = GridData.FILL;
			composite.setLayoutData(data);
		}
		//File .sad
		labelSad = new Label(composite,SWT.LEFT);
		{
			labelSad.setText(Messages.SadAnalyzerSettingsWizard_ImportSadFile + ": ");
			GridData gd_labelName = new GridData();
			gd_labelName.horizontalAlignment = GridData.FILL;
			labelSad.setLayoutData(gd_labelName);
		}
		textSad = new Text(composite, SWT.BORDER);
		textSad.setText("");
		{
			GridData gd_textName = new GridData();
			gd_textName.horizontalAlignment = GridData.FILL;
			gd_textName.grabExcessHorizontalSpace = true;
			textSad.setLayoutData(gd_textName);
		}
		
		browseSadButton = new Button(composite, SWT.PUSH);
		browseSadButton.setText(Messages.SadAnalyzerSettingsWizard_ImportFile);
		browseSadButton.setImage(image.createImage());
		setButtonLayoutData(browseSadButton);
		
		//File .uimasad
		labelUimaSad = new Label(composite,SWT.LEFT);
		{
			labelUimaSad.setText(Messages.SadAnalyzerSettingsWizard_ImportUimaSadFile + ": ");
			GridData gd_labelName = new GridData();
			gd_labelName.horizontalAlignment = GridData.FILL;
			labelUimaSad.setLayoutData(gd_labelName);
		}
		textUimaSad = new Text(composite, SWT.BORDER);
		textUimaSad.setText("");
		{
			GridData gd_textName = new GridData();
			gd_textName.horizontalAlignment = GridData.FILL;
			gd_textName.grabExcessHorizontalSpace = true;
			textUimaSad.setLayoutData(gd_textName);
		}
		
		browseUimaSadButton = new Button(composite, SWT.PUSH);
		browseUimaSadButton.setText(Messages.SadAnalyzerSettingsWizard_ImportFile);
		browseUimaSadButton.setImage(image.createImage());
		setButtonLayoutData(browseUimaSadButton);
		
		browseSadButton.addSelectionListener(new SelectionAdapter() {
			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse
			 * .swt.events.SelectionEvent)
			 */
			public void widgetSelected(SelectionEvent e) {
				handleLocationArchiveButtonPressed(textSad, new SadValidator());
			}

		});
		
		browseUimaSadButton.addSelectionListener(new SelectionAdapter() {
			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse
			 * .swt.events.SelectionEvent)
			 */
			public void widgetSelected(SelectionEvent e) {
				handleLocationArchiveButtonPressed(textUimaSad, new UimaSadValidator());
			}

		});
		
		setPageComplete(validatePage());
		setControl(composite);
	}
	
	/**
	 * The browse button has been selected. Select the location.
	 */
	protected void handleLocationArchiveButtonPressed(Text field, SadAnalyzerWizardValidator validator) {

		ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog(field.getShell(), new WorkbenchLabelProvider(), new WorkbenchContentProvider());

		dialog.setInput(ResourcesPlugin.getWorkspace());
		dialog.setTitle(Messages.SadAnalyzerSettingsWizard_Import);
		dialog.setValidator(validator);		
		dialog.setAllowMultiple( false );
		IResource resource = null;
		if( dialog.open() == Window.OK ){
		    resource = (IResource) dialog.getFirstResult();
		    if (resource != null ){
		    	String path = resource.getLocationURI().getPath();
		    	field.setText(path.substring(1, path.length()));
			}
		}				
		setPageComplete(validatePage());

	}
	
	
	protected boolean validatePage() {
		boolean fields = true;
		if(textUimaSad.getText().length() < 1){
			fields = false;
		}
		if(textSad.getText().length() < 1){
			fields = false;
		}
		return fields;
	}

}
