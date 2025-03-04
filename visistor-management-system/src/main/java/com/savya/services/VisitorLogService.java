package com.savya.services;

import com.savya.database.dao.VisitorLogDAO;

public class VisitorLogService {
    private final VisitorLogDAO visitorLogDAO = new VisitorLogDAO();

    public void displayVisitorLogs() {
        System.out.println("Visitor Logs:");
        visitorLogDAO.findAll().forEach(visitorLog -> {
            String checkoutInfo = visitorLog.getCheckoutTime() != null ? 
                " and checked out at " + visitorLog.getCheckoutTime() : 
                " (still checked in)";
            
            System.out.printf("Visitor: %s - Contact: %s - Checked in: %s%s%n",
                visitorLog.getVisitor().getName(),
                visitorLog.getVisitor().getContact(),
                visitorLog.getCheckinTime(),
                checkoutInfo);
        });
    }

    public void clearVisitorLogs() {
        visitorLogDAO.deleteAll();
        System.out.println("Visitor logs cleared");
    }
}
