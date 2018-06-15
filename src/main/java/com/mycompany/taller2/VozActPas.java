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
    public String Detectar(String sentence) throws InvalidFormatException, IOException{
        int auxvbn=0;
        int auxvb=0;
        int auxvbd=0;
        int auxvbz=0;
        int auxvbp=0;
        int posverboVB = 0;
        int posverboVBN = 0;
        int posverboVBD = 0;
        int posverboVBZ = 0;
        int posverboVBP = 0;
        int posverbo=0;
        int possujeto=0;
        int possujetoNNP=0;
        int possujetoNN=0;
        int possujetoNNS=0;
        int possujetoPRP=0;
        int auxprp=0;
        int auxnn=0;
        int auxnnp=0;
        int auxnns=0;
        boolean estado= false;
        boolean estado1= false;
        InputStream tokenModelIn = null;
        InputStream posModelIn = null;
        String enviar = null;
        String p=null;
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
            

            for(int i=0;i<tokens.length;i++){
                
                estado1=false;
                
                if(tokens[i].equals("by")){
                    enviar= "Pasiva\n";
                 //   p =Interfaz.TextArea.getText();
                 //   p = p + enviar;
                 //   Interfaz.TextArea.setText(p);
                    estado1=true;
                    break;
                }
                if(tags[i].equals("VBZ")   ){
                    posverboVBZ=i;
                    auxvbz=1;
                }
                if(tags[i].equals("VBD")   ){
                    posverboVBD=i;
                   auxvbd=1;
                }
                if(tags[i].equals("VBN")   ){
                    posverboVBN=i;
                    auxvbn=1;
                }
                
                 if(tags[i].equals("VB")){
                    posverboVB=i;    
                    auxvb=1;
                 }
                if(tags[i].equals("VBP")){
                    posverboVBP=i;      
                    auxvbp=1;
                 }
                


                if(tags[i].equals("PRP")){     
                        possujetoPRP=i; 
                        auxprp=1;
                }
                if(tags[i].equals("NNS")){     
                        possujetoNNS=i; 
                        auxnns=1;
                }
                if (tags[i].equals("NN")) {
                    if(estado==false){
                        possujetoNN = i;
                        auxnn=1;
                        estado=true;
                    }

                }
                if(tags[i].equals("NNP")){     
                        possujetoNNP=i; 
                        auxnnp=1;
                }
                
            }
            if(estado1==false){
                
                if(auxvbn>0){
                    posverbo=posverboVBN;
                }else if(auxvbd>0){
                    posverbo=posverboVBD;
                }else if(auxvb>0){
                    posverbo=posverboVB;
                }else if(auxvbp>0){
                    posverbo=posverboVBP;
                }else if(auxvbz>0){
                    posverbo=posverboVBZ;
                }
                
                if(auxprp>0){
                    possujeto=possujetoPRP;
                }else if(auxnnp>0){
                    possujeto=possujetoNNP;
                }else if(auxnns>0){
                    possujeto=possujetoNNS;
                }else if(auxnn>0){
                    possujeto=possujetoNN;
                }
            
            

            if(possujeto<posverbo){
                enviar= "Activa\n";
               // p =Interfaz.TextArea.getText();
               // p = p + enviar;
               // Interfaz.TextArea.setText(p);
               
                
            }else{
                enviar= "Pasiva\n";
              //  p =Interfaz.TextArea.getText();
              //  p = p + enviar;
              //  Interfaz.TextArea.setText(p);
                
            }
            
            
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
        return enviar;
    }
}
