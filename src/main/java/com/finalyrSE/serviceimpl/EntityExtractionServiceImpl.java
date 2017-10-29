package com.finalyrSE.serviceimpl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

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
public class EntityExtractionServiceImpl implements EntityExtractionService{

	@Override
	public ArrayList<String> entityEx(String text) throws IOException {
		//String text="As a User Admin, I need to be able to add a new user group to the system, so that I can add users to that group and manage them easily.";
		PrintWriter out;
		out=new PrintWriter(System.out);
		
	//cretaes a stanford object, with POS tagging, lemmatization,NER,parsing and coreference resolution// 	
		Properties props=new Properties();
		props.setProperty("annotators", "tokenize,ssplit,pos,lemma,ner,parse,dcoref");
		
		StanfordCoreNLP pipeline=new StanfordCoreNLP(props);
		Annotation document=new Annotation(text); //creates an empty annotation with the given text string//
		pipeline.annotate(document); //run all annotations in this text//
		
		//pipeline.prettyPrint(document, out);
		
		//sentences//
		List<CoreMap> sentences = document.get(SentencesAnnotation.class);
		//System.out.println("sentences are: " + sentences);
		
		ArrayList<String> array = new ArrayList<String>();
		
		for(CoreMap sentence: sentences){
			//System.out.println("==== "+sentence);
			for(CoreLabel token: sentence.get(TokensAnnotation.class)){
				String word = token.get(TextAnnotation.class);
				String pos = token.get(PartOfSpeechAnnotation.class);
				String ne = token.get(NamedEntityTagAnnotation.class);
				/*System.out.print("word = "+word);
				System.out.print(" pos = "+pos);
				System.out.println(" ne = "+ne);*/
				
				if(pos.equals("NN") ||pos.equals("VB")||pos.equals("VBP")||pos.equals("NNP")||pos.equals("NNS") ){
					
					if(!array.contains(word)){
						array.add(word);
					}
					
				}
				/*else if(pos.equals("VB")){
					array.add(word);
				}*/
			/*	for(int i=0;i<array.size();i++){
					for(int j=1;j<array.size();j++){
						//System.out.println(array.get(i)+array.get(i+1));
						if(array.get(i).equalsIgnoreCase(array.get(j))){
							array.remove(j);
						}
					}				
				}*/
				
			}
			
			
		}
		return array;
		
		
		
	}

}
