/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.studentquizgrades.controller;

import com.mycompany.studentquizgrades.dao.StudentQuizGradesDao;
import com.mycompany.studentquizgrades.dao.StudentQuizGradesDaoException;
import com.mycompany.studentquizgrades.dto.Student;
import com.mycompany.studentquizgrades.ui.StudentQuizGradesView;
import com.mycompany.studentquizgrades.ui.UserIO;
import com.mycompany.studentquizgrades.ui.UserIOConsoleImpl;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author John
 */
public class StudentQuizGradeController {
    //Creates a 'UserIOConsoleImpl' object 'io' of type UserIO
    //As this has been defined as type UserIO it only has access to the methods
    //defined in the UserIO interface
    private UserIO io = new UserIOConsoleImpl();
    //Creates a ClassRosterView object 'view' of type ClassRosterView
    //view has access to all methods in ClassRosterView and any classes it
    //implements
    //removed and replaced with dependency injection
    //private ClassRosterView view = new ClassRosterView();
    //Creaates a data access object. This creates a ClassRosterDaoFileImpl
    //object of type ClassRosterDao. As such it only has access to the methods
    //defined in the ClassRosterDao interface.
    //removed and replaced with dependency injection
    //private ClassRosterDao dao = new ClassRosterDaoFileImpl();
    private StudentQuizGradesDao dao;
    private StudentQuizGradesView view;
    public StudentQuizGradeController(StudentQuizGradesDao dao, StudentQuizGradesView view){
        this.dao = dao;
        this.view = view;
    }
        public void run(){
        boolean keepGoing = true;
        int menuSelection = 0;
        try{    
            while(keepGoing){

                menuSelection = getMenuChoice();

                switch(menuSelection){
                    case 1 :
                        listStudents();
                        break;
                    case 2 :
                        createStudent();
                        break;
                    case 3 :
                        viewStudent();
                        break;
                    case 4 :
                        removeStudent();
                        break;
                    case 5 :
                        keepGoing = false;
                        break;
                    default :
                        unknownCommand();
                }
            }exitMessage();
        }catch(StudentQuizGradesDaoException e){
            view.dispErrorMessage(e.getMessage());
        }
    }
    private int getMenuChoice(){
        return view.dispMenuGetChoice();
    }
    private ArrayList getQuizGrades(){
        return view.getStudentGrades();
    }
    //controller creates a student by calling the View and DAO layers
    public void createStudent() throws StudentQuizGradesDaoException{
        view.dispCreateStudentBanner();
        Student newStudent = view.getNewStudentInfo();
        dao.addStudent(newStudent.getStudentID(), getQuizGrades());
        view.dispCreateStudentBanner();
        
    }
    private void listStudents() throws StudentQuizGradesDaoException{
        view.dispAllBanner();
        List<Student> studentList = dao.getAllStudents();
        view.dispStudentList(studentList);
    }
    private void viewStudent() throws StudentQuizGradesDaoException{
        view.dispStudentBanner();
        String studentId = view.getStudentChoiceId();
        Student student = dao.getStudentGrades(studentId);
        view.dispStudent(studentId);
    }
    private void removeStudent() throws StudentQuizGradesDaoException{
        view.dispRemoveStudentBanner();
        String studentId = view.getStudentChoiceId();
        Student removedStudent = dao.removeStudent(studentId);
        view.dispRemovalResult(removedStudent);
    }
    private void unknownCommand(){
        view.dispUnknownCommandBanner();
    }
    private void exitMessage(){
        view.dispExitBanner();
    }
}
