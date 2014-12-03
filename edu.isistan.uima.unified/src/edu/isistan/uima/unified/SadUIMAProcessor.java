package edu.isistan.uima.unified;

import java.io.IOException;
import java.util.List;

import org.apache.uima.UIMAException;
import org.apache.uima.analysis_engine.AnalysisEngine;
import org.apache.uima.collection.CollectionReader;
import org.apache.uima.fit.pipeline.SimplePipeline;
import org.apache.uima.resource.ExternalResourceDescription;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.resource.metadata.TypePriorities;
import org.apache.uima.resource.metadata.TypeSystemDescription;
import org.apache.uima.util.InvalidXMLException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;

import edu.isistan.uima.unified.sharedresources.ClustersResource;
import edu.isistan.uima.unified.sharedresources.ProgressMonitorResource;

@SuppressWarnings("unused")
public class SadUIMAProcessor {
	private static SadUIMAProcessor instance = null;
	private SadUIMAFactory factory = null;
	
	private SadUIMAProcessor(String language) {
		factory = SadUIMAFactory.getInstance();
		factory.setLanguage(language);
	}
	
	public static SadUIMAProcessor getInstance(String language) {
		if(instance == null)
			instance = new SadUIMAProcessor(language);
		return instance;
	}
	
	public void execute(String inputFile, String outputFile) {
		execute(inputFile, outputFile, new NullProgressMonitor());
	}
	
	public void execute(String inputFile, String outputFile, IProgressMonitor monitor) {
		try {
			// UIMA Modules Count
			int total = 0;
			// UIMA TypeSystems & Priorities
			TypeSystemDescription typeSystemDescription = factory.getTypeSystemDescription();
			TypePriorities typePriorities = factory.getTypePriorities();
			// External Resources
			ExternalResourceDescription sharedDataResource = factory.getXMISharedDataResource();
			ExternalResourceDescription monitorResource = factory.getProgressMonitorResource();
			// Collection Reader
			CollectionReader collectionReader = factory.getSADCR(typeSystemDescription, typePriorities, monitorResource, inputFile); total++;
//			CollectionReader collectionReader = factory.getXMIReaderCR(typeSystemDescription, typePriorities, monitorResource, sharedDataResource, inputFile); total++;
	
			// Sentence and Token Annotators
			AnalysisEngine sentenceAE = factory.getOpenNLPSentenceAA(typeSystemDescription, typePriorities, monitorResource); total++;
			AnalysisEngine tokenAE = factory.getOpenNLPTokenAA(typeSystemDescription, typePriorities, monitorResource); total++;

			// Word Annotators
			AnalysisEngine stopwordAE = factory.getNLPStopwordAA(typeSystemDescription, typePriorities, monitorResource); total++;
			AnalysisEngine stemmerAE = factory.getNLPStemmerAA(typeSystemDescription, typePriorities, monitorResource); total++;
			AnalysisEngine lemmaAE = factory.getMateToolsLemmaAA(typeSystemDescription, typePriorities, monitorResource); total++;

			// POS Annotators

			AnalysisEngine posAE = factory.getOpenNLPPOSAA(typeSystemDescription, typePriorities, monitorResource); total++;

			// Dependency Annotators
//		    AnalysisEngine conlldependencyAE = factory.getMateToolsDependencyAA(typeSystemDescription, typePriorities, monitorResource); total++;

			// SRL Annotators

//			AnalysisEngine conllsrlAE = factory.getCoNLLSRLAA(typeSystemDescription, typePriorities, monitorResource); total++;
			
			// Domain Annotators
//			AnalysisEngine domainActionAE = factory.getDomainActionAA(typeSystemDescription, typePriorities, monitorResource); total++;
	
			// CAS Writer Consumer
			AnalysisEngine writerCC = factory.getXMIWriterCC(typeSystemDescription, typePriorities, monitorResource, sharedDataResource, outputFile); total++;
			
			
			ProgressMonitorResource progressMonitorResource = (ProgressMonitorResource) collectionReader.getUimaContext().getResourceObject("monitor");
			progressMonitorResource.setMonitor(monitor);
			monitor.beginTask("UIMA pipeline execution", total);
			//
			
			SimplePipeline.runPipeline(
					collectionReader,
					sentenceAE,
					 tokenAE,
					 stopwordAE,
				     stemmerAE, 
					 lemmaAE,					
					 posAE, 
//					conlldependencyAE, 
//					conllsrlAE, 
//					domainActionAE,
					writerCC);
			//
			monitor.done();
		} catch (ResourceInitializationException e) {
			e.printStackTrace();
		} catch (UIMAException e) {
			e.printStackTrace();
		} catch (IOException e) {	
			e.printStackTrace();
		}
	}
	
