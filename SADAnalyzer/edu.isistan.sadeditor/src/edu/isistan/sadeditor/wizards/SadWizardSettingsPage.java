package edu.isistan.sadeditor.wizards;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.StringTokenizer;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.internal.ide.IDEWorkbenchPlugin;

import edu.isistan.sadeditor.editor.Messages;



/**
 * The "New" wizard page allows setting the container for the new file as well
 * as the file name. The page will only accept file name without the extension
 * OR with the extension that matches the expected one (mpe).
 */

public class SadWizardSettingsPage extends WizardPage {

	public static final String ID = "edu.isistan.sadeditor.wizards.SadWizardSettingsPage";


	private Text urlPath;
	private Text archivePathField;
	private Text directoryTemplateField;
	private Button browseArchivesButton;
	private Button browseTemplateDirectoriesButton;
	private static final String[] FILE_IMPORT_MASK = {"*.pdf"};
	private static final String[] FILE_IMPORT_TEMPLATE_MASK = {"*.xml"};
	private static String previouslyBrowsedArchive = ""; 
	protected Button sadFromArchiveRadio;
	protected Button sadFromURLRadio;
		
	
	/**
	 * Create the wizard.
	 */
	public SadWizardSettingsPage(String pageId) {
		super(pageId);
	}

	
	/**
	 * Create contents of the wizard.
	 * @param parent
	 */
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
//		 sad url radio button
		sadFromURLRadio = new Button(composite, SWT.RADIO);
		sadFromURLRadio.setText(Messages.SadWizard_Settings_URL_Field);
		
		urlPath = new Text(composite, SWT.BORDER);
		urlPath.setText(Messages.Sad_UrlField);
		urlPath.addModifyListener(validator);
				
