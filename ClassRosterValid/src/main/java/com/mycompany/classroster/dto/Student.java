/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.classroster.dto;

/**
 *This class exists in the DTO package and will be used to facilitate data
 * transfer between project packages and classes.
 * @author John
 */
public class Student {
    //variable cohort should hold the programming language and month/year
    private String firstName, lastName, studentID, cohort;

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

    public String getCohort() {
        return cohort;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCohort(String cohort) {
        this.cohort = cohort;
    }
    
}
