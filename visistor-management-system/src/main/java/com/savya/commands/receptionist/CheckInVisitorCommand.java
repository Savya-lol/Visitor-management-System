package com.savya.commands.receptionist;


import com.savya.commands.Command;
import com.savya.rbac.Role;
import com.savya.services.VisitorService;

public class CheckInVisitorCommand extends Command {
    private VisitorService visitorService;

    public CheckInVisitorCommand(String commandName,VisitorService visitorService,Role role){
        super(commandName,role);
        this.visitorService = visitorService;
    }

    @Override
    public void execute() {
        visitorService.checkInVisitor();
    }
}