		GridData directoryPathData = new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL);
		urlPath.setLayoutData(directoryPathData);
		
		// button ghost
		Button ghostButton = new Button(composite, SWT.PUSH);
		ghostButton.setText("");
		ghostButton.setVisible(false);
		setButtonLayoutData(ghostButton);
		
		
		
		sadFromArchiveRadio = new Button(composite, SWT.RADIO);		
		sadFromArchiveRadio.setText(Messages.SadWizard_Settings_Document_Field);
		
		// pdf Sad location entry field
		archivePathField = new Text(composite, SWT.BORDER);

		GridData archivePathData = new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL);
		archivePathField.setLayoutData(archivePathData); 
		archivePathField.setEditable(false);
		// browse button
		browseArchivesButton = new Button(composite, SWT.PUSH);
		browseArchivesButton.setText(Messages.SadWizard_Settings_Browse);
		setButtonLayoutData(browseArchivesButton);

		sadFromURLRadio.setSelection(true);
		archivePathField.setEnabled(false);
		browseArchivesButton.setEnabled(false);	
		
		
		Label title = new Label(composite, SWT.NONE);
		title.setText(Messages.SadWizard_Settings_Template_Field + ": ");
		
		// template location entry field
		directoryTemplateField = new Text(composite, SWT.BORDER);

		GridData directoryTemplatePathData = new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL);
		directoryTemplateField.setLayoutData(directoryTemplatePathData);
		directoryTemplateField.setEditable(false);
		
		// browse button
		browseTemplateDirectoriesButton = new Button(composite, SWT.PUSH);
		browseTemplateDirectoriesButton
				.setText(Messages.SadWizard_Settings_Browse);
		setButtonLayoutData(browseTemplateDirectoriesButton);
		
						
		browseArchivesButton.addSelectionListener(new SelectionAdapter() {
			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse
			 * .swt.events.SelectionEvent)
			 */
			public void widgetSelected(SelectionEvent e) {
				handleLocationArchiveButtonPressed(archivePathField, FILE_IMPORT_MASK);
			}

		});
		sadFromArchiveRadio.addSelectionListener(new SelectionAdapter() {
			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse
			 * .swt.events.SelectionEvent)
			 */
			public void widgetSelected(SelectionEvent e) {
				archiveRadioSelected();
			}
		});
		
		browseTemplateDirectoriesButton.addSelectionListener(new SelectionAdapter() {
			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetS
			 * elected(org.eclipse.swt.events.SelectionEvent)
			 */
			public void widgetSelected(SelectionEvent e) {
				handleLocationArchiveButtonPressed(directoryTemplateField, FILE_IMPORT_TEMPLATE_MASK);
			}

		});
		
		sadFromURLRadio.addSelectionListener(new SelectionAdapter() {
			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse
			 * .swt.events.SelectionEvent)
			 */
			public void widgetSelected(SelectionEvent e) {
				urlRadioSelected();
			}
		});		
		
		setPageComplete(validatePage());
		setControl(composite);
	}
	
	

	private void urlRadioSelected() {
		if (sadFromURLRadio.getSelection()) {
			sadFromURLRadio.setSelection(true);
			urlPath.setEnabled(true);
			archivePathField.setEnabled(false);
			browseArchivesButton.setEnabled(false);
			urlPath.setFocus();
			sadFromArchiveRadio.setSelection(false);
		}
		setPageComplete(validatePage());
	}
	
	private void archiveRadioSelected() {
		if (sadFromArchiveRadio.getSelection()) {
			sadFromArchiveRadio.setSelection(true);
			urlPath.setEnabled(false);
			archivePathField.setEnabled(true);
			browseArchivesButton.setEnabled(true);
			archivePathField.setFocus();
			sadFromURLRadio.setSelection(false);
		}
		setPageComplete(validatePage());
	}
	
	
	/**
	 * The browse button has been selected. Select the location.
	 */
	protected void handleLocationArchiveButtonPressed(Text field, String[] mask) {

		FileDialog dialog = new FileDialog(field.getShell(), SWT.SHEET);
		dialog.setFilterExtensions(mask);
		dialog
				.setText(Messages.SadWizard_Settings_Import);

		String fileName = field.getText().trim();
		if (fileName.length() == 0) {
			fileName = previouslyBrowsedArchive;
		}

		if (fileName.length() == 0) {
			dialog.setFilterPath(IDEWorkbenchPlugin.getPluginWorkspace()
					.getRoot().getLocation().toOSString());
		} else {
			File path = new File(fileName).getParentFile();
			if (path != null && path.exists()) {
				dialog.setFilterPath(path.toString());
			}
		}

		String selectedArchive = dialog.open();
		if (selectedArchive != null) {
			previouslyBrowsedArchive = selectedArchive;
			field.setText(previouslyBrowsedArchive);
		}
		setPageComplete(validatePage());

	}
	
	protected ModifyListener validator = new ModifyListener() {
		public void modifyText(ModifyEvent e) {
			setPageComplete(validatePage());
		}
	};

	protected boolean validatePage() {
		boolean fields = true;
		if(this.sadFromArchiveRadio.getSelection()){
			if(getArchivePathField().getText().isEmpty()){
				fields = false;
			}
		}
		
		if(this.sadFromURLRadio.getSelection()){
			if(getUrlPath().getText().length() <= Messages.Sad_UrlField.length()){
				fields = false;
			}
		}	
		if(getDirectoryTemplateField().getText().isEmpty()){
			if(this.sadFromURLRadio.getSelection()){
				fields = false;
			}
		}
		
		return fields; 
	}
	
	public Text getUrlPath() {
		return urlPath;
	}


	public void setUrlPath(Text urlPath) {
		this.urlPath = urlPath;
	}


	public Text getArchivePathField() {
		return archivePathField;
	}


	public void setArchivePathField(Text archivePathField) {
		this.archivePathField = archivePathField;
	}


	public Text getDirectoryTemplateField() {
		return directoryTemplateField;
	}


	public void setDirectoryTemplateField(Text directoryTemplateField) {
		this.directoryTemplateField = directoryTemplateField;
	}


	public String getUrl() {
		String ret=getUrlPath().getText();
		if(sadFromArchiveRadio.getSelection()){
			ret=getArchivePathField().getText();
		}
		return ret;
	}


	public boolean isWikiSelection() {
		
		return sadFromURLRadio.getSelection();
	}

}