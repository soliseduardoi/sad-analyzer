package edu.isistan.uima.unified.ruta;

import java.util.ArrayList;
import java.util.List;

public class CrosscuttingConcernAdapted {

	private String name;
	
	List<ImpactWrapper> impacts= new ArrayList<ImpactWrapper>();

	public void setName(String name) {
		this.name= name;
		
	}

	public List<ImpactWrapper> getImpacts() {
		
		return impacts;
	}

	public String getName() {
		
		return this.name;
	}

}
