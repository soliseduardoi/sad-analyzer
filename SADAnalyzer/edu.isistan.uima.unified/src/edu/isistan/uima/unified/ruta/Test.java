package edu.isistan.uima.unified.ruta;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.apache.uima.UIMAException;
import org.apache.uima.analysis_engine.AnalysisEngineDescription;
import org.apache.uima.collection.CollectionReaderDescription;
import org.apache.uima.fit.factory.AnalysisEngineFactory;
import org.apache.uima.fit.factory.CollectionReaderFactory;
import org.apache.uima.fit.factory.TypeSystemDescriptionFactory;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.resource.metadata.TypePriorities;
import org.apache.uima.resource.metadata.TypeSystemDescription;
import org.apache.uima.util.InvalidXMLException;

public class Test {
	
	public TypeSystemDescription getTypeSystemDescription() throws ResourceInitializationException {
		System.setProperty("org.apache.uima.fit.type.import_pattern", "classpath*:descriptor/edu/isistan/uima/unified/typesystems/**/*.xml");
		                         
		return TypeSystemDescriptionFactory.createTypeSystemDescription();
	}
	
	public TypePriorities getTypePriorities() throws ResourceInitializationException {
//		return TypePrioritiesFactory.createTypePriorities(
//
//		"edu.isistan.uima.unified.typesystems.sad.SadSection",
//		"edu.isistan.uima.unified.typesystems.sad.Sad",
//			"edu.isistan.uima.unified.typesystems.domain.CrosscuttingConcern",
//			"edu.isistan.uima.unified.typesystems.nlp.Sentence",
//			"edu.isistan.uima.unified.typesystems.nlp.SDDependency",
//			"edu.isistan.uima.unified.typesystems.nlp.Chunk",
//			"edu.isistan.uima.unified.typesystems.nlp.Entity",
//			"edu.isistan.uima.unified.typesystems.nlp.Token",
//			"edu.isistan.uima.unified.typesystems.wordnet.Sense");
		return null;
	}
	
	public CollectionReaderDescription getXMIReaderCR(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities, String inputFile) throws ResourceInitializationException, InvalidXMLException {
		CollectionReaderDescription crDescription = 
			CollectionReaderFactory.createReaderDescription(XMICollectionReader.class, typeSystemDescription, typePriorities, "input", inputFile);
		return crDescription;
	}
	
	public AnalysisEngineDescription getXMIWriterCC(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities, String outputFile) throws ResourceInitializationException, InvalidXMLException {
		AnalysisEngineDescription aeDescription = 
				AnalysisEngineFactory.createEngineDescription(XMIWriterConsumer.class, typeSystemDescription, typePriorities, "output", outputFile);
		return aeDescription;
	}
	
	public AnalysisEngineDescription getRutaAA(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities, String script) throws ResourceInitializationException, InvalidXMLException {
		AnalysisEngineDescription aeDescription = 
			AnalysisEngineFactory.createEngineDescription(RutaAnnotator.class, typeSystemDescription, typePriorities, RutaAnnotator.RUTA_SCRIPT, script, RutaAnnotator.RUTA_DEBUG, false);
		return aeDescription;
	}
	
	public AnalysisEngineDescription getRutaAA(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities, String script, boolean debug) throws ResourceInitializationException, InvalidXMLException {
		AnalysisEngineDescription aeDescription = 
			AnalysisEngineFactory.createEngineDescription(RutaAnnotator.class, typeSystemDescription, typePriorities, RutaAnnotator.RUTA_SCRIPT, script, RutaAnnotator.RUTA_DEBUG, debug);
		return aeDescription;
	}
	
	
	
	public String readScript(String path) throws IOException {
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(path);
		String script = IOUtils.toString(inputStream, "UTF-8");
		return script;
	}
	
	public static void main(String[] args) throws UIMAException, IOException {
//		Test test = new Test();
//		
//		boolean debug = true;
//		
//		TypeSystemDescription typeSystemDescription = test.getTypeSystemDescription();
//		TypePriorities typePriorities = test.getTypePriorities();
//		
		String inputFile = "file:///G:/wsEntregaFinal/edu.isistan.sadanalyzer.ruta/input/PetStore22secciones.uimasad";
//		CollectionReaderDescription reader = test.getXMIReaderCR(typeSystemDescription, typePriorities, inputFile);
//
		String outputFile = "file:///G:/wsEntregaFinal/edu.isistan.sadanalyzer.ruta/PetStore22secciones.uimasadOut";
//		AnalysisEngineDescription writer = test.getXMIWriterCC(typeSystemDescription, typePriorities, outputFile);
//		
//		JCasIterable iterable = SimplePipeline.iteratePipeline(
//				reader, 
////				test.getRutaAA(typeSystemDescription, typePriorities, test.readScript("script/edu/isistan/sadanalyzer/ruta/domain/DomainActor.ruta"), debug),
////				test.getRutaAA(typeSystemDescription, typePriorities, test.readScript("script/edu/isistan/sadanalyzer/ruta/concerns/Accuracy.ruta"), debug),
////				test.getRutaAA(typeSystemDescription, typePriorities, test.readScript("script/edu/isistan/sadanalyzer/ruta/concerns/Concurrence.ruta"), debug),
////				test.getRutaAA(typeSystemDescription, typePriorities, test.readScript("script/edu/isistan/sadanalyzer/ruta/concerns/ErrorManagement.ruta"), debug),
////				test.getRutaAA(typeSystemDescription, typePriorities, test.readScript("script/edu/isistan/sadanalyzer/ruta/concerns/ExternalCommunication.ruta"), debug),
////				test.getRutaAA(typeSystemDescription, typePriorities, test.readScript("script/edu/isistan/sadanalyzer/ruta/concerns/IntegrityManagement.ruta"), debug),
////				test.getRutaAA(typeSystemDescription, typePriorities, test.readScript("script/edu/isistan/sadanalyzer/ruta/concerns/Latency.ruta"), debug),
//				test.getRutaAA(typeSystemDescription, typePriorities, test.readScript("script/edu/isistan/sadanalyzer/ruta/concerns/Persistence.ruta"), debug),
////				test.getRutaAA(typeSystemDescription, typePriorities, test.readScript("script/edu/isistan/sadanalyzer/ruta/concerns/Presentation.ruta"), debug),
////				test.getRutaAA(typeSystemDescription, typePriorities, test.readScript("script/edu/isistan/sadanalyzer/ruta/concerns/Reliability.ruta"), debug),
////				test.getRutaAA(typeSystemDescription, typePriorities, test.readScript("script/edu/isistan/sadanalyzer/ruta/concerns/UserAccessControl.ruta"), debug),
//				writer
//				);
//		for(JCas jCas : iterable) {
//			System.out.printf("Found %d Sentences instances%n", JCasUtil.select(jCas, Sentence.class).size());
//			System.out.printf("Found %d token instances%n", JCasUtil.select(jCas, Token.class).size());			
////			System.out.printf("Found %d domain actor instances%n", JCasUtil.select(jCas, DomainActor.class).size());
//			System.out.printf("Found %d crosscutting concern instances%n", JCasUtil.select(jCas, CrosscuttingConcern.class).size());
//		}
		
		System.setProperty("MODELS_PATH", "C:/REAssistant-models");
		RutaEngine engine = new RutaEngine();
		
		engine.execute(inputFile, outputFile);
		
		
	}
}
