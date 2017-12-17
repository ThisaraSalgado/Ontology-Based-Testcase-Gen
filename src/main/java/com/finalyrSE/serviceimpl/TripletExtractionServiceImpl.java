package com.finalyrSE.serviceimpl;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finalyrSE.service.TripletExtracionService;

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.ling.SentenceUtils;
import edu.stanford.nlp.ling.CoreAnnotations.NamedEntityTagAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.PartOfSpeechAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TextAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TokensAnnotation;
import edu.stanford.nlp.parser.lexparser.LexicalizedParser;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.trees.GrammaticalStructure;
import edu.stanford.nlp.trees.GrammaticalStructureFactory;
import edu.stanford.nlp.trees.PennTreebankLanguagePack;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.TreebankLanguagePack;
import edu.stanford.nlp.trees.TypedDependency;
import edu.stanford.nlp.util.CoreMap;

@Service("tripletex")
@Transactional
public class TripletExtractionServiceImpl implements TripletExtracionService{

	@Override
	public ArrayList<String> extractTriplets(String text) {
		String actor;
		String predicate;
		String Object;
		ArrayList<String> strary=new ArrayList<String>();
		ArrayList<String> straryactor=new ArrayList<String>();
		ArrayList<String> returnArray=new ArrayList<String>();
		String[] text2 = null;
		String text1=text.substring(0, text.indexOf("so that"));
		System.out.println(text1);
		
		if(text1.contains("want")){
			text2 = text1.split("I want to"); // I want phrase get removed//
			System.out.println(text2[0]); // eg: As an admin//
			System.out.println(text2[1]); // eg: add a new user group to the system//
		}
		
		if(text1.contains("need")){
			text2 = text1.split("I need to be able to"); // this phrase get removed//
		}
		 
		
		/*String sent1=text2[1].trim();
		String sent2=text2[0].trim();*/
		
		Properties props=new Properties();
		props.setProperty("annotators", "tokenize,ssplit,pos,lemma,ner,parse,dcoref");
		StanfordCoreNLP pipeline=new StanfordCoreNLP(props);
		
		LexicalizedParser lp = LexicalizedParser.loadModel("edu/stanford/nlp/models/lexparser/englishPCFG.ser.gz","-maxLength", "80", "-retainTmpSubcategories");
		TreebankLanguagePack tlp = new PennTreebankLanguagePack();
		tlp.setGenerateOriginalDependencies(true);
		GrammaticalStructureFactory gsf = tlp.grammaticalStructureFactory();
		
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
					String pos = token.get(PartOfSpeechAnnotation.class);
					String ne = token.get(NamedEntityTagAnnotation.class);
					//System.out.println("word = "+word);
					//System.out.println("pos = "+pos);
					//System.out.println("ne = "+ne);
					if(i==0){
						straryactor.add(word);
					}
					if(i==1){
						strary.add(word);
					}
					
				}
					if(i==0){
						//straryactor.add(word);
						Tree parse = lp.apply(SentenceUtils.toUntaggedList(straryactor));
						GrammaticalStructure gs = gsf.newGrammaticalStructure(parse);
						Collection<TypedDependency> tdl=gs.typedDependenciesEnhanced();
						System.out.println(tdl);
						System.out.println("++++++");
						
						for (Object obj : tdl.toArray()) {
							TypedDependency dep = (TypedDependency) obj;
							System.out.println(dep.reln());
							System.out.println("[[[[[[[[");
							String wordGov = dep.gov().toString();
							String wordDep = dep.dep().toString();
							String outword=wordDep.substring(0,wordDep.indexOf("/"));
							
							System.out.println(wordGov);
							System.out.println(wordDep);
							System.out.println(outword);
							
							if(dep.reln().toString().equals("pobj")){
								actor=outword;
								returnArray.add(0,actor);
								System.out.println("actor= "+actor);
							}
							
						}
					}
					else if(i==1){
						//strary.add(word);
						Tree parse = lp.apply(SentenceUtils.toUntaggedList(strary));
						GrammaticalStructure gs = gsf.newGrammaticalStructure(parse);
						Collection<TypedDependency> tdl=gs.typedDependenciesEnhanced();
						System.out.println(tdl);
						System.out.println("++++++");
						
						for (Object obj : tdl.toArray()) {
							TypedDependency dep = (TypedDependency) obj;
							System.out.println(dep.reln());
							System.out.println("[[[[[[[[");
							String wordGov = dep.gov().toString();
							String wordDep = dep.dep().toString();
							String outword=wordDep.substring(0,wordDep.indexOf("/"));
							
							System.out.println(wordGov);
							System.out.println(wordDep);
							System.out.println(outword);
							
							if(dep.reln().toString().equals("root")){
								predicate=outword;
								returnArray.add(1,predicate);
								System.out.println("predicate= "+predicate);
							}
							if(dep.reln().toString().equals("dobj")){
								Object=outword;
								returnArray.add(2,Object);
								System.out.println("object= "+Object);
							}
							
						}
					}
					
				
				
			}
		
		
		
		
	}
		
		System.out.println(returnArray);
		
		return returnArray;
	}

}
