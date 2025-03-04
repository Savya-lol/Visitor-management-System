package com.savya.commands.receptionist;

import com.savya.commands.Command;
import com.savya.rbac.Role;
import com.savya.services.VisitorLogService;

public class DisplayVisitorLogsCommand extends Command {
    private final VisitorLogService visitorLogService;

    public DisplayVisitorLogsCommand(String commandName,VisitorLogService visitorLogService,Role role) {
        super(commandName,role);
        this.visitorLogService = visitorLogService;
    }

    @Override
    public void execute() {
        visitorLogService.displayVisitorLogs();
    }

}
