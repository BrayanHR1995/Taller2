/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.taller03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;



/**
 *
 * @author Pavilion g4
 */
public class LeerCsv {
    
   private static final String SEPARATOR=";";
   private static final String QUOTE="\"";
   private static String contenido;
   private static BufferedReader br;
   
   LeerCsv (){
       contenido ="";
       br = null;
   }
   
   public String mostrarCsv (String abre)throws IOException{
       
      try {
         br =new BufferedReader(new FileReader(abre));
         String line = br.readLine();
         while (null!=line) {
            String [] fields = line.split(SEPARATOR);
            fields = removeTrailingQuotes(fields);
            contenido = contenido + Arrays.toString(fields) + "\n";
            contenido=contenido.replace("[", "");
            contenido=contenido.replace("]", "");
            line = br.readLine();
         }
      } catch (Exception e) {
         System.out.println("No se pudo abrir el archivo");
      } finally {
         if (null!=br) {
            br.close();
         }
      }
      return contenido;
   }
   
   private static String[] removeTrailingQuotes(String[] fields) {

      String result[] = new String[fields.length];

      for (int i=0;i<result.length;i++){
         result[i] = fields[i].replaceAll("^"+QUOTE, "").replaceAll(QUOTE+"$", "");
      }
      return result;
   }
    
}