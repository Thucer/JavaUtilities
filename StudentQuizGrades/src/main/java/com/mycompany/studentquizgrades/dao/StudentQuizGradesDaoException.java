/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.studentquizgrades.dao;

/**
 *Application Specific exception class
 * @author John
 */
public class StudentQuizGradesDaoException extends Exception{
    
    public StudentQuizGradesDaoException(String msg){
        super(msg);
    }
    //Calls the two argument constructor in Exceptions, takes a string and a
    //throwable as parameters
    public StudentQuizGradesDaoException(String msg, Throwable cause){
        super(msg, cause);
    }
}
