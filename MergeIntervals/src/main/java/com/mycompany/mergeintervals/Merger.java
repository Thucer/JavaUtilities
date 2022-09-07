/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mergeintervals;

import java.util.ArrayList;

/**
 *Class part of MergeIntervals contains logic to actually perform the merger
 * @author John
 */
public class Merger {
    protected static ArrayList<Pair> mergeIntervals(ArrayList<Pair> arrList){
        ArrayList<Pair> mergedList = new ArrayList();
        if(arrList.size() == 0){
            return null;
        }
        for(int i=0; i < arrList.size(); i++){
            if()
        }
        
        return mergedList;
    }
    protected static void printArrList(ArrayList<Pair> arrList){
        System.out.println("Co-ordinate pairs in list:");
        for(int i=0; i <arrList.size(); i++){
            System.out.println(String.format("[%d, %d]", arrList.get(i).first, 
                    arrList.get(i).second));
        }
    }
}
