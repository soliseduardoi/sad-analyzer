package edu.isistan.uima.unified.ruta;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.component.JCasAnnotator_ImplBase;
import org.apache.uima.fit.descriptor.ConfigurationParameter;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceConfigurationException;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.ruta.engine.Ruta;
import org.apache.uima.ruta.engine.RutaEngine;
import org.apache.uima.util.InvalidXMLException;

public class RutaAnnotator extends JCasAnnotator_ImplBase {
	public static final String RUTA_SCRIPT = "script";
	@ConfigurationParameter(name = RUTA_SCRIPT)
	private String script;
	
	public static final String RUTA_DEBUG = "debug";
	@ConfigurationParameter(name = RUTA_DEBUG)
	private boolean debug;

	@Override
	public void process(JCas jCas) throws AnalysisEngineProcessException {
		try {
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put(RutaEngine.PARAM_DEBUG, debug);
			Ruta.apply(jCas.getCas(), script, parameters);
		} catch (InvalidXMLException e) {
			e.printStackTrace();
		} catch (ResourceInitializationException e) {
			e.printStackTrace();
		} catch (ResourceConfigurationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
}
