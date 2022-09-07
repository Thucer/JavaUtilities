/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.refactorlabs;

/**
 *
 * @author John
 */
public class App {
    public static void runFactorizer(){
        Factorizer run = new Factorizer();
        int number = run.getNumber();
        run.getFactors(number);
        System.out.println("");
        run.isPrime(number);
        System.out.println("");
        run.isPerfect(number);
    }
    //could add a chooser method to allow user to pick which game to play
    public static void main(String [] args){
        System.out.print("Rock Paper Scissors\n");
        RockPaperScissors run = new RockPaperScissors();
        run.playRockPaperScissors();
        System.out.print("\n\nLucky Sevens!\n");
        LuckySevens play = new LuckySevens();
        play.luckySevensGame();
        System.out.print("\nInterest Calculator\n");
        InterestCalculator calculate = new InterestCalculator();
        calculate.welcomeMessage();
        System.out.print("\nFactorize!\n");
        runFactorizer();
        
    }
}
