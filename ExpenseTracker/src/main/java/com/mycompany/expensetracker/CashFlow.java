/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.expensetracker;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author prashnamshrestha
 */
public abstract class CashFlow implements Serializable {

    private String name;
    private double amount;
    private LocalDate date;
    private Category category;
    private Wallet wallet;
    
    public CashFlow(String name, double amount, Category category, Wallet wallet) {
        
        setName(name);
        setAmount(amount);
        setDate(LocalDate.now());
        setCategory(category);
        setWallet(wallet);
    }
    // Generalinfo
    public abstract String getCashFlowInfo();
    
    // Getters and Setters
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }
    
    
    
    
    
}
