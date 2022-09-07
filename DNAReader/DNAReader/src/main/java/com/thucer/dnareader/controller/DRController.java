/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thucer.dnareader.controller;

import com.thucer.dnareader.dao.DAOException;
import com.thucer.dnareader.dao.DRDAO;
import com.thucer.dnareader.dto.DNA;
import com.thucer.dnareader.ui.DRUserIO;
import com.thucer.dnareader.ui.DRView;

/**
 *
 * @author John
 */
public class DRController {
//CLASS VARIABLES
    //INJECTION OBJECTS
    private DRUserIO io;
    private DRDAO dao;
    private DRView view;
    
//END CLASS VARIABLES
    ////////////////////////////////////////////////////////////////////
//CONSTRUCTOR SECTION
    //DEPENDENCY INJECTION
    /**
     * CONSTRUCTOR
     * Constructor Controller is responsible for constructor injection of the 
     * UserIO object 'io'. This 'client' class, 'Controller' will only know of  
     * the interface, UserIO, not the specific implementation utilized. 
     * @param io 
     * @param dao 
     */
    public DRController(DRUserIO io, DRDAO dao, DRView view){
       /* Checks to make sure valid interface exists 
        if(io == null){
            throw new InvalidParameterException("Failed to access interface, goodbye.");
            //System.exit(-2);
        }*/
       this.io = io;
       this.dao = dao;
       this.view = view;
    }
//END CONSTRUCTORS
    /////////////////////////////////////////////////////////////////////////
//PROGRAM LOGIC
    /* CONTROL LOGIC
     * This section contains the method(s) responsible for defining the program
     * functionality. Main execution should call this method.
     * method.
     *  
     */
    public void run(){
        //try{
            switch(getMainMenuChoice()){
                case 1 -> {
                    String sourceFilePath = getFilePath();
                    //While entry is not a valid file
                    while(!validateFile(sourceFilePath)){
                        io.printTC("Sorry, that is not a valid file.");
                        sourceFilePath = getFilePath();
                    }
                    //Make DNA object
                    DNA sample = getDNAObj(sourceFilePath);
                    switch(getSubMenuChoice()){
                        case 1 ->{
                            sample.getGenes();
                            getGenesFromFile(sourceFilePath);  
                        }
                        case 2 -> {
                            sample.getCgRatio();
                            getCGRatio();
                        }
                        case 3 -> {
                            getSeqCount(sourceFilePath);
                        }
                    }
                }//END MAINMENU CASE 1 - CLOSE FILE SUBMENU
                //START MAINMENU CASE 2 - DIRECTORY SUBMENU
                case 2 -> {
                    String dirPath = getDirectoryPath();
                    //While entry is not a valid directory
                    while(!validateDir(dirPath)){
                        io.printTC("Sorry, that is not a valid directory.");
                        dirPath = getDirectoryPath();
                    }
                    switch(getSubMenuChoice()){
                        case 1 -> {
                            
                        }
                        case 2 -> {
                    }
                }
            }
        //}//catch(DAOException e){
           // view.dispErrMsg(e.getMessage());
       // }
        }//END MAINMENU -END
    }//END METHOD RUN
    //END CONTROL
        ////////////////////////////////////////////////////////////////
    //USE CASE LOGIC
    /*
     * USE CASE LOGIC
     * This section contains the method(s) responsible for defining specific use
     * case functionality.
     */
   //FILE CASES
    private String getFilePath(){
        String filePath;
        filePath = view.getSourceFilePath();
        return filePath;
    }
    private DNA getDNAObj(String sourceFilePath){
        DNA DNASample = dao.makeDNAObj(sourceFilePath);
        return DNASample;
    }
    //USE CASE 1 - FIND ALL GENES IN A FILE
    
    private void getGenesFromFile(String sourceFile){
        io.printTC("GENES IN FILE");
        view.dispGene(sourceFile);
    }
    //END USE CASE 1-END
    //USE CASE 2 - FIND THE C-G RATIO OF EACH GENE IN A FILE
    private void getCGRatio(){
        io.printTC("CGRatio");
    }
    
    //END USE CASE 2-END
    //USE CASE 3 - SEARCH FOR A PARTICULAR GENETIC SEQUENCE IN A FILE
    private void getSeqCount(String sourceFile){
        String searchSeq = view.getSearchSeq();
        view.dispSearchSeqCount(sourceFile, searchSeq);
    }
    //END USE CASE 3-END
   //END FILE CASES -END
        ///////////////////////////////////////////////////////////
   //DIRECTORY CASES
    private String getDirectoryPath(){
        String dirPath;
        dirPath = view.getDirectoryPath();
        return dirPath;
    } 
    //USE CASE 4 - FIND ALL GENES IN EACH FILE IN A DIRECTORY
    private void getGenesFromDirectory(){
        
    }
    //END USE CASE 4 - END
    //USE CASE 5 - 
    
    //END USE CASE 5
    //USE CASE 6 - 
    //USE CASE 7 - 
    //USE CASE 8 - 
    //END USE CASE LOGIC
    //UTILITY LOGIC
    /*
     * UTILITY LOGIC
     * This section contains the methods which provide some utility
     */
     //MENU INTERACTIONS
     private int getMainMenuChoice(){
         return view.displayMenu();
     }
     private int getSubMenuChoice(){
         return view.displaySubMenu();
     }
     //END MENU INTERACTIONS
     //VALIDATORS
     private boolean validateFile(String filePath){
        //Implementation should be moved to DAO
         boolean isFile = dao.checkFile(filePath);
         return isFile;
     }
     private boolean validateDir(String dirPath){
        //Implementation should be moved to DAO
         boolean isDir = dao.checkDir(dirPath);
         return isDir;
     }
     //END VALIDATORS
    //END UTILITY LOGIC
//END PROGRAM LOGIC
}//END CLASS CONTROLLER
