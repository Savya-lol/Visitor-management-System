package com.savya;

import com.savya.auth.AuthService;
import com.savya.commands.CommandInvoker;
import com.savya.utilities.InputManager;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Program {
    public static void main(String[] args) {
        Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
        Logger.getLogger("org.hibernate.SQL").setLevel(Level.SEVERE);
        Logger.getLogger("org.hibernate.type").setLevel(Level.SEVERE);
        Logger.getLogger("org.hibernate.type.descriptor.sql").setLevel(Level.SEVERE);
        Logger.getLogger("org.hibernate.orm.jdbc.bind").setLevel(Level.SEVERE);
        Logger.getLogger("org.hibernate.engine.transaction").setLevel(Level.SEVERE);

        CommandInvoker commandInvoker = new CommandInvoker();
        while (true) {
            if (AuthService.IsLoggedIn()) {
                commandInvoker.displayCommands();
                int choice = InputManager.getInt("Enter choice: ");
                commandInvoker.invokeCommand(choice);
                InputManager.getString("Press Enter to continue...");
            } else {
                AuthService.login();
            }
        }
    }
}
