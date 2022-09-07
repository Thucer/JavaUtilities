/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.studentquizgrades.dto;

import java.util.ArrayList;

/**
 *
 * @author John
 */
public class Student {
    //variable studentID will be used in the extensions
    //classGroup will be used if multiple classes need to be averaged
    private String firstName, lastName, studentID, classGroup;
    private ArrayList<Integer> quizGrades = new ArrayList<>();

    
    
    public ArrayList<Integer> getQuizGrades() {
        return quizGrades;
    }
    public Student(String studentID) {
        this.studentID = studentID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getClassGroup() {
        return classGroup;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setClassGroup(String classGroup) {
        this.classGroup = classGroup;
    }
}
