/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.arraypractice;

import java.util.Random;

/**
 *
 * @author John
 */
public class ArrayPractice {

    //iterates through an int array and populates with random ints from 0-100.
    public void populateArray(int[] array)
    {
        Random randGen = new Random();
        for(int i = 0; i < array.length; i++)
        {
            array[i] = randGen.nextInt(101);
        }
    }
    //Simple combination merges two int arrays taken as arguments
    public void simpleCombination(int[] first, int[] second){
        //length of first and second array declared as named variables
        int firstLength = first.length, secondLength = second.length;
        int[] mergedArray = new int[firstLength+secondLength];
        //The following for blocks copy the initial two array into a new array
        //This is a manual array copy
        for(int i = 0; i < firstLength; i++){
                 mergedArray[i] = first[i];
        }
        /*mergerStartPos is given a separate variable, in this context it is
        // the same as firstLength bust could be changed to alter where the merge
        //begins*/
        int mergerStartPos = first.length;
        for(int i = 0; i < secondLength; i++ ){
            mergedArray[mergerStartPos+i] = second[i];
        }
        /*Prints the merged array
        System.out.print("The merged array has "+mergedArray.length+" elements.");
        for(int element : mergedArray)
            System.out.print(element+" ");
        */
        //Bubble sorts the mergedArray before printing, smallest to largest
        basicBubbleSortAndBreak(mergedArray);
        //Prints the merged array in lines of ten elements each
        System.out.print("The merged array has "+mergedArray.length+" elements.");
        for(int i = 0; i < mergedArray.length; i++){
            if(i % 10 == 0)
                System.out.println("");
            System.out.print(mergedArray[i]+" ");
        }
            
    }
    //Simple combination merges two int arrays taken as arguments
    //This version of the method uses SystemArrayCopy versus manual copy
    public void simpleCombinationSystemArrayCopy(int[] first, int[] second){
        //length of first and second array declared as named variables
        int firstLength = first.length, secondLength = second.length;
        int[] mergedArray = new int[firstLength+secondLength];
        //The following for blocks copy the initial two array into a new array
        //This is a manual array copy
        System.arraycopy(first, 0, mergedArray, 0, firstLength);
        
        /*mergerStartPos is given a separate variable, in this context it is
        // the same as firstLength bust could be changed to alter where the merge
        //begins*/
        int mergerStartPos = first.length;
        
        System.arraycopy(second, 0, mergedArray, mergerStartPos, secondLength);
        
        /*Prints the merged array
        System.out.print("The merged array has "+mergedArray.length+" elements.");
        for(int element : mergedArray)
            System.out.print(element+" ");
        */
        //Bubble sorts the mergedArray before printing, smallest to largest
        basicBubbleSortAndBreak(mergedArray);
        //Prints the merged array in lines of ten elements each
        System.out.print("The merged array has "+mergedArray.length+" elements.");
        for(int i = 0; i < mergedArray.length; i++){
            if(i % 10 == 0)
                System.out.println("");
            System.out.print(mergedArray[i]+" ");
        }
    }
    //Method searches through a string array for a particular key
    //takes one array as arg and one string key
    public void SquirrelTreasure(String[] array, String key){
        //This defines the search key, in this context it is 'nut'
        //this could be changed to evaluate a different search goal
        //String key = key;
        int index = 0; 
        for(String element : array){
            index++;
            if(element == key){
                System.out.print("You've found the oaky treasure!\n"
                        + "it was hiding in index "+ index+".");
            }
        }
                
    }
    //this method works to place a specific string sequence randomly in an array
    //This is like the setter method to the above getter method
    //This takes one string array arg and one String to be placed
    public void hideTreasure(String[] array, String toHide){
        Random newR = new Random();
        array[newR.nextInt(array.length)] = toHide;
        System.out.println("The string has been placed.");
        
    }
    //Evaluates the string contents of an array and counts how many times a
    //given word appears
    public void fruitsBasket(){
        int numOrange=0, numApple=0, numElse=0;
        String[] fruitBasket = {"Orange", "Apple", "Orange", "Apple", "Orange", "Apple",
            "Orange", "Apple", "Orange", "Orange", "Orange", "Apple", "Orange", "Orange",
            "Apple", "Orange", "Orange", "Apple", "Apple", "Orange", "Apple", "Apple",
            "Orange", "Orange", "Apple", "Apple", "Apple", "Banana", "Apple", "Orange",
            "Orange", "Apple", "Apple", "Orange", "Orange", "Orange", "Orange", "Apple",
            "Apple", "Apple", "Apple", "Orange", "Orange", "PawPaw", "Apple", "Orange",
            "Orange", "Apple", "Orange", "Orange", "Apple", "Apple", "Orange", "Orange",
            "Apple", "Orange", "Apple", "Kiwi", "Orange", "Apple", "Orange",
            "Dragonfruit", "Apple", "Orange", "Orange"};
        
        for(String element : fruitBasket){
            switch (element) {
                case "Orange":
                    numOrange++;
                    break;
                case "Apple":
                    numApple++;
                    break;
                default:
                    numElse++;
                    break;
            }      
        }
        System.out.print("There are "+numOrange+" oranges, "+numApple+" apples "
                + "and "+numElse+" pieces of other fruit.");
    }
    //prints colors of a rainbow, or any colors in the array colors
    public void aRainbow(){
        String [] colors = {"red","green","blue","violet","indigo","yellow"};
        //forEach loop iterates through each array item
        for (String color : colors) {
            System.out.print(color + " ");
        }
    }
    //gets positive elements of an int array and returns them as a separate array
    public void getPositive(int [] x){
        int[] positives = new int[x.length];
        for(int i = 0; i < x.length; i++){
            if(x[i] % 2 == 0)
                positives[i] = x[i];
            //this places a -1 value to overwrite any odd numbers
            //this will be used to truncate array or filter the print output
            else
                positives[i] = -1;
        }
        // will sort array smallest to largest before printing
        basicBubbleSortAndBreak(positives);
        for(int i = 0; i < positives.length; i++){
            if(positives[i] == -1)
                System.out.print("");
            else
                System.out.print(positives[i]+" ");
        }
    }
    /*Basic Bubble Sort for a single dimesnion int array, breaks if no swaps made*/
    public void basicBubbleSortAndBreak(int[] array){
        int temp, sortCount = 1;
        boolean madeSwap;
        for(int i = 1; i < array.length; i++)
        {
            madeSwap = false;
            for(int j = 0; j < array.length - i; j++)
            {
                if(array[j] > array[j+1])
                {
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    madeSwap = true;
                    sortCount++;
                }
            }
            if(madeSwap == false)
                {
                    System.out.print("Sorting complete after "+sortCount+" passes,"
                            + " exiting loop.\n");
                    break;
                }
        }
    
    }
    public static void main(String[] args) {
        ArrayPractice practice = new ArrayPractice();
        //System.out.println("Hello World!");
        int[] numbers = new int[100];//{1,2,3,4,5,6,7,8};
        int[] firstHalf = new int[20];
        int[] secondHalf = new int[30];
        String[] hiddenTreasure = new String[100];
        //practice.populateArray(numbers);
        //practice.aRainbow();
        //practice.getPositive(numbers);
        //practice.fruitsBasket();
        /*
        practice.populateArray(firstHalf);
        practice.populateArray(secondHalf);
        for(int element : firstHalf)
             System.out.print(element+" ");
        System.out.println("");
        for(int element : secondHalf)
             System.out.print(element+" ");
        //practice.simpleCombination(firstHalf, secondHalf);
        practice.simpleCombinationSystemArrayCopy(firstHalf, secondHalf);
       */
        practice.hideTreasure(hiddenTreasure, "nut");
        practice.SquirrelTreasure(hiddenTreasure, "nut");
        
    }
}
