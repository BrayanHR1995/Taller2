/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
 
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import java.awt.TextArea;
import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;
 
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
/**
 *
 * @author Pavilion g4
 */
public class Gui {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Interfaz ventana = new Interfaz();
        ventana.setTitle("Interfaz Taller Dos");
        ventana.setVisible(true);
        
    }
    
        public void Detectar(String sentence) throws InvalidFormatException, IOException{
        int posverboVB = 0;
        int posverboVBN = 0;
        int posverboVBD = 0;
        int posverboVBZ = 0;
        int posverboVBP = 0;
        int posverbo=0;
        int possujeto=0;
        boolean estado= false;
        InputStream tokenModelIn = null;
        InputStream posModelIn = null;
        
        try {
         
            // tokenize the sentence
            tokenModelIn = new FileInputStream("C:\\Users\\braya\\OneDrive\\Documents\\NetBeansProjects\\OpenNPL\\src\\en-token.bin");
            TokenizerModel tokenModel = new TokenizerModel(tokenModelIn);
            Tokenizer tokenizer = new TokenizerME(tokenModel);
            String tokens[] = tokenizer.tokenize(sentence);
 
            // Parts-Of-Speech Tagging
            // reading parts-of-speech model to a stream 
            posModelIn = new FileInputStream("C:\\Users\\braya\\OneDrive\\Documents\\NetBeansProjects\\OpenNPL\\src\\en-pos-maxent.bin");
            // loading the parts-of-speech model from stream
            POSModel posModel = new POSModel(posModelIn);
            // initializing the parts-of-speech tagger with model 
            POSTaggerME posTagger = new POSTaggerME(posModel);
            // Tagger tagging the tokens
            String tags[] = posTagger.tag(tokens);
            // Getting the probabilities of the tags given to the tokens
            double probs[] = posTagger.probs();
            
            System.out.println("Token\t:\tTag\t:\tProbability\n---------------------------------------------");
            for(int i=0;i<tokens.length;i++){
                System.out.println(tokens[i]+"\t:\t"+tags[i]+"\t:\t"+probs[i]);
                if(tags[i].equals("VBZ")   ){
                    posverboVBZ=i;
                }
                if(tags[i].equals("VBD")   ){
                    posverboVBD=i;
                }
                if(tags[i].equals("VBN")   ){
                    posverboVBN=i;
                }
                
                 if(tags[i].equals("VB")){
                    posverboVB=i;                     
                 }
                if(tags[i].equals("VBP")){
                    posverboVBP=i;                     
                 }
                
                 
                 
                if(tags[i].equals("NNP") || tags[i].equals("PRP") || tags[i].equals("NNS") || tags[i].equals("NN")){
                    if(estado==false){
                        possujeto=i;
                        estado = true;
                    }
                    
                }
                
            }
            
            if(probs[posverboVBZ]>probs[posverboVBD]){
                if(probs[posverboVBZ]>probs[posverboVBN]){
                    if(probs[posverboVBZ]>probs[posverboVB]){
                        if(probs[posverboVBZ]>probs[posverboVBP]){
                            posverbo=posverboVBZ;
                        }
                    }
                }
                
            }else if(probs[posverboVBD]>probs[posverboVBN]){
                if(probs[posverboVBD]>probs[posverboVB]){
                    if(probs[posverboVBD]>probs[posverboVBP]){
                        posverbo=posverboVBD;
                    }
                }
                
            }else if(probs[posverboVBN]>probs[posverboVB]){
                if(probs[posverboVBN]>probs[posverboVBP]){
                    posverbo=posverboVBN;
                }
                
            }else if(probs[posverboVB]>probs[posverboVBP]){
                posverbo=posverboVB;
                
            }else{
                posverbo=posverboVBP;
            }
            if(possujeto<posverbo){
             
                Interfaz.TextArea.setText("Activa");
                System.out.println("Activa");
                
            }else{
         
                Interfaz.TextArea.setText("Pasiva");
                System.out.println("Pasiva");
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
    }
    
}