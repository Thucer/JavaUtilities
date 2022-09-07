/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.statecapitalsfileio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author John
 */
public class StateCapitalsFileIO{
    //Creates Map object
    protected static Map<String, String> statesAndCapitalsMap = new HashMap<>();
    //Creates a Map object of type HashMap
    protected static void makeMap()throws IOException {
        //Scanner used to read from text file, fileReader requires valid file
        //path if the desired file is not in the program files.
        Scanner fileScan = new Scanner(new BufferedReader(new FileReader("StateCapitalsFormatted.txt")));
        //while loop iterates through the file line by line. hasNext returns 
        //false when no more lines are present to be read
        while(fileScan.hasNext()){
            //sets fileLine equal to the next line of the file the Scanner
            //object grabs
            String fileLine = fileScan.nextLine();
            //fileLine now holds a single lline read from the file, this needs
            //to be split along the delimeters, in this case ::
            arrayToHashMap(splitString(fileLine));
        }
        printMap(statesAndCapitalsMap);
        
    }
    //Following method spilts a string along :: delimiters, for this application
    // it is known there are only two strings per line, thus the array is set
    // to two, this can be changed for a more general approach.
    protected static String[] splitString(String s){
        final String DELIMITER = "::";
        String[] splitStrings = s.split("::");
        //TESTSystem.out.println("Length = "+splitStrings.length);
        //for (int i = 0; i < splitStrings.length; i++) {  
           //splitStrings = s.split("::");
        //}
        return splitStrings;
    }
    //Takes the array returned by splitString and places values in a HashMap
    protected static Map<String,String> arrayToHashMap(String[] stArray){
         
        //Scanner used to read from text file, fileReader requires valid file
        //path if the desired file is not in the program files.
        int bounds = stArray.length;
        //Interior for loop is likely unneccessary as columns are either 0
        //or 1
        for(int i = 0; i < bounds - 1; i++){
            statesAndCapitalsMap.put(stArray[i],stArray[i+1]);
             
        }
        return statesAndCapitalsMap;
    }
    //Prints a map object
    //Could also be achieved with a collection to grab the values.
    protected static void printMap(Map mapObj){
        Set<String> keySet = mapObj.keySet();
        //Collection<String> valueCollection = mapObj.values();
        
            for(String mapItem : keySet){
            System.out.println(("The Capital of "+mapItem+" is "
                    + mapObj.get(mapItem)).replace("_", " "));
            }
   
    }
    
}
