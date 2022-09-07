/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.adder;

import java.util.Scanner;

/**
 *
 * @author John
 */
public class Adder {

    public static void main(String[] args) {
        Adder add = new Adder();
    //Adder without user input
        System.out.println("Sum equals: " + add.Adder1(3, 2));
    //Adder with user input
        System.out.println("Sum equals: " + add.Adder2());
    }
    public int Adder1(int x, int y)
    {
        int operand1 = x, operand2 = y, sum;
        return sum = operand1 + operand2;
    }
    public int Adder2()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter an integer value for operand1: ");
        int operand1 = Integer.parseInt(input.nextLine());
        System.out.print("Please enter an integer value for operand2: ");
        int operand2 = Integer.parseInt(input.nextLine()), sum;
        return sum = operand1 + operand2;    
    }
}
