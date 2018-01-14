package com.finalyrSE.serviceimpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finalyrSE.service.EntityExtractionService;

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.ling.CoreAnnotations.LemmaAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.NamedEntityTagAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.PartOfSpeechAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TextAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TokensAnnotation;
import edu.stanford.nlp.parser.lexparser.LexicalizedParser;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.semgraph.SemanticGraph;
import edu.stanford.nlp.semgraph.SemanticGraphCoreAnnotations.CollapsedCCProcessedDependenciesAnnotation;
import edu.stanford.nlp.trees.GrammaticalStructure;
import edu.stanford.nlp.trees.GrammaticalStructureFactory;
import edu.stanford.nlp.trees.PennTreebankLanguagePack;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.TreebankLanguagePack;
import edu.stanford.nlp.trees.TypedDependency;
import edu.stanford.nlp.trees.TreeCoreAnnotations.TreeAnnotation;
import edu.stanford.nlp.util.CoreMap;

@Service("entityextractor")
@Transactional
public class EntityExtractionServiceImpl implements EntityExtractionService {

	@SuppressWarnings("deprecation")
	@Override
	public ArrayList<String> extractTriplets(String text) {
		String actor=null;
		String predicate = null;
		String Object = null;
		ArrayList<String> strary=new ArrayList<String>();
		ArrayList<String> straryactor=new ArrayList<String>();
		ArrayList<String> returnArray=new ArrayList<String>();
		String[] text2 = null;
		String text1 = null;
		
		String processedWord=preProcess(text);
		//System.out.println(processedWord);
		if(processedWord.contains("so that")){
			text1=processedWord.substring(0, processedWord.indexOf("so that"));
		}
		else{
			text1=processedWord;
		}
		
		//System.out.println(text1);
		
		if(text1.contains("want")){
			text2 = text1.split("i want to"); // I want phrase get removed//
			System.out.println(text2[0]); // eg: As an admin//
			System.out.println(text2[1]); // eg: add a new user group to the system//
		}
		
		if(text1.contains("need")){
			text2 = text1.split("i need to be able to"); // this phrase get removed//
		}
		 		
		Properties props=new Properties();
		props.setProperty("annotators", "tokenize,ssplit,pos,lemma,ner,parse");
		StanfordCoreNLP pipeline=new StanfordCoreNLP(props);
		
		for(int i=0;i<text2.length;i++){
			Annotation document=new Annotation(text2[i]);
			pipeline.annotate(document);
			
			List<CoreMap> sentences = document.get(SentencesAnnotation.class); //all the sentences
			System.out.println("sentences are: " + sentences);
			
			for(CoreMap sentence: sentences){
				//System.out.println("==== "+sentence); //each sentence in sentences list coremap//
				for(CoreLabel token: sentence.get(TokensAnnotation.class)){
					//System.out.println("token "+token); //tokens in each sentence//
					
					/*String word = token.get(TextAnnotation.class);
					String pos = token.get(PartOfSpeechAnnotation.class);
					String ne = token.get(NamedEntityTagAnnotation.class);
					System.out.println("word = "+word);
					System.out.println("pos = "+pos);
					System.out.println("ne = "+ne);
					if(i==0){
						straryactor.add(word);
					}
					if(i==1){
						strary.add(word);
					}*/
					
				}
					if(i==0){
						
						SemanticGraph dependencies = sentence.get(CollapsedCCProcessedDependenciesAnnotation.class);
						Collection<TypedDependency> tdl=dependencies.typedDependencies();
						System.out.println(tdl);

						for (Object obj : tdl.toArray()) {
							TypedDependency dep = (TypedDependency) obj;
							
							String wordGov = dep.gov().toString();
							String wordDep = dep.dep().toString();
							String word=wordDep.substring(0,wordDep.indexOf("/"));
							
							
							String[] dependent_word=wordDep.split("/");
							String depword=dependent_word[0];//eg: admin
							String POS_tag=dependent_word[1];//eg: NN
							
							if(dep.reln().toString().equals("root")){
								if(POS_tag.equals("NN")){
									actor=depword;
									Annotation tokenAnnotation = new Annotation(actor);
									pipeline.annotate(tokenAnnotation);  // necessary for the LemmaAnnotation to be set.
									List<CoreMap> list = tokenAnnotation.get(SentencesAnnotation.class);
									String tokenLemma = list.get(0).get(TokensAnnotation.class).get(0).get(LemmaAnnotation.class);
									//System.out.println(tokenLemma);
									returnArray.add(0,tokenLemma);
									System.out.println("actor= "+tokenLemma);
								}
								else{
									System.out.println("actor not valid");
									returnArray.add(0,"Invalid");
									return returnArray;
								}
											
							}
							
						}
					}
					else if(i==1){
						SemanticGraph dependencies = sentence.get(CollapsedCCProcessedDependenciesAnnotation.class);
						Collection<TypedDependency> tdl=dependencies.typedDependencies();
						System.out.println(tdl);
						
						for (Object obj : tdl.toArray()) {
							TypedDependency dep = (TypedDependency) obj;
							
							String wordGov = dep.gov().toString();
							String wordDep = dep.dep().toString();
							String outword=wordDep.substring(0,wordDep.indexOf("/"));
							String[] dependent_word=wordDep.split("/");
							String depword=dependent_word[0];//eg: admin
							String POS_tag=dependent_word[1];//eg: NN
							
							String wordGovrnr=null;
							if(wordGov.contains("/")){
								wordGovrnr=wordGov.substring(0,wordGov.indexOf("/"));
							}
									
							if(dep.reln().toString().equals("root")){
								predicate=outword;
								Annotation tokenAnnotation = new Annotation(predicate);
								pipeline.annotate(tokenAnnotation);  // necessary for the LemmaAnnotation to be set.
								List<CoreMap> list = tokenAnnotation.get(SentencesAnnotation.class);
								String tokenLemma = list.get(0).get(TokensAnnotation.class).get(0).get(LemmaAnnotation.class);
								//System.out.println(tokenLemma);
								returnArray.add(1,tokenLemma);
								System.out.println("predicate= "+tokenLemma);
							}
							
							if(dep.reln().toString().equals("dobj")||dep.reln().toString().equals("dep")){
								if(wordGovrnr.equals(predicate)){
									Object=depword;
									Annotation tokenAnnotation = new Annotation(Object);
									pipeline.annotate(tokenAnnotation);  // necessary for the LemmaAnnotation to be set.
									List<CoreMap> list = tokenAnnotation.get(SentencesAnnotation.class);
									String tokenLemma = list.get(0).get(TokensAnnotation.class).get(0).get(LemmaAnnotation.class);
									//System.out.println(tokenLemma);
									returnArray.add(2,tokenLemma);
									System.out.println("object= "+tokenLemma);
								}	
								
							}
							
						}				
					}												
			}		
	}
		
		System.out.println(returnArray);
		
		return returnArray;
	}

