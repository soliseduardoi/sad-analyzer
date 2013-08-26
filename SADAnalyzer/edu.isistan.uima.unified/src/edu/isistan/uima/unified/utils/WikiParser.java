package edu.isistan.uima.unified.utils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import net.htmlparser.jericho.Attribute;
import net.htmlparser.jericho.Source;



public class WikiParser implements SadParser {

	private static final String SLASH = "/";
	private String urlBase;
	private int lastIndexValid;
	
	
	@Override
	public Section getSad(String path) {
		
		URL url= null;
		try {
			 url= new URL(path);
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		}
		
		urlBase= url.getProtocol()+"://"+url.getHost();
		Source source=null;
		try {
			source = new Source(url);
		} catch (IOException e) {
			
			e.printStackTrace();	
			}
		
		CompositeSection document=  generateStructure(source);
		
		
		return document;
	}

	private CompositeSection generateStructure(Source source) {
		
		
		List<TemplateStructure> templateFormat = new LeerXml().getPlainStructure();
		CompositeSection document= new CompositeSection();		
	
		List<Attribute> urls = source.getURIAttributes();

		validateUrls(templateFormat,urls,document);			

		return document;
	}
	
	public void generate(CompositeSection document) {

		
	}

	private void validateUrls(List<TemplateStructure> template,
			List<Attribute> urls,CompositeSection document ) {

		TemplateStructure firstItem = template.get(0);
		descartarUrls(firstItem, urls);
		int urlIndex = 0;
		int templateIndex = 0;		
		
		boolean valid = urls.size() > 0
				&& validateAgainstTemplate(document, template, templateIndex,
						urls, urlIndex);

		if (valid) {
			System.out.println("Estructura VAlida");
//			structure.setValid();
			descartarUrlsSobrantes(urls, this.lastIndexValid);
//			this.structureWrapped = structure;
//			setSadGenerated(true);
			urls.toString();
		} else {
			System.out.println("Estructura incorrecta");
		}
	}
	

	private void descartarUrls(TemplateStructure templateItem,
			List<Attribute> urls) {
		boolean matching = false;
		int indexFirstMatch = 0;
		for (; !matching && indexFirstMatch < urls.size(); indexFirstMatch++) {
			if (matching(templateItem, urls.get(indexFirstMatch))) {
				matching = true;
			} else {
				urls.remove(indexFirstMatch);
				indexFirstMatch--;
			}
		}

	}
	
	private boolean validateAgainstTemplate(CompositeSection document,
			List<TemplateStructure> template, int templateIndex,
			List<Attribute> urls, int urlIndex) {

		boolean valid = false;
		UrlSection urlSection = new UrlSection(urlBase);

		// Si nodo en el template es un item
		TemplateStructure templateNode = template.get(templateIndex);
		if (templateNode.isItem()) {
			document.addSection(urlSection);
			urlSection.setAtt(urls.get(urlIndex));
			valid = validateItem(document, template, templateIndex, urls,
					urlIndex);

		} else {
			// Seccion con link
			if (!templateNode.isItem() && templateNode.hasLink()) {
				document.addSection(urlSection);
				urlSection.setAtt(urls.get(urlIndex));
				valid = validateSectionWithLink(document, template,
						templateIndex, urls, urlIndex);

			} else {
				// Seccion sin link
				if (!templateNode.hasLink()) {
					valid = validateSectionWithoutLink(document, template,
							templateIndex, urls, urlIndex);
				}
			}

		}
		return valid;

	}

	private boolean validateSectionWithoutLink(CompositeSection document,
			List<TemplateStructure> template, int templateIndex,
			List<Attribute> urls, int urlIndex) {

		boolean valid = false;
		// No hay con que hacer matching por eso no se llama a dicha funcion

		// Si seccion vacia recorro hasta el prox matching
		if (template.get(templateIndex).isEmpty()) {
			/**
			 * Agrego urls hast ael proximo matching...
			 */
			valid = validateEmptySection(document, template, templateIndex,
					urls, urlIndex);

		} else {// Sin link y con hijos. se llama recursivamente solo avanzando
				// en el template porq como no tiene link no hay que avanzar en
				// la pagina

			valid = validateAgainstTemplate(document, template, ++templateIndex,
					urls, urlIndex);

		}
		return valid;
	}
	
	private boolean validateItem(CompositeSection document,
			List<TemplateStructure> template, int templateIndex,
			List<Attribute> urls, int urlIndex) {
		boolean ret;

		TemplateStructure templateNode = template.get(templateIndex);
		if (matching(templateNode, urls.get(urlIndex))) {

			// Avanzo en ambas estructuras *1
			if (templateIndex < template.size() - 1
					&& urlIndex < urls.size() - 1) {
				ret = validateAgainstTemplate(document, template,
						++templateIndex, urls, ++urlIndex);
			} else {
				// Recorri el template entero. Estructura valida
				if (templateIndex == template.size() - 1) {
					ret = true;
					this.lastIndexValid = urlIndex;
				} else {
					// Recorri las urls completas. Estructura invalida
					ret = false;
				}
			}
		} else {
			// Corto. estructura invalida
			ret = false;
		}
		return ret;
	}
	
