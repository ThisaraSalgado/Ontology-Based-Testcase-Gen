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
		/*String filename = "C:/common12-Copy-Copy.rdf";
		System.out.println("file loaded");
		// Create an empty model
		Model model = ModelFactory.createDefaultModel();
				
		// Use the FileManager to find the input file
		InputStream in = FileManager.get().open(filename);

		if (in == null)
			throw new IllegalArgumentException("File: "+filename+" not found");

		// Read the RDF/XML file
		//have to delete this code segment
		model.read(in, null);*/
		//========
		String actor = "Admin";
		String par = "Update";
		String obj = "Group";
		
		
		ArrayList<String> resultDependency;
		resultDependency = checkImplicits(actor, par);
		resultDependency.add(par);
		
		ArrayList<String> actionProperties;
		actionProperties = getActionDataProperties(actor,resultDependency);
		
		ArrayList<String> dataProperties;
		dataProperties = getObjectDataProperties(actor, par, obj);
		
		System.out.println("size of result dependancy array " + resultDependency.size());
		System.out.println("size of result actionproperty array " + actionProperties.size());
		System.out.println("size of result dataproperty array " + dataProperties.size());
	
		for(int i = 0 ; i<resultDependency.size();i++){
			System.out.println("has dependency " + resultDependency.get(i));
		}
		
		for(int j = 0 ; j<actionProperties.size();j++){
			System.out.println("action properties " + actionProperties.get(j));
		}
		
		for(int k = 0 ; k<dataProperties.size();k++){
			System.out.println("data properties " + dataProperties.get(k));
		}
		
		/*
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
			//System.out.println("in file 1");
			QuerySolution binding = results.nextSolution();
			Resource subj = (Resource) binding.get("x");
		    String resultString = subj.getURI();
		    String result;
		    //get result as string without URI prefix, but different approach to get in from the query execution
		    System.out.println(resultString.substring(resultString.lastIndexOf("#") +1));
		    resultadoConsulta.add(resultString.substring(resultString.lastIndexOf("#") +1));
		}
		if (resultadoConsulta.size()==0){
			System.out.println("To such relationship, generate test cases manually");
		}else{
			for(int i = 0;i<resultadoConsulta.size();i++){
		    	System.out.println("Create Group Using " + resultadoConsulta.get(i));
		    	//result = resultString.substring(resultString.lastIndexOf("#") +1);
		    }
		}*/
		
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
		//String obj = object;
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

	@Override
	public ArrayList<String> checkImplicits(String actor, String action) {
		String filename = "C:/common12-Copy-Copy.rdf";
		System.out.println("called here");
		// Create an empty model
		Model model = ModelFactory.createDefaultModel();
				
		// Use the FileManager to find the input file
		InputStream in = FileManager.get().open(filename);

		if (in == null)
			throw new IllegalArgumentException("File: "+filename+" not found");

		// Read the RDF/XML file
		model.read(in, null);
		String act = actor;
		String pred = action;
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
						" test:"+act+" test:hasAction test:"+pred+" ."+
						" test:"+pred+" test:hasDependency ?x ."+
						"}");
		
		String queryString = pss.toString();
		System.out.println(queryString);
		Query query = QueryFactory.create(queryString);
		QueryExecution qexec = QueryExecutionFactory.create(query, model) ;
		ResultSet results = qexec.execSelect() ;
		
		ArrayList<String> hasDependecyList = new ArrayList<String>();
		while (results.hasNext())
		{
			//System.out.println("in file 1");
			QuerySolution binding = results.nextSolution();
			Resource subj = (Resource) binding.get("x");
		    String resultString = subj.getURI();
		    String result;
		    //get result as string without URI prefix, but different approach to get in from the query execution
		    System.out.println(resultString.substring(resultString.lastIndexOf("#") +1));
		    hasDependecyList.add(resultString.substring(resultString.lastIndexOf("#") +1));
			/*String ob = binding.getLiteral("x").toString();
			System.out.println();*/
		    
		}
		if (hasDependecyList.isEmpty()){
			System.out.println("dependency set empty");
			return hasDependecyList;
			
		}
		else{
			System.out.println("has dependency array");
			for(int i = 0;i<hasDependecyList.size();i++){
		    	System.out.println("has dependency " + hasDependecyList.get(i));
		    	//result = resultString.substring(resultString.lastIndexOf("#") +1);
		    }
			return hasDependecyList;
		}
		
	}

	@Override
	public ArrayList<String> getActionDataProperties(String actor,ArrayList<String> actions) {
		String filename = "C:/common12-Copy-Copy.rdf";
		System.out.println("file loaded");
		// Create an empty model
		Model model = ModelFactory.createDefaultModel();
				
		// Use the FileManager to find the input file
		InputStream in = FileManager.get().open(filename);

		if (in == null)
			throw new IllegalArgumentException("File: "+filename+" not found");

		// Read the RDF/XML file
		model.read(in, null);
		ArrayList<String> resultadoConsulta = new ArrayList<String>();
		int actionsCount = actions.size();
		for(int i = 0;i<actionsCount;i++){
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
							" test:"+actor+" test:hasAction test:"+actions.get(i)+" ."+
							" test:"+actions.get(i)+" ?x ?y."+
							" ?x a owl:DatatypeProperty ."+
							"}");
			
			String queryString = pss.toString();
			System.out.println(queryString);
			Query query = QueryFactory.create(queryString);
			QueryExecution qexec = QueryExecutionFactory.create(query, model) ;
			ResultSet results = qexec.execSelect() ;
			
			while (results.hasNext())
			{
				//System.out.println("in file 1");
				QuerySolution binding = results.nextSolution();
				Resource subj = (Resource) binding.get("x");
			    String resultString = subj.getURI();
			    String result;
			    //get result as string without URI prefix, but different approach to get in from the query execution
			    System.out.println(resultString.substring(resultString.lastIndexOf("#") +1));
			    resultadoConsulta.add(resultString.substring(resultString.lastIndexOf("#") +1));
				/*String ob = binding.getLiteral("x").toString();
				System.out.println();*/
			    
			}
			if (resultadoConsulta.size()==0){
				System.out.println("To such relationship, generate test cases manually");
				//return resultadoConsulta;
			}
			else{
				for(int j = 0;j<resultadoConsulta.size();j++){
			    	System.out.println("Create Group Using " + resultadoConsulta.get(j));
			    	//result = resultString.substring(resultString.lastIndexOf("#") +1);
			    }
				
			}
		}
		return resultadoConsulta;
	}

	@Override
	public ArrayList<String> getObjectDataProperties(String actor, String action, String object) {
		String filename = "C:/common12-Copy-Copy.rdf";
		System.out.println("file loaded");
		// Create an empty model
		Model model = ModelFactory.createDefaultModel();
				
		// Use the FileManager to find the input file
		InputStream in = FileManager.get().open(filename);

		if (in == null)
			throw new IllegalArgumentException("File: "+filename+" not found");

		// Read the RDF/XML file
		//have to delete this code segment
		model.read(in, null);
		String act = actor;
		String pred = action;
		String obj = object;
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
						" test:"+actor+" test:hasAction test:"+pred+" ."+
						" test:"+pred+" test:hasObject test:"+obj+" ."+
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
			//System.out.println("in file 1");
			QuerySolution binding = results.nextSolution();
			Resource subj = (Resource) binding.get("x");
		    String resultString = subj.getURI();
		    String result;
		    //get result as string without URI prefix, but different approach to get in from the query execution
		    System.out.println(resultString.substring(resultString.lastIndexOf("#") +1));
		    resultadoConsulta.add(resultString.substring(resultString.lastIndexOf("#") +1));
		}
		if (resultadoConsulta.size()==0){
			System.out.println("To such relationship, generate test cases manually");
		}
		else{
			for(int i = 0;i<resultadoConsulta.size();i++){
		    	System.out.println("Create Group Using " + resultadoConsulta.get(i));
		    	//result = resultString.substring(resultString.lastIndexOf("#") +1);
		    }
		}
		return resultadoConsulta;
	}

}
