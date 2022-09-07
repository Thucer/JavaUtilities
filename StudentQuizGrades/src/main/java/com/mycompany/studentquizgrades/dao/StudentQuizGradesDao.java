/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.studentquizgrades.dao;

import com.mycompany.studentquizgrades.dto.Student;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author John
 */
public interface StudentQuizGradesDao {
    /**
     * Method will add a student to the classData along with all of their quiz
     * scores. The student is represented by a String studentName and the quiz
     * scores are held in an ArrayList. Students are held in a HashMap with the 
     * studentName as the key and the ArrayList as values. 
     * If there is already a student located at the key provided that object
     * should be returned.
     * @param studentName is the Map key
     * @param quizScores are the values
     * @return returns student object if key is already populated
     */
    Student addStudent(String studentName, ArrayList quizScores) throws 
            StudentQuizGradesDaoException;
   /**
     * returns a list of all Student objects in the classData allowing a view
     * of all students
     * @return List containing all student objects in classData
    */
    List<Student> getAllStudents() throws StudentQuizGradesDaoException;
    /**
     * returns Student and a list of all the scores associated with given name, 
     * if none returns null
     * @param studentName is id to be be retrieved
     * @return Student object associated with given ID, if none null
     */
    Student getStudentGrades(String studentName) throws StudentQuizGradesDaoException;
   /**
     * returns Student and their averaged grade 
     * if none returns null
     * @param studentName is id to be be retrieved
     * @return Student object associated with given ID, if none null
     */
    Student getStudentAverage(String studentName) throws StudentQuizGradesDaoException;
   /**
     * Removes the Student object associated with given name from classData
     * Returns the removed Student object, if none returns null
     * @param studentName represents the id of Student to remove
     * @return Student object that was removed or null
     */
    Student removeStudent(String studentName) throws StudentQuizGradesDaoException;
}

/**
 * EXTENSIONS TO ADD
 * Calculate the average grade for the entire class
 * Find and list the student(s) with the highest score
 * Find and list the student(s) with the lowest score
 */
