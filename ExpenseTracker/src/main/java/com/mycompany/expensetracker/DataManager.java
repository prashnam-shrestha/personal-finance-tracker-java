package com.mycompany.expensetracker;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author prashnamshrestha
 */
public class DataManager {
    
    public static void saveAppState(AppState state, String filePath) {
      
            try (FileOutputStream fos = new FileOutputStream(filePath);
                 ObjectOutputStream oos = new ObjectOutputStream(fos)) {

                oos.writeObject(state); // Writes the entire AppState to the file
                System.out.println("  [✓] Data saved successfully to " + filePath);

            } catch (IOException e) {
                System.out.println("  [x] Error saving data: " + e.getMessage());
                e.printStackTrace();
            }
        }
    
    public static AppState loadAppState(String filePath) {
        
            try (FileInputStream fis = new FileInputStream(filePath);
                 ObjectInputStream ois = new ObjectInputStream(fis)) {

                // Read the object and cast it back to AppState
                AppState state = (AppState) ois.readObject();
                System.out.println("  [✓] Data loaded successfully.");
                return state;

            } catch (IOException | ClassNotFoundException e) {
                System.out.println("  [i] No previous save data found or error loading. Starting fresh.");
                return new AppState(); // Return a fresh state if loading fails
            }
        }
    
}
