package edu.isistan.sadeditor.editor;

import org.eclipse.osgi.util.NLS;

/**
 * 
 * @author mbasso
 *
 */
public class Messages extends NLS {
	
	private static final String BUNDLE_NAME = "edu.isistan.sadeditor.editor.messages";


	
	public static String Sad_FilenameDefault;
	public static String Sad_Extension;
	public static String Sad_UrlField;
	public static String SadWizard_Title;
	public static String SadWizard_Windows_Title;
	public static String SadWizard_Description;
	public static String SadWizard_Settings_Description;
	public static String SadWizard_ErrorFileName;
	public static String SadWizard_SourceSad;	
	public static String SadWizard_Settings_URL_Field;
	public static String SadWizard_Settings_Document_Field;
	public static String SadWizard_Settings_Template_Field;
	public static String SadWizard_XMLEncodingChoices;
	public static String SadWizard_XMLEncoding;
	public static String SadEditor_OverviewTitle;
	public static String SadEditor_OverviewSource;
	public static String SadEditor_OverviewTemplate;
	public static String Sad_OverviewRunSection;
	public static String Sad_OverviewRun;
	public static String Sad_OverviewDetail;
	public static String Sad_OverviewDescription1;
	public static String Sad_OverviewDescription2;
	public static String Sad_OverviewDescription3;
	public static String Sad_OverviewModelTree;
	public static String Sad_OverviewViewSection;
	
	
	public static String SadEditor_Overview;
	
	static {
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
