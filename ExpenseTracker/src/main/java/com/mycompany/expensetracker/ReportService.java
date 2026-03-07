/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.expensetracker;

/**
 *
 * @author prashnamshrestha
 */
public class ReportService {
    
    public static void showTransaction(User u) {
        System.out.println("\n────────────────────────────────────── TRANSACTIONS ──────────────────────────────────────");
        for (Transaction t: u.getAppState().getTransaction()) {

            System.out.println(t.getDetail());

        }
        System.out.println("──────────────────────────────────────────────────────────────────────────────────────────");
    }
    
    // Display cashflow
    public static void displayCashFlow(User u) {
        
        System.out.println("\n==================== 📊 CASHFLOW REPORT ====================");
        System.out.println("▼ EXPENSES (Count: " + u.getAppState().getExpenses().size() + ")");
        System.out.println("------------------------------------------------------------");
        double totalExpenses = 0;
        
        for (Expense e : u.getAppState().getExpenses()) {
             System.out.println("  - " + e.getCashFlowInfo());
             totalExpenses += e.getAmount();
        }
        
        System.out.println("\n▲ INCOMES (Count: " + u.getAppState().getIncomes().size() + ")");
        System.out.println("------------------------------------------------------------");
        double totalIncome = 0;
        
        for (Income i : u.getAppState().getIncomes()) {
             System.out.println("  - " + i.getCashFlowInfo());
             totalIncome += i.getAmount();
        }
        
        System.out.println("\n---------------------- SUMMARY -----------------------------");
        System.out.printf("  Total Expenses Amount : Rs %.2f\n", totalExpenses);
        System.out.printf("  Total Income Amount   : Rs %.2f\n", totalIncome);
        System.out.printf("  Remaining amount      : Rs %.2f\n", totalIncome - totalExpenses);
        System.out.println("============================================================");
        
    }
    
}
