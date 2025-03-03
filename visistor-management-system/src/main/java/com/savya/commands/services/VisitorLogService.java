package com.savya.commands.services;

import com.savya.database.dao.VisitorLogDAO;

public class VisitorLogService {
    private final VisitorLogDAO visitorLogDAO = new VisitorLogDAO();

    public void displayVisitorLogs() {
        System.out.println("Visitor Logs:");
        visitorLogDAO.findAll().forEach(visitorLog -> {
            System.out.println(visitorLog.getVisitor().getName() + "with contact" +
                    visitorLog.getVisitor().getContact() + " checked in at " + visitorLog.getCheckinTime());
        });
    }

    public void clearVisitorLogs() {
        visitorLogDAO.deleteAll();
        System.out.println("Visitor logs cleared");
    }
}
