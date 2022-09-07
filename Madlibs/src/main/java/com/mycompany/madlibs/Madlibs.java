/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.madlibs;
import java.util.Scanner;

/**
 *
 * @author John
 */
public class Madlibs {

    public static void main(String[] args) {
        Madlibs run = new Madlibs();
        System.out.print(run.getUserInput());
        
    }
    /*
        No try/catch blocks used as it is taking string input and would have to user define
        a custom exception with various checks.
    */
    public String getUserInput()
    {
        Scanner input = new Scanner(System.in);
        String[] madLib = new String[10];
        boolean isAString = false;
        System.out.println("Let's play MadLibs!");  
        System.out.println("You need a noun:");
        madLib[0] = input.next();
        System.out.println("You need an adjective:");
        madLib[1] = input.next();
        System.out.println("You need a noun:");
        madLib[2] = input.next();
        System.out.println("You need a number:");
        madLib[3] = input.next();
        System.out.println("You need a adjective:");
        madLib[4] = input.next();
        System.out.println("You need a plural noun:");
        madLib[5] = input.next();
        System.out.println("You need another plural noun:");
        madLib[6] = input.next();
        System.out.println("And one more:");
        madLib[7] = input.next();
        System.out.println("You need a verb:");
        madLib[8] = input.next();
        System.out.println("You need the past tense of the previous verb:");
        madLib[9] = input.next();
    
 
        return madLib[0] + ": the "+ madLib[1]+ " frontier. These are "
                + "the voyages of the starship "+madLib[2]+". It's "
                +madLib[3]+" year mission, to explore strange "+madLib[4]+" "+madLib[5]
                +" to seek out "+madLib[4]+" "+madLib[6]+" and "+madLib[4]+" "+
                madLib[7]+ " to boldy "+ madLib[8]+" where no one has "+madLib[9]+
                " before.";
    }
    
}
