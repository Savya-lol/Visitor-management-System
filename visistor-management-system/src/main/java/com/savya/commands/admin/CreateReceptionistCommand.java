package com.savya.commands.admin;

import com.savya.commands.Command;
import com.savya.rbac.Role;
import com.savya.services.AdminService;

public class CreateReceptionistCommand extends Command {
    private AdminService adminService;
    public CreateReceptionistCommand(String commandName,AdminService adminService,Role role) {
        super(commandName,role);
        this.adminService = adminService;
    }

    @Override
    public void execute() {
        adminService.createReceptionist();
    }


}


