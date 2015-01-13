package edu.isistan.uima.unified.ruta;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

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
	private List<RutaScript> scripts = new ArrayList<RutaScript>();
	private boolean rutaScriptProcessed= false;
	TypeSystemDescription typeSystemDescription; 
	TypePriorities typePriorities;
	private String languaje;
	
			
	private  String getRuleSetPath() {
		return getModelsPath() + "/ruta/"+languaje+"/";
	}
	
	private  String getModelsPath() {
		String modelsPath = null;
		if(modelsPath == null || modelsPath.isEmpty())
			modelsPath = System.getenv("MODELS_PATH");
		if(modelsPath == null || modelsPath.isEmpty())
			modelsPath = System.getProperty("MODELS_PATH");
		return modelsPath;
	}

	
	public RutaEngine(String languaje) {		
		
		this.languaje=languaje;		
		try {
			typeSystemDescription = getTypeSystemDescription();
			typePriorities =getTypePriorities();
		} catch (ResourceInitializationException e) {
			System.out.println("Error al levantar los tipos de UIMA");
			e.printStackTrace();
		}
		scripts = getScriptRuta(getRuleSetPath());		
	}
	
	public List<RutaScript> getScriptRuta(String path){
		List<RutaScript> list = new ArrayList<RutaScript>();
		if(path!=null){
			File rootDirectory = new File(path);
			if(rootDirectory.isDirectory()){
				for (File file : rootDirectory.listFiles()) {
				
					String name= file.getName();			
				
					if (RUTA_EXT.equals(name.substring(name.length()-4, name.length()))) {
					
						RutaScript script = new RutaScript(file.getPath());
						script.setName(name.substring(0, name.length()-5));
						script.setList(getScriptRuta(rootDirectory+"/"+script.getName()));
						list.add(script);				
					}
			   }
			}
			
	   }
		
		return list;
	}
	
	public void execute(String inputFile, String outputFile) {
		
		try{
		boolean debug = true;
		long startTime = System.currentTimeMillis();
			
		CollectionReaderDescription reader = getXMIReaderCR(typeSystemDescription, typePriorities, inputFile);
		
//		AnalysisEngineDescription writer = getXMIWriterCC(typeSystemDescription, typePriorities, outputFile);
		int index= 0;
		JCasIterable iterable = SimplePipeline.iteratePipeline(
				reader, 
				getRutaAA(typeSystemDescription, typePriorities,scripts.get(index++).getScriptCode(), debug),
				getRutaAA(typeSystemDescription, typePriorities,scripts.get(index++).getScriptCode(), debug),
				getRutaAA(typeSystemDescription, typePriorities,scripts.get(index++).getScriptCode(), debug),
				getRutaAA(typeSystemDescription, typePriorities,scripts.get(index++).getScriptCode(), debug),
				getRutaAA(typeSystemDescription, typePriorities,scripts.get(index++).getScriptCode(), debug),
				getRutaAA(typeSystemDescription, typePriorities,scripts.get(index++).getScriptCode(), debug),
				getRutaAA(typeSystemDescription, typePriorities,scripts.get(index++).getScriptCode(), debug),
				getRutaAA(typeSystemDescription, typePriorities,scripts.get(index++).getScriptCode(), debug),
				getRutaAA(typeSystemDescription, typePriorities,scripts.get(index++).getScriptCode(), debug),
				getRutaAA(typeSystemDescription, typePriorities,scripts.get(index).getScriptCode(), debug)
				);
		for(JCas jCas : iterable) {
			System.out.printf("Found %d Sentences instances%n", JCasUtil.select(jCas, Sentence.class).size());
			System.out.printf("Found %d token instances%n", JCasUtil.select(jCas, Token.class).size());			
			System.out.printf("Found %d crosscutting concern instances%n", JCasUtil.select(jCas, CrosscuttingConcern.class).size());
		}
		
		long endTime = System.currentTimeMillis();
		long time=  endTime - startTime;
		
		System.out.println("Tiempo pipeline: "+ Long.toString(time/1000)+" seg.");
		
	} catch (ResourceInitializationException e) {
		e.printStackTrace();
	} catch (UIMAException e) {
		e.printStackTrace();
	} 		
		
	}
	
	
	private TypeSystemDescription getTypeSystemDescription() throws ResourceInitializationException {
		System.setProperty("org.apache.uima.fit.type.import_pattern", "classpath*:desc/**/*.xml");
//		System.setProperty("org.uimafit.type.import_pattern", "classpath*:desc/typesystems/**/*.xml");
		TypeSystemDescriptionFactory.forceTypeDescriptorsScan();                      
		return TypeSystemDescriptionFactory.createTypeSystemDescription();
	}
	
	private TypePriorities getTypePriorities() throws ResourceInitializationException {
		return TypePrioritiesFactory.createTypePriorities(
		"edu.isistan.uima.unified.typesystems.sad.SadSection",
		"edu.isistan.uima.unified.typesystems.sad.Sad",
		"edu.isistan.uima.unified.typesystems.nlp.Sentence",
		"edu.isistan.uima.unified.typesystems.domain.CrosscuttingConcern",
		"edu.isistan.uima.unified.typesystems.srl.Predicate",
		"edu.isistan.uima.unified.typesystems.srl.Structure",
		"edu.isistan.uima.unified.typesystems.srl.Argument",
		"edu.isistan.uima.unified.typesystems.nlp.SDDependency",
		"edu.isistan.uima.unified.typesystems.nlp.Chunk",
		"edu.isistan.uima.unified.typesystems.nlp.Entity",
		"edu.isistan.uima.unified.typesystems.srl.Role",
		"edu.isistan.uima.unified.typesystems.domain.DomainNumber",
		"edu.isistan.uima.unified.typesystems.nlp.Token",
		"edu.isistan.uima.unified.typesystems.wordnet.Sense");
//		return null;
	}
	
	private CollectionReaderDescription getXMIReaderCR(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities, String inputFile) throws ResourceInitializationException, InvalidXMLException {
		CollectionReaderDescription crDescription = 
			CollectionReaderFactory.createReaderDescription(XMICollectionReader.class, typeSystemDescription, typePriorities, "input", inputFile);
		return crDescription;
	}
	
