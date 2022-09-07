/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thucer.dnareader.ui;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author John
 */
public class DRUserIOImpl implements DRUserIO{
    private Scanner input = new Scanner(System.in);
    @Override
    public void printTC(String msgOut) {
        System.out.println(msgOut);
    }
    @Override
    public void printTF(String filePath, String stringToFile) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void printTF(String filePath, List<String> stingsToFile) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public double readDouble(String prompt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public float readFloat(String prompt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int readInt(String prompt) {
        boolean isValid = false;
        int output = 0;
        do{
            try{
                System.out.println(prompt);
                output = Integer.parseInt(input.nextLine());
                isValid = true;
            }catch(NumberFormatException e){
                System.out.print("Sorry, that was an invalid entry, please enter"
                        + " whole number, integer, values only.\n");
            }
        }while(!isValid);
                
        return output;
    }


    @Override
    public int readInt(String prompt, int min, int max) {
         boolean inRange = true;
        int output = 0;
        do{
            try{
                System.out.println(prompt);
                output = Integer.parseInt(input.nextLine());
                if(output < min || output > max){
                    System.out.println("Sorry that was an invalid value. The number"
                            + " must be between "+min+" and "+max+".");
                    inRange = false;
                }
                else
                    inRange = true;
            }catch(NumberFormatException e){
                System.out.print("Sorry, that was an invalid entry, please enter"
                        + " whole number, integer, values only.\n");
                inRange = false;
            }
        }while(!inRange);
        
        return output;
    }


    @Override
    public long readLong(String prompt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        String output = input.nextLine();
        
        return output;
    }

    @Override
    public void printTL(String errOut) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
