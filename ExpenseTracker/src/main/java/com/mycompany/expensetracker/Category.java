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
public class Category implements Serializable {
    private String nameCategory;
    private CashFlowType typeCashFlow;
    
    // Todo Budget
    
    public Category(String nameCategory, CashFlowType typeCashFlow) {
        setNameCategory(nameCategory);
        setTypeCashFlow(typeCashFlow);
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public CashFlowType getTypeCashFlow() {
        return typeCashFlow;
    }

    public void setTypeCashFlow(CashFlowType typeCashFlow) {
        this.typeCashFlow = typeCashFlow;
    }


   
    
    
    
}
