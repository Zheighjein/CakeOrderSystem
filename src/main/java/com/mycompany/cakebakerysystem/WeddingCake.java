/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cakebakerysystem;

/**
 *
 * @author zheig
 */
public class WeddingCake extends Cake{
    private double pricePerSlice;

    public WeddingCake(String name, double pricePerSlice) {
        super(name);
        this.pricePerSlice = pricePerSlice;
    }

    //getter - encapsulation
    @Override
    public double getPrice() {
        return pricePerSlice;
    }
}
