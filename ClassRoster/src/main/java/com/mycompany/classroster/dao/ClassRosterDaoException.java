/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.classroster.dao;

/**
 *Application specific exception class extends Exception
 * Used to wrap any exceptions preventing implementation leakage
 * @author John
 */
public class ClassRosterDaoException extends Exception{
    //Calls the one argument constructor in Exceptions
    public ClassRosterDaoException(String message){
        super(message);
    }
    //Calls the two argument constructor in Exceptions, takes a string and a
    //throwable as parameters
    public ClassRosterDaoException(String message, Throwable cause){
        super(message, cause);
    }
}
