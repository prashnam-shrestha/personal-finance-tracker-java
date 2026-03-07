/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.expensetracker;

import java.io.Serializable;

/**
 *
 * @author prashnamshrestha
 */
public class Transaction implements Serializable {
    
    public CashFlow incomeOrExpense;
    public double currentBalance;
    
    public Transaction(CashFlow incomeOrExpense) {
        setIncomeOrExpense(incomeOrExpense);
        
        currentBalance = incomeOrExpense.getWallet().getBalance();
        
    }
    
    public String getDetail() {
        
        String detail = String.format(
                " ⮂ Transaction: %-10s | Rs %-8.2f | Date: %s | Wallet: %-10s | Balance: Rs %.2f",
                incomeOrExpense.getCategory().getNameCategory(),
                incomeOrExpense.getAmount(),
                incomeOrExpense.getDate(),
                incomeOrExpense.getWallet().getNameWallet(),
                currentBalance
        );
        
        return detail;
    }
    
    // Getters and Setters

    public CashFlow getIncomeOrExpense() {
        return incomeOrExpense;
    }

    public void setIncomeOrExpense(CashFlow incomeOrExpense) {
        this.incomeOrExpense = incomeOrExpense;
    }

    
    
    
}