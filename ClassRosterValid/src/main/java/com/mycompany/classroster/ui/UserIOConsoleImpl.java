/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.classroster.ui;

import java.util.Scanner;

/**
 *
 * @author John
 */
public class UserIOConsoleImpl implements UserIO{
    protected Scanner input = new Scanner(System.in);
    @Override
    public void print(String message) {
       System.out.println(message);
    }

    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        String output = input.nextLine();
        
        return output;
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
            }
        }while(!inRange);
        
        return output;
    }

    @Override
    public double readDouble(String prompt) {
        boolean isValid = false;
        double output = 0;
        do{
            try{
                System.out.println(prompt);
                output = Double.parseDouble(input.nextLine());
                isValid = true;
            }catch(NumberFormatException e){
                System.out.print("Sorry, that was an invalid entry, please enter"
                        + " whole number, integer, values only.\n");
            }
        }while(!isValid);
                
        return output;
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        boolean inRange = true;
        double output = 0;
        do{
            try{
                System.out.println(prompt);
                output = Double.parseDouble(input.nextLine());
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
            }
        }while(!inRange);
        
        return output;
    }

    @Override
    public float readFloat(String prompt) {
        boolean isValid = false;
        float output = 0;
        do{
            try{
                System.out.println(prompt);
                output = Float.parseFloat(input.nextLine());
                isValid = true;
            }catch(NumberFormatException e){
                System.out.print("Sorry, that was an invalid entry, please enter"
                        + " whole number, integer, values only.\n");
            }
        }while(!isValid);
                
        return output;
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        boolean inRange = true;
        float output = 0;
        do{
            try{
                System.out.println(prompt);
                output = Float.parseFloat(input.nextLine());
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
            }
        }while(!inRange);
        
        return output;
    }

    @Override
    public long readLong(String prompt) {
        boolean isValid = false;
        long output = 0;
        do{
            try{
                System.out.println(prompt);
                output = Long.parseLong(input.nextLine());
                isValid = true;
            }catch(NumberFormatException e){
                System.out.print("Sorry, that was an invalid entry, please enter"
                        + " whole number, integer, values only.\n");
            }
        }while(!isValid);
                
        return output;
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        boolean inRange = true;
        long output = 0;
        do{
            try{
                System.out.println(prompt);
                output = Long.parseLong(input.nextLine());
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
            }
        }while(!inRange);
        
        return output;
    }
    
}