	public List<List<String>> executeClustering(String inputFile, String linkageType, String distanceType, float minimumDistance, IProgressMonitor monitor) {
		try {
			// UIMA Modules Count
			int total = 0;
			// UIMA TypeSystems & Priorities
			TypeSystemDescription typeSystemDescription = factory.getTypeSystemDescription();
			TypePriorities typePriorities = factory.getTypePriorities();
			// External Resources
			ExternalResourceDescription sharedDataResource = factory.getXMISharedDataResource();
			ExternalResourceDescription clusterResource = factory.getClustersResource();
			ExternalResourceDescription monitorResource = factory.getProgressMonitorResource();
			// Collection Reader
			CollectionReader collectionReader = factory.getXMIReaderCR(typeSystemDescription, typePriorities, monitorResource, sharedDataResource, inputFile); total++;
			// Clusterer Consumer
			AnalysisEngine clustererCC = factory.getClustererCC(typeSystemDescription, typePriorities, monitorResource, clusterResource, linkageType, distanceType, minimumDistance); total++;
			//
			ProgressMonitorResource progressMonitorResource = (ProgressMonitorResource) collectionReader.getUimaContext().getResourceObject("monitor");
			progressMonitorResource.setMonitor(monitor);
			monitor.beginTask("AOIG mining execution", total);
			//
			SimplePipeline.runPipeline(
					collectionReader, 
					clustererCC);
			//
			ClustersResource clustersResource = (ClustersResource) clustererCC.getUimaContext().getResourceObject("clusters");
			List<List<String>> clusters = clustersResource.getClusters();
			//
			monitor.done();
			//
			return clusters;
		} catch (ResourceInitializationException e) {
			e.printStackTrace();
		} catch (UIMAException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void executeDomainExtraction(String inputFile, String outputFile) {
		try {
			IProgressMonitor monitor = new NullProgressMonitor();
			// UIMA Modules Count
			int total = 0;
			// UIMA TypeSystems & Priorities
			TypeSystemDescription typeSystemDescription = factory.getTypeSystemDescription();
			TypePriorities typePriorities = factory.getTypePriorities();
			// External Resources
			ExternalResourceDescription sharedDataResource = factory.getXMISharedDataResource();
			ExternalResourceDescription monitorResource = factory.getProgressMonitorResource();
			// Collection Reader			
			CollectionReader collectionReader = factory.getXMIReaderCR(typeSystemDescription, typePriorities, monitorResource, sharedDataResource, inputFile); total++;
			// Domain Action Extractor Consumer
			AnalysisEngine domainCSVExtractorCC = factory.getDomainCSVExtractorCC(typeSystemDescription, typePriorities, monitorResource, outputFile); total++;
			//
			ProgressMonitorResource progressMonitorResource = (ProgressMonitorResource) collectionReader.getUimaContext().getResourceObject("monitor");
			progressMonitorResource.setMonitor(monitor);
			monitor.beginTask("UIMA domain action extraction execution", total);
			//
			SimplePipeline.runPipeline(
					collectionReader,
					domainCSVExtractorCC);
			//
			monitor.done();
		} catch (ResourceInitializationException e) {
			e.printStackTrace();
		} catch (InvalidXMLException e) {
			e.printStackTrace();
		} catch (UIMAException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void executeAppendDomainLabeling(String inputFile, String outputFile) {
		try {
			IProgressMonitor monitor = new NullProgressMonitor();
			// UIMA Modules Count
			int total = 0;
			// UIMA TypeSystems & Priorities
			TypeSystemDescription typeSystemDescription = factory.getTypeSystemDescription();
			TypePriorities typePriorities = factory.getTypePriorities();
			// External Resources
			ExternalResourceDescription sharedDataResource = factory.getXMISharedDataResource();
			ExternalResourceDescription monitorResource = factory.getProgressMonitorResource();
			// Collection Reader
			CollectionReader collectionReader = factory.getXMIReaderCR(typeSystemDescription, typePriorities, monitorResource, sharedDataResource, inputFile); total++;
			// Domain Action Annotator
			AnalysisEngine domainActionAA = factory.getDomainActionAA(typeSystemDescription, typePriorities, monitorResource); total++;
			// CAS Writer Consumer
			AnalysisEngine writerCC = factory.getXMIWriterCC(typeSystemDescription, typePriorities, monitorResource, outputFile); total++;
			//
			ProgressMonitorResource progressMonitorResource = (ProgressMonitorResource) collectionReader.getUimaContext().getResourceObject("monitor");
			progressMonitorResource.setMonitor(monitor);
			monitor.beginTask("UIMA append domain action execution", total);
			//
			SimplePipeline.runPipeline(
					collectionReader,
					domainActionAA,
					writerCC);
			//
			monitor.done();
		} catch (ResourceInitializationException e) {
			e.printStackTrace();
		} catch (InvalidXMLException e) {
			e.printStackTrace();
		} catch (UIMAException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void executeUpdateDomainLabeling(String inputFile, String outputFile) {
		try {
			IProgressMonitor monitor = new NullProgressMonitor();
			// UIMA Modules Count
			int total = 0;
			// UIMA TypeSystems & Priorities
			TypeSystemDescription typeSystemDescription = factory.getTypeSystemDescription();
			TypePriorities typePriorities = factory.getTypePriorities();
			// External Resources
			ExternalResourceDescription sharedDataResource = factory.getXMISharedDataResource();
			ExternalResourceDescription monitorResource = factory.getProgressMonitorResource();
			// Collection Reader
			CollectionReader collectionReader = factory.getXMIReaderCR(typeSystemDescription, typePriorities, monitorResource, sharedDataResource, inputFile); total++;
			// Domain Action Annotators
		//	AnalysisEngine domainActionCleaningAA = factory.getDomainActionCleaningAA(typeSystemDescription, typePriorities, monitorResource); total++;
			//AnalysisEngine domainActionAA = factory.getDomainActionAA(typeSystemDescription, typePriorities, monitorResource); total++;
			// CAS Writer Consumer
			AnalysisEngine writerCC = factory.getXMIWriterCC(typeSystemDescription, typePriorities, monitorResource, sharedDataResource, outputFile); total++;
			//
			ProgressMonitorResource progressMonitorResource = (ProgressMonitorResource) collectionReader.getUimaContext().getResourceObject("monitor");
			progressMonitorResource.setMonitor(monitor);
			monitor.beginTask("UIMA append domain action execution", total);
			//
			SimplePipeline.runPipeline(
					collectionReader,
				//	domainActionCleaningAA,
				//	domainActionAA,
					writerCC);
			//
			monitor.done();
		} catch (ResourceInitializationException e) {
			e.printStackTrace();
		} catch (InvalidXMLException e) {
			e.printStackTrace();
		} catch (UIMAException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
