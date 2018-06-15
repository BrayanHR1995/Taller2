/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.taller2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.util.InvalidFormatException;

/**
 *
 * @author BrayanHR09
 */
public class VozActPas {
    private static boolean subj;
    private static boolean verb_participe;
    private static boolean verb_aux;
    private static boolean by_or_for;
    private static String forma;
    String p="";
    static int x = 0;
    static int y = 0;
    public String Detectar(String sentence) throws InvalidFormatException, IOException{

        InputStream tokenModelIn = null;
        InputStream posModelIn = null;
        
        
        
        
        try {
         
            // tokenize the sentence
            tokenModelIn = new FileInputStream("en-token.bin");
            TokenizerModel tokenModel = new TokenizerModel(tokenModelIn);
            Tokenizer tokenizer = new TokenizerME(tokenModel);
            String tokens[] = tokenizer.tokenize(sentence);
 
            // Parts-Of-Speech Tagging
            // reading parts-of-speech model to a stream 
            posModelIn = new FileInputStream("en-pos-maxent.bin");
            // loading the parts-of-speech model from stream
            POSModel posModel = new POSModel(posModelIn);
            // initializing the parts-of-speech tagger with model 
            POSTaggerME posTagger = new POSTaggerME(posModel);
            // Tagger tagging the tokens
            String tags[] = posTagger.tag(tokens);
            // Getting the probabilities of the tags given to the tokens
            double probs[] = posTagger.probs();
            
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
            if(tokens[i].equals("was") || tokens[i].equals("were")){
                verb_aux=true;
            }
        }
        
        for(int i=0;i<tokens.length;i++){
            if(tokens[i].equals("by") || tokens[i].equals("for")){
                by_or_for=true;
            }
        }
        
        if(subj==true && (verb_aux==true ||verb_participe==true) && by_or_for== true){
            forma="Pasiva\n";
            x++;

        }else if(subj==true && verb_aux==true && verb_participe==true){
            forma="Pasiva\n";
            x++;

        }else{
            forma="Activa\n";
            y++;


        }

        
            


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
        System.out.println(forma);
     return forma;   
    }
    
    public void almacenar(){
            
            p=p+forma;
            Interfaz.TextArea.setText(p);
    }
     
    public void conteo(){
        Interfaz.jTextField1.setText(String.valueOf(y));
        Interfaz.jTextField2.setText(String.valueOf(x));
        
    }
}
