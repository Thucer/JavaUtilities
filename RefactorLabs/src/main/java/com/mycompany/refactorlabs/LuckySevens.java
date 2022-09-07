/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.refactorlabs;


import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author John
 */
public class LuckySevens {
    Scanner input = new Scanner(System.in);
    Random rGen = new Random();
    public int getDollars(){
        System.out.print("How many dollars do you have to lose? ");
        int dollars = Integer.parseInt(input.next());
        
        return dollars;
    }
    /*
    //This method creates and populates an array to represent a variable
    //sided dice, whose sides ascend incrementally 1,2,3...
    public int[] populateArray(){
        int sides;
        System.out.println("How many sides will each dice have?");
        sides = Integer.parseInt(input.next());
        int[] array = new int[sides];
        for(int i = 0; i < sides; i++){
            array[i] = i+1;
        }
        return array;
    }
    //same as above though takes one int arg, this method is more useful when
    //the amount of dice faces is already known.
    public int[] populateArray(int x){
        int[] array = new int[x];
        for(int i = 0; i < x; i++){
            array[i] = i+1;
        }
        return array;
    }
    */
    
    //Method rolls a six sided dice, the dice are represented in a 2d array.
    public void rollDice(){
        //int[] diceOne = {1,2,3,4,5,6};
        //int[] diceTwo = {1,2,3,4,5,6};
        int[][] bothDice = {{1,2,3,4,5,6},{6,5,4,3,2,1}};
        //This statement could be written out as a method of its own if there
        //were many many dice that would be rolled.
        int firstDice = bothDice[0][rGen.nextInt(0, 5)];//bounds are 0 - 5
        int secondDice = bothDice[1][rGen.nextInt(0, 5)];//to match array indices
        int roll = firstDice+secondDice;
        System.out.print("You rolled "+firstDice+" and "+secondDice+" for a "
                + "total of "+roll);
        rGen.nextInt(1, 7);
       
        
    }
    /*Rolls dice without any arrays, this will roll two dice of variable sides
    *the argument int x represents how many sides the dice shall have
    *The return output is the total roll, method will also printout each dice
    */
    public String rollDiceTwo(int x){
        int diceOne = rGen.nextInt(1, x+1);
        int diceTwo = rGen.nextInt(1, x+1);
        System.out.print("First dice: "+diceOne +"\nSecond dice: "+diceTwo+"\n");
        return "You rolled a "+(diceOne+diceTwo)+".";
    }
    public int rollDice(int x){
        int diceOne = rGen.nextInt(1, x+1);
        int diceTwo = rGen.nextInt(1, x+1);
        //System.out.print("First dice: "+diceOne +"\nSecond dice: "+diceTwo+"\n");
        return diceOne+diceTwo;
    }
    public void luckySevensGame(){
        int dollars = getDollars(), rolls = 1, startDollars = dollars, maxDollars = dollars, maxRoll = 1;
        while(dollars != 0){
            if(rollDice(6) == 7)
                dollars = dollars + 4;
            else
                dollars--;
            if(dollars > startDollars){
                maxDollars = dollars;
                maxRoll = rolls;
            }
            rolls++;
        }
        System.out.println("Sorry, all you're money is gone! "+rolls+" rolls! "
                + "why did you keep playing this long?");
        System.out.println("Roll "+maxRoll+" was your peak at $"+maxDollars);
    }
    /*
    public static void main(String[] args) {
        LuckySevens play = new LuckySevens();
        //System.out.println(play.rollDice(6));
        play.luckySevensGame();
    }
    */
}
