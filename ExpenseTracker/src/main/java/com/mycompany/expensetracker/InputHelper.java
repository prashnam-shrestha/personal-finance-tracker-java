/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.expensetracker;

import java.util.Scanner;

/**
 *
 * @author prashnamshrestha
 */
public class InputHelper {
    
    // Scanner
    public static Scanner sc = new Scanner(System.in);
    
    // Get valid input
    public static int getValidInt(String text) {
        while (true) {
            try {
                System.out.print(text);
                int input = sc.nextInt();
                
                sc.nextLine();
                return input;
            }
            catch (Exception e) {
                System.out.println("\n  [x] Invalid input. Please enter a number.\n");
                sc.nextLine();
            }
        }
    }
    
    // Get valid input
    public static double getValidDouble(String text) {
        while (true) {
            try {
                System.out.print(text);
                double input = sc.nextDouble();
                
                sc.nextLine();
                
                if (input < 0) {
                    throw new IllegalArgumentException("amount cannot be negative.");
                }
                return input;
            }
            catch (IllegalArgumentException i) {
                System.out.println("\n  [x] " + i.getMessage() + "\n");
            }
            catch (Exception e) {
                System.out.println("\n  [x] Invalid input. Please enter a number.\n");
                sc.nextLine();
            }
        }
    }
    
    // Get valid input
    public static String getValidString(String text) {
        
        while (true) {
            try {
                System.out.print(text);
                String input = sc.nextLine();
                
                if (input.isEmpty()) {
                    throw new IllegalArgumentException("name cannot be empty.");
                }
                return input;
            }
            catch (Exception i) {
                System.out.println("\n  [x] " + i.getMessage() + "\n");
            }

        }
    }
    
}
