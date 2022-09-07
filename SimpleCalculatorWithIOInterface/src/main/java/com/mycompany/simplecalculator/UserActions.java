/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simplecalculator;

import java.util.Scanner;

/**
 *Prompts the user for inputs and validates given inputs
 * @author John
 */
public class UserActions {
    private static UserIO run = new UserIOImplementation();
    private static double operandOne, operandTwo;
    private static Scanner input = new Scanner(System.in);
    private static final String EXIT = "exit";
    private static final boolean CONTROL = true;

    //Checks if user has keyed in the exit code
    protected static void exitCheck(String x){
        boolean jumpOut = false;
        //x = input.nextLine();
        if(x.equals(EXIT)){
            run.print("Thank you, goodbye.\n");
                System.exit(0);
        }
        //return jumpOut;
    }
    //prompts the user for their inputs and validates given inputs    
    protected static <T>String getChoice(){
        int attempts = 1;
        String choice, exitCheck;
        boolean isValid = false, shouldRun = false;
        run.print("This is a simple calculator. Please follow the "
                    + "prompts to perform calculations.\nEnter 'exit' anytime "
                    + "to terminate the program.\n");
        
            run.print("Please enter a value for the first operand: ");
            exitCheck = input.nextLine();
            exitCheck(exitCheck);
                do{
                    try{
                        exitCheck(exitCheck);
                        operandOne = Double.parseDouble(exitCheck);
                        shouldRun = true;
                    }catch(NumberFormatException e){
                        run.print("Sorry, that was an invalid entry."
                                + " Please enter a numeric value. ");
                        exitCheck = input.nextLine();
                        }
                    }while(!shouldRun);
            shouldRun = false;
            run.print("Please enter a value for the second operand: ");
            exitCheck = input.nextLine();
            exitCheck(exitCheck);
            do{
                    try{
                        exitCheck(exitCheck);
                        operandTwo = Double.parseDouble(exitCheck);
                        shouldRun = true;
                    }catch(NumberFormatException e){
                        System.out.print("Sorry, that was an invalid entry."
                                + " Please enter a numeric value. ");
                        exitCheck = input.nextLine();
                        }
                    }while(!shouldRun);
            shouldRun = true;
         /* }catch(NumberFormatException e){
              System.out.print("Sorry, these values must be numeric.");
          }*/
            run.print("Would you like to multiply, divide, add "
                        + "or subtract? ");        
            do{
                choice = input.nextLine();
                exitCheck(choice);
                if(choice.equals("multiply") || choice.equals("divide") 
                        || choice.equals("add") || choice.equals("subtract")){
                    isValid = true;
                }else if(attempts > 4){
                    run.print("Sorry, you have entered too many "
                            + "invalid entries. Goodbye.\n");
                    System.exit(0);
                }else{
                    run.print("Sorry that was not a valid option. Would you like "
                            + "to 'multiply', 'divide', 'add' "
                        + "or 'subtract'? ");
                    attempts++;
                    /*if(input.nextLine().equals("multiply") || input.nextLine().equals("divide") 
                        || input.nextLine().equals("add") || input.nextLine().equals("subtract")){
                    choice = input.nextLine();
                    }*/
                }
            }while(!isValid);
            run.print("Operand 1 = "+operandOne+", operand two "
                       + "= "+operandTwo+".\n");
        return choice;
    }
    //Does the necessary calculations using SimpleCalculator class methods
    //based on user choices. Prompts user if division by zero.
    public static void doCalculations(){
           //SimpleCalculator make = new SimpleCalculator();
           //System.out.println("Operand 1 = "+operandOne+", operand two "
                //   + "="+operandTwo+"."); 
           String divByZero = "";
           switch(getChoice()){
                case "multiply" :
                    run.print("Multiplication:\nProduct = "
                            +SimpleCalculator.multiply(operandOne,operandTwo)+"\n");
                    break;
                case "divide" :
                    if(operandTwo == 0){
                        run.print("Are you sure you want to divide by "
                                + "zero? Y/N ");
                        divByZero = input.nextLine();
                        exitCheck(divByZero);
                        if(divByZero.equals("Y")){
                            /*as all values are read as doubles this will return
                             *  a quotient of 'Infinity'
                             */
                            run.print("Division:\nQuotient = "
                                +SimpleCalculator.divide(operandOne,operandTwo)+"\n");
                        }else if(divByZero.equals("N")){
                            run.print("Division by 0 aborted. Goodbye.\n");
                            System.exit(0);
                        }else{
                            run.print("Sorry, you have entered an invalid "
                                    + "option. Goodbye");
                            System.exit(9);
                        }
                    }else{
                        run.print("Division:\nQuotient = "
                            +SimpleCalculator.divide(operandOne,operandTwo)+"\n");
                    }
                    break;
                case "add" :
                   run.print("Addition:\nSum = "
                            +SimpleCalculator.add(operandOne,operandTwo)+"\n");
                    break;
                case "subtract" :
                   run.print("Subtraction:\nDifference = "
                            +SimpleCalculator.subtract(operandOne,operandTwo)+"\n");
                    break;
                default :
                        //System exit with error
                        System.exit(11);
                        //could also
                        break;
            }
        }

}