//	private AnalysisEngineDescription getXMIWriterCC(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities, String outputFile) throws ResourceInitializationException, InvalidXMLException {
//		AnalysisEngineDescription aeDescription = 
//				AnalysisEngineFactory.createEngineDescription(XMIWriterConsumer.class, typeSystemDescription, typePriorities, "output", outputFile);
//		return aeDescription;
//	}
	
	private AnalysisEngineDescription getRutaAA(TypeSystemDescription typeSystemDescription, TypePriorities typePriorities, String script, boolean debug) throws ResourceInitializationException, InvalidXMLException {
		AnalysisEngineDescription aeDescription = 
			AnalysisEngineFactory.createEngineDescription(RutaAnnotator.class, typeSystemDescription, typePriorities, RutaAnnotator.RUTA_SCRIPT, script, RutaAnnotator.RUTA_DEBUG, debug);
		return aeDescription;
	}
	
		
	
public void executeMultiplesPipeline(String inputFile) {
		
		try{
		boolean debug = true;
		long startTime = System.currentTimeMillis();
				
		CollectionReaderDescription reader = getXMIReaderCR(typeSystemDescription, typePriorities, inputFile);
		Collection<CrosscuttingConcern> concerns = new Vector<CrosscuttingConcern>();
//		AnalysisEngineDescription writer = getXMIWriterCC(typeSystemDescription, typePriorities, outputFile);
//		int index= 0;
//		Collection<Sentence> sentences = null;
//		Collection<Token> tokens = null;
//		Collection<CrosscuttingConcern> concerns = new Vector<CrosscuttingConcern>();
//		ArrayList<JCasIterable> iterables= new ArrayList<JCasIterable>();
		for (int i = 0; i < scripts.size(); i++) {
			
			RutaScript sriptConcern = scripts.get(i);
			
			if(sriptConcern.isEnable()){
				//iiNVESTIGAR PIPELINE CPE
//				CpeBuilder builder = new CpeBuilder();
//				builder.createCpe(null);
//				builder.setAnalysisEngine(getRutaAA(typeSystemDescription, typePriorities,sriptConcern.getScriptCode(), debug));
//				builder.setReader(reader);
//				
//		
//		
//		   CpePipeline.runPipeline(builder.getCpeDescription().ge, arg1);
			JCasIterable iterable = SimplePipeline.iteratePipeline(reader, 
					getRutaAA(typeSystemDescription, typePriorities,sriptConcern.getScriptCode(), debug));
//			sriptConcern.setJCasIter(iterable);
			
			
			for(JCas jCas : iterable) {
//				sriptConcern.setjCas(jCas);
				 for (CrosscuttingConcern concern: JCasUtil.select(jCas, CrosscuttingConcern.class)){
					 int begin= concern.getSentence().getBegin();
					 int end= concern.getSentence().getEnd();
					 SentenceMark sentenceW= new SentenceMark(begin, end);
					 ImpactWrapper impacto = new ImpactWrapper();
					 impacto.setSentence(sentenceW);
					 sriptConcern.addImpact(impacto);
				  }			
			
				}
			}
		
		}
		
		long endTime = System.currentTimeMillis();
		long time=  endTime - startTime;
		
		System.out.println("Tiempo pipeline multiple: "+ Long.toString(time/1000)+"seg.");
		rutaScriptProcessed=true;
			
		
	} catch (ResourceInitializationException e) {
		e.printStackTrace();
	} catch (UIMAException e) {
		e.printStackTrace();
	} 		
		
	}


