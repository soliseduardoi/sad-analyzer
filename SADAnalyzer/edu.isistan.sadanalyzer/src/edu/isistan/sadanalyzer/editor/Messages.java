package edu.isistan.sadanalyzer.editor;

import org.eclipse.osgi.util.NLS;

/**
 * 
 * @author mbasso
 *
 */
public class Messages extends NLS {
	
	private static final String BUNDLE_NAME = "edu.isistan.sadanalyzer.editor.messages";

	public static String SadAnalyzer_Extension;
	public static String SadAnalyzerWizard_ErrorFileName;
	public static String SadAnalyzerWizard_Windows_Title;
	public static String SadAnalyzerWizard_Title;
	public static String SadAnalyzerWizard_Description;
	public static String SadAnalyzer_FilenameDefault;
	public static String SadAnalyzerEditor_Configuration;
	public static String SadAnalyzerEditor_ConfigurationTitle;
	public static String SadAnalyzerEditor_ConfigurationModelTree;
	public static String SadAnalyzerEditor_ConfigurationModelTreeDescription;
	public static String SadAnalyzerEditor_ConfigurationDetail;
	public static String SadAnalyzerEditor_ConfigurationDetailDescription;
	public static String SadAnalyzerEditor_SadSource;
	public static String SadAnalyzerEditor_UIMASadFile;
	public static String SadAnalyzerEditor_ConfigurationRun;
	public static String SadAnalyzerEditor_ConfigurationRunDescription;
	public static String SadAnalyzerEditor_ConfigurationRunButton;
	public static String SadAnalyzerWizard_ErrorMaskFile;
	public static String SadAnalyzerSettingsWizard_ImportSadFile;
	public static String SadAnalyzerSettingsWizard_ImportUimaSadFile;
	public static String SadAnalyzerSettingsWizard_ImportFile;
	public static String SadAnalyzerSettingsWizard_Description;
	public static String SadAnalyzerSettingsWizard_Import;
	public static String SadAnalyzerEditor_Viewer;
	public static String SadAnalyzerEditor_ViewerTitle;
	public static String SadAnalyzerEditor_ViewerDetail;
	public static String SadAnalyzerEditor_ViewerDetailDescription;
	
	static {
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
