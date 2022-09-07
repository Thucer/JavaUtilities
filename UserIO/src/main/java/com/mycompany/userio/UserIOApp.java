/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.userio;

/**
 *
 * @author John
 */
public class UserIOApp {
    public static void main(String[] args){
        UserIO run = new UserIOImplementation();
        run.readInt("Please enter a value in range", 1,7);
        run.readInt("Please enter a number:");
    }
}
