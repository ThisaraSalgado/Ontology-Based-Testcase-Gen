package com.finalyrSE.serviceimpl;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

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
		String actor = "Admin";
		String par = "Create";
		String obj = "Group";
		ParameterizedSparqlString pss = new ParameterizedSparqlString();
		
		//pss.setLiteral(par, "Create");
		// List all the resources with the property "vcard:FN"
		pss.setCommandText("PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" +
						"PREFIX owl: <http://www.w3.org/2002/07/owl#>"+
						"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
						"PREFIX test: <http://www.semanticweb.org/prabhavi/ontologies/2017/9/untitled-ontology-53#>" +
						"PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>" +
						"PREFIX skos: <http://www.w3.org/2004/02/skos/core#>" +
						"SELECT ?x ?y " +
						"WHERE {" +
						" test:"+actor+" test:hasAction test:"+par+" ."+
						" test:"+par+" test:hasObject test:"+obj+" ."+
						" test:"+obj+" ?x ?y ."+
						" ?x a owl:DatatypeProperty ."+
						"}");
		
		String queryString = pss.toString();
		System.out.println(queryString);
		Query query = QueryFactory.create(queryString);
		QueryExecution qexec = QueryExecutionFactory.create(query, model) ;
		ResultSet results = qexec.execSelect() ;
		
		ArrayList<String> resultadoConsulta = new ArrayList<String>();
		while (results.hasNext())
		{
			System.out.println("in file 1");
			QuerySolution binding = results.nextSolution();
			Resource subj = (Resource) binding.get("x");
		    String resultString = subj.getURI();
		    String result;
		    //get result as string without URI prefix, but different approach to get in from the query execution
		    System.out.println(resultString.substring(resultString.lastIndexOf("#") +1));
		    resultadoConsulta.add(resultString.substring(resultString.lastIndexOf("#") +1));
		    System.out.println("from array " + resultadoConsulta.get(0));
		    result = resultString.substring(resultString.lastIndexOf("#") +1);
			/*String ob = binding.getLiteral("x").toString();
			System.out.println();*/
		    
		}
		return null;
	}

	@Override
	public String jenaWithParam(String actor, String action, String object) {
		String filename = "C:/common12-Copy.rdf";
		System.out.println("file loaded");
		// Create an empty model
		Model model = ModelFactory.createDefaultModel();
				
		// Use the FileManager to find the input file
		InputStream in = FileManager.get().open(filename);

		if (in == null)
			throw new IllegalArgumentException("File: "+filename+" not found");

		// Read the RDF/XML file
		model.read(in, null);
		String act = actor;
		String par = action;
		//String obj = "Group";
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
						" test:"+act+" test:hasAction test:"+par+" ."+
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
