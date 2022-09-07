/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.shapeperimeters;

/**
 *
 * @author John
 */
public class Rectangle extends Shape{
    private final float SIDEONE = 11, SIDETWO = 9, 
            PERIMETER = getPerimeter(), AREA = getArea();
    @Override
    protected float getPerimeter() {
        float perimeter = SIDEONE*2 + SIDETWO*2;
        return perimeter;
    }

    @Override
    protected float getArea() {
        float area = SIDEONE*SIDETWO;
        return area;        
    }
    
}