	@Override
	public String preProcess(String text) {
		String preproceSent=text.toLowerCase().replaceAll("[^a-zA-Z ]", "");	
		return preproceSent;
	}

	@Override
	public ArrayList<String> ambiguityExtract(String text) {
		String actor=null;
		String predicate = null;
		String Object = null;
		ArrayList<String> strary=new ArrayList<String>();
		ArrayList<String> straryactor=new ArrayList<String>();
		ArrayList<String> returnArray=new ArrayList<String>();
		String[] text2 = null;
		String text1 = null;
		
		
		String processedWord=preProcess(text);
		//System.out.println(processedWord);
		if(processedWord.contains("so that")){
			text1=processedWord.substring(0, processedWord.indexOf("so that"));
		}
		else{
			text1=processedWord;
		}
		
		//System.out.println(text1);
		
		if(text1.contains("want")){
			text2 = text1.split("i want to"); // I want phrase get removed//
			System.out.println(text2[0]); // eg: As an admin//
			System.out.println(text2[1]); // eg: add a new user group to the system//
		}
		
		if(text1.contains("need")){
			text2 = text1.split("i need to be able to"); // this phrase get removed//
		}
		
		Properties props=new Properties();
		props.setProperty("annotators", "tokenize,ssplit,pos,lemma,ner,parse");
		StanfordCoreNLP pipeline=new StanfordCoreNLP(props);
		
		for(int i=0;i<text2.length;i++){
			Annotation document=new Annotation(text2[i]);
			pipeline.annotate(document);
			
			List<CoreMap> sentences = document.get(SentencesAnnotation.class); //all the sentences
			System.out.println("sentences are: " + sentences);
			
			for(CoreMap sentence: sentences){
				//System.out.println("==== "+sentence); //each sentence in sentences list coremap//
				for(CoreLabel token: sentence.get(TokensAnnotation.class)){
					//System.out.println("token "+token); //tokens in each sentence//
					
					String word = token.get(TextAnnotation.class);
					
					if(i==1){
						if(word.equals("view")||(word.equals("list"))){
							predicate=word;
							returnArray.add(1,predicate);
							System.out.println("predicate= "+predicate);
						}/*else{
							returnArray.add(1,"Invalid");
						}*/
					}
					
				}
					if(i==0){
						
						SemanticGraph dependencies = sentence.get(CollapsedCCProcessedDependenciesAnnotation.class);
						Collection<TypedDependency> tdl=dependencies.typedDependencies();
						System.out.println(tdl);

						for (Object obj : tdl.toArray()) {
							TypedDependency dep = (TypedDependency) obj;
							
							String wordGov = dep.gov().toString();
							String wordDep = dep.dep().toString();
							String word=wordDep.substring(0,wordDep.indexOf("/"));
							
							
							String[] dependent_word=wordDep.split("/");
							String depword=dependent_word[0];//eg: admin
							String POS_tag=dependent_word[1];//eg: NN
							
							if(dep.reln().toString().equals("root")){
								if(POS_tag.equals("NN")){
									actor=depword;
								}
								else{
									System.out.println("actor not valid");
								}
								Annotation tokenAnnotation = new Annotation(actor);
								pipeline.annotate(tokenAnnotation);  // necessary for the LemmaAnnotation to be set.
								List<CoreMap> list = tokenAnnotation.get(SentencesAnnotation.class);
								String tokenLemma = list.get(0).get(TokensAnnotation.class).get(0).get(LemmaAnnotation.class);
								//System.out.println(tokenLemma);
								returnArray.add(0,tokenLemma);
								System.out.println("actor= "+tokenLemma);			
							}
							
						}
					}
					else if(i==1){
						SemanticGraph dependencies = sentence.get(CollapsedCCProcessedDependenciesAnnotation.class);
						Collection<TypedDependency> tdl=dependencies.typedDependencies();
						System.out.println(tdl);
						
						for (Object obj : tdl.toArray()) {
							TypedDependency dep = (TypedDependency) obj;
							
							String wordGov = dep.gov().toString();
							String wordDep = dep.dep().toString();
							String outword=wordDep.substring(0,wordDep.indexOf("/"));
							String[] dependent_word=wordDep.split("/");
							String depword=dependent_word[0];//eg: admin
							String POS_tag=dependent_word[1];//eg: NN
							
							String wordGovrnr=null;
							if(wordGov.contains("/")){
								wordGovrnr=wordGov.substring(0,wordGov.indexOf("/"));
							}
													
							
							if(dep.reln().toString().equals("root")){
								Object=outword;
								Annotation tokenAnnotation = new Annotation(Object);
								pipeline.annotate(tokenAnnotation);  // necessary for the LemmaAnnotation to be set.
								List<CoreMap> list = tokenAnnotation.get(SentencesAnnotation.class);
								String tokenLemma = list.get(0).get(TokensAnnotation.class).get(0).get(LemmaAnnotation.class);
								//System.out.println(tokenLemma);
								if(returnArray.size()==2){
									returnArray.add(2,tokenLemma);
								}
								else{
									returnArray.add(1,"Invalid");
								}
								
								System.out.println("object= "+tokenLemma);
							}
													
						}				
					}												
			}		
	}
		
		System.out.println(returnArray);
		
		return returnArray;
	}
	
}
