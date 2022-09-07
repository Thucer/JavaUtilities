/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.studentquizgrades.dao;

import com.mycompany.studentquizgrades.dto.Student;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author John
 */
public class StudentQuizGradesDaoFileImpl implements StudentQuizGradesDao{
    //Map object of type HashMap holds quiz data, the student name is the key
    //and the values are populated by an ArrayList of integers.
    private Map<String,ArrayList<Integer>> quizData = new HashMap<>();
    private ArrayList<Integer> quizScores = new ArrayList<>();
    public static final String DATA_FILE = "classData.txt";
    public static final String DELIMITER = "::";
    
    
    
    
/**
 * Following section contains all the methods that interact with file storage
 */    
    /**
     * Loads the classData file to be read and evaluated
     * @throws ClassRosterDaoException 
     */
        private void fileLoad()throws StudentQuizGradesDaoException{
        Scanner scanner;
        try{
            //Grabs file contents using scanner
            scanner = new Scanner
                (new BufferedReader(new FileReader(DATA_FILE)));       
        }catch(FileNotFoundException e){
            throw new StudentQuizGradesDaoException("Data was not successfully "
                    + "loaded to memory.",e);
        }
        //Holds most recent line scanned from file
        String currentLine;
        //Holds most recent student info scanned
        Student currentStudent;
        //Evaluates DATA_FILE until no more lines present 
        while(scanner.hasNextLine()){
            //sets current line to current line in file
            currentLine = scanner.nextLine();
            currentStudent = unmarshallStudent(currentLine);
            quizData.put(currentStudent.getFirstName()+" "+
                    currentStudent.getLastName(), quizScores);
        }
        scanner.close();
        
    }
        /**
         * This method does not handle the IOException it simply translates it
         * to the application specific exception ClassRosterDaoException and then
         * reports it to the calling code. If error handling is desired that 
         * should be handled by the calling code.
         * @throws StudentQuizGradesDaoException 
         */
    private void writeFile()throws StudentQuizGradesDaoException{
        //Declare a print writer object
        PrintWriter out;
        try{
            out = new PrintWriter(new FileWriter(DATA_FILE));
        }catch(IOException e){
            throw new StudentQuizGradesDaoException("Could not save student data "
                    + "to file.", e);
        }
        /**
         * The below segment could be achieved, ?more efficiently?, by 
         * creating a Collection off of the students HashMap. The collection 
         * would hold all the map values, which in this case are all the student
         * grades. This collection could then be iterated over. However, since
         * getAllStudents is already written to return a list of all students
         * that was used here.
         */
        String studentAsText;
        List<Student> studentList = this.getAllStudents();
        for(Student currentStudent : studentList){
            //turn student object to string
            studentAsText = marshallStudent(currentStudent);
            //Write studentAsText out to file
            out.println(studentAsText);
            //flush anything left in buffer to file
            out.flush();
        }out.close();
        
        
    }        
    //Reads data from file (unmarshalls data) and translates to more usable form
    private Student unmarshallStudent(String studentAsText){
        //Takes a text line from file and splits along delimiter
        String[] studentTokens = studentAsText.split(DELIMITER);
        String studentId = studentTokens[0];
        Student studentFromFile = new Student(studentId);
        studentFromFile.setFirstName(studentTokens[1]);
        studentFromFile.setLastName(studentTokens[2]);
        //studentFromFile.setClassGroup(studentTokens[3]);
        
        return studentFromFile;
    }
    private String marshallStudent(Student aStudent){
        //Places all student info into a formatted text string which will
        //be read into a file or memory store
        String studentAsText = aStudent.getStudentID()+DELIMITER+aStudent.getFirstName()
                +DELIMITER+aStudent.getLastName();
        //This still needs to add student grades
        return studentAsText;
    }    
/**
 * Following section contains all the method overrides
 */
    @Override
    public Student addStudent(String studentName, ArrayList quizScores) throws StudentQuizGradesDaoException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Student> getAllStudents() throws StudentQuizGradesDaoException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Student getStudentGrades(String studentName) throws StudentQuizGradesDaoException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Student getStudentAverage(String studentName) throws StudentQuizGradesDaoException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Student removeStudent(String studentName) throws StudentQuizGradesDaoException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    

}
