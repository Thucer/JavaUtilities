/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.simplecalculator;

/**
 *All methods will be defined to take and return doubles. This is to ensure any
 * numeric entry will be handled. Alternatively methods could be overloaded taking
 * various parameters such as int,int int, double etc.
 * @author John
 */
public class SimpleCalculator {
    public static <T> double add(double x, double y){
        double sum = x + y;
        return sum;
    }
    public static double subtract(double x, double y){
        double difference = x - y;
        //double difference = Math.abs(x - y);
        return difference;
    }
    public static double divide(double x, double y){
        double quotient = x/y;
        return quotient;
    }
    public static double multiply (double x, double y){
        double product = x*y;
        return product;
    }
}
