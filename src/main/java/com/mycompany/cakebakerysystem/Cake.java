/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cakebakerysystem;


// Interface representing a priced item
interface Priced {
    double getPrice();
}

abstract class Cake implements Priced{
    protected String name;

    public Cake(String name) {
        this.name = name;
    }

    @Override
    public abstract double getPrice();
    
    
    //makes the class name human readable when called
    @Override
    public String toString() {
        return name;
    }
}
