/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.simplefileio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author John
 */
public class SimpleFileIO {

    public static void main(String[] args) throws IOException {
        /*
        //This line creates a new PrintWriter object 'toFile'
        //The PrintWriter object then can print formatted text output
        //to the text output stream which, in turn, is handed off to
        //a FileWriter which writes the output stream to a specified
        //file. FileWriter will create the file if non exists or overwrite
        //an existing file of the same name.
        */
        PrintWriter toFile = new PrintWriter(new FileWriter("OutputFile.txt"));
        //Calls the PrintWriter object to print the string to the 
        //text output stream        
        toFile.println("This is a test of file inputs and outputs.");
        toFile.println("line 2");
        //flush() 'flushes' everything in the text out put stream and the
        //PrintWriter buffer to be written to the file
        toFile.flush();
        //Closes the file, database etc.
        toFile.close();
        //Creates new scanner object. Scanner object calls on FileReader to 
        //open the desired file and BufferedReader to parse(?).
        Scanner fileScan = new Scanner(new BufferedReader(new FileReader("OutputFile.txt")));
        //while loop iterates through the file line by line. hasNext returns 
        //false when no more lines are present to be read
        while(fileScan.hasNext()){
            //sets fileLine equal to the next line of the file the Scanner
            //object grabs
            String fileLine = fileScan.nextLine();
            //prints most recent line of file read
            System.out.println(fileLine);
        }
        System.out.print("File read complete.\n");
        

    }
}
