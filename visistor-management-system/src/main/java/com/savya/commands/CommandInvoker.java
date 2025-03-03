package com.savya.commands;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.savya.auth.AuthService;
import com.savya.commands.admin.ClearVisitorLogsCommand;
import com.savya.commands.admin.CreateReceptionistCommand;
import com.savya.commands.admin.DeleteReceptionistCommand;
import com.savya.commands.admin.ListReceptionsitsCommand;
import com.savya.commands.admin.UpdateReceptionistCommand;
import com.savya.commands.common.LogOutCommand;
import com.savya.commands.receptionist.CheckInVisitorCommand;
import com.savya.commands.receptionist.CheckOutVisitorCommand;
import com.savya.commands.receptionist.DisplayVisitorLogsCommand;
import com.savya.commands.receptionist.RegisterVisitorCommand;
import com.savya.commands.services.AdminService;
import com.savya.commands.services.VisitorLogService;
import com.savya.commands.services.VisitorService;
import com.savya.rbac.Role;

public class CommandInvoker {
    private List<Command> registeredCommands = new ArrayList<>();
    private Map<Integer, Command> menuOptions = new LinkedHashMap<>();
    private final VisitorService visitorService = new VisitorService();
    private final VisitorLogService visitorLogService = new VisitorLogService();
    private final AdminService adminService = new AdminService();

    public CommandInvoker() {
        addCommand(new RegisterVisitorCommand("Register New Visitor", visitorService, Role.RECEPTIONIST));
        addCommand(new CheckInVisitorCommand("Check In Visitor", visitorService, Role.RECEPTIONIST));
        addCommand(new CheckOutVisitorCommand("Check Out Visitor", visitorService, Role.RECEPTIONIST));
        addCommand(new DisplayVisitorLogsCommand("Display Visitor Logs", visitorLogService, Role.RECEPTIONIST));

        addCommand(new ListReceptionsitsCommand("List Receptionists", adminService, Role.ADMIN));
        addCommand(new CreateReceptionistCommand("Create Receptionist", adminService, Role.ADMIN));
        addCommand(new UpdateReceptionistCommand("Update Receptionist", adminService, Role.ADMIN));
        addCommand(new DeleteReceptionistCommand("Delete Receptionist", adminService, Role.ADMIN));
        addCommand(new ClearVisitorLogsCommand("Clear All Logs", visitorLogService, Role.ADMIN));

        addCommand(new LogOutCommand("Log Out", Role.COMMON));

    }

    public void addCommand(Command command) {
        registeredCommands.add(command);
    }

    public void displayCommands() {
        System.out.println("Available commands:");
        Map<Role, List<Command>> commandsByRole = new LinkedHashMap<>();

        for (Command command : registeredCommands) {
            if (AuthService.getCurrentUser().getRole().ordinal() <= command.getRole().ordinal()) {
                commandsByRole.computeIfAbsent(command.getRole(), k -> new ArrayList<>()).add(command);
            }
        }

        int i = 1;
        for (Map.Entry<Role, List<Command>> entry : commandsByRole.entrySet()) {
            System.out.println("\n" + entry.getKey() + " COMMANDS:");
            for (Command command : entry.getValue()) {
                System.out.println(i + ". " + command);
                menuOptions.put(i, command);
                i++;
            }
        }
    }

    public void invokeCommand(int option) {
        Command command = menuOptions.get(option);
        if (command == null) {
            System.out.println("Invalid option");
            return;
        }
        if (AuthService.getCurrentUser().getRole().ordinal() > command.getRole().ordinal()) {
            System.out.println("You are not authorized to perform this action");
            return;
        }

        command.execute();
    }
}
