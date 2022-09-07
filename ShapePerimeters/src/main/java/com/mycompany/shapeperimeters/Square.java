/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.shapeperimeters;

/**
 *
 * @author John
 */
public class Square extends Shape{
    private final float SIDEONE = 11, SIDETWO = SIDEONE, 
            PERIMETER = getPerimeter(), AREA = getArea();
    @Override
    protected float getPerimeter() {
        float perimeter = SIDEONE*4;
        return perimeter;
    }

    @Override
    protected float getArea() {
        float area = SIDEONE*SIDEONE;
        return area;
    }
    
}
