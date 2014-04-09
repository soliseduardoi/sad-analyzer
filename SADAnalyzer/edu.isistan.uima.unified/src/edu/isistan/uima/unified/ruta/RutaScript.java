package edu.isistan.uima.unified.ruta;

import java.io.File;
import java.io.FileInputStream;
import java.util.Collection;

import org.apache.commons.io.IOUtils;
import org.apache.uima.fit.pipeline.JCasIterable;
import org.apache.uima.jcas.JCas;

import edu.isistan.uima.unified.typesystems.domain.CrosscuttingConcern;

public class RutaScript {
	
	private String pathToScript;
	private boolean enable;
	private String scriptCode;
	private Collection<CrosscuttingConcern> concerns;
	private JCas jCas;
	private JCasIterable jCasIter;
	private String scriptName;
	/**
	 * @return the scriptCode
	 */
	public String getScriptCode() {
		return scriptCode;
	}
	
	
	/**
	 * @return the jCas
	 */
	public JCas getjCas() {
		return jCas;
	}

	/**
	 * @return the concerns
	 */
	public Collection<CrosscuttingConcern> getConcerns() {
		return concerns;
	}


	/**
	 * @param concerns the concerns to set
	 */
	public void setConcerns(Collection<CrosscuttingConcern> concerns) {
		this.concerns = concerns;
	}


	public String getPathToScript() {
		return pathToScript;
	}
	public void setPathToScript(String pathToScript) {
		this.pathToScript = pathToScript;
	}
	/**
	 * @return the jCasIter
	 */
	public JCasIterable getjCasIter() {
		return jCasIter;
	}


	/**
	 * @param jCasIter the jCasIter to set
	 */
	public void setjCasIter(JCasIterable jCasIter) {
		this.jCasIter = jCasIter;
	}


	public boolean isEnable() {
		return enable;
	}
	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	public RutaScript(String pathToScript) {
		super();
		this.pathToScript = pathToScript;
		this.enable = true;
		this.scriptCode =readScript(pathToScript);
	}

	
	private String readScript(String path)  {

	 try{
		File f = new File(path);
		FileInputStream fs = new FileInputStream(f);
		
		return IOUtils.toString(fs, "UTF-8");
	 }catch (Exception e) {
		return "";
	}
	 }



	/**
	 * @param jCas the jCas to set
	 */
	public void setjCas(JCas jCas) {
		this.jCas = jCas;
	}


	public void setJCasIter(JCasIterable iterable) {
		this.jCasIter=iterable;
		
	}


	public String getName() {
		// TODO Auto-generated method stub
		return scriptName;
	}


	public void setName(String name) {
		this.scriptName=name;
		
	}


	
}
