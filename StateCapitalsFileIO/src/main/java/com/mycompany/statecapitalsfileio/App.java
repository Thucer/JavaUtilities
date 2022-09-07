/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.statecapitalsfileio;

import java.io.IOException;

/**
 *Creates a hash map to hold a set of values read from a text document, in this
 * case the states and their capitals. Texxt document is formatted in such a manner
 * that the State will be the key and the Capital will be the value.
 * @author John
 */
public class App {
    public static void main(String[] args) throws IOException{
        StateCapitalsFileIO.makeMap();
        
    }
}
