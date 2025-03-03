package com.savya.commands.admin;

import com.savya.commands.Command;
import com.savya.commands.services.VisitorLogService;
import com.savya.rbac.Role;

public class ClearVisitorLogsCommand extends Command {
    private VisitorLogService visitorLogService;

    public ClearVisitorLogsCommand(String commandName,VisitorLogService visitorLogService, Role role) {
        super(commandName,role);
        this.visitorLogService = visitorLogService;
    }

    @Override
    public void execute() {
        visitorLogService.clearVisitorLogs();
    }
    
}
