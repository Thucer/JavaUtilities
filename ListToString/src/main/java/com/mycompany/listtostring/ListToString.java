/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.listtostring;

/**
 *This program takes a list and formats it into individual strings based on white
 * spaces
 * @author John
 */
public class ListToString {


    public static void main(String[] args) {
        for(String s : StateCapitolNames.toArray(StateCapitolNames.stateNames)){
            System.out.println(s);
        }
        
    }
}
