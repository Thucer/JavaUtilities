/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.refactorlabs;

import java.util.Scanner;

/**
 *
 * @author John
 */
public class InterestCalculator {
    //Scanner object given class scope
    Scanner input = new Scanner(System.in);
    //gets the term of investment in years
    public int getYears(){
        int years;
        int invalidTime = 0;
        do{
            System.out.print("How long, in years, do you plan to leave your money invested: ");
            years = Integer.parseInt(input.next());
            if(years < 2){
                System.out.print("Sorry, the minimum duration of investment is 2 years. ");
                invalidTime++;
            }
            if(invalidTime >= 3){
                System.out.print(" Unfortunately, we do not have an account to "
                        + "match your desires. Thank you, goodbye.");
                //System exit here is expected thus the zero code is used
                System.exit(0);
            }
        }while(years < 2);

        return years;
    }
    //gets the compounding period from user
    public String getCompoundingFrequency(){
        String frequency;
        int invalidRate = 0;
        do{
            System.out.print("Please enter your desired compounding frequency: ");
            frequency = input.next();
            //TEST/System.out.println(frequency);
            //using equals() to evaluate actual string value equality
            //== operator would work in this context but as it compares
            //references, not values, it is less robust
            if("daily".equals(frequency) || "monthly".equals(frequency) || "yearly".equals(frequency))
                return frequency;
            else{
                System.out.print("Sorry that's not a valid choice. Please choose "
                        + "between 'daily', 'monthly' or 'quarterly'. ");
                invalidRate++;
            }
            if(invalidRate >= 3){
                System.out.print(" Unfortunately, we do not have an account to "
                        + "match your desires. Thank you, goodbye.");
                //System exit here is expected thus the zero code is used
                System.exit(0);
            }
        }while(!"daily".equals(frequency) || !"monthly".equals(frequency) || !"quarterly".equals(frequency));
        return frequency;
    }
    //gets annual interest rate from user
    public float getInterestRate(){
        float rate;
        int overInterest = 0;
        do{
            System.out.print("Please enter your desired annual interest rate: %");
            rate = Float.parseFloat(input.next());
            if(rate > 10){
                System.out.print("Wow %"+rate+" would be great. Unfortunately"
                        + " the highest rate we offer on any account is 10%.");
                overInterest++;
            }
            if(overInterest >= 3){
                System.out.print(" Unfortunately, we do not have an account to "
                        + "match your desires. Thank you, goodbye.");
                //System exit here is expected thus the zero code is used
                System.exit(0);
            }
        }while(rate > 10);

        return rate;
    }
    //following method gets the dollar amount to invest
    public float getAmount(){
        float amount;
        int insufficientFunds = 0;
        do{
            System.out.print("What is the amount, in US dollars, you are "
                + "looking to invest: $");
            amount = Float.parseFloat(input.next());
            if(amount < 100){
                System.out.print("I'm sorry $"+amount+"0 is not enough to open an"
                        + " account. Bank policy is a $100 minimum principal. ");
            
                insufficientFunds++;
            }
            //if user enters insufficient funds three times program terminates
            if(insufficientFunds >= 3){
                System.out.print("It seems you do not have enough funds"
                        + " to begin investing with us. Thank you, goodbye.");
                //System exit here is expected thus the zero code is used
                System.exit(0);
            }
        }while(amount < 100);
        System.out.print("Great, thanks. Next we need to know what your desired rate of return is. ");
        return amount;
    }
    //method calculates earnings based on user input.
    /*uses compound interest formula 
    *   finalBalance = startingBalance(1+interest%/compoundRate)^(compoundRate*duration)
    * doubles are used over floats for many variables as java.Math.pow requires
    * double args
    */
    public void calculateEarnings(int duration, String compoundRate, float principal, float interest){
        int annualPeriod = 1;
        double startBalance = principal, interestP = interest/100;
        double finalBalance = 0, compoundingPeriod, yearlyEarnings = 0; 
        
        while(annualPeriod <= duration){
            switch(compoundRate){
            case "daily" :
                //startBalance = principal;
                compoundingPeriod = 365;
                finalBalance = startBalance * Math.pow((1 + (interestP/compoundingPeriod)),(compoundingPeriod * 1));//changeannualperiodto1
                yearlyEarnings = finalBalance - startBalance;
                break;
             case "monthly" :
                //adjustedInterest = (interest/12)/100;
                compoundingPeriod = 12;
                finalBalance = startBalance * Math.pow((1 + (interestP/compoundingPeriod)),(compoundingPeriod * annualPeriod));
                yearlyEarnings = finalBalance - startBalance;
                break;
             case "quarterly" :
                compoundingPeriod = 4;
                finalBalance = startBalance * Math.pow((1 + (interestP/compoundingPeriod)),(compoundingPeriod * annualPeriod));
                yearlyEarnings = finalBalance - startBalance;
                break;
             default :
                /*error handling in getInterestRate should ensure there are no
                 *invalid values here, however, if one slips by an error message
                 *will output and the program will terminate
                 */
                System.out.print("Something has gone wrong, "
                     + "please contact support for further assistance");
                //Exit code set arbitrarily to 12 to signify improper 
                //termination, can sub in any non-sero value
                System.exit(12);
                break;
            }

            System.out.print("Year "+annualPeriod+":\n");
                    System.out.print("Beginning balance: $"+String.format("%.2f",startBalance)+"\n"
                            + "Final balance: $"+String.format("%.2f",finalBalance)+"\n"
                         + "Yearly earnings: $"+String.format("%.2f",yearlyEarnings)+"\n");
                    
            startBalance = finalBalance;
            annualPeriod++;
        }
    }
    /*Following takes no arguments. Method prints the banks welcome message and
    * executes the various get methods to collect required info.    
    */
    public void welcomeMessage(){
        //Line broken for readability
        System.out.print("Hello, welcome to Madeup Bank. I am glad you've "
                + "chosen to open an account with us. We have a few different "
                + "options so I would like get some information from you."
                + "\nFirst, ");
        float principal = getAmount();
        //System.out.print("Great, thanks. Next we need to know what your desired rate of return is. ");
        float interest = getInterestRate();
        System.out.print("Thanks, we're almost done. ");
        int duration = getYears();
        System.out.print("Okay, and finally, we offer three different compounding"
                + " options, daily, monthly and quarterly.");
        String frequency = getCompoundingFrequency();
        calculateEarnings(duration, frequency, principal, interest);
        //calculateEarnings(duration, frequency, principal, interest);
    }
    /*
    public static void main(String[] args) {
        InterestCalculator run = new InterestCalculator();
        
        run.welcomeMessage()
    }
    */
}
