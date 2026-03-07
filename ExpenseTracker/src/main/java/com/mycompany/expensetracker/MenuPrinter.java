/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.expensetracker;

/**
 *
 * @author prashnamshrestha
 */
public class MenuPrinter {
// Display Expenses ALL 
    public static void displayExpenses(User u) {
        
        int num = 1;
        System.out.println("\n──────────────────────────────────────── EXPENSES ────────────────────────────────────────");
        System.out.printf(" %-4s | %-12s | %-12s | %-11s | %-12s | %s\n", "ID", "Date", "Category", "Amount", "Wallet", "Description");
        System.out.println("──────┼──────────────┼──────────────┼─────────────┼──────────────┼──────────────");
        
        for (Expense e: u.getAppState().getExpenses()) {
            System.out.printf(" %-4s | %s\n", num + ".", e.getCashFlowInfo());
            num++;
        }
        System.out.println("──────────────────────────────────────────────────────────────────────────────────────────");
       
    }
            
    
    // Display main menu
    public static void displayMainMenu(User u) {
        System.out.println("\n=======================================================");
        System.out.println("                 💳 EXPENSE TRACKER                      ");
        System.out.println("=======================================================");
        System.out.println(" Welcome back, " + u.getName() + "!");
        System.out.println("-------------------------------------------------------");
        System.out.println("  1. ➕ Add Expense");
        System.out.println("  2. ❌ Delete Expense");
        System.out.println("  3. 💼 Manage Wallet"); //
        System.out.println("  4. 📂 Manage Category"); //
        System.out.println("  5. 📊 Report Cashflow");
        System.out.println("  6. 🚪 Exit Program");
        System.out.println("=======================================================");
    }
    
    // Display Manage Wallet
    public static void displayWalletMenu(User u) {
        
        int size = displayAvailabeWallet(u);
        System.out.printf("\n     Wallets: %s\n", size);
        
        System.out.println("\n--- 💼 Manage Wallets ---");
        System.out.println("  1. Add Wallet");
        System.out.println("  2. Delete Wallet");
        System.out.println("  3. Deposit Balance"); // Add income
        System.out.println("  4. Withdraw Cash"); 
        System.out.println("  5. Show Transactions");
        System.out.println("  6. Exit To Main Menu");
        System.out.println("-------------------------");
    }
    
    // Display Available Wallets
    public static int displayAvailabeWallet(User u) {
        
        int size = u.getAppState().getWallet().size();
        
        if (size == 0) {
            return 0;
        }
        
        int num = 1;
        
        System.out.println("\n================ AVAILABLE WALLETS ================");
        System.out.printf(" %-4s | %-15s | %s\n", "ID", "Wallet", "Balance");
        System.out.println("──────┼─────────────────┼────────────────────────");
        for (Wallet w: u.getAppState().getWallet()) {
            System.out.printf(" %-4s | %-15s | Rs %.2f\n", num + ".", w.getNameWallet(), w.getBalance());
            num++;
        }
        System.out.println("===================================================");
        
        return size;
    }
    
    
    // Display Manage Category
    public static void displayCategoryMenu(User u) {
        
        displayAvailabeCategory(u);
        
        System.out.println("\n--- 📂 Manage Categories ---");
        System.out.println("  1. Add Category");
        System.out.println("  2. Delete Category");
        System.out.println("  3. Exit To Main Menu");
        System.out.println("----------------------------");
    }
    
    // Display Available Categories
    public static int displayAvailabeCategory(User u) {
   
        int size = u.getAppState().getCategory().size();
        
        if (size == 0) {
            return 0;
        }
        
        int num = 1;
        System.out.println("\n============== AVAILABLE CATEGORIES ==============");
        System.out.printf(" %-4s | %s\n", "ID", "Category Name");
        System.out.println("──────┼───────────────────────────────────────────");
        
        for (Category c: u.getAppState().getCategory()) {
            
                System.out.printf(" %-4s | %s\n", num + ".", c.getNameCategory());
                num++;
        }
        
        System.out.println("==================================================");
        
        return size;
    }
          
    
}
