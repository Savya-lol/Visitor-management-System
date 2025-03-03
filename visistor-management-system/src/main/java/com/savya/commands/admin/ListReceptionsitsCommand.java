package com.savya.commands.admin;

import com.savya.commands.Command;
import com.savya.commands.services.AdminService;
import com.savya.rbac.Role;

public class ListReceptionsitsCommand extends Command {
    private AdminService adminService;

    public ListReceptionsitsCommand(String commandName,AdminService adminService, Role role) {
        super(commandName, role);
        this.adminService = adminService;
    }

    @Override
    public void execute() {
        adminService.listReceptionists();
    }

}
