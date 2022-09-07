/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thucer.dnareader.dao;

import com.thucer.dnareader.dto.DNA;
import com.thucer.dnareader.ui.DRUserIO;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author John
 */
public class DRDAOImpl implements DRDAO{
//CLASS VARIABLES
    //INJECTION VARIABLES

    private DRUserIO io;
    private DNA DNA;
    private Map <String, DNA> dnaMap = new HashMap<>();
//END CLASS VARIABLES
    //////////////////////////////////////////////////////////////////////////
//CONSTRUCTOR SECTION
    public DRDAOImpl(DRUserIO io){
       this.io = io;
    }
//END CONSTRUCTORS
    /////////////////////////////////////////////////////////////////////
//DTO CREATION
    @Override
    public DNA makeDNAObj(String sourceFilePath){
        DNA = new DNA(sourceFilePath);
        return DNA;
    }
    
//END DTO BUILD -END
//CASE LOGIC
    //USE CASE 1 - FIND ALL GENES IN A FILE
    //END USE CASE 1
        ////////////////////////////////////////////////////////////
    //USE CASE 2 - DETERMINE THE C-G RATIO OF ALL GENES IN A FILE
    //END USE CASE 2
        ///////////////////////////////////////////////////////////
    //USE CASE 3 - FIND SPECIFIC SEQUENCE IN A FILE
    
    //END USE CASE 3
        /////////////////////////////////////////////////////////////
    //USE CASE 4 - FIND ALL GENES IN A DIRECTORY OF FILES
    //END USE CASE 4
        //////////////////////////////////////////////////////////
//END CASE LOGIC
        /////////////////////////////////////////////////////////
    //MARSHALL DATA TO FILE
    



    @Override
    public boolean checkFile(String filePath) {
        boolean isFile = false;
        isFile = new File(filePath).isFile();
        return isFile;
    }
    
    public boolean checkDir(String dirPath){
        boolean isDir = false;
        isDir = new File(dirPath).isDirectory();
        return isDir;
    }

    @Override
    public boolean makeFile(String filePath) {
       return true;
    }

    @Override
    public boolean makeDirectory(String dirPath) {
       return true;
    }

    @Override
    public String getFileContents(String filePath) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Map getDirectoryFiles(String dirPath) {
      throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public File addToFile(String toAdd) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public File addToDir(File toAdd) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int setEndSequence(String initialString) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    @Override
    public String findGene(String DNASample, String filePath) {
        makeDNAObj(filePath);
        String gene, sampleCut;
        int startIndex, endIndex;
        do{
            startIndex = DNASample.indexOf(DNA.getStartCodon(), 0);
            endIndex = DNASample.indexOf(DNA.getEndCodon(), startIndex);
            
            //Adding 3 to start reading from end of stop codon
            gene = DNASample.substring(startIndex, endIndex+3);
            
            //Validates gene length is appropriate, can be own method
            if(gene.length() % 3 != 0){
                return "There appears to be an abnormality within the sequence"
                        + gene + ".\nStart and stop codons found, the sequence"
                        + "has an incorrect number of nucleotides.";
            }else{
                DNASample = DNASample.substring(endIndex+3);
                startIndex = 0;
              
            }
        }while(startIndex != -1 || endIndex != -1);
        if(endIndex == -1){
            return "Start codon found at "+startIndex+", no stop codon "
                        + "found.";
        }else if (startIndex == -1){
            return "No start codon found";
        }else
            return gene;
    }

    @Override
    public void subStringToFile(String filePath, String subString) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<String> findAllSubStrings(String initialString) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void subStringsToFile(String filePath, List<String> stringsToFile) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int findSequence(String initialString, String seq) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String findGenes(String initialString) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getDNA(String filePath) {
        DNA sample = new DNA(filePath);
        return sample.getDNASample();
        
    }
    
}
