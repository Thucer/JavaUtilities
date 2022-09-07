/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.factorizer;

import java.util.Scanner;

/**
 *
 * @author John
 * This program will intake a numeric value from the user, determine whether the
 * number is perfect, or prime and return all factors of the number
 */
public class Factorizer {
    //Scanner object class scope
    Scanner input = new Scanner(System.in);
    //method gets number to be evaluated from user, takes no args returns an int
    public int getNumber(){
        System.out.print("Please enter an integer value to be evaluated: ");
        int number = Integer.parseInt(input.nextLine());
        
        return number;
    }
    //evaluates whether the number chosen is prime, takes an integer arg 
    //returns boolean
    public boolean isPrime(int x){
        boolean isPrime = false;
        //counts number of factors to determine prime
        int factors = 0;
        for(int i = x; i > 0; i--){
            if(x % i == 0)
                factors++;
        }
        if(factors == 2){
            System.out.print("The number "+x+" is prime.");
            isPrime = true;
        }
        else{
            System.out.print("The number "+x+" is not prime.");
        }
      return isPrime;
    }
    //evaluates whether the number is perfect, takes one int arg
    //return boolean
    public boolean isPerfect(int x){
        boolean isPerfect = false;
        //determines and sums factors
        int factorSum = 0;
        for(int i = x; i > 0; i--){
            if(x % i == 0){
                factorSum = factorSum + i;
            }
        }
            if(factorSum - x == x){
                System.out.print("The number "+x+" is perfect.");
                isPerfect = true;
            }else
                System.out.print("The number "+x+" is not perfect.");
        return isPerfect;
    }
    /*gets all factors and places them in an array
    *This is problematic if the number chosen is large as the array will have
    *many indices simply holding zeros. These can be eliminated in the print 
    *out however keeping that much memory for useless data seems wasteful.
    *the array should be truncated, which in this case will be achieved by
    *copying the portion of the array that contains valid factors into a new 
    *array. This entire function may be better achieved in a list or arrayList
    *as they offer more dynamic sizing options.
    */
    public int[] getFactors(int x){
        //Array bounds initially set to value of x
        //this ensures all factors fit
        int[] factorArrayLong = new int[x];
        int factorIndex=0;
        for(int i = x; i > 0; i--){
            if(x % i == 0){
                factorArrayLong[factorIndex] = i;
                factorIndex++;
            }
        }
        /*This next section will 'truncate' the array. Java does not allow 
        *dynamic array sizing so this will be accomplished by copying the
        *part of the array containing factors into a new array and leaving behind
        *all of the meaningless zeros. Again, this may be expedited by using a list
        *or arrayList structure.
        *
        *
        *new factorArray will not hold meaningless zeros, the number of indices
        *is known and stored in the factorIndex variable
        */
        int[] factorArray = new int[factorIndex];
        int newIndexCount = 0;
        for(int element : factorArrayLong){
            if(element != 0){
                factorArray[newIndexCount] = element;
                newIndexCount++;
            }
        }
        //This section prints out the factors
        System.out.print("The number: "+x+" has "+factorIndex+" factors, they are: ");
        for(int elements : factorArray)
            System.out.print(elements+" ");
                
        return factorArray;
    }
    public static void main(String[] args) {
        Factorizer run = new Factorizer();
        int number = run.getNumber();
        //System.out.println("Hello World!");
    
        
        run.getFactors(number);
        System.out.println("");
        run.isPrime(number);
        System.out.println("");
        run.isPerfect(number);
    }
}
