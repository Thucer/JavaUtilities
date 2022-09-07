/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.classroster.controller;

import com.mycompany.classroster.dao.ClassRosterDao;
import com.mycompany.classroster.dao.ClassRosterDaoException;
import com.mycompany.classroster.dao.ClassRosterDaoFileImpl;
import com.mycompany.classroster.dto.Student;
import com.mycompany.classroster.ui.ClassRosterView;
import com.mycompany.classroster.ui.UserIOConsoleImpl;
import java.util.List;
import com.mycompany.classroster.ui.UserIO;

/**
 *Controller should display the menu, get the user's menu choice then call 
 * necessary method to perform action based on user choice
 * @author John
 */
public class ClassRosterController {
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
    private ClassRosterDao dao;
    private ClassRosterView view;
    public ClassRosterController(ClassRosterDao dao, ClassRosterView view){
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
        }catch(ClassRosterDaoException e){
            view.dispErrorMessage(e.getMessage());
        }
    }
    private int getMenuChoice(){
        return view.dispMenuGetChoice();
    }
    //controller creates a student by calling the View and DAO layers
    public void createStudent() throws ClassRosterDaoException{
        view.dispCreateStudentBanner();
        Student newStudent = view.getNewStudentInfo();
        dao.addStudent(newStudent.getStudentID(), newStudent);
        view.dispCreateStudentBanner();
        
    }
    private void listStudents() throws ClassRosterDaoException{
        view.dispAllBanner();
        List<Student> studentList = dao.getAllStudents();
        view.dispStudentList(studentList);
    }
    private void viewStudent() throws ClassRosterDaoException{
        view.dispStudentBanner();
        String studentId = view.getStudentChoiceId();
        Student student = dao.getStudent(studentId);
        view.dispStudent(student);
    }
    private void removeStudent() throws ClassRosterDaoException{
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
