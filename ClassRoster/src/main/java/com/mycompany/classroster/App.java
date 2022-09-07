/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.classroster;

import com.mycompany.classroster.controller.ClassRosterController;
import com.mycompany.classroster.dao.ClassRosterDao;
import com.mycompany.classroster.dao.ClassRosterDaoFileImpl;
import com.mycompany.classroster.ui.ClassRosterView;
import com.mycompany.classroster.ui.UserIOConsoleImpl;
import com.mycompany.classroster.ui.UserIO;

/**
 *
 * @author John
 */
public class App {

    public static void main(String[] args) {
        UserIO io = new UserIOConsoleImpl();
        ClassRosterView view = new ClassRosterView(io);
        ClassRosterDao dao = new ClassRosterDaoFileImpl();
        ClassRosterController controller = new ClassRosterController(dao,view);
        //Creates a ClassRosterController object 'controller' of type
        //ClassRosterController. This object will have access to all the 
        //methods in ClassRosterController and any classes it implements
        //ClassRosterController controller = new ClassRosterController();
        controller.run();
        
    }
}
