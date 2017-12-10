package com.finalyrSE.serviceimpl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.hibernate.mapping.Array;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finalyrSE.service.EntityExtractionService;

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.ling.CoreAnnotations.NamedEntityTagAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.PartOfSpeechAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TextAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TokensAnnotation;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;

@Service("entityextractor")
@Transactional
public class EntityExtractionServiceImpl implements EntityExtractionService {

	@Override
	public ArrayList<ArrayList<String>> entityEx(ArrayList<String> textlist) throws IOException {
		System.out.println(textlist);
		PrintWriter out;
		out = new PrintWriter(System.out);

		// cretaes a stanford object, with POS tagging,
		// lemmatization,NER,parsing and coreference resolution//
		Properties props = new Properties();
		props.setProperty("annotators", "tokenize,ssplit,pos,lemma,ner,parse,dcoref");

		StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
		ArrayList<ArrayList<String>> array=new ArrayList<ArrayList<String>>();
		
		for (int i = 0; i < textlist.size(); i++) {
			Annotation document = new Annotation(textlist.get(i)); // creates an empty annotation with the given text string//														
			pipeline.annotate(document); // run all annotations in this text//
			
			List<CoreMap> sentences = document.get(SentencesAnnotation.class);
			
			for (CoreMap sentence : sentences) {
				ArrayList<String> arraynew = new ArrayList<String>();
				for (CoreLabel token : sentence.get(TokensAnnotation.class)) {
					String word = token.get(TextAnnotation.class);
					String pos = token.get(PartOfSpeechAnnotation.class);
					String ne = token.get(NamedEntityTagAnnotation.class);
					
					 /*System.out.print("word = "+word);
					 System.out.print(" pos = "+pos);
					 System.out.println(" ne = "+ne);*/
					 

					if (pos.equals("NN") || pos.equals("VB")) {
						if (!arraynew.contains(word)) {
							arraynew.add(word);
						}
					}	
				}
				
				array.add(arraynew);
				
			}			
		}
	
		return array;

	}

	@Override
	public ArrayList<String> sentenceTokenize(String text) {

		Properties props = new Properties();
		props.setProperty("annotators", "tokenize,ssplit");

		StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
		Annotation document = new Annotation(text);
		pipeline.annotate(document);

		// sentences//
		List<CoreMap> sentences = document.get(SentencesAnnotation.class);
	
		String t;
		ArrayList<String> arraystr = new ArrayList<String>();
		for (CoreMap sentence : sentences) {
			// System.out.println(sentence);
			String sentence1 = sentence.toString();
			//System.out.println("++++ " + sentence1);
			if (sentence1.contains("so that")) {
				// t=sentence1.substring(0,sentence1.indexOf("so that"));
				// System.out.println(t+" t");
				String[] t1 = sentence1.split("so that");
				
				for (int i = 0; i < t1.length; i++) {
					arraystr.add(t1[i]);
				}

			} else {
				t = sentence1;
				arraystr.add(t);
				
			}

		}

		return arraystr;
	}

	@Override
	public ArrayList<String> extractEntity(String userstory) {
		String[] t1 = null;
		String user=null;
		String obj=null;
		ArrayList<String> array=new ArrayList<String>();
		ArrayList<String> arraynew = new ArrayList<String>();
		if(userstory.contains("so that")){
			t1 = userstory.split("so that");
			/*for(int i=0;i<t1.length;i++){
				System.out.println(t1[i]);
			}*/
		}
		
		String text1=t1[0];
		if(text1.contains("need")){
			user=text1.substring(5,text1.indexOf(", I need to"));
			obj=text1.substring(text1.indexOf("I need to be"));
			
		}
		else if(text1.contains("want")){
			user=text1.substring(5,text1.indexOf(", I want to"));
			obj=text1.substring(text1.indexOf("I want to"));
		}
		arraynew.add(user);
		ArrayList<String> objects=extrachNounVerbs(obj);
		//System.out.println(objects);
		array.addAll(arraynew);
		array.addAll(objects);
		
		//System.out.println(array);
		return array;
	}

	@Override
	public String splitSentence(String text) {
		return null;
	}

	@Override
	public ArrayList<String> extrachNounVerbs(String text) {
		ArrayList<String> nounlist=new ArrayList<String>();
		ArrayList<String> verblist=new ArrayList<String>();
		ArrayList<String> returnArray=new ArrayList<String>();
		Properties props=new Properties();	//creates stanford core NLP object, with POS tagging, lemmatization,parsing,coreference resolution
		props.setProperty("annotators", "tokenize,ssplit,pos,lemma,ner,parse,dcoref");
		StanfordCoreNLP pipeline=new StanfordCoreNLP(props);
				
		Annotation document=new Annotation(text); //creates an empty annotation with the given text string//		
		pipeline.annotate(document); //run all annotations in this text//
		
		
		//sentences//
		List<CoreMap> sentences = document.get(SentencesAnnotation.class); //all the sentences
		System.out.println("sentences are: " + sentences);
				
		for(CoreMap sentence: sentences){
			//System.out.println("==== "+sentence); //each sentence in sentences list coremap//
			for(CoreLabel token: sentence.get(TokensAnnotation.class)){
				//System.out.println("?????"+token); //tokens in each sentence//		
						
				String word = token.get(TextAnnotation.class);
				String pos = token.get(PartOfSpeechAnnotation.class);
				String ne = token.get(NamedEntityTagAnnotation.class);
				//System.out.println("word = "+word);
				//System.out.println("pos = "+pos);
				//System.out.println("ne = "+ne);
				if(pos.equals("NN")){
					//System.out.println("yes NN");
					nounlist.add(word);
				}
				else if(pos.equals("VB")){
					//System.out.println("yes NN");
					verblist.add(word);
				}
				
			}	
			String verb=verblist.get(verblist.size()-1);
			String object=nounlist.get(1);
		returnArray.add(verb);
		returnArray.add(object);
		}
		//System.out.println(returnArray);
		return returnArray;

	}
}
