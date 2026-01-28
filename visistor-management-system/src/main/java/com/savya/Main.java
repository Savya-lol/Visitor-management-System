package com.savya;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.savya.auth.AuthService;
import com.savya.commands.CommandInvoker;
import com.savya.utilities.InputManager;

public class Main {
    public static void main(String[] args) {
        if (args.length > 0 && args[0].equalsIgnoreCase("--init-admin")) {
            com.savya.utilities.setup.AdminCreator.main(args);
        } else {
            Program.main(args);
        }
    }
}