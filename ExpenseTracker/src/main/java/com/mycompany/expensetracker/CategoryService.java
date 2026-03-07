/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.expensetracker;

import static com.mycompany.expensetracker.InputHelper.getValidInt;
import static com.mycompany.expensetracker.InputHelper.getValidString;
import static com.mycompany.expensetracker.InputHelper.sc;

/**
 *
 * @author prashnamshrestha
 */
public class CategoryService {
    
    public static void handleAddCategory(User u) {
        
        String name = getValidString("Enter Category Name: ");
        
        if (name.isEmpty()) {
            System.out.println("\n  [x] Name cannot be empty! Please try again!");
            return;
        }

        Category category = new Category(name, null);
        u.addCategory(category);
        System.out.printf("\n  [✓] Successfully added category: %s\n", name);
    }
           
    public static void handleDeleteCategory(User u) {
        int categoryIndex = getValidInt("Enter Category ID: ") - 1;
        
        try {
            
            Category c = u.getAppState().getCategory().get(categoryIndex);
            u.deleteCategory(c);
            System.out.printf("\n  [✓] Successfully deleted category: %s\n", c.getNameCategory());
            
        } catch (IndexOutOfBoundsException i) {
            System.out.printf("\n  [x] Category ID %s not found!\n", categoryIndex + 1);
        }
        
        
    }
    
    public static Category getCategorySpecific(User u) {
        
        int categoryIndex = getValidInt(String.format("  ➤ Pick a Category (1 - %s): ", u.getAppState().getCategory().size())) - 1;

        Category category;

         // Catch invalid category option to pre return
        try {

            category = u.getAppState().getCategory().get(categoryIndex);
            return category;

        }  catch (IndexOutOfBoundsException i) {

                System.out.println("\n  [x] Category option not found!");
                return null;
        }
    }
    
    
}
