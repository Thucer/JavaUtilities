/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.statecapitalscapitalobject;

/**
 *
 * @author John
 */
public class Capital {
    String name;
    //population holds how many people live in the capital, sqMiles is the size
    int population;
    float sqMiles;

    public Capital() {
    }
    
    public Capital(String name, int population, float sqMiles) {
        this.name = name;
        this.population = population;
        this.sqMiles = sqMiles;
    }
    //Overrides default toString of Capital class for better formatting
    @Override
    public String toString() {
        return name+" | Population: "+population+" | Square Miles: "
                + sqMiles+" |";
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public float getSqMiles() {
        return sqMiles;
    }

    public void setSqMiles(float sqMiles) {
        this.sqMiles = sqMiles;
    }
    
}
