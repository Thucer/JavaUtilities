/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.classroster.dao;

import com.mycompany.classroster.dto.Student;
import java.util.List;

/**
 *This is a data access object
 * 
 * @author John
 */
public interface ClassRosterDao {
    /**
     * This method will evaluate a given Student object adding it to the roster 
     * and associating it with the given StudentID. If there is already a Student
     * at that ID it should return that Student object, else return null.
     * @param studentId represents the id which the student object is associated
     * @param student represents the Student object to be added to roster
     * @return Student object associated with the ID if none then null
     */
    Student addStudent(String studentId, Student student) throws
            ClassRosterDaoException;
    /**
     * returns a list of all Student objects in the roster
     * @return List containing all student objects in roster
    */
    List<Student> getAllStudents() throws ClassRosterDaoException;
    /**
     * returns Student associated with given ID, if none returns null
     * @param studentId is id to be be retrieved
     * @return Student object associated with given ID, if none null
     */
    Student getStudent(String studentId) throws ClassRosterDaoException;
    /**
     * Removes the Student object associated with given ID from roster
     * Returns the removed Student object, if none returns null
     * @param studentId represents the id of Student to remove
     * @return Student object that was removed or null
     */
    Student removeStudent(String studentId) throws ClassRosterDaoException;
}
