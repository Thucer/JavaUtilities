/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.liststructureexamples;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
// what is .awt.List?
/**
 *
 * @author John
 */
public class ArrayListExamples {
    
    protected static List<String> sList = new ArrayList<>();
    
    protected static <T> void populateList(){
        Scanner input = new Scanner(System.in);
        String s;
        System.out.println("Please enter each element to add to the list, "
                    + "type 'exit' when finished.");
        do{
            
            s = input.nextLine();
            if(s.equals("exit")){
               // break;
            }else{
                sList.add(s);
            }
            
            
        }while(!s.equals("exit"));           
    }
    protected static <T> void printList(){
        System.out.println("String List");
        /*for(String st : sList){
            System.out.println(st);
        }*/
        Iterator<String> iterator = sList.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
//END CLASS
}
