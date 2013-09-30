package edu.isistan.sadanalyzer.query;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.internal.core.index.Index;

import edu.isistan.reassistant.ccdetector.model.Query;
import edu.isistan.sadanalyzer.util.ReflectionHelper;



public class QueryDispatcher {
	public static Index index;
	@SuppressWarnings("unused")
	private Resource resource = null;
	private ResourceSet resourceSet = null;
	private int maxResultSetSize = 1000000; //Unbounded
	private int numberOfResults = -1; //Unbounded
	
	static {
		IndexFactory.dumpIndexes();
		index = IndexFactory.getInstance();
	}
	
	public QueryDispatcher(ResourceSet resourceSet, Resource resource) {
		this.resourceSet = resourceSet;
		this.resource = resource;
	}
	
	public void addToIndex(final Resource resource) {
		index.executeUpdateCommand(
			new UpdateCommandAdapter() {
				@Override
				public void execute(final IndexUpdater updater) {
					final ResourceIndexer indexer = new ResourceIndexer();
					try {
						indexer.resourceChanged(updater, resource);
					} catch (Exception e) {
						// Put your logging here
					}
				}
			}
		);
	}
	
	public void removeFromIndex(final Resource resource) {
		index.executeUpdateCommand(
			new UpdateCommandAdapter() {
	
				@Override
				public void execute(IndexUpdater updater) {
					updater.deleteResource(resource.getURI());
				}
			}
		);
	}
	
	private QueryContext getQueryContext(final ResourceSet resourceSet) {
		return new QueryContext() {
			public URI[] getResourceScope() {
				final List<URI> result = new ArrayList<URI>();
				index.executeQueryCommand(new QueryCommand() {
					public void execute(QueryExecutor queryExecutor) {
						ResourceQuery<ResourceDescriptor> resourceQuery = IndexQueryFactory.createResourceQuery();
						for (ResourceDescriptor resourceDescriptor : queryExecutor.execute(resourceQuery)) {
							result.add(resourceDescriptor.getURI());
						}
					}
				});
				return result.toArray(new URI[0]);
			}
			public ResourceSet getResourceSet() {
				return resourceSet;
			}
		};
	}
	
	public ResultSet executeQuery(Query query) {
		QueryProcessor queryProcessor = QueryProcessorFactory.getDefault().createQueryProcessor(index);
		queryProcessor.setMaxResultSetSize(maxResultSetSize);
		QueryContext queryContext = getQueryContext(resourceSet);
		ResultSet result = queryProcessor.execute(query, queryContext, numberOfResults);
		return result;
	}
	
	public ResultSet executeQuery(String query) {
		QueryProcessor queryProcessor = QueryProcessorFactory.getDefault().createQueryProcessor(index);
		queryProcessor.setMaxResultSetSize(maxResultSetSize);
		QueryContext queryContext = getQueryContext(resourceSet);
		ResultSet result = queryProcessor.execute(query, queryContext, numberOfResults);
		return result;
	}
	
	public String resolveQueryURIs(String query) {
		String regex = "#[\\d|\\w|\\s]*#";
		boolean finish = false;
		while(!finish) {
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(query);
			if(matcher.find()) {
				int start = matcher.start();
				int end = matcher.end();
				String match = query.substring(start, end);
				String classToResolve = query.substring(start + 1, end - 1);
				EClass eClass = ReflectionHelper.getEClass(classToResolve);
				String classResolved = EcoreUtil.getURI(eClass).toString();
				query = query.replace(match, classResolved);
			}
			else
				finish = true;
		}
		return query;
	}
}
