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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import javax.swing.JFileChooser;
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
   public static final String SEPARATOR=";";
   public static final String QUOTE="\"";
   public static String contenido;
   public static BufferedReader br;
    public static void main(String[] args) {
        // TODO code application logic here
        Interfaz ventana = new Interfaz();
        ventana.setTitle("Interfaz Taller Dos");
        ventana.setVisible(true);
        
    }
    
        public void Detectar(String sentence) throws InvalidFormatException, IOException{
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
                 
                 
                if(tags[i].equals("NNP") || tags[i].equals("PRP") || tags[i].equals("NNS") || tags[i].equals("NN")){
                    if(estado==false){
                        possujeto=i;
                        estado = true;
                    }
                    
                }
                
            }

            if(possujeto<posverbo){
                String enviar =Interfaz.TextArea.getText();
                enviar = enviar + ","+"Activa";
                Interfaz.TextArea.setText(enviar);
                System.out.println("Activa");
                
            }else{
                String enviar =Interfaz.TextArea.getText();
                enviar = enviar +","+ "Pasiva";
                Interfaz.TextArea.setText(enviar);
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