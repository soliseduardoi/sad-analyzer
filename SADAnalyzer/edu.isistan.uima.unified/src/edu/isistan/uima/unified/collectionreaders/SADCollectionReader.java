package edu.isistan.uima.unified.collectionreaders;

import java.io.IOException;

import org.apache.uima.UimaContext;
import org.apache.uima.collection.CollectionException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.util.Progress;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.uimafit.component.JCasCollectionReader_ImplBase;
import org.uimafit.descriptor.ConfigurationParameter;
import org.uimafit.descriptor.ExternalResource;

import SadModel.Sad;
import SadModel.SadSection;
import edu.isistan.uima.unified.analysisengines.AnnotationGenerator;
import edu.isistan.uima.unified.sharedresources.ProgressMonitorResource;

public class SADCollectionReader extends JCasCollectionReader_ImplBase {
	@ConfigurationParameter(name="input")
	private String inputString;
	
	private URI resourceURI;
	private ResourceSet resourceSet;
	private Resource resource;	
	
	private Sad project;
	private boolean processed;
	//
	public static String EOL = System.getProperty("line.separator");
	//
	@ExternalResource(key="monitor")
	private ProgressMonitorResource monitorResource;
	private IProgressMonitor subMonitor;
	//
	@Override
	public void initialize(UimaContext aContext) throws ResourceInitializationException {
		super.initialize(aContext);
		
		resourceURI = URI.createURI(inputString);
		
		resourceSet = new ResourceSetImpl();
		resource = resourceSet.getResource(resourceURI, true);

		project = (Sad) resource.getContents().get(resource.getContents().size()-1);		
		
		processed = false;
	}


	@Override
	public boolean hasNext() throws IOException, CollectionException {
		return !processed;
	}
	
	@Override
	public void getNext(JCas aJCas) throws IOException, CollectionException {
		StringBuffer buffer = new StringBuffer();
		
		subMonitor = new SubProgressMonitor(monitorResource.getMonitor(), 1, SubProgressMonitor.PREPEND_MAIN_LABEL_TO_SUBTASK);
		subMonitor.beginTask(this.getClass().getSimpleName(), project.getSections().size());
		int gap= 0;
		if(project.getSections().size()==2){
			gap =1;
		}
		
		for(SadSection section : project.getSections()) {
			
			int begin = buffer.length();
			
			StringBuffer bufferDocument = new StringBuffer();
			String text=section.getText();
			if(text!=null && !"".equals(text)){
				
				bufferDocument.append(text).append(EOL);
				buffer.append(bufferDocument);
			  generateSection(begin,section,"Section", bufferDocument, aJCas);		
			}
			subMonitor.worked(1);
		}
		String allDocument = buffer.toString();
		aJCas.setDocumentText(allDocument);
		AnnotationGenerator.generateSad(0, allDocument.length(), project.getID(), project.getTitle(), project.getContent(), "Sad", aJCas,gap);
		processed = true;
		
		subMonitor.done();
	}
	
	private int generateSection(int begin, SadSection section, String kind, StringBuffer buffer, JCas aJCas) {
		StringBuffer bufferSection = new StringBuffer();
		int end = begin;
		
		bufferSection.append(section.getText()).append(EOL);
		end += bufferSection.length();
		if(bufferSection.length() > 0) {
			buffer.append(bufferSection);
			AnnotationGenerator.generateSadSection(begin, end, section.getID(), section.getName(), kind, aJCas);
			return end;
		}
		else
			return 0;
	}
	
//	private int transverseMultiple(int begin, EList<Section> sections, String kind, StringBuffer buffer, JCas aJCas) {
//		int end = begin;
//		for(Section section : sections)
//			end = transverseSingle(end, section, kind, buffer, aJCas);
//		return end;
//	}

	@Override
	public Progress[] getProgress() {
		return null;
	}

	@Override
	public void close() throws IOException {
		super.close();
	}
	
	@Override
	public void destroy() {
		super.destroy();
	}
}