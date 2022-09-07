/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.mergeintervals;

import java.util.ArrayList;

/**
 *
 * @author John
 */
public class MergeIntervals {
    private static Merger use = new Merger();
    public static void main(String[] args) {
        ArrayList<Pair> startList = new ArrayList();
        startList.add(new Pair(1, 5));
        startList.add(new Pair(3, 7));
        startList.add(new Pair(4, 6));
        startList.add(new Pair(6, 8));
        startList.add(new Pair(10, 12));
        startList.add(new Pair(11, 15));
        use.printArrList(startList);
        use.mergeIntervals(startList);
    }
}
