/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cakebakerysystem;
import java.util.*;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author zheig
 */
public class CakeOrder {
    private int orderNumber;
    private String customerName;
    private ArrayList<CakeOrderItem> items;

    public CakeOrder(int orderNumber, String customerName) {
        this.orderNumber = orderNumber;
        this.customerName = customerName;
        this.items = new ArrayList<>();
    }

    public void addItem(CakeOrderItem item) {
        items.add(item);
    }

    public double calculateTotal() {
        double total = 0;
        for (CakeOrderItem item : items) {
            total += item.getTotalCost();
        }
        return total;
    }

    public void printReceipt() {
        JTextArea myArea = new JTextArea(); //create a jtextarea to display the final receipt

        myArea.setEditable(false);
        myArea.setBackground(new Color(255, 228, 196)); // set background color to bisque
        myArea.setFont(new Font("Monospaced", Font.PLAIN, 12)); // set font style to monospaced

        if (items.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Cancelled Order", "Order Cancelled", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0); //if user clicked on cancel
        }

        myArea.append("Yuh Bakery\nOfficial Receipt\n");
        myArea.append("\nOrder Number: " + orderNumber);
        myArea.append("\nCustomer Name: " + customerName + "\n\n");

        myArea.append("Order(s):\n");
        for (CakeOrderItem item : items) {
            myArea.append(item.toString() + "\n");
        }

        myArea.append("\nTotal Cost: $" + calculateTotal());

        JOptionPane.showMessageDialog(null, myArea, "Receipt", JOptionPane.INFORMATION_MESSAGE);
    }
}