public void executePipelineSpecific(String inputFile) {
	
	try{
		boolean debug = true;
		long startTime = System.currentTimeMillis();
				
		CollectionReaderDescription reader = getXMIReaderCR(typeSystemDescription, typePriorities, inputFile);
		executeScript(reader,scripts);		
		
		long endTime = System.currentTimeMillis();
		long time=  endTime - startTime;
		
		System.out.println("Tiempo pipeline multiple: "+ Long.toString(time/1000)+"seg.");
		rutaScriptProcessed=true;		
	
	} catch (ResourceInitializationException e) {
		e.printStackTrace();
	} catch (UIMAException e) {
		e.printStackTrace();
	} 		
}

private void executeScript(CollectionReaderDescription reader, List<RutaScript> scriptsList) throws ResourceInitializationException, UIMAException{
	for (int i = 0; i < scriptsList.size(); i++) {
		
		RutaScript scriptConcern = scriptsList.get(i);
		
		if(scriptConcern.isEnable()){
			scriptConcern.resetAddImpact();  
			if(!scriptConcern.getList().isEmpty()){
				executeScript(reader, scriptConcern.getList());
			}
			JCasIterable iterable = SimplePipeline.iteratePipeline(reader, 
					getRutaAA(typeSystemDescription, typePriorities,scriptConcern.getScriptCode(), true));
			
			///seguir probando con las otras librerias de dependencia
			for(JCas jCas : iterable) {
				 for (CrosscuttingConcern concern: JCasUtil.select(jCas, CrosscuttingConcern.class)){
					 int begin= concern.getSentence().getBegin();
					 int end= concern.getSentence().getEnd();
					 SentenceMark sentenceW= new SentenceMark(begin, end);
					 ImpactWrapper impacto = new ImpactWrapper();
					 impacto.setSentence(sentenceW);
					 scriptConcern.addImpact(impacto);
				 }			
			}
		}
	
	}
}

		/**
		 * @return the scripts
		 */
		public List<RutaScript> getScripts() {
			return scripts;
		}




	public Vector<CrosscuttingConcernAdapted> getConcern()
		 {
	Vector<CrosscuttingConcernAdapted> concerns= new Vector<CrosscuttingConcernAdapted>();
	for (Iterator scriptIterator = scripts.iterator(); scriptIterator.hasNext();) {			
		
		RutaScript rutaScript = (RutaScript) scriptIterator.next();			
		CrosscuttingConcernAdapted concernAdapted = rutaScript.getConcernsAdapted();
		concernAdapted.setName(rutaScript.getName());			
		
		concerns.add(concernAdapted);		
		
	}
	return concerns;
}
	
	
	
	
}
