package com.savya;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.savya.auth.AuthService;
import com.savya.commands.CommandInvoker;
import com.savya.utilities.InputManager;

public class Main {
    public static void main(String[] args) {
        Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
        Logger.getLogger("org.hibernate.SQL").setLevel(Level.SEVERE);
        Logger.getLogger("org.hibernate.type").setLevel(Level.SEVERE);

        CommandInvoker commandInvoker = new CommandInvoker();
        while (true) {
            if (AuthService.IsLoggedIn()) {
                commandInvoker.displayCommands();
                int choice = InputManager.getInt("Enter choice: ");
                commandInvoker.invokeCommand(choice);
            } else {
                AuthService.login();
            }
        }
    }
}