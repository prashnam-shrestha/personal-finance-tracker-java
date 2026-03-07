/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.expensetracker;

import static com.mycompany.expensetracker.CategoryService.*;
import static com.mycompany.expensetracker.ExpenseService.*;
import static com.mycompany.expensetracker.InputHelper.*;
import static com.mycompany.expensetracker.MenuPrinter.*;
import static com.mycompany.expensetracker.ReportService.*;
import static com.mycompany.expensetracker.WalletService.*;


/**
 *
 * @author prashnamshrestha
 */
public class ExpenseTracker {
    
    private static final String SAVE_FILE = "expensetracker_data.ser";

    public static void main(String[] args) {
        
        User u = new User("Default User");
    
        AppState LoadedState = DataManager.loadAppState(SAVE_FILE);
        u.setAppState(LoadedState);
        
        // Application 
        boolean run = true;
        while (run) {
            
            displayMainMenu(u);
            int choice = getValidInt("  ➤ Enter choice: "); 
            switch (choice) {
                
                // Add expenses
                case 1:
                    
                    int categoryCount = displayAvailabeCategory(u);
                    
                    // Add Expenses Confirm
                    if (categoryCount > 0) {
                        
                        addExpenseOperation(u, categoryCount);
                                
                    }
                    else {
                        System.out.println("\n  [!] Not enough Categories! Please create them to add Expenses.");
                    }
                    break;
                
                // Delete expense 
                case 2:
                    
                    // Check if the list is empty;
                    int expenseCount = u.getAppState().getExpenses().size();
                    if (expenseCount == 0) {
                        
                        System.out.println("\n  [i] No expenses created yet!");
                        break;
                    }
                        deleteExpenseOperation(u, expenseCount);
                    
                    break;
                  
                // Manage Wallet
                case 3:
                    boolean runOperation = true;
                    
                    while (runOperation) {
                       runOperation = manageWalletOperation(u);
                    }

                    break;
                 
                // Manage Category
                case 4:
                    boolean runOperation2 = true;
                    
                    while (runOperation2) {
                       runOperation2 = manageCategoryOperation(u);
                    }
                    break;
                
                // Report Cashflow
                case 5:
                        displayCashFlow(u);
                    break;
                
                case 6:
                    run = false;
                    
                    DataManager.saveAppState(u.getAppState(), SAVE_FILE);
                    System.out.println("\n────────────────────────────────────────────────────────");
                    System.out.println("       Thank you for using Expense Tracker. Goodbye!    ");
                    System.out.println("────────────────────────────────────────────────────────\n");
                    break;
                
                default:
                    System.out.println("\n  [x] Option not found! Please try again.");
                            
            }
        }
        
    }
    
// Manage Category Operation
    public static boolean manageCategoryOperation(User u) {
        
        // Display Wallet and Options
        displayCategoryMenu(u);
        
        int choice = getValidInt("  ➤ Enter choice: ");
        switch (choice) {
            
            // Add Category
            case 1:
                
                handleAddCategory(u);
                break;

            case 2:
                
                handleDeleteCategory(u);
                
                break;

            // Exit
                
            case 3:
                
                return false;
                
            default:
                System.out.println("\n  [x] Option not found! Please try again.");
                
        } 
        return true;
    }
    
    // Manage wallet operation
    public static boolean manageWalletOperation(User u) {
        
        // Display Wallet and Options
        displayWalletMenu(u);
        
        
        int choice = getValidInt("  ➤ Enter choice: ");
        switch (choice) {
            
            // Add Wallet
            case 1:
                
                handleAddWallet(u);
                break;
             
            // Delete Wallet
            case 2:
                
                handleDelete(u);
                break;
            
            // Deposit
            case 3:
                
                handleDeposit(u);
                break;
            
            // Withdraw cash
            case 4:
                handleWithdraw(u);
                break; 
                
            // Show transaction
            case 5:
                showTransaction(u);
                break;
            
            // Exit
            case 6:
                return false;
                
            default:
                System.out.println("\n  [x] Option not found! Please try again.");
                
        } 
        return true;
    }
         
}