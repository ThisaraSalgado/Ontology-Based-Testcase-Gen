package com.finalyrSE.serviceimpl;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.jena.query.ParameterizedSparqlString;
//import org.apache.http.client.cache.Resource;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.util.FileManager;
import org.springframework.stereotype.Service;
import org.apache.jena.rdf.model.Resource;
import com.finalyrSE.service.JenaTestService;

@Service("jenatest")
public class JenaTestServiceImpl implements JenaTestService {
	
	@Override
	public String testJena(){
		String filename = "C:/Users/ThisaraPC/common12-Copy.rdf";
		System.out.println("file loaded");
		// Create an empty model
		Model model = ModelFactory.createDefaultModel();
				
		// Use the FileManager to find the input file
		InputStream in = FileManager.get().open(filename);

		if (in == null)
			throw new IllegalArgumentException("File: "+filename+" not found");

		// Read the RDF/XML file
		model.read(in, null);
		String par = "Create";
		ParameterizedSparqlString pss = new ParameterizedSparqlString();
		
		//pss.setLiteral(par, "Create");
		// List all the resources with the property "vcard:FN"
		pss.setCommandText("PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" +
						"PREFIX owl: <http://www.w3.org/2002/07/owl#>"+
						"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
						"PREFIX test: <http://www.semanticweb.org/prabhavi/ontologies/2017/9/untitled-ontology-53#>" +
						"PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>" +
						"PREFIX skos: <http://www.w3.org/2004/02/skos/core#>" +
						"SELECT ?x " +
						"WHERE {" +
						" test:"+par+" test:hasObject ?x ."+
						"}");
		
		String queryString = pss.toString();
		System.out.println(queryString);
		Query query = QueryFactory.create(queryString);
		QueryExecution qexec = QueryExecutionFactory.create(query, model) ;
		ResultSet results = qexec.execSelect() ;
		
		while (results.hasNext())
		{
			System.out.println("in file 1");
			QuerySolution binding = results.nextSolution();
			Resource subj = (Resource) binding.get("x");
		    String resultString = subj.getURI();
		    String result;
		    //get result as string without URI prefix, but different approach to get in from the query execution
		    System.out.println(resultString.substring(resultString.lastIndexOf("#") +1));
		    result = resultString.substring(resultString.lastIndexOf("#") +1);
		    
		}
		return null;
	}

}
