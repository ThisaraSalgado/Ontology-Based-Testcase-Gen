package com.finalyrSE.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

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
import org.apache.jena.rdf.model.Resource;


public class JenaTest {

	public static void main(String[] args) throws IOException {
		sparqlTestNewClassInstanceString();
		//sparqlTestNewClassInstanceStringURL();

	}
	
	//Get instances of a particular class
			static void sparqlTestNewClassInstanceString() throws IOException
			{
				String filename = "C://grpManagementNewTest.rdf";
				
				// Create an empty model
				Model model = ModelFactory.createDefaultModel();
						
				// Use the FileManager to find the input file
				InputStream in = FileManager.get().open(filename);
				
				if (in == null)
					throw new IllegalArgumentException("File: "+filename+" not found");

				// Read the RDF/XML file
				model.read(in, null);
				
				// List all the resources with the property "vcard:FN"
				String queryString = 
						"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" +
								"PREFIX owl: <http://www.w3.org/2002/07/owl#>"+
								"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
								"PREFIX : <http://www.semanticweb.org/prabhavi/ontologies/2017/7/untitled-ontology-32#>" +
								"PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>" +
								"PREFIX skos: <http://www.w3.org/2004/02/skos/core#>" +
								"SELECT ?instance_of " +
								"WHERE {" +
								" ?instance_of rdf:type ?type."+
								" ?type owl:NamedIndividual* :Actor."+
								"}";
				Query query = QueryFactory.create(queryString);
				QueryExecution qexec = QueryExecutionFactory.create(query, model) ;
				ResultSet results = qexec.execSelect() ;
				
				while (results.hasNext())
				{
					QuerySolution binding = results.nextSolution();
					Resource subj = (Resource) binding.get("instance_of");
				    String resultString = subj.getURI();
				    
				    //get result as string without URI prefix, but different approach to get in from the query execution
				    System.out.println(resultString.substring(resultString.lastIndexOf("#") +1));
				}

			}
			
			static void sparqlTestNewClassInstanceStringURL() throws IOException
			{
				//String filename = "C://grpManagementNewTest.rdf";
				final String url = "http://onto.000webhostapp.com/grpManagementNew.rdf";
				// Create an empty model
				Model model = ModelFactory.createDefaultModel();
						
				// Use the FileManager to find the input file
				InputStream in = FileManager.get().open(url);
				System.out.println("read file");
				if (in == null)
					throw new IllegalArgumentException("File: "+url+" not found");

				// Read the RDF/XML file
				model.read(in, null);
				//model.read(url);
				// List all the resources with the property "vcard:FN"
				String queryString = 
						"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" +
								"PREFIX owl: <http://www.w3.org/2002/07/owl#>"+
								"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
								"PREFIX : <http://www.semanticweb.org/prabhavi/ontologies/2017/7/untitled-ontology-32#>" +
								"PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>" +
								"PREFIX skos: <http://www.w3.org/2004/02/skos/core#>" +
								"SELECT ?instance_of " +
								"WHERE {" +
								" ?instance_of rdf:type ?type."+
								" ?type owl:NamedIndividual* :Actor."+
								"}";
				Query query = QueryFactory.create(queryString);
				QueryExecution qexec = QueryExecutionFactory.create(query, model) ;
				ResultSet results = qexec.execSelect() ;
				
				while (results.hasNext())
				{
					QuerySolution binding = results.nextSolution();
					Resource subj = (Resource) binding.get("instance_of");
				    String resultString = subj.getURI();
				    
				    //get result as string without URI prefix, but different approach to get in from the query execution
				    System.out.println(resultString.substring(resultString.lastIndexOf("#") +1));
				}

			}

}
