/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.shapeperimeters;

/**
 *
 * @author John
 */
public class Triangle extends Shape{
    private final float SIDEONE = 13, SIDETWO = 7.6f, SIDETHREE = 15.7F, 
            PERIMETER = getPerimeter(), AREA = getArea();
    @Override
    protected float getPerimeter() {
        float perimeter = SIDEONE + SIDETWO + SIDETHREE;
        return perimeter;
    }
    //All three sides are defined, thus area will be achieved using Heron's 
    //formula
    @Override
    protected float getArea() {
        float s = getPerimeter()/2;
        float area = (float)Math.sqrt(s*(s-SIDEONE)*(s-SIDETWO)*(s-SIDETHREE));
        return area;        
    }
    
}

