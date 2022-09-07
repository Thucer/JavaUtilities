/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.studentquizgrades.ui;

import com.mycompany.studentquizgrades.dto.Student;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author John
 */
public class StudentQuizGradesView {
    //Creates a 'UserIOConsoleImpl' object 'io' of type UserIO
    //As this has been defined as type UserIO it only has access to the methods
    //defined in the UserIO interface
    //removed and replaced with dependency injection
    //private UserIO io = new UserIOConsoleImpl();
    private UserIO io;
    public StudentQuizGradesView(UserIO io){
        this.io = io;
    }
    public int dispMenuGetChoice(){
            io.print("Main Menu");
            io.print("1. View Enrolled Students");
            io.print("2. Create New Student Record");
            io.print("3. Remove a Student Record");
            io.print("4. View Grades");
            io.print("5. Exit Program");
            return io.readInt("Please select from the above choices.",
                    1, 5);
    }
/**
 * Following section contains all of the methods that ask for some type of input
 *  
 */
    //Prompts user to enter New Student information
    public Student getNewStudentInfo(){
        //String studentId = io.readString("Please enter Student ID");
        String firstName = io.readString("Please enter First Name");
        String lastName = io.readString("Please enter Last Name");
        String studentName = firstName+" "+lastName;
        //Creates a new Student object of type Student called currentStudent
        //this is initialized with a consctuctor which takes one argument
        Student currentStudent = new Student(studentName);
        currentStudent.setFirstName(firstName);
        currentStudent.setLastName(lastName);
                
        return currentStudent;
    }
    public ArrayList<Integer> getStudentGrades(){
        ArrayList<Integer> quizScores = new ArrayList<>();
        String firstName = io.readString("Please enter First Name");
        String lastName = io.readString("Please enter Last Name");
        String studentGrades = io.readString("Please enter student grades "
                + "separated by commas: ");
        String[] studentGradesArr = studentGrades.split(",");
        for (String studentGrade : studentGradesArr) {
            quizScores.add(Integer.parseInt(studentGrade));
        }
       
        return quizScores;
    }
    public String getStudentChoiceId(){
        return io.readString("Please enter the Student ID");
    }
/**
 * Following section contains the methods that all output something
 * 
 */
    public void dispStudentList(List<Student> studentList){
        for(Student currStudent : studentList){
            String studentInfo = String.format("#%s : %s %s", 
                    currStudent.getStudentID(),
                    currStudent.getFirstName(),
                    currStudent.getLastName());
                io.print(studentInfo);
        }
        io.readString("Please hit enter to continue");
    } 
    public void dispStudent(String studentName){
        //if there is an actual student record
        if(studentName != null){
            //io.print(studentName.getStudentID());
            io.print(studentName);
            io.print("");
            //io.print(student.getCohort());
            io.print("");
        }else{
            io.print("No such student.");
        }io.readString("Hit enter to continue.");
    }
    
/**
 * Following section contains all of the methods that display some type of banner
 */
    public void dispCreateStudentBanner(){
        io.print("---->CREATE STUDENT<----");
    }
    public void dispCreateSuccessbanner(){
        io.print("Student record added. Hit enter to continue");
    }
    public void dispAllBanner(){
        io.print("---->CLASS ROSTER<----");
    }
    public void dispStudentBanner(){
        io.print("---->STUDENT RECORD<----");
        }
    public void dispRemoveStudentBanner(){
        io.print("---->Remove Student Record<----");
    }
    public void dispRemovalResult(Student studentRecord){
        //if there is a student record to remove
        if(studentRecord != null){
            io.print("Student record removed.");
        }else{
            io.print("No corresponding student found");
        }io.readString("Hit enter to continue.");
    }
    
    public void dispUnknownCommandBanner(){
        io.print("Sorry, you have enetered an unrecognized command.");
    }
    public void dispErrorMessage(String errorMsg){
        io.print("---->ERROR<----");
        io.print(errorMsg);
    }
    public void dispExitBanner(){
        io.print("Goodbye!");
    }
    
    
}
