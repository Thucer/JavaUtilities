/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thucer.dnareader.ui;

import com.thucer.dnareader.dao.DRDAO;

/**
 *
 * @author John
 */
public class DRView {
//CLASS VARIABLES
    //private SMDaoException
    //INJECTION OBJECTS
    private DRUserIO io = new DRUserIOImpl();
    private DRDAO dao;
    //INPUT VARIABLES -- Variables to keep track of user menu choices
    private int mainMenuChoice, subMenuChoice;
//END CLASS VARIABLES
/****************************************************************************/
//CONSTRUCTOR SECTION
    //DEPENDENCY INJECTION
    /**
     * CONSTRUCTOR
     * Constructor DRView is responsible for constructor injection of the UserIO
     * and DRDao objects, 'io' and 'dao' respectively.This 'client' class, 
     * 'SMView' will only know of the interface, UserIO, not the specific 
     * implementation utilized. 
     * @param io 
     * @param dao 
     */
    public DRView(DRUserIO io, DRDAO dao){
       /* if(io == null){
            throw new InvalidParameterException("Failed to access interface, goodbye.");
            //System.exit(-2);
        }*/
       this.dao = dao;
       this.io = io;
    }
    //END CONSTRUCTORS
/*****************************************************************************/
//METHOD SECTION
    /* MENU METHODS
     * This section will contain all methods that display some menu prompt to
     * the user and retrieve their choice as input.
     */
        //////////////////////////////////////////////////////////////////
    public int displayMenu(){
        io.printTC("PROGRAM MENU\n"
                + "1. Evaluate single file\n"
                + "2. Evaluate directory\n");
        mainMenuChoice = io.readInt("Please make a choice from the menu: ", 1, 2);
        return mainMenuChoice;
    }
        public int displaySubMenu(){
        switch (mainMenuChoice) {
            case 1 -> {
                //String sample = fromF.getFromFile(getSourceFilePath());
                io.printTC("SINGLE FILE MENU\n"
                        + "1. Find the first gene in the sample\n"
                        + "2. Find all the genes in the sample\n"
                        + "3. Find a particular sequence of nucleotides "
                                + "in the sample\n");
            }
            case 2 -> {
                //getDirectoryPath();
                io.printTC("DIRECTORY MENU\n"
                        + "1. Find the first gene in each sample\n"
                        + "2. Find all the genes in each sample\n"
                        + "3. Find a particular sequence of nucleotides"
                            + " in each sample\n");
            }
            default -> {
                    /**
                     * Default case will only execute if something has gone
                     * wrong fetching the user's first choice
                     */
                    io.printTC("Sorry, something seems to have gone wrong, goodbye.");
                    System.exit(-1);
            }
        }
        subMenuChoice = io.readInt("Please make a choice from the menu: ", 1, 3);
        return subMenuChoice;
    }//END METHOD displaySubMenu
//END MENU METHODS
       ///////////////////////////////////////////////////////////////
//USE CASE METHODS
   //FILE CASES
    public String getSourceFilePath(){
        String filePath;
        filePath = io.readString("Please enter the source file path: ");
        return filePath;
    }   
    //USE CASE 1 - FIND ALL GENES IN A FILE
    public void dispGene(String filePath){
        String DNA, gene;
        DNA = dao.getDNA(filePath);
        gene = dao.findGene(DNA, filePath);
        io.printTC(gene);
        
    }
    //END USE CASE 1
    //USE CASE 2 - FIND THE G-G RATIO OF EACH GENE IN A FILE
    //END USE CASE 2
    //USE CASE 3 - SEARCH FOR A PARTICULAR GENETIC SEQUENCE IN A FILE
    public String getSearchSeq(){
        String searchSequence = io.readString("Please enter the sequence to search for: ");
        return searchSequence.toUpperCase();
    }
    public void dispSearchSeqCount(String fileName, String searchSeq) {
        String sourceFileContents;
        System.out.println(fileName);
        sourceFileContents = dao.getFileContents(fileName);
        int count;
        count = dao.findSequence(sourceFileContents, searchSeq);
        if(count != -1){
            io.printTC("Sample "+fileName +" contained "+ count
                        + " occurences of the sequence \""+searchSeq+"\".\n");
        }else{
            io.printTC("Sample " +fileName +" contained no "
                        + "occurrences of the sequence \""+searchSeq+"\".\n");
        }
    }
    //END USE CASE 3-END
   //END FILE CASES - END
    //DIRECTORY CASES
    public String getDirectoryPath(){
        String dirPath;
        dirPath = io.readString("Please enter the directory path: ");
        return dirPath;
    }
//END USE CASE METHODS
//UTILITY METHODS
    //Error message to console
    public void dispErrMsg(String eMsg){
        io.printTC("--->!ERROR!<---");
        io.printTC(eMsg);
    }
//END UTILITY METHODS
//DISPLAY BANNER METHODS
//END BANNER DISPLAYS
}//END CLASS DRView