	private boolean matching(TemplateStructure templateItem, Attribute url) {

		// Reemplazo los espacios en blanco en los titulos del template por
		// guines bajpos para pder comparar con la url en la wiki
		String title = templateItem.getTitle().replaceAll(" ", "_");
		// Obtengo la url del tag actual
		String rawUrl = url.getValue().substring(1, url.getValue().length());
		// Me quedo con el final despues de la ultima barra
		String[] linkSplit = rawUrl.split(SLASH);
		String link = linkSplit[linkSplit.length - 1];

		/**
		 * A veces el link en la url tiene agregado adelante el nombre del
		 * proyecto o algun otro valor entonces busco las diferentes palabras
		 * del titulo del template en la url
		 */

		// String[] titlesPotentials= templateItem.getTitle().split(" ");
		// String titlePotential="";
		//
		// for (int i = 0; i < titlesPotentials.length; i++) {
		// titlePotential= titlesPotentials[i];
		// if(link.contains(titlePotential)){
		// return true;
		// }
		//
		//
		// }

		return link.toLowerCase().contains(title.toLowerCase());
	}
	
	private boolean validateSectionWithLink(CompositeSection document,
			List<TemplateStructure> template, int templateIndex,
			List<Attribute> urls, int urlIndex) {

		boolean valid = false;
		TemplateStructure templateNode = template.get(templateIndex);
		if (matching(templateNode, urls.get(urlIndex))) {

			// Seccion VAcia
			if (templateNode.isEmpty()) {
				/**
				 * Agrego urls hast ael proximo matching...
				 */
				valid = validateEmptySection(document, template, templateIndex,
						urls, urlIndex);

			} else {
				// no puedo preguntar por el siguiente del templat y de las
				// url.. porqel template tambien es lineal. Ver d eusar las dos
				// estructuras mezcladas.

				if (templateIndex < template.size() - 1
						&& urlIndex < urls.size() - 1) {
					// debo validar hijos y luego avanzar. COmo la estructura
					// del template es lineal. Simplemente llamo recursivamente
					// avanzando en las dos estructuras

					valid = validateAgainstTemplate(document, template,
							++templateIndex, urls, ++urlIndex);

				} else {

					if (templateIndex < template.size() - 1) {
						valid = true;
						this.lastIndexValid = urlIndex;
					} else {
						// Recorri las urls completas. Estructura invalida
						valid = false;
					}

				}
			}

		} else {
			valid = false;
		}
		return valid;
	}
	
	private boolean validateEmptySection(CompositeSection document,
			List<TemplateStructure> template, int templateIndex,
			List<Attribute> urls, int urlIndex) {

		boolean ret = false;

		if (templateIndex < template.size() - 1) {

			templateIndex = getNextItemToMatch(template, templateIndex);
			TemplateStructure templateItemNext = template.get(templateIndex);
			urlIndex = addUrlUntilNextMatch(document, templateItemNext, urls,
					urlIndex);
			ret = validateAgainstTemplate(document, template, templateIndex,
					urls, urlIndex);

		} else {

			// Si entra aca se deben validar el resto de las urls. Ver la forma
			// de solucionar porque va agregar todas las que siguen a
			// continuacion
			urlIndex = addRemainingUrls(document, urls, urlIndex);
			ret = true;
			this.lastIndexValid = urlIndex;

		}
		return ret;
	}

	/**
	 * Retorna el proximo elemento con el cual hacer matching. Avanza hasta que
	 * el nodo del template tenga un link
	 * 
	 * @param templateIter
	 * @return
	 */

	private int getNextItemToMatch(List<TemplateStructure> template, int index) {

		TemplateStructure ret = template.get(index);
		while (!ret.hasLink()) {
			if (index < template.size())
				ret = template.get(++index);
		}

		return index;
	}
	
	private void descartarUrlsSobrantes(List<Attribute> urls, int index) {

		while (index < urls.size() - 1) {
			urls.remove(index);

		}

	}
	/**
	 * Avanza en el iterador mientra no haga matching.
	 * 
	 * @param wrapper
	 * @param templateItemNext
	 * @param urlsIter
	 */
	private int addUrlUntilNextMatch(CompositeSection document,
			TemplateStructure templateItemNext, List<Attribute> urls,
			int urlIndex) {

		// Mientras haya urls y no haga matching sigue avanzando ene el iterador
		while (urlIndex < urls.size()
				&& !matching(templateItemNext, urls.get(urlIndex))) {
			UrlSection child = new UrlSection(urlBase);
			child.setAtt(urls.get(urlIndex));
			document.addSection(child);
			urlIndex++;
		}
		return urlIndex;

	}
	
	/**
	 * Avanza hasta el final del iterador
	 * 
	 * @param wrapper
	 * @param urlsIter
	 */
	private int addRemainingUrls(CompositeSection document, List<Attribute> urls,
			int urlIndex) {

		while (urlIndex < urls.size()) {
			UrlSection child = new UrlSection(urlBase);
			child.setAtt(urls.get(urlIndex));
			document.addSection(child);
			urlIndex++;
		}

		return urlIndex;

	}
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		double t1, t2;
        t1 = System.currentTimeMillis();
		
		String path= "https://wiki.sei.cmu.edu/sad/index.php/The_Java_Pet_Store_SAD";
		
		SadParser parser= SadParserFactory.getParser(SadParserFactory.WIKI);
		
		CompositeSection doc= (CompositeSection) parser.getSad(path);
		
     
		t2= System.currentTimeMillis();
		
		System.out.println("Tiempo de ejecucion: "+(t2-t1)/1000.0);

	}


}
