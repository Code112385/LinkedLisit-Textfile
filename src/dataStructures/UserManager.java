/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataStructures;

/**
 *
 * @author senju
 */
import java.io.*;
import java.util.*;

public class UserManager {
    private LinkedList<User> users;
    private String fileName;

    public UserManager(String fileName) {
        this.users = new LinkedList<>();
        this.fileName = fileName;
        loadUsersFromFile();
    }

    // Load users from file
    private void loadUsersFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    users.add(new User(parts[0], parts[1], parts[2]));
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading users: " + e.getMessage());
        }
    }

    // Save users to file
    private void saveUsersToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (User user : users) {
                bw.write(user.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving users: " + e.getMessage());
        }
    }

    // Add a new user
    public void addUser(String username, String password, String userType) {
        users.add(new User(username, password, userType));
        saveUsersToFile();
    }

    // Check if username and password are correct
    public boolean validateLogin(String username, String password, String userType) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password) && user.getUserType().equals(userType)) {
                return true;
            }
        }
        return false;
    }
     public boolean validateUser(String userType){
         for (User user : users){
             if(user.getUserType().equals(userType)){
                 return true;
             }
         }
         return false;
     }

    // Check if username already exists
    public boolean usernameExists(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }
}

