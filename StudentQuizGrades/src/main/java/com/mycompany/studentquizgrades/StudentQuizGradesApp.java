/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.studentquizgrades;

import com.mycompany.studentquizgrades.controller.StudentQuizGradeController;
import com.mycompany.studentquizgrades.dao.StudentQuizGradesDao;
import com.mycompany.studentquizgrades.dao.StudentQuizGradesDaoFileImpl;
import com.mycompany.studentquizgrades.ui.StudentQuizGradesView;
import com.mycompany.studentquizgrades.ui.UserIO;
import com.mycompany.studentquizgrades.ui.UserIOConsoleImpl;

/**
 *
 * @author John
 */
public class StudentQuizGradesApp {

    public static void main(String[] args) {
        UserIO io = new UserIOConsoleImpl();
        StudentQuizGradesView view = new StudentQuizGradesView(io);
        StudentQuizGradesDao dao = new StudentQuizGradesDaoFileImpl();
        StudentQuizGradeController controller = new StudentQuizGradeController(dao,view);
        //Creates a ClassRosterController object 'controller' of type
        //ClassRosterController. This object will have access to all the 
        //methods in ClassRosterController and any classes it implements
        //ClassRosterController controller = new ClassRosterController();
        controller.run();
    }
}
