/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.expensetracker;

import static com.mycompany.expensetracker.CategoryService.*;
import static com.mycompany.expensetracker.InputHelper.*;
import static com.mycompany.expensetracker.MenuPrinter.displayAvailabeCategory;

/**
 *
 * @author prashnamshrestha
 */
public class WalletService {
    
    public static void handleDeposit(User u) {

        // Declear parameters to be passed
        Category category;
        Wallet wallet;
        String description;
        double amount;

        int walletCount = u.getAppState().getWallet().size();

        // Check no wallet case
        if (walletCount == 0) {
            System.out.println("\n  [!] Not enough Wallets! Please create them to add Income.");
            return;
        }

        wallet = getWalletSpecific(u);

        if (wallet == null) { // Return if no wallet selected
                return;
        }
        // Display Available Categories
        int count = displayAvailabeCategory(u);

        // Check no category case
        if (count == 0) {
            System.out.println("\n  [!] Not enough Categories! Please create them to add Income.");
            return;
        }

        category = getCategorySpecific(u);

        if (category == null) { // Return if no category selected
            return;
        }

        //Get name and amount
        System.out.print("  ✎ Enter Income Description: ");
        description = sc.nextLine();
        amount = getValidDouble("  💲 Enter amount (Rs): ");
        Income incomeNew = new Income(description, amount, category, wallet);
        u.addIncome(incomeNew);

        System.out.println("\n  [✓] Successfully added income!");

        return;
    }
    
    public static void handleDelete(User u) {
        int walletIndex = getValidInt("  ➤ Enter Wallet ID: ") - 1;
        String name;
        
        
        // Catch if wallet exists
                
        try {
            // Delete
            Wallet walletDelete =  u.getAppState().getWallet().get(walletIndex);
            name = walletDelete.getNameWallet();
            
            // Check if its linked with expenses or not
            for (Expense e : u.getAppState().getExpenses()) {
                if (e.getWallet() == walletDelete) {
                    System.out.printf("\n  [x] Wallet ID %s has linked expenses.!\n", walletIndex + 1);
                    return;
                }
            }
            
            for (Income i : u.getAppState().getIncomes()) {
                if (i.getWallet() == walletDelete) {
                    System.out.printf("\n  [x] Wallet ID %s has linked incomes.!\n", walletIndex + 1);
                    return;
                }
            }
                    
            u.getAppState().getWallet().remove(walletDelete);
            System.out.printf("\n  [✓] Successfully deleted wallet: %s\n", name);
            return;
                    
        } catch (IndexOutOfBoundsException i) {
                    
           System.out.printf("\n  [x] Wallet ID %s not found!\n", walletIndex + 1);
           return;
        }
    }
    
    public static void handleWithdraw(User u) {
        
        double amountWithdraw = getValidDouble("  💲 Enter amount to withdraw (Rs): ");
        Wallet wallet2;
        int walletCount2 = u.getAppState().getWallet().size();

        // Catch no wallet case
        if (walletCount2 == 0) {
            System.out.println("\n  [!] Not enough Wallets! Please create them to add Income.");
            return;
        }

        wallet2 = getWalletSpecific(u);

        if (wallet2 == null) { // If user doesnt select any wallet

                return;
        }


        boolean success = wallet2.withdraw(amountWithdraw);
        if (!success) {

            System.out.printf("\n  [x] Not enough balance in wallet: %s\n", wallet2.getNameWallet());
            return;
        }

        System.out.printf("\n  [✓] Successfully withdrawn Rs %s from wallet: %s\n", amountWithdraw, wallet2.getNameWallet());

        // Not keeping transaction for now.. (Gets complicated)

    }
    
    public static void handleAddWallet(User u) {
                String walletName;
                boolean run;
                
                do {
                    walletName = getValidString("  ✎ Enter Wallet Name: ");
                   
                    run = false;
                    
                    // Checking if the name already exists
                    for (Wallet w: u.getAppState().getWallet()) {

                        if (w.getNameWallet().toLowerCase().equals(walletName.toLowerCase())) {

                            System.out.println("\n  [x] Wallet name already exists! Please try again!");
                            run = true;
                            break;
                        }
                    }
                }
                while (run);
                
                // If doesnt exists
                Wallet walletNew = new Wallet(walletName, 0);
                
                u.addWallet(walletNew);
                System.out.printf("\n  [✓] Successfully added wallet: %s\n", walletName);
    }
    
    public static Wallet getWalletSpecific(User u) {
            // Pick wallet
            int walletIndex = getValidInt(String.format("  ➤ Pick a Wallet (1 - %s): ", u.getAppState().getWallet().size())) - 1;
            
            Wallet wallet;
            // Catch invalid wallet number to pre return
            try {
                
                wallet = u.getAppState().getWallet().get(walletIndex);
                return wallet;
                
            } catch (IndexOutOfBoundsException i) {
                
                System.out.println("\n  [x] Wallet not found!");
                return null;
            }
    }
 
}
