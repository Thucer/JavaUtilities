/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.shapeperimeters;

/**
 *
 * @author John
 */
public class App {
    public static void main(String[] args){
        Square square = new Square();
        Rectangle rectangle = new Rectangle();
        Triangle triangle = new Triangle();
        Circle circle = new Circle();
        
        System.out.println("The perimeter of Square is " +square.getPerimeter()+" units."
                + "\nThe area of Square is "+square.getArea()+" units squared.");
        System.out.println("The perimeter of Rectangle is " +rectangle.getPerimeter()+" units."
                + "\nThe area of Rectangle is "+rectangle.getArea()+" units squared.");
        System.out.println("The perimeter of Triangle is " +triangle.getPerimeter()+" units."
                + "\nThe area of Triangle is  "+triangle.getArea()+" units squared.");
        System.out.println("The perimeter of Circle is " +circle.getPerimeter()+" units."
                + "\nThe area of Circle is "+circle.getArea()+" units squared.");
    }
}
