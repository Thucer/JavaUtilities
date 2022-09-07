/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.rockpaperscissors;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author John
 */
public class RockPaperScissors {
    Scanner input = new Scanner(System.in);
    
    public int getRounds(){
        boolean isInt = false;
        int rounds = 1;
        do{
            try{
                System.out.print("How many rounds do you want to play? ");
                rounds = Integer.parseInt(input.nextLine());
                /*This if block terminates the program completely if an entry
                *out of range is used per the assignment requirements, this
                *could be changed to handle this error and then repeat the
                *question.
                */
                if(rounds < 1 || rounds > 10){
                    System.out.print("Sorry, that was an invalid entry, goodbye.");
                    System.exit(0);
                }
                isInt = true;
            }catch(NumberFormatException e){
                System.out.print("Sorry, that was an invalid entry, please enter"
                        + " whole number values only.\n");
            }
            
        }while(!isInt);
        return rounds;
    }
    public String makeChoice(){
        boolean isValid = false;
        String playerChoice;
        do{
            System.out.println("Do you choose 'rock', 'paper' or 'scissor'? ");
            playerChoice = input.nextLine();
            //verifies that player choice is valid
            if(playerChoice.equals("rock") || playerChoice.equals("paper") 
                    || playerChoice.equals("scissor")){
                        isValid = true;
            }
            else{
                System.out.print("Sorry that is not a valid option.\n");
                isValid = false;
            }
        }while(!isValid);
        return playerChoice;
    }
    public String computerChoice(){
        Random rGen = new Random();
        String computerChoice = "";
        int compChoice = rGen.nextInt(1, 4);
        switch(compChoice){
            case 1 :
                computerChoice = "rock";
                break;
            case 2 :
                computerChoice = "paper";
                break;
            case 3 :
                computerChoice = "scissor";
                break;
        }
        return computerChoice;
    }
    public void playRockPaperScissors(){
        
        int rounds = getRounds(), counter = 1, tie = 0, userWins = 0,
                userLosses = 0;
        while(counter <= rounds){
            String userC = makeChoice(), compC = computerChoice();
            
            if(userC.equals(compC)){
                System.out.print("You both chose "+ userC+" this round is a"
                        + " tie. ");
                tie++;
            }
            else if(userC.equals("rock") && compC.equals("paper")){
                System.out.print("Paper beats rock, you have lost!\n");
                userLosses++;
            }
            else if(userC.equals("paper") && compC.equals("scissor")){
                System.out.print("Scissor beats paper, you have lost!\n");
                userLosses++;
            }
            else if(userC.equals("scissor") && compC.equals("rock")){
                System.out.print("Rock beats scissor, you have lost!\n");
                userLosses++;
            }
            else{
                System.out.print("Congratulations, you have won!\n");
                userWins++;
            }
            counter++;
        }
        System.out.print("There were "+tie+" ties. You won "+userWins+" rounds "
                + "and lost "+userLosses+" rounds.");
        if(userWins > userLosses)
            System.out.println("\nCongratulations, you have won the game!");
        else if(userWins < userLosses)
            System.out.println("\nSorry, you have lost the game :( !");
        else
            System.out.println("\nThere are no winner or losers, it's a tie!");
        
        //Determines if the game will play again
        System.out.print("Do you want to play again Y/N ");
        String playAgain = input.nextLine();
        switch(playAgain){
                case "Y" :
                    playRockPaperScissors();
                    break;
                case "N" :
                    System.out.print("Thanks for playing!");
                    System.exit(0);
                    break;
        }
    }
    
    public static void main(String[] args) {
        RockPaperScissors run = new RockPaperScissors();
        run.playRockPaperScissors();
    }
}
