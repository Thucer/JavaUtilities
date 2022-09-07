/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.alphabetprinter;

/**
 *
 * @author John
 */
public class RangeException {
    private int num;
    
    public RangeException(int num){
        this.num = num;
    }
    
    public boolean checkRange(){
        if(num >= 1 && num <= 26)
            return true;
        else
            return false;        
    }
    public void printMessage(boolean x){
        if(x == true)
            System.out.print("");
        else
            System.out.println("Sorry that entry was out of range. Please enter"
                    + "a number between 1 and 26: ");       
    }
    
    
}
