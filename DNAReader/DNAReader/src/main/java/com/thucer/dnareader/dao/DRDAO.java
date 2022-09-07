/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.thucer.dnareader.dao;

import com.thucer.dnareader.dto.DNA;
import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * INTERFACE SMDao
 * This interface is responsible for defining a set of methods to be used in 
 * String manipulation and evaluation. These methods should be defined in such
 * a manner that they could be applied to any problem dealing with Strings.
 * @author John
 */
public interface DRDAO {
//DATA MARSHALLING AND UNMARSHALLING
    boolean checkFile(String filePath);
    /**
     * METHOD makeFile
     * Method is responsible for making a file, the file path should be provided
     * as a method parameter.
     * @param filePath is a String representation of the file path
     * @return is a boolean value, returns true if made, else false
     * @throws com.mycompany.stringmanipulator.SMDAO.SMDaoException
     */
    boolean makeFile(String filePath) ;
    /**
     * METHOD makeDirectory
     * Method is responsible for creating a directory dirName 
     * @param dirPath String representation of the directory name or path
     * @return is the created directory as a File object
     */
    boolean makeDirectory(String dirPath);
    /**
     * METHOD getFileContents
 Method is responsible for pulling a single file based on the fileName
 parameter.Method returns a String representation of the file's contents.
     * @param filePath a String representation of the file path
     * @return is a String representation of the file's contents
     * @throws com.mycompany.stringmanipulator.SMDAO.SMDaoException
     *
     */
    String getFileContents(String filePath) ;
    /**
     * METHOD getDirectory
     * Method is responsible for pulling a directory.Method returns a Map 
     * representation of the directory. Map keys are String representations of 
     * the directory's file names. Map values are String representations of the
     * associated file's contents.
     * @param dirPath
     * @return Map value representing a directory
     * @throws com.mycompany.stringmanipulator.SMDAO.SMDaoException
     */
    Map getDirectoryFiles(String dirPath) ;
    /**
     * METHOD addToFile
     * Method is responsible for appending a String onto an existing file.
     * @param toAdd is the String to be appended
     * @return returns the file if successful else null 
     */
    File addToFile(String toAdd);
    File addToDir (File toAdd);
//ESTABLISH SEARCH PARAMETERS
    /**
     * METHOD setEndSequence
     * Method is responsible for determining which endSeq should be used
     * in the evaluation of a String. This method does not evaluate the overall 
     * length of the resultant String as that is performed in a subsequent 
     * method. Takes one String parameter. Returns an int value.
     * Method design is largely dependent on desired functionality as well as 
     * total possible end sequences. This method logic could also be duplicated
     * to determine the appropriate start sequence as well.
     * 
     * @param initialString is the initial String to be evaluated
     * @return returns an int value. The value will be between 0 and the
     * length of the array holding all possible end values - 1. 
     */
    int setEndSequence(String initialString);
    /**
     * METHOD findSubString
     * Method is responsible for analyzing a String and determining whether or
     * not a particular subString is present. This may be determined by 
     * predefined start and/or stop sequences along with other criteria, such as
     * subString length. If a subString is found that meets the stated criteria
     * this method will return the first occurrence of said subString.
     * If there are no occurrences of the target subString found the method
     * will return a message alerting the user that the subString was not
     * found. 
     * 
     * @param initialString is the String representation of initial String to
     * be searched
     * @return returns a String representing the first occurrence of the 
     * subString in the original String. 
     */
    String findGene(String initialString, String fP);
    void subStringToFile(String filePath, String subString) ;
    /**
     * METHOD findAllSubStrings
     * Method is responsible for finding all occurrences of specified 
     * subString(s). Each valid subString is added to a List of Strings which
     * is returned when the method completes. 
     * @param initialString is the initial String to be searched
     * @return a List of String elements composed of validated subStrings
     */
    
    List<String> findAllSubStrings(String initialString);
    void subStringsToFile(String filePath, List<String> stringsToFile) ;
    /**
     * METHOD findSequence
     * Method is responsible for evaluating a given String for a particular 
     * sequence. The method takes two parameters, the initial String and the 
     * sequence to be evaluated. Method returns an integer value representing
     * the number of occurrences of the given sequence found.
     * @param initialString is the String to be evaluated
     * @param seq is a String representation of the sequence to be found
     * @return integer representation of occurrences found
     */
    
    int findSequence(String initialString, String seq);

    public boolean checkDir(String dirPath);

    public DNA makeDNAObj(String sourceFilePath);
     public String findGenes(String DNASample);

    public String getDNA(String filePath);
}
