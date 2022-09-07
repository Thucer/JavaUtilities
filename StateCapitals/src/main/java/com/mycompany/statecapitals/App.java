/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.statecapitals;

/**
 *
 * @author John
 */
public class App {
    public static void main(String[] args){
      /*  for(String s : StateCapitals.toArray(StateCapitals.statesCapitalsNames)){
            System.out.println(s);
        }
       /* System.out.println("\n");
        for(String f : StateCapitals.refineArray(StateCapitals.toArray(StateCapitals.statesCapitalsNames))){
            System.out.println(f);
        }*/
        System.out.println("\n");
        
        //StateCapitals.refineArray(StateCapitals.toArray(StateCapitals.statesCapitalsNames));
        System.out.println("Here are all of the states in the US:");
        StateCapitals.printKeys(StateCapitals.arrayToHashMap(StateCapitals.refineArray(StateCapitals.toArray(StateCapitals.statesCapitalsNames))));
        System.out.println("\n\nHere are all of the state's capitals in the US:");
        StateCapitals.printValues(StateCapitals.arrayToHashMap(StateCapitals.refineArray(StateCapitals.toArray(StateCapitals.statesCapitalsNames))));
        System.out.println("\n\nHere are all the states in the US and their capitals:");
        StateCapitals.printMap(StateCapitals.arrayToHashMap(StateCapitals.refineArray(StateCapitals.toArray(StateCapitals.statesCapitalsNames))));
        
    
    }
            
}
