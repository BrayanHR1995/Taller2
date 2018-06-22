/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.taller03;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;

/**
 *
 * @author Pavilion g4
 */
public class PosTagger {
    private static InputStream tokenModelIn;
    private static InputStream posModelIn;
    private static String sentence;
    private static TokenizerModel tokenModel;
    private static Tokenizer tokenizer;
    private static String tokens[];
    private static POSModel posModel;
    private static POSTaggerME posTagger;
    private static String tags[];
    private static double probs[];
    private static boolean subj;
    private static boolean verb_participe;
    private static boolean verb_aux;
    private static boolean by_or_for;
    private static String forma;
    private static int correctas;
    private static int erroneas;
    
    public PosTagger(){
        tokenModelIn = null;
        posModelIn = null;
        sentence="";
        tokenModel=null;
        tokenizer=null;
        tokens=null;
        posModel=null;
        posTagger=null;
        tags=null;
        probs=null;
        subj=false;
        verb_participe=false;
        by_or_for=false;
        verb_aux=false;
        forma="";
    }
    
    public String getSentence(){
        return sentence;
        
    }
    
    public String analyzePhrase(){
        subj=false;
        verb_participe=false;
        by_or_for=false;
        verb_aux=false;
        forma="";
        for(int i=0;i<tags.length;i++){
            if(tags[i].equals("NNP") || tags[i].equals("NNPS") || tags[i].equals("PRP$") || tags[i].equals("NN")){
                subj=true;
            }
        }
        
         for(int i=0;i<tags.length;i++){
            if(tags[i].equals("VBG") || tags[i].equals("VBN")){
                verb_participe=true;
            }
        }
         
        for(int i=0;i<tags.length;i++){
            if(tokens[i].equals("was") || tokens[i].equals("were") || tokens[i].equals("been")){
                verb_aux=true;
            }
        }
        
        for(int i=0;i<tokens.length;i++){
            if(tokens[i].equals("by") || tokens[i].equals("for")){
                by_or_for=true;
            }
        }
        
        if(subj==true && (verb_aux==true ||verb_participe==true) && by_or_for== true){
            forma="Voz pasiva";
        }else if(subj==true && verb_aux==true && verb_participe==true){
            forma="Voz pasiva";
        }else{
            forma="Voz activa";
        }
        
        return forma;
    }
    
    public void decomposePhrase(){

        try {
            
            // tokenize the sentence
            tokenModelIn = new FileInputStream("en-token.bin");
            tokenModel = new TokenizerModel(tokenModelIn);
            tokenizer = new TokenizerME(tokenModel);

 
            // Parts-Of-Speech Tagging
            // reading parts-of-speech model to a stream 
            posModelIn = new FileInputStream("en-pos-maxent.bin");
            // loading the parts-of-speech model from stream
            posModel = new POSModel(posModelIn);
            // initializing the parts-of-speech tagger with model 
            posTagger = new POSTaggerME(posModel);
            // Tagger tagging the tokens

            
        }
        catch (IOException e) {
            // Model loading failed, handle the error
            e.printStackTrace();
        }
        finally {
            if (tokenModelIn != null) {
                try {
                    tokenModelIn.close();
                }
                catch (IOException e) {
                }
            }
            if (posModelIn != null) {
                try {
                    posModelIn.close();
                }
                catch (IOException e) {
                }
            }
        }
       
    }
     public void comparar(String p_sentence){
         sentence = p_sentence;
         tokens = tokenizer.tokenize(sentence);
         tags= posTagger.tag(tokens);
         
         
     }
    
}
