/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.alphabetprinter;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author John
 * Program takes an integer, n, from the user and returns the nth letter of the 
 * alphabet printed n times. Basic error checking to ensure the number is valid.
 */
public class AlphabetPrinter {

    public static void main(String[] args) {
        AlphabetPrinter use = new AlphabetPrinter();

        use.getNum();
        
    
    }
    public void printLetter(int x){

        String[] alphabetArray = {"A","B","C","D","E","F",
        "G","H","I","J","K","L","M","N","O","P",
        "Q","R","S","T","U","V","W","X","Y","Z"};
        
        for(int i = 0; i <= x; i++)
        {
            System.out.print(alphabetArray[x-1]);
        } 
    }
    public int getNum(){
        Scanner in = new Scanner(System.in);
        int num = 0;
       //ERROR CHECK BLOCK INCOMPLETE 
        boolean inRange = false;
        do{
            try{
                System.out.print("Enter a number, 1 - 26: ");
                num = in.nextByte();
                printLetter(num);
                inRange = true;
            }catch(ArrayIndexOutOfBoundsException e){
                System.out.print("Sorry that entry was out of range. ");
            }/*catch block to verify integer, not functional
                catch(InputMismatchException e){
                System.out.print("Sorry that entry was invalid. Please enter a "
                        + "whole number value. ");
                throw e;
            }  */
        }while(!inRange);
        
        return num;
    }
}