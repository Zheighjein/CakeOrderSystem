/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
///what append does is add data
///JOptionsPaane will always start with a 'null' it means that there's not an associated "parent" dialog ---- the dialog that will be displayed doesnt belong to another dialog

package com.mycompany.cakebakerysystem;
import java.util.*;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author zheig
 */
public class CakeBakerySystem {
    private static int orderNumberCounter = 1;
    
    public static void main(String[] args) {

  
        //get next available order number
        int orderNumber = getOrderNumber();

        String customerName = JOptionPane.showInputDialog(null, "Enter customer name:");
        
        if (customerName == null) {
            JOptionPane.showMessageDialog(null, "Cancelled Order", "Order Cancelled", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0); // Exit the program
        }

        CakeOrder order = createCakeOrder(orderNumber, customerName);
        
        //display the receipt
        order.printReceipt();
    }

    private static int getOrderNumber() {
        // incrementing the order number counter and returning the next order number
        return orderNumberCounter++;
    }

    private static CakeOrder createCakeOrder(int orderNumber, String customerName) {
        // creating a StringBuilder to build the menu message. stringbuilder allows contents of the string to be modified after it's been created
        StringBuilder menuMessage = new StringBuilder("Menu:\n");
        menuMessage.append("Cupcakes:\n");
        
        // displaying the menu and adding values
        
        //this method (array) adds the values vvvv
        Cupcake[] cupcakeMenu = {
                new Cupcake("Chocolate Cupcake", 3.50),
                new Cupcake("Vanilla Cupcake", 3.25),
                new Cupcake("Red Velvet Cupcake", 4.00)
        };
        
        //this method does the displaying vvvvv
        displayMenu(menuMessage, cupcakeMenu);
        
        
        menuMessage.append("\nCheesecakes:\n");
        Cheesecake[] cheesecakeMenu = {
                new Cheesecake("Classic Cheesecake", 20.00),
                new Cheesecake("Strawberry Cheesecake", 25.00),
                new Cheesecake("Blueberry Cheesecake", 28.00)
        };

        displayMenu(menuMessage, cheesecakeMenu);

        menuMessage.append("\nWedding Cakes:\n");
        WeddingCake[] weddingCakeMenu = {
                new WeddingCake("Elegant Wedding Cake", 125.50),
                new WeddingCake("Royal Wedding Cake", 250.75),
                new WeddingCake("Deluxe Wedding Cake", 499.00)
        };

        displayMenu(menuMessage, weddingCakeMenu);
        
        //creates the cakeorder instance
        CakeOrder order = new CakeOrder(orderNumber, customerName);
        
        //it flags the code to continue ordering
        //flagging controls the flow of the code. in this case, it enters a loop to enable the user to continue ordering
        boolean continueOrdering = true;

        while (continueOrdering) {
            //taking userinput for category and item number
            String input = JOptionPane.showInputDialog(null,
                    "Enter the category (Cupcake/Cheesecake/WeddingCake) and item number you want to order (0 to finish):");

            if (input == null) {
                // User clicked Cancel or closed the dialog
                break;
            }
            
            // splitting the user input to extract category and item number. so strings (category) and integers (item number) won't be taken as one data
            String[] inputParts = input.toLowerCase().split("\\s+");
            String category = inputParts[0];
            
                                                //OR
            if (category.equals("cupcake") || category.equals("cheesecake") || category.equals("weddingcake")) {
                int itemNumber = Integer.parseInt(inputParts[1]);
                
                //taking quantity
                int quantity = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the quantity:"));

                Cake selectedItem = null;
                
                // switch statement to select the chosen item based on category and item number
                switch (category) {
                    case "cupcake":
                        if (itemNumber > 0 && itemNumber <= cupcakeMenu.length) {
                            //subtracted 1 because arrays will always start with a 0, followed by 1 and so forth
                            selectedItem = cupcakeMenu[itemNumber - 1];
                        }
                        break;
                    case "cheesecake":
                        if (itemNumber > 0 && itemNumber <= cheesecakeMenu.length) {
                            selectedItem = cheesecakeMenu[itemNumber - 1];
                        }
                        break;
                    case "weddingcake":
                        if (itemNumber > 0 && itemNumber <= weddingCakeMenu.length) {
                            selectedItem = weddingCakeMenu[itemNumber - 1];
                        }
                        break;
                }
                
                //adds the selected item to the order
                if (selectedItem != null) {
                    order.addItem(new CakeOrderItem(selectedItem, quantity));
                } else {
                    //display an error meesage for invalid item number
                    JOptionPane.showMessageDialog(null, "Invalid item number or category. Please try again.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else if (category.equals("0")) {
                //user chose to finish ordering
                continueOrdering = false;
            } else {
                //error message for invalid category
                JOptionPane.showMessageDialog(null, "Invalid category. Please try again.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }

        return order;
    }

    private static void displayMenu(StringBuilder menuMessage, Cake[] menu) {
        //displaying menu options for each category. "menu[0].getClass().getSimpleName()" extarcts the class name of the first item in the menu array. it's used to identify the category and appends it to the menu as an option
        menuMessage.append("0. No ").append(menu[0].getClass().getSimpleName()).append("\n");
        //loops through each item in the menu
        for (int i = 1; i <= menu.length; i++) {
            menuMessage.append(i).append(". ").append(menu[i - 1].toString()).append("\t$")
                    .append(menu[i - 1].getPrice()).append("\n");
        }
        JOptionPane.showMessageDialog(null, menuMessage.toString(), "Menu", JOptionPane.INFORMATION_MESSAGE);
    }
}
