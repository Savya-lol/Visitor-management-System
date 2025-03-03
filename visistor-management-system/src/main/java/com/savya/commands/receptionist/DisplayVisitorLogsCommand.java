package com.savya.commands.receptionist;

import com.savya.commands.Command;
import com.savya.commands.services.VisitorLogService;
import com.savya.rbac.Role;

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
