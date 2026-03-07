/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.expensetracker;

/**
 *
 * @author prashnamshrestha
 */
public class User {
    
    private String name;
    private AppState appState;
    
    public User (String name) {
        
       setAppState(new AppState());
       setName(name);
        
    }
    public void addIncome(Income income) { 
        
        appState.getIncomes().add(income);
        
        // Everytime an income is added
        // Transaction is added
        
        income.getWallet().deposit(income.getAmount());
        
        Transaction transactionNew = new Transaction(income);
        addTransaction(transactionNew);
        

    }
    
    // Expense
    public boolean addExpense(Expense expense) { 
        
        // Checking if enough balance
        boolean run = expense.getWallet().withdraw(expense.getAmount());
        
        if (run) {
            appState.getExpenses().add(expense);
        
            // Everytime an expense is added
            // Transaction is added
            
            Transaction transactionNew = new Transaction(expense);
            addTransaction(transactionNew);
            return run;
        }
        
        return run;

    }
    
    // Delete expense
    public void deleteExpense(Expense expense) {
        appState.getExpenses().remove(expense);
        
    }
    
    // Category
    public void addCategory(Category c) {
        appState.getCategory().add(c);
    }
    
    public void deleteCategory(Category c) {
        appState.getCategory().remove(c);
    }
    
    // Wallet
    public void addWallet(Wallet w) {
        appState.getWallet().add(w);
    }
    
    public void deleteWallet(Wallet w) {
        appState.getWallet().remove(w);
    }
    
    // Transaction
    public void addTransaction(Transaction t) {
        appState.getTransaction().add(t);
    }
    
    public void deleteTransaction(Transaction t) {
        appState.getTransaction().remove(t);
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AppState getAppState() {
        return appState;
    }

    public void setAppState(AppState appState) {
        this.appState = appState;
    }
    
    
    
}
