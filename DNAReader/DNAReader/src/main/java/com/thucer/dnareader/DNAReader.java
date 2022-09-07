/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.thucer.dnareader;

import com.thucer.dnareader.controller.DRController;
import com.thucer.dnareader.dao.DRDAOImpl;
import com.thucer.dnareader.dao.DRDAO;
import com.thucer.dnareader.ui.DRUserIO;
import com.thucer.dnareader.ui.DRUserIOImpl;
import com.thucer.dnareader.ui.DRView;

/**
 *EMPTY PROGRAM
 * This program contains no functionality, this is an organizational template
 * for designing in the agile paradigm.
 * @author John
 */
public class DNAReader {

    public static void main(String[] args) {
        DRUserIO io = new DRUserIOImpl();
        DRDAO dao = new DRDAOImpl(io);
        DRView view = new DRView(io, dao);
        DRController run = new DRController(io,dao,view);
        run.run();
    }
}
