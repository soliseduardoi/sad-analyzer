package edu.isistan.uima.unified.analysisengines.opennlp;

import java.util.LinkedList;
import java.util.List;

import opennlp.tools.coref.DiscourseEntity;
import opennlp.tools.coref.LinkerMode;
import opennlp.tools.coref.mention.DefaultParse;
import opennlp.tools.coref.mention.Mention;
import opennlp.tools.lang.english.TreebankLinker;
import opennlp.tools.parser.Parse;
import opennlp.tools.parser.Parser;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.text.AnnotationIndex;
import org.apache.uima.fit.component.JCasAnnotator_ImplBase;
import org.apache.uima.fit.descriptor.ConfigurationParameter;
import org.apache.uima.fit.descriptor.ExternalResource;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;
import org.apache.uima.resource.ResourceInitializationException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;

import edu.isistan.uima.unified.analysisengines.AnnotationGenerator;
import edu.isistan.uima.unified.sharedresources.ProgressMonitorResource;
import edu.isistan.uima.unified.typesystems.nlp.Sentence;

@SuppressWarnings("unused")
public class CoreferenceAnnotator extends JCasAnnotator_ImplBase {
	@ConfigurationParameter(name="parser")
	private String parserName;
	@ConfigurationParameter(name="linker")
	private String linkerName;
	//
	protected Parser parser;
	protected TreebankLinker linker;
	//
	@ExternalResource(key="monitor")
	private ProgressMonitorResource monitorResource;
	private IProgressMonitor subMonitor;
	
	@Override
	public void initialize(UimaContext aContext) throws ResourceInitializationException {
		super.initialize(aContext);
		try {
			//parserName = (String) aContext.getConfigParameterValue("parser");
			//parser = TreebankParser.getParser(parserName);
			//linkerName = (String) aContext.getConfigParameterValue("linker");
			linker = new TreebankLinker(linkerName, LinkerMode.TEST);
		} catch (Exception e) { 
			e.printStackTrace();
		}
	}
	
	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		if(parser == null || linker == null)
			return;
		//
		subMonitor = new SubProgressMonitor(monitorResource.getMonitor(), 1, SubProgressMonitor.PREPEND_MAIN_LABEL_TO_SUBTASK);
		subMonitor.subTask("Annotating coreferences (OpenNLP)");
		//
		String docText = aJCas.getDocumentText();
		AnnotationIndex<Annotation> sAnnotations = aJCas.getAnnotationIndex(Sentence.type);
		
		List<String> sentenceList = new LinkedList<String>();
		for(Annotation sAnnotation : sAnnotations) {
			Sentence sentenceAnnotation = (Sentence) sAnnotation;
			String sentence = sentenceAnnotation.getCoveredText();	
			sentenceList.add(sentence);
		}
				
		String[] sentences = new String[sentenceList.size()];
		for (int i = 0; i < sentences.length; i++) {
			sentences[i] = sentenceList.get(i);
		}
		//
		subMonitor.beginTask(this.getClass().getSimpleName(), sentences.length);
		//
		//int sentencePos = 0;
		for(int sentenceNumber = 0; sentenceNumber < sentences.length; sentenceNumber++) {
			String sentence = sentences[sentenceNumber];
			Parse parse = null;
			//parse = TreebankParser.parseLine(sentence, parser, 1)[0];
			DefaultParse dp = new DefaultParse(parse, sentenceNumber);
			Mention[] extents =	linker.getMentionFinder().getMentions(dp);
			DiscourseEntity[] discourseEntities = linker.getEntities(extents);
			AnnotationGenerator.generateCoreference(0, 0, aJCas);
			//
			subMonitor.worked(1);
		}
		//
		subMonitor.done();
	}

	@Override
	public void destroy() {
		super.destroy();
	}
}