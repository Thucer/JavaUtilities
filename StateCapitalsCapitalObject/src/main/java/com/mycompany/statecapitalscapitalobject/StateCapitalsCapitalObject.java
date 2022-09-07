/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.statecapitalscapitalobject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author John
 */
public class StateCapitalsCapitalObject{
    //Creates Map object
    protected static Map<String, Capital> statesAndCapitalsMap = new HashMap<>();
    //This captial variable will be initialized by a constructor call in the 
    //method create capital. Declared here so it is only constructed once
    protected static Capital capital;
    protected static final int  LINEITEMS = 0;
    //Creates a Map object of type HashMap
    protected static void makeMap()throws IOException {
        //Scanner used to read from text file, fileReader requires valid file
        //path if the desired file is not in the program files.
        Scanner fileScan = new Scanner(new BufferedReader(new FileReader("StatesAndCapitalsInfo.txt")));
        //while loop iterates through the file line by line. hasNext returns 
        //false when no more lines are present to be read
        while(fileScan.hasNext()){
            //sets fileLine equal to the next line of the file the Scanner
            //object grabs
            String fileLine = fileScan.nextLine();
            //fileLine now holds a single lline read from the file, this needs
            //to be split along the delimeters, in this case ::
            arrayToHashMap((splitString(fileLine)));
        }
       // Capital capital = new Capital();
        printOut();
        printMap(statesAndCapitalsMap);
        
        
    }
    //Following method spilts a string along :: delimiters, for this application
    // Array will be automatically defined to the length required to satisfy
    //all of the splits.
    protected static String[] splitString(String s){
        final String DELIMITER = "::";
        String[] splitStrings = s.split(DELIMITER);
        //TESTSystem.out.println("Length = "+s.length);
        //for (int i = 0; i < splitStrings.length; i++) {  
           //splitStrings = s.split("::");
        //}
        return splitStrings;
    }
    //Creates the Capital object based on info provided by the read file
    protected static Capital createCapital(String[] s){
        String name = s[1];
        int population = Integer.parseInt(s[2]);
        float sqMiles = Float.parseFloat(s[3]);
        capital = new Capital(name, population, sqMiles);
        
        return capital;
    }
    //Takes the array returned by splitString and places values in a HashMap
    protected static Map<String, Capital> arrayToHashMap(String[] stArray){
         
        //Scanner used to read from text file, fileReader requires valid file
        //path if the desired file is not in the program files.
        int bounds = stArray.length;
        //create a Capital object
        capital = createCapital(stArray);
        //Interior for loop is likely unneccessary as columns are either 0
        //or 1
        for(int i = 0; i < bounds - 1; i++){
            statesAndCapitalsMap.put(stArray[0],capital);
             
        }
        return statesAndCapitalsMap;
    }
    //counts the number of items stored as values in the map
    protected static int countValues(Map mapObj){
        int numValues = mapObj.values().size();
        return numValues;
    }
    //counts the number of items stored as keys in the map
    protected static int countKeys(Map mapObj){
        int numKeys = mapObj.keySet().size();
        return numKeys;
    }
    //Prints out other info about the hashmap
    protected static void printOut(){
        System.out.println("This hash map is currently holding "+
                countValues(statesAndCapitalsMap)+" Capital items." );
    }
    //Prints a map object
    //Could also be achieved with a collection to grab the values.
    protected static void printMap(Map mapObj){
        Set<String> keySet = mapObj.keySet();
        //Collection<String> valueCollection = mapObj.values();
        //createCapital()
       
            for(String mapItem : keySet){
            System.out.println(("The capital of "+mapItem+" is "
                    + mapObj.get(mapItem)));
            }
   
    }
    //Evaluates Capital object based on population
    protected static void capitalPop(Map mapObj){
        Collection<Capital> mapValues = mapObj.values();
        
        
        
    }
    //Evaluate Capital object based on area in sq miles
    protected static void capitalArea(){
        
    }
    //solicits user for any search parameters
    protected static void getSearches(Map mapObj){
        //Collection for iterator to use
        Collection<Capital> mapValues = mapObj.values();
        //Iterator object to facilitate iteration
        Iterator<Capital> iterate = mapValues.iterator();
        Set<String> mapKeys = mapObj.keySet();
        //declaring new scanner object to read inputs
        Scanner in = new Scanner(System.in);
        System.out.println("Would you like to perform any search queries over"
                + "this map? Y/N ");
        String choiceThree, choiceTwo, choice = in.nextLine();
        int choicePop;
        float choiceArea;
        //Gets whether the user wants to search info based on specific criteria
        switch(choice){
                case "Y" :
                    System.out.println("Okay, would you like to search by "
                            + "'population' or 'area'? ");
                    choiceTwo = in.nextLine();
                    switch(choiceTwo){
                        //Evaluates the enties based on capital population
                        case "population" :
                            System.out.println("Okay, please enter a population"
                                    + " amount to evaluate.");
                            choicePop = Integer.parseInt(in.nextLine());
                            System.out.println("Great, would you like to search "
                                    + "for cities with a 'greater' or 'lesser' "
                                    + "population? ");
                            choiceThree = in.nextLine();
                            //will hold the next Capital value provided by
                                    //iterator
                                Capital next;
                            switch(choiceThree){
                                case "greater" :
                                //While there is more to iterate
                                     while(iterate.hasNext()){
                                    //loops through key values     
                                        for(String key : mapKeys){
                                                next = iterate.next();
                                             if(next.getPopulation() >= choicePop)
                                             {
                                                System.out.println(key+" -> "+next.getName()+
                                                  " | "+next.getPopulation()+" | "+
                                                   next.getSqMiles());
                                               }
                                        } 
                                     }
                                     break;
                                case "lesser" :
                                //While there is more to iterate
                                     while(iterate.hasNext()){
                                    //loops through key values     
                                        for(String key : mapKeys){
                                                next = iterate.next();
                                             if(next.getPopulation() <= choicePop)
                                             {
                                                System.out.println(key+" -> "+next.getName()+
                                                  " | "+next.getPopulation()+" | "+
                                                   next.getSqMiles());
                                               }
                                        } 
                                     }
                                    break;
                                default :
                                    System.out.println("Sorry, that was not a valid entry. "
                                    + "System exiting, goodbye.");
                                    //System exits with 11 to signify error
                                    System.exit(11);
                                    break;
                            }
                            break;
                        //evaluates the entries based on capital sq miles    
                        case "area" :
                            System.out.println("Okay, please enter an area"
                                    + " to evaluate.");
                            choiceArea = Float.parseFloat(in.nextLine());
                            System.out.println("Great, would you like to search "
                                    + "for cities with a 'greater' or 'lesser' "
                                    + "area? ");
                            choiceThree = in.nextLine();
                            switch(choiceThree){
                                case "greater" :
                                    //While there is more to iterate
                                     while(iterate.hasNext()){
                                    //loops through key values     
                                        for(String key : mapKeys){
                                                next = iterate.next();
                                             if(next.getSqMiles() >= choiceArea)
                                             {
                                                System.out.println(key+" -> "+next.getName()+
                                                  " | "+next.getPopulation()+" | "+
                                                   next.getSqMiles());
                                               }
                                        } 
                                     }
                                    break;
                                case "lesser" :
                                    //While there is more to iterate
                                     while(iterate.hasNext()){
                                    //loops through key values     
                                        for(String key : mapKeys){
                                                next = iterate.next();
                                             if(next.getSqMiles()<= choiceArea)
                                             {
                                                System.out.println(key+" -> "+next.getName()+
                                                  " | "+next.getPopulation()+" | "+
                                                   next.getSqMiles());
                                               }
                                        } 
                                     }
                                    break;
                                default :
                                    System.out.println("Sorry, that was not a valid entry. "
                                    + "System exiting, goodbye.");
                                    //System exits with 11 to signify error
                                    System.exit(11);
                                    break;
                            }
                            break;
                        default :
                            System.out.println("Sorry, that was not a valid entry. "
                            + "System exiting, goodbye.");
                            //System exits with 11 to signify error
                            System.exit(11);
                            break;
                    }
                    break;
                case "N" :
                    System.out.print("\nThank you. Goodbye.\n");
                    System.exit(0);
                    break;
                default :
                    System.out.print("Sorry, that was not a valid entry. "
                        + "System exiting, goodbye.");
                    //System exits with 11 to signify error
                    System.exit(11);
                    break;
        }
    }
  
}