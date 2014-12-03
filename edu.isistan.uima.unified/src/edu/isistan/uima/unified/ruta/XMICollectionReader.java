package edu.isistan.uima.unified.ruta;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;

import org.apache.uima.UimaContext;
import org.apache.uima.cas.impl.XmiCasDeserializer;
import org.apache.uima.collection.CollectionException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.util.Progress;
import org.apache.uima.fit.component.JCasCollectionReader_ImplBase;
import org.apache.uima.fit.descriptor.ConfigurationParameter;
import org.xml.sax.SAXException;

public class XMICollectionReader extends JCasCollectionReader_ImplBase {
	@ConfigurationParameter(name="input")
	private String inputString;

	private URI resourceURI;
	private FileInputStream inputStream;
	private boolean processed;
	
	public void initialize(UimaContext aContext) throws ResourceInitializationException {
		super.initialize(aContext);
		resourceURI = URI.create(inputString);
		try {
			inputStream = new FileInputStream(new File(resourceURI));
			processed = false;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean hasNext() throws IOException, CollectionException {
		return !processed;
	}

	@Override
	public void getNext(JCas jCas) throws IOException, CollectionException {
		try {
			if(inputStream != null)
				XmiCasDeserializer.deserialize(inputStream, jCas.getCas());
			processed = true;
		} catch (SAXException e) {
			throw new CollectionException(e);
		} finally {
			if(inputStream != null)
				inputStream.close();
		}
	}

	@Override
	public Progress[] getProgress() {
		return null;
	}

	@Override
	public void close() throws IOException {
		if(inputStream != null)
			inputStream.close();
		super.close();
	}
	
	@Override
	public void destroy() {
		inputStream = null;
		super.destroy();
	}
}