package com.savya.commands;

import com.savya.rbac.Role;

public abstract class Command {
    private Role role;
    private String commandName;

    protected Command(String commandName,Role role) {
        this.role = role;
        this.commandName = commandName;
    }

    public Role getRole() {
        return role;
    }

    public abstract void execute();

    @Override
    public String toString() {
        return commandName;
    }
}
