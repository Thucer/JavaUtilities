/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simplecalculator;

import java.util.Scanner;
/**
 *This is a simple calculator program. It will prompt the user for two operands
 * along with what type of operation, addition, multiplication, subtraction or
 * division, the user wants to perform. The program will run infinitely until the
 * user keys in the exit code.
 * @author John
 */
public class App {
    private static final boolean CONTROL = true;

    
    public static void main(String[] args) {
        //App run = new App();
        
        //creates an infinite loop, this program will run until exited by 
        //the user
        while(CONTROL){
            //run.doCalculations();
            UserActions.doCalculations();
        }
    }
}
