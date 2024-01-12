/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cakebakerysystem;

/**
 *
 * @author zheig
 */
public class Cheesecake extends Cake {
    private double price;

    public Cheesecake(String name, double price) {
        super(name);
        this.price = price;
    }

    //getter - encapsulation
    @Override
    public double getPrice() {
        return price;
    }
}
