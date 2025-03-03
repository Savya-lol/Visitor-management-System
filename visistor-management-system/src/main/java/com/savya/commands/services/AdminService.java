package com.savya.commands.services;

import com.savya.database.dao.UserDAO;
import com.savya.database.dao.VisitorLogDAO;
import com.savya.database.entities.User;
import com.savya.rbac.Role;
import com.savya.security.SecurityService;
import com.savya.utilities.InputManager;

public class AdminService {
    private final UserDAO userDAO = new UserDAO();
    private final VisitorLogDAO visitorLogDAO = new VisitorLogDAO();

    private String userNamePrompt = "Enter username: ";

    public void createReceptionist() {
        String username = InputManager.getString(userNamePrompt);
        String password = InputManager.getString("Enter password: ");
        try {
            User newUser = new User(username, SecurityService.hashPassword(password), Role.RECEPTIONIST);
            userDAO.save(newUser);
            System.out.println("Receptionist created successfully");
        } catch (Exception e) {
            System.out.println("Error creating user: " + e.getMessage());
        }
    }

    public void updateReceptionist() {
        listReceptionists();
        String username = InputManager.getString(userNamePrompt);
        User user = userDAO.findByUsername(username);
        if (user == null) {
            System.out.println("User not found");
            return;
        }
        String password = InputManager.getString("Enter new password: ");
        try {
            user.setPassword(SecurityService.hashPassword(password));
            userDAO.update(user);
            System.out.println("User updated successfully");
        } catch (Exception e) {
            System.out.println("Error updating user: " + e.getMessage());
        }
    }

    public void deleteReceptionist() {
        String username = InputManager.getString("Enter username: ");
        User user = userDAO.findByUsername(username);
        if (user == null) {
            System.out.println("User not found");
            return;
        }
        userDAO.delete(user);
        System.out.println("User deleted successfully");
    }

    public void listReceptionists() {
        System.out.println("Receptionists:");
        userDAO.findAll().forEach(user -> {
            if (user.getRole() == Role.RECEPTIONIST) {
                System.out.println(user.getUsername());
            }
        });
    }
}
