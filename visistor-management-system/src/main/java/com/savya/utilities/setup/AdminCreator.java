package com.savya.utilities.setup;

import com.savya.database.dao.UserDAO;
import com.savya.database.entities.User;
import com.savya.rbac.Role;
import com.savya.security.SecurityService;

public class AdminCreator {
    public static void main(String[] args) {
        try {
            String username = args.length > 0 ? args[0] : "admin";
            String password = args.length > 1 ? args[1] : "password";

            System.out.println("Creating admin user: " + username);
            UserDAO userDAO = new UserDAO();

            // Check if user already exists
            User existingUser = userDAO.findByUsername(username);
            if (existingUser != null) {
                System.out.println("User already exists!");
                return;
            }

            // Create new admin user
            String hashedPassword = SecurityService.hashPassword(password);
            User adminUser = new User(username, hashedPassword, Role.ADMIN);
            userDAO.save(adminUser);

            System.out.println("Admin user created successfully!");
        } catch (Exception e) {
            System.err.println("Error creating admin user: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
