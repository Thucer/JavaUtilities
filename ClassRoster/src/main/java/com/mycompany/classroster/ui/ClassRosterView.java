/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.classroster.ui;

import com.mycompany.classroster.dto.Student;
import java.util.List;

/**
 *
 * @author John
 */
public class ClassRosterView {
    //Creates a 'UserIOConsoleImpl' object 'io' of type UserIO
    //As this has been defined as type UserIO it only has access to the methods
    //defined in the UserIO interface
    //removed and replaced with dependency injection
    //private UserIO io = new UserIOConsoleImpl();
    private UserIO io;
    public ClassRosterView(UserIO io){
        this.io = io;
    }
    public int dispMenuGetChoice(){
            io.print("Main Menu");
            io.print("1. List Student IDs");
            io.print("2. Create New Student Record");
            io.print("3. View a Student Record");
            io.print("4. Remove a Student Record");
            io.print("5. Exit Program");
            return io.readInt("Please select from the above choices.",
                    1, 5);
    }
    public Student getNewStudentInfo(){
        String studentId = io.readString("Please enter Student ID");
        String firstName = io.readString("Please enter First Name");
        String lastName = io.readString("Please enter Last Name");
        String cohort = io.readString("Please enter cohort");
        //Creates a new Student object of type Student called currentStudent
        //this is initialized with a consctuctor which takes one argument
        Student currentStudent = new Student(studentId);
        currentStudent.setFirstName(firstName);
        currentStudent.setLastName(lastName);
        currentStudent.setCohort(cohort);
        
        return currentStudent;
    }
    public void dispCreateStudentBanner(){
        io.print("---->CREATE STUDENT<----");
    }
    public void dispCreateSuccessbanner(){
        io.print("Student record added. Hit enter to continue");
    }
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
    public void dispAllBanner(){
        io.print("---->Display All Students<----");
    }
    public void dispStudentBanner(){
        io.print("---->Display Student<----");
        }
    //gets student Id to evaluate
    public String getStudentChoiceId(){
        return io.readString("Please enter the Student ID");
    }
    public void dispStudent(Student student){
        //if there is an actual student record
        if(student != null){
            io.print(student.getStudentID());
            io.print(student.getFirstName()+" "+student.getLastName());
            io.print(student.getCohort());
            io.print("");
        }else{
            io.print("No such student.");
        }io.readString("Hit enter to continue.");
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
    public void dispExitBanner(){
        io.print("Goodbye!");
    }
    public void dispUnknownCommandBanner(){
        io.print("Sorry, you have enetered an unrecognized command.");
    }
    public void dispErrorMessage(String errorMsg){
        io.print("---->ERROR<----");
        io.print(errorMsg);
    }
}
