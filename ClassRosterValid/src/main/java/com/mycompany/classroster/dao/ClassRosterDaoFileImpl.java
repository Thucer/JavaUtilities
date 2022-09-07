/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.classroster.dao;

import com.mycompany.classroster.dto.Student;
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
public class ClassRosterDaoFileImpl implements ClassRosterDao{
    //Map object to hold all student data using ID as mapKey, Student as value
    public static final String ROSTER_FILE = "roster.txt";
    public static final String DELIMITER = "::";
    private Map<String, Student> students = new HashMap<>();

    @Override
    public Student addStudent (String studentId, Student student) throws 
            ClassRosterDaoException{
        //Reads all lines from file
        loadRoster();
        //Stores a student object in prevStudent
        Student prevStudent = students.put(studentId, student);
        //writes any new student info to the file
        writeRoster();
        return prevStudent;
    }

    @Override
    public List<Student> getAllStudents() throws ClassRosterDaoException{
        //load from file
        loadRoster();
        //Creates an array lists of Student type from the values stored in
        //the students hashmap. Why not use collection?
        return new ArrayList<Student>(students.values());
    }

    @Override
    public Student getStudent(String studentId) throws ClassRosterDaoException{
        //load from file
        loadRoster();
        //pulls corresponding values from hashmap based on studentId key
        return students.get(studentId);
    }

    @Override
    public Student removeStudent(String studentId) throws ClassRosterDaoException{
        //load from file
        loadRoster();
        //remove student record
        Student removedStudent = students.remove(studentId);
        //update file
        writeRoster();
        return removedStudent;
    }
    //Reads data from file and translates to more usable 
    private Student unmarshallStudent(String studentAsText){
        //Takes a text line from file and splits along delimiter
        String[] studentTokens = studentAsText.split(DELIMITER);
        String studentId = studentTokens[0];
        Student studentFromFile = new Student(studentId);
        studentFromFile.setFirstName(studentTokens[1]);
        studentFromFile.setLastName(studentTokens[2]);
        studentFromFile.setCohort(studentTokens[3]);
        
        return studentFromFile;
    }
    private void loadRoster()throws ClassRosterDaoException{
        Scanner scanner;
        try{
            //Grabs file contents using scanner
            scanner = new Scanner
                (new BufferedReader(new FileReader(ROSTER_FILE)));       
        }catch(FileNotFoundException e){
            throw new ClassRosterDaoException("Data was not successfully "
                    + "loaded to memory.",e);
        }
        //Holds most recent line scanned from file
        String currentLine;
        //Holds most recent student info scanned
        Student currentStudent;
        //Evaluates ROSTER_FILE until no more lines present 
        while(scanner.hasNextLine()){
            //sets current line to current line in file
            currentLine = scanner.nextLine();
            currentStudent = unmarshallStudent(currentLine);
            students.put(currentStudent.getStudentID(), currentStudent);
        }
        scanner.close();
        
    }
    private String marshallStudent(Student aStudent){
        //Places all student info into a formatted text string which will
        //be read into a file or memory store
        String studentAsText = aStudent.getStudentID()+DELIMITER+aStudent.getFirstName()
                +DELIMITER+aStudent.getLastName()+DELIMITER+aStudent.getCohort();
        return studentAsText;
    }
    /**
     * Writes all students to ROSTER_FILE
     * @throws ClassRosterDaoException if error occurs during wirte
     */
    private void writeRoster()throws ClassRosterDaoException{
        //This method does not handle the IOException it simply translates it
        //to the application specific exception ClassRosterDaoException and then
        //reports it to the calling code. If error handling is desired that 
        //should be handled by the calling code.
        
        //Declare a print writer object
        PrintWriter out;
        try{
            out = new PrintWriter(new FileWriter(ROSTER_FILE));
        }catch(IOException e){
            throw new ClassRosterDaoException("Could not save student data "
                    + "to file.", e);
        }
        /**
         * The below segment could be achieved, perhaps more efficiently, by 
         * creating a Collection off of the students HashMap. The collection 
         * would hold all the map values, which in this case are all the student
         * object. This collection could then be iterated over. However, since
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
    
}
