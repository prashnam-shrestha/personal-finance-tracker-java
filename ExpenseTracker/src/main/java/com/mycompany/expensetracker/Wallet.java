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
public class Wallet implements Serializable {
    
    private double balance;
    private String nameWallet;
    
    public Wallet(String name, double balance) {
        setBalance(balance);
        setNameWallet(name);
    }
    
    public boolean withdraw(double amount) {
        double bal = getBalance();
        if (bal < amount) {
            return false;
        }
        else {
            this.setBalance(bal - amount);
            return true;
        }
    }
    
    public void deposit(double amount) {
        setBalance(getBalance() + amount);
    }
    
    public String getDetail() {
        String info = String.format(" 💼 Wallet [%s] : Rs %.2f", getNameWallet(), getBalance());
        return info;
    }

    // Getters and Setters
    
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getNameWallet() {
        return nameWallet;
    }

    public void setNameWallet(String nameWallet) {
        this.nameWallet = nameWallet;
    }
    
    
    
    
}