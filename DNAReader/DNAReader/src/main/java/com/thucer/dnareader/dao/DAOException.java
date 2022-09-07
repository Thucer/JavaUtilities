/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thucer.dnareader.dao;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * CLASS DAOException
 * Class is responsible for defining custom exception, DAOException
 * Method excLogSetup requires the name of the implementation class being used
 * before execution.
 * 
 * @author John
 */
public class DAOException extends Exception{
    //private Logger daoExcLogger;
    public DAOException(String msg) {
        //super(msg);
        excLogSetup().log(Level.SEVERE, msg);
        
    }
    public DAOException(String msg, Throwable cause) {
        //super(msg, cause);
        excLogSetup().log(Level.SEVERE, msg, cause);
        
    }
    /**
     * METHOD excLogSetup
     * Method is responsible for creating an error log for any errors associated
     * with implementations of DAO.
     * @return 
     */
    public Logger excLogSetup(){
        Logger daoExcLogger = Logger.getLogger(DRDAOImpl.class.getName());
        FileHandler fH = null;
        boolean append = true;
        final int byteLimit = 5000, fileCount = 6; 
        try {
            boolean newDir = new File("Logs").mkdir();
            boolean newFile = new File("Logs").createNewFile();
            fH = new FileHandler("Logs/SMDaoExceptionLog.txt", byteLimit, fileCount, append);
        } catch (IOException | SecurityException ex) {
            daoExcLogger.log(Level.SEVERE, "FileHandler failed to write out", ex);
        }
        SimpleFormatter sF = new SimpleFormatter();
        fH.setFormatter(sF);
        daoExcLogger.addHandler(fH);
        return daoExcLogger;
    }
}//END CLASS DAOException
