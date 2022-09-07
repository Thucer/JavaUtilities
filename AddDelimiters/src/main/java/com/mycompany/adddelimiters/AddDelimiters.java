/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.adddelimiters;

/**
 *Very basic program adds delimeters to a String before placing in a text file.
 * @author John
 */
public class AddDelimiters {
    protected static String[][] statesAndCapitals = new String[50][2];
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
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

    protected static String[] toArray(String s){
            String[] stringArray = s.split("\n");
            return stringArray;
        }
    protected static String[][] refineArray(String[] s){
        String[] refinedArray = new String[2];
        //TESTSystem.out.println("Length = "+s.length);
        for (int i = 0; i < s.length; i++) {  
           refinedArray = s[i].split("\\s+");
           statesAndCapitals[i] = new String[]{refinedArray[0],refinedArray[1]};
        }
        return statesAndCapitals;
    }
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
    protected static void printValues(Map mapObj){
        Collection<String> valueCollection = mapObj.values();
        
            for(String mapItem : valueCollection){
                System.out.println((mapItem).replace("_", " "));
            }
    }
    protected static void printValues( ){
        
    }




}
