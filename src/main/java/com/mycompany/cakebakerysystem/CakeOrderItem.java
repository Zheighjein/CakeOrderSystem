/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cakebakerysystem;

/**
 *
 * @author zheig
 */
public class CakeOrderItem {
    private Cake cake;
    private int quantity;

    public CakeOrderItem(Cake cake, int quantity) {
        this.cake = cake;
        this.quantity = quantity;
    }

    public double getTotalCost() {
        return cake.getPrice() * quantity;
    }
    
    //makes the class name human readable when called
    @Override
    public String toString() {
        return cake.toString() + "\t$" + cake.getPrice() + "\n" + quantity + "x\t\t\t$" + getTotalCost();
    }
}
