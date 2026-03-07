/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.expensetracker;

import static com.mycompany.expensetracker.CategoryService.*;
import static com.mycompany.expensetracker.InputHelper.*;
import static com.mycompany.expensetracker.MenuPrinter.*;
import static com.mycompany.expensetracker.WalletService.*;

/**
 *
 * @author prashnamshrestha
 */
public class ExpenseService {
    
// Delete expense Operation
    public static void deleteExpenseOperation(User u, int expenseCount) {
        
        displayExpenses(u);
        
        int expenseIndex = getValidInt(String.format("\n  ➤ Enter expense ID (1 - %s): ", expenseCount)) - 1;
        
        try {
            
            Expense expenseDelete = u.getAppState().getExpenses().get(expenseIndex);
            
            double amount = expenseDelete.getAmount();
            Wallet wallet = expenseDelete.getWallet();
            
            // Remove transaction
            for (Transaction t: u.getAppState().getTransaction()){
                
                if (t.getIncomeOrExpense().getCashFlowInfo().equals(expenseDelete.getCashFlowInfo())) {
                    
                    u.deleteTransaction(t);
                    System.out.println("  [i] Temp: Removed transaction");
                    break;
                }
            }
            // Deposit the amount back
            wallet.setBalance(wallet.getBalance() + amount);
            
            // Remove expense
            u.deleteExpense(expenseDelete);
            System.out.println("  [✓] Expense deleted successfully.");
            
        }
        catch (IndexOutOfBoundsException i) {
            System.out.printf("\n  [x] Expense ID %s not found!\n", expenseIndex + 1);
        }
        
    }
    
    // Add Expense Operation
    public static void addExpenseOperation(User u, int categoryCount) {
        
        Category category = getCategorySpecific(u);
        if (category == null) {
            return;
        }
        
        // Get expense details from user
        
        String name = getValidString("  ✎ Description of expense: ");
            
        double amount = getValidDouble("  💲 Enter amount (Rs): ");
        
        // Display available wallets
        int walletCount = displayAvailabeWallet(u);
        
        // Catch no wallet case
        if (walletCount > 0) {
            
            Wallet wallet = getWalletSpecific(u);
            
            if (wallet == null) {
                return;
            }
             
            Expense exp = new Expense(name, amount, category, wallet);
            
            // Adding expense
            if (u.addExpense(exp)) {
                
                System.out.printf("\n  [✓] Successfully added expense: %s!\n", exp.getName());
            }
            else {
                // Exit if not enough balance
                System.out.printf("\n  [x] Not enough balance in the wallet: %s!\n", wallet.getNameWallet());
            }
        }
       
        else {
            System.out.println("\n  [!] Not enough Wallets! Please create them to add Expenses.");
        }
                
    }
    
}
