package edu.isistan.uima.unified.ruta;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.uima.fit.pipeline.JCasIterable;
import org.apache.uima.jcas.JCas;

public class RutaScript {
	
	private String pathToScript;
	private boolean enable;
	private String scriptCode;
	private List<RutaScript> list;
	
	private CrosscuttingConcernAdapted concernsAdapted = new CrosscuttingConcernAdapted();
	/**
	 * @return the impact
	 */



	/**
	 * @return the concernsAdapted
	 */
	public CrosscuttingConcernAdapted getConcernsAdapted() {
		return concernsAdapted;
	}


	/**
	 * @param concernsAdapted the concernsAdapted to set
	 */
	public void setConcernsAdapted(CrosscuttingConcernAdapted concernsAdapted) {
		this.concernsAdapted = concernsAdapted;
	}


	/**
	 * @param impact the impact to set
	 */
	public void addImpact(ImpactWrapper impact) {
		this.concernsAdapted.getImpacts().add(impact);
	}
	
	public void resetAddImpact(){
		this.concernsAdapted.getImpacts().clear();
	}


	/**
	 * @return the scriptName
	 */
	public String getScriptName() {
		return scriptName;
	}


	/**
	 * @param scriptName the scriptName to set
	 */
	public void setScriptName(String scriptName) {
		this.scriptName = scriptName;
	}


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
		this.enable = false;
		this.scriptCode =readScript(pathToScript);
		this.list=new ArrayList<RutaScript>();
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
		
		return scriptName;
	}


	public void setName(String name) {
		this.scriptName=name;
		
	}


	public List<RutaScript> getList() {
		return list;
	}


	public void setList(List<RutaScript> list) {
		this.list = list;
	}


	
}
