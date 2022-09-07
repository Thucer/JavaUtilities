/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.liststructureexamples;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

/**
 *HashMaps hold two values the key and the value ordered as (key, value)
 * @author John
 * @param <T>
 * @param <U>
 */
public class HashMapExamples<T,U> {
/*    
//sObj and D for String and Double object
    protected T tObj;
    protected U uObj;
    protected HashMapExamples(T tObj, U uObj) {
        this.tObj = tObj;
        this.uObj = uObj;
    }
  */  
    protected static Map<String, Double> foodCosts = new HashMap<>();
    protected static Set<String> foodSet = foodCosts.keySet();
    protected static Collection<Double> costSet = foodCosts.values();
    //This syntax allows for the creation and output of a set
    //the set mirrors all the values of the HashMap except they are organized
    //as a Set.
    protected static Set<Entry<String, Double>> foodCostsToPrint = foodCosts.entrySet();
    protected static void populateMap(){
        Scanner input = new Scanner(System.in);
        String food;
        double cost;
        boolean goodLoop = true;
        System.out.println("Please enter the food item followed by the cost. "
                + "Enter '0000' to terminate the program.");
        do{
        
        food = input.nextLine();
        if(food.equals("0000")){
            goodLoop = false;
            break;
        }
        cost = Double.parseDouble(input.nextLine());
        if(cost == 0000){
            goodLoop = false;
            break;
        }
        /*HashMapExamples <String, Double> mapObj = 
                new HashMapExamples<>(input.nextLine(),Double.parseDouble(input.nextLine()));
        System.out.println(mapObj);
        */
        foodCosts.put(food, cost);
        }while(goodLoop);
    }
    protected static void printMap(){
           for(String foods : foodSet){
            System.out.println("The cost of "+foods+" is $"
                    + foodCosts.get(foods));
        }
    }
    
}
