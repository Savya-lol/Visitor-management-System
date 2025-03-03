package com.savya.commands.common;


import com.savya.auth.AuthService;
import com.savya.commands.Command;
import com.savya.rbac.Role;

public class LogOutCommand extends Command {
    public LogOutCommand(String commandName, Role role) {
        super(commandName,role);
    }

    @Override
    public void execute() {
        AuthService.logout();
    }

}
