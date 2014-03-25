package edu.isistan.uima.unified.ruta;

public class RutaScript {
	
	private String pathToScript;
	private boolean enable;
	public String getPathToScript() {
		return pathToScript;
	}
	public void setPathToScript(String pathToScript) {
		this.pathToScript = pathToScript;
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
	}

}
