/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thucer.dnareader.dto;

import com.thucer.dnareader.dao.DRDAO;
import com.thucer.dnareader.ui.DRView;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Scanner;

/**
 *Class is responsible for defining a 'DNA' object. This object contains a 
 * String representation of a piece of DNA. This object contains identifying 
 * information about the DNA itself.
 * @author John
 */
public class DNA {
//CLASS VARIABLES
    //List of all genes present within the DNA (object) sample
    private DRView view;
    private DRDAO dao;
    private List<String> genes;
    private final String endCodon = "TAA";
    private final String startCodon = "ATG";
    private File sourceFile;
    private String sourceFilePath, sampleName, DNASample;
    
    private int geneLength;
    
    private double cgRatio;
//END CLASS VARIABLES
    /////////////////////////////////////////////////////////////////////
//CONSTRUCTORS
    public DNA(String sourceFilePath){
        this.sourceFilePath = sourceFilePath;
        //Filepath is validated before being passed to constructor
        this.sourceFile = new File(sourceFilePath);
        this.sampleName = setSampleName(sourceFilePath);
        this.DNASample = setDNASample();
        
    }
//END CONSTRUCTORS
//GETTERS/SETTERS
    public File getSourceFile() {
        return sourceFile;
    }
    private String setDNASample(){
        Scanner readIn = null;
        try {
            readIn = new Scanner(new BufferedReader(new FileReader(sourceFile)));
        } catch (FileNotFoundException ex) {
            view.dispErrMsg(ex.getMessage());
        }
        String DNA = readIn.nextLine().toUpperCase();
        return DNA;
    }

    public String getDNASample() {
        return DNASample;
    }
    
    public String getEndCodon() {
        return endCodon;
    }
    public void setEndCodon(String endCodon) {
        this.endCodon = endCodon;
    }
    public int getGeneLength() {
        return geneLength;
    }
    public void setGeneLength(int geneLength) {
        this.geneLength = geneLength;
    }
    public double getCgRatio() {
        return cgRatio;
    }
    public double setCgRatio(String gene) {
        String sansC = gene.replaceAll("C", "");
        int geneLength = gene.length();
        int cCount = geneLength - sansC.length();
        String sansG = gene.replaceAll("G","");
        int gCount = geneLength - sansG.length();
        int cgCount = cCount + gCount;
        double cgCountDec = (double) cgCount, geneLengthDec 
                = (double) geneLength;
        cgRatio = cgCountDec/geneLengthDec;
        return cgRatio;
    }
    public List<String> getGenes() {
        return genes;
    }

    private List<String> setGenes(String DNASample) {
        //DNA codons are 3 chars long, minimum valid length is two codons.
        int minValLength = 6;
        while(DNASample.length() >= minValLength){
            String gene = dao.findGenes(DNASample);
            genes.add(gene);
            DNASample = DNASample.substring(gene.length());
        }
        return genes;
    }

    public String getSourceFilePath() {
        return sourceFilePath;
    }

    public void setSourceFilePath(String sourceFilePath) {
        this.sourceFilePath = sourceFilePath;
    }

    public String getSampleName() {
        return sampleName;
    }

    private String setSampleName(String filePath) {
        int cut, endCut;
        cut = filePath.indexOf("/");
        endCut = filePath.indexOf(".");
        String sampleName = filePath.substring(cut, endCut);
        return sampleName;
    }
    public String getStartCodon() {
        return startCodon;
    }
//END GET/SET - END

   

    
}//END CLASS DNA
