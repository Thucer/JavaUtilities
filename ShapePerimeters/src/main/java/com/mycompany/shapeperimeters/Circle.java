/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.shapeperimeters;

/**
 *
 * @author John
 */
public class Circle extends Shape{
    private final float DIAMETER = 11, PI = 3.14159F, 
        PERIMETER = getPerimeter(), AREA = getArea();
//As pi is not a truly accurate representation here, truncated at five decimals,
//this result will not be the most precise, same with the getArea() method    
    @Override
    protected float getPerimeter() {
        float circumference = DIAMETER*PI;
        return circumference;
    }

    @Override
    protected float getArea() {
        double radius = DIAMETER/2f;
        float area = PI*(float)(Math.pow(radius, 2));
        return area;        
    }
    
}

