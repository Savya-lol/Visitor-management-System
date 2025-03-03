package com.savya.auth;

import com.savya.database.dao.UserDAO;
import com.savya.database.entities.User;
import com.savya.security.SecurityService;
import com.savya.utilities.InputManager;

public class AuthService {
    private static User currentUser;

    public static User getCurrentUser() {
        return currentUser;
    }

    public static boolean IsLoggedIn() {
        return currentUser != null;
    }

    public static void login() {
        try {
            System.out.println("Login");
            String username = InputManager.getString("Enter username: ");
            String password = InputManager.getString("Enter password: ");
            UserDAO userDAO = new UserDAO();
            User user = userDAO.findByUsername(username);
            if (user == null) {
                System.out.println("Authentication failed: User not found");
                return;
            }
            if (SecurityService.verifyPassword(password, user.getPassword())) {
                currentUser = user;
                System.out.println("Authentication successful");
            } else {
                System.out.println("Authentication failed: Invalid password");
            }
        } catch (Exception e) {
            System.out.println("Authentication Error: " + e.getMessage());
        }
    }

    public static void logout() {
        System.out.println("Logging out");
        currentUser = null;
    }
}
