/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.thucer.dnareader.ui;
import java.util.List;

/**
 *
 * @author John
 */
public interface DRUserIO {
//PRINT METHODS
    /**
     * METHOD printTC
     * Method is responsible for printing out a String message to the console.
     * Method takes one String parameter, return is void.
     * @param msgOut is the String to be printed out to the console
     */
    void printTC(String msgOut);
    /**
     * METHOD printTL
     * Method is responsible for printing error, exception or other messages to
     * the log. These messages will not display on the user console.
     * @param errOut 
     */
    void printTL(String errOut);
    void printTF(String filePath, String stringToFile) ;
    void printTF(String filePath, List<String> stingsToFile) ;
//INPUT/READER METHODS    
    double readDouble(String prompt);
    double readDouble(String prompt, double min, double max);
    float readFloat(String prompt);
    float readFloat(String prompt, float min, float max);
    /**
     * METHOD readInt
     * Method is responsible for delivering a prompt to the user to solicit
     * an integer input. The method will return the given integer. The method
     * will verify whether the input was actually an integer, if not it will
     * output a message to the console to alert the user and prompt for a new
     * entry.
     * @param prompt is a String prompting the user to enter integer data
     * @return the return is the validated integer.
     */
    int readInt(String prompt);
    /**
     * METHOD readInt
     * Method is responsible for delivering a prompt to the user to solicit
     * an integer input. The method will return the given integer. The method
     * will verify whether the input was actually an integer, if not it will
     * output a message to the console to alert the user and prompt for a new
     * entry. This method version takes two additional parameters to set the 
     * minimum and maximum acceptable values, inclusive. Integers outside of 
     * the range will not be considered valid.
     * @param prompt is a String prompting the user to enter integer data
     * @param min is an integer representing the minimum valid value
     * @param max is an integer representing the maximum valid value
     * @return the return is the validated integer.
     */
    int readInt(String prompt, int min, int max);
    long readLong(String prompt);
    long readLong(String prompt, long min, long max);
    /**
     * METHOD readString
     * Method is responsible for delivering a prompt to the user to solicit a 
     * String input. The method will return the given String.
     * @param prompt
     * @return 
     */
    String readString(String prompt);
}
