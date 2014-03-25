package edu.isistan.uima.unified.ruta;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.IOUtils;
import org.apache.uima.UIMAException;
import org.apache.uima.analysis_engine.AnalysisEngineDescription;
import org.apache.uima.collection.CollectionReaderDescription;
import org.apache.uima.fit.factory.AnalysisEngineFactory;
import org.apache.uima.fit.factory.CollectionReaderFactory;
import org.apache.uima.fit.factory.TypePrioritiesFactory;
import org.apache.uima.fit.factory.TypeSystemDescriptionFactory;
import org.apache.uima.fit.pipeline.JCasIterable;
import org.apache.uima.fit.pipeline.SimplePipeline;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.resource.metadata.TypePriorities;
import org.apache.uima.resource.metadata.TypeSystemDescription;
import org.apache.uima.util.InvalidXMLException;

import edu.isistan.uima.unified.typesystems.domain.CrosscuttingConcern;
import edu.isistan.uima.unified.typesystems.nlp.Sentence;
import edu.isistan.uima.unified.typesystems.nlp.Token;

public class RutaEngine {
	
	private static final String RUTA_EXT = "ruta";
	private ArrayList<RutaScript> scripts = new ArrayList<RutaScript>();
	
			
	private  String getRuleSetPath() {
		return getModelsPath() + "/ruta/";
	}
	
	private  String getModelsPath() {
		String modelsPath = null;
		if(modelsPath == null || modelsPath.isEmpty())
			modelsPath = System.getenv("MODELS_PATH");
		if(modelsPath == null || modelsPath.isEmpty())
			modelsPath = System.getProperty("MODELS_PATH");
		return modelsPath;
	}

	
	public RutaEngine() {		
		
		File rootDirectory = new File(getRuleSetPath());
		
		if(rootDirectory!=null){
			
			for (File file : rootDirectory.listFiles()) {
			
				String name= file.getName();			
			
				if (RUTA_EXT.equals(name.substring(name.length()-4, name.length()))) {
					RutaScript script = new RutaScript(file.getPath());
					scripts.add(script);				
				}
		   }	
			
	   }
		
	}
	
	public void execute(String inputFile, String outputFile) {
		
		try{
		boolean debug = true;
		TypeSystemDescription typeSystemDescription = getTypeSystemDescription();
		TypePriorities typePriorities =getTypePriorities();
		
		CollectionReaderDescription reader = getXMIReaderCR(typeSystemDescription, typePriorities, inputFile);
		
		AnalysisEngineDescription writer = getXMIWriterCC(typeSystemDescription, typePriorities, outputFile);
		
		JCasIterable iterable = SimplePipeline.iteratePipeline(
				reader, 
				getRutaAA(typeSystemDescription, typePriorities,readScript("Accuracy.ruta"), debug),
				getRutaAA(typeSystemDescription, typePriorities,readScript("Concurrence.ruta"), debug),
				getRutaAA(typeSystemDescription, typePriorities,readScript("ErrorManagement.ruta"), debug),
				getRutaAA(typeSystemDescription, typePriorities,readScript("ExternalCommunication.ruta"), debug),
				getRutaAA(typeSystemDescription, typePriorities,readScript("IntegrityManagement.ruta"), debug),
				getRutaAA(typeSystemDescription, typePriorities,readScript("Latency.ruta"), debug),
				getRutaAA(typeSystemDescription, typePriorities,readScript("Persistence.ruta"), debug),
				getRutaAA(typeSystemDescription, typePriorities,readScript("Presentation.ruta"), debug),
				getRutaAA(typeSystemDescription, typePriorities,readScript("Reliability.ruta"), debug),
				getRutaAA(typeSystemDescription, typePriorities,readScript("UserAccessControl.ruta"), debug),
				writer
				);
		for(JCas jCas : iterable) {
			System.out.printf("Found %d Sentences instances%n", JCasUtil.select(jCas, Sentence.class).size());
			System.out.printf("Found %d token instances%n", JCasUtil.select(jCas, Token.class).size());			
			System.out.printf("Found %d crosscutting concern instances%n", JCasUtil.select(jCas, CrosscuttingConcern.class).size());
		}
		
	} catch (ResourceInitializationException e) {
		e.printStackTrace();
	} catch (UIMAException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
		
		
	}
	
	
	private TypeSystemDescription getTypeSystemDescription() throws ResourceInitializationException {
		System.setProperty("org.apache.uima.fit.type.import_pattern", "classpath*:desc/typesystems/**/*.xml");
		                         
		return TypeSystemDescriptionFactory.createTypeSystemDescription();
	}
	
	private TypePriorities getTypePriorities() throws ResourceInitializationException {
//		return TypePrioritiesFactory.createTypePriorities(
//		"edu.isistan.uima.unified.typesystems.sad.SadSection",
//		"edu.isistan.uima.unified.typesystems.sad.Sad",
//		"edu.isistan.uima.unified.typesystems.nlp.Sentence",
//		"edu.isistan.uima.unified.typesystems.domain.CrosscuttingConcern",
//		"edu.isistan.uima.unified.typesystems.srl.Predicate",
//		"edu.isistan.uima.unified.typesystems.srl.Structure",
//		"edu.isistan.uima.unified.typesystems.srl.Argument",
//		"edu.isistan.uima.unified.typesystems.nlp.SDDependency",
//		"edu.isistan.uima.unified.typesystems.nlp.Chunk",
//		"edu.isistan.uima.unified.typesystems.nlp.Entity",
//		"edu.isistan.uima.unified.typesystems.srl.Role",
//		"edu.isistan.uima.unified.typesystems.domain.DomainNumber",
//		"edu.isistan.uima.unified.typesystems.nlp.Token",
//		"edu.isistan.uima.unified.typesystems.wordnet.Sense");
		return null;
	}
	
	private CollectionReaderDescription getXMIReaderCR(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities, String inputFile) throws ResourceInitializationException, InvalidXMLException {
		CollectionReaderDescription crDescription = 
			CollectionReaderFactory.createReaderDescription(XMICollectionReader.class, typeSystemDescription, typePriorities, "input", inputFile);
		return crDescription;
	}
	
	private AnalysisEngineDescription getXMIWriterCC(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities, String outputFile) throws ResourceInitializationException, InvalidXMLException {
		AnalysisEngineDescription aeDescription = 
				AnalysisEngineFactory.createEngineDescription(XMIWriterConsumer.class, typeSystemDescription, typePriorities, "output", outputFile);
		return aeDescription;
	}
	
	private AnalysisEngineDescription getRutaAA(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities, String script, boolean debug) throws ResourceInitializationException, InvalidXMLException {
		AnalysisEngineDescription aeDescription = 
			AnalysisEngineFactory.createEngineDescription(RutaAnnotator.class, typeSystemDescription, typePriorities, RutaAnnotator.RUTA_SCRIPT, script, RutaAnnotator.RUTA_DEBUG, debug);
		return aeDescription;
	}
	
	
	private String readScript(String path) throws IOException {
//		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream( getRuleSetPath()+path);
//		String script = IOUtils.toString(inputStream, "UTF-8");
		String script =getRuleSetPath()+path;
		
		File f = new File(script);
		FileInputStream fs = new FileInputStream(f);
		
		return IOUtils.toString(fs, "UTF-8");
	}
	
	
	
	
	
	
}
