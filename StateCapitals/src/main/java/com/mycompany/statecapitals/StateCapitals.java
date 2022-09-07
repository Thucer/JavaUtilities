/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.statecapitals;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * This program prints a list of the states, the capitals and then a lists of
 * each state and its capital. This program achieves this using HashMaps.
 * Any string can be passed through the program, however, they program cuts the 
 * provided string along white space, thus any space characters that should remain 
 * must be represented by an underscore in the initial list. This program could also
 * read from a text file with some simple added functionality.
 * @author John
 */
public class StateCapitals {
    protected static String[][] statesAndCapitals = new String[50][2];
    //This list requires any space characters to be replaced with '_' as the
    //way this info is read will chop up the strings based on white space.
    //'_' will be replaced with 'space' character before final print out.
    protected static String statesCapitalsNames =
            "Alabama	Montgomery\n" +
        "Alaska	Juneau\n" +
        "Arizona	Phoenix\n" +
        "Arkansas	Little_Rock\n" +
        "California	Sacramento\n" +
        "Colorado	Denver \n" +
        "Connecticut	Hartford\n" +
        "Delaware	Dover\n" +
        "Florida	Tallahassee \n" +
        "Georgia	Atlanta\n" +
        "Hawaii	Honolulu\n" +
        "Idaho	Boise\n" +
        "Illinois	Springfield\n" +
        "Indiana	Indianapolis\n" +
        "Iowa	Des_Moines\n" +
        "Kansas	Topeka\n" +
        "Kentucky	Frankfort\n" +
        "Louisiana	Baton_Rouge\n" +
        "Maine	Augusta\n" +
        "Maryland	Annapolis\n" +
        "Massachusetts	Boston\n" +
        "Michigan	Lansing\n" +
        "Minnesota	Saint_Paul\n" +
        "Mississippi	Jackson\n" +
        "Missouri	Jefferson_City\n" +
        "Montana	Helena\n" +
        "Nebraska	Lincoln\n" +
        "Nevada	Carson_City\n" +
        "New_Hampshire	Concord \n" +
        "New_Jersey	Trenton\n" +
        "New_Mexico	Santa Fe\n" +
        "New_York	Albany\n" +
        "North_Carolina	Raleigh\n" +
        "North_Dakota	Bismarck\n" +
        "Ohio	Columbus\n" +
        "Oklahoma	Oklahoma_City\n" +
        "Oregon	Salem\n" +
        "Pennsylvania	Harrisburg\n" +
        "Rhode_Island	Providence\n" +
        "South_Carolina	Columbia\n" +
        "South_Dakota	Pierre\n" +
        "Tennessee	Nashville\n" +
        "Texas	Austin\n" +
        "Utah	Salt_Lake_City\n" +
        "Vermont	Montpelier\n" +
        "Virginia	Richmond\n" +
        "Washington	Olympia\n" +
        "West_Virginia	Charleston\n" +
        "Wisconsin	Madison\n" +
        "Wyoming	Cheyenne";
    
    //Formatting method, takes the string of states and capitols and places each
    //state and corresponding capital as an element in a String array.
    protected static String[] toArray(String s){
        String[] stringArray = s.split("\n");
        return stringArray;
    }
    /*This method refines the array from above by first splitting each element
    //into two elements along the whitespaces. This separates the State from 
    //the capital. These elements are temporarily held in the refinedArray before
    //being passed to the 2D array statesAndCapitals.*/
    protected static String[][] refineArray(String[] s){
        String[] refinedArray = new String[2];
        //TESTSystem.out.println("Length = "+s.length);
        for (int i = 0; i < s.length; i++) {  
           refinedArray = s[i].split("\\s+");
           statesAndCapitals[i] = new String[]{refinedArray[0],refinedArray[1]};
        }
        return statesAndCapitals;
    }
    /*
    This method prints the 2D array built by the refineArray method
    */
    protected static String printTwoArray(String[][] stArray){
        int colLength = stArray[1].length, rowLength = stArray.length;
        for(int i = 0; i < rowLength; i++){
             for(int j = 0; j < colLength; j++){
                System.out.printf("%s\s",stArray[i][j]);
                if(j == 1)
                    System.out.println("");
             }
        }
        
        return "That is all of the US states and their capitals.";
    }
    /*
    This method copies the 2D array info into a HashMap. HashMap Can also be
    made direct from string, see method below.
    */
    protected static Map<String,String> arrayToHashMap(String[][] stArray){
        Map<String, String> statesAndCapitalsMap = new HashMap<>();

        int colLength = stArray[1].length, rowLength = stArray.length;
        //Interior for loop is likely unneccessary as columns are either 0
        //or 1
        for(int i = 0; i < rowLength; i++){
             for(int j = 0; j < colLength; j++){
                 statesAndCapitalsMap.put(statesAndCapitals[i][0],statesAndCapitals[i][1]);
             }
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
    //Prints onnly the key values of a map object
    protected static void printKeys(Map mapObj){
        Set<String> keySet = mapObj.keySet();
        //Collection<String> valueCollection = mapObj.values();
        
            for(String mapItem : keySet){
                System.out.println((mapItem).replace("_", " "));;
            }
    }
    //Prints only the values of a map object
    protected static void printValues(Map mapObj){
        Collection<String> valueCollection = mapObj.values();
        
            for(String mapItem : valueCollection){
                System.out.println((mapItem).replace("_", " "));
            }
    }
    /*
    This method will format the output to eliminate any _ characters. The way the
    data was written in to the program left _ characters as opposed to a 'space' 
    character.NOT NEEDED AS THE STRING METHOD .replace() WORKS IN THE PRINT METHODS
    */
    protected static void formatOutput(){
        
    }

}
