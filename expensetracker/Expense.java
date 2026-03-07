/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.expensetracker;

import java.time.LocalDate;

/**
 *
 * @author prashnamshrestha
 */
public class Expense extends CashFlow{
    
    public Expense(String name, double amount, Category category, Wallet wallet) {
        super(name, amount, category, wallet);
    }
    // General expense info
    public String getCashFlowInfo() {
        String info = String.format("%-12s | %-12s | Rs %-8.2f | %-12s | %s", getDate(), getCategory().getNameCategory(), getAmount(), getWallet().getNameWallet(), getName());
        return info;
    }
    
}