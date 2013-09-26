package edu.isistan.sadanalyzer.wizards;


import java.io.File;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.internal.ide.IDEWorkbenchPlugin;
import org.eclipse.ui.internal.wizards.datatransfer.DataTransferMessages;


public class SadAnalyzerSettingsPage extends WizardPage {

	public static final String ID = "edu.isistan.sadanalyzer.wizards.SadAnalyzerSettingsPage";
	private TreeViewer treeViewer;
	
	private IStructuredSelection selection;
	private Label labelSad;
	private Text textSad;
	
	public Text getTextSadPath() {
		return textSad;
	}


	public Text getTextUimaSadPath() {
		return textUimaSad;
	}


	private Button browseSadButton;
	private Label labelUimaSad;
	private Text textUimaSad;
	private Button browseUimaSadButton;
	private static String previouslyBrowsedArchive = "";
	private static final String[] FILE_IMPORT_SAD_MASK = {"*.sad"};
	private static final String[] FILE_IMPORT_UIMASAD_MASK = {"*.uimasad"};
	
	/**
	 * Create the wizard.
	 * @param pageName
	 */
	protected SadAnalyzerSettingsPage(IStructuredSelection selection) {
		super(ID);
		this.selection = selection;
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
			labelSad.setText("File .sad:");
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
		browseSadButton.setText("InportSad");
		setButtonLayoutData(browseSadButton);
		
		//File .uimasad
		labelUimaSad = new Label(composite,SWT.LEFT);
		{
			labelUimaSad.setText("File .sad:");
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
		browseUimaSadButton.setText("InportSad");
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
				handleLocationArchiveButtonPressed(textSad, FILE_IMPORT_SAD_MASK);
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
				handleLocationArchiveButtonPressed(textUimaSad, FILE_IMPORT_UIMASAD_MASK);
			}

		});
		
		setPageComplete(validatePage());
		setControl(composite);
	}
	
	/**
	 * The browse button has been selected. Select the location.
	 */
	protected void handleLocationArchiveButtonPressed(Text field, String[] mask) {

		FileDialog dialog = new FileDialog(field.getShell(), SWT.SHEET);
		dialog.setFilterExtensions(mask);
		dialog
				.setText(DataTransferMessages.WizardProjectsImportPage_SelectArchiveDialogTitle);

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
