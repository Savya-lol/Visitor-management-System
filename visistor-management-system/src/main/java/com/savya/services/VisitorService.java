package com.savya.services;

import java.time.LocalDateTime;

import com.savya.database.dao.VisitorDAO;
import com.savya.database.dao.VisitorLogDAO;
import com.savya.database.entities.Visitor;
import com.savya.database.entities.VisitorLog;
import com.savya.utilities.InputManager;

public class VisitorService {

    private final VisitorDAO visitorDAO = new VisitorDAO();
    private final VisitorLogDAO visitorLogDAO = new VisitorLogDAO();

    public void registerVisitor() {
        String name = InputManager.getString("Enter visitor's name: ");
        String contact = InputManager.getString("Enter visitor's contact: ");
        String purpose = InputManager.getString("Enter visitor's purpose: ");

        if (getVisitorByContact(contact) != null) {
            System.out.println("Visitor with this contact already exists");
            return;
        }

        Visitor visitor = new Visitor(name, contact, purpose);
        visitorDAO.save(visitor);
        System.out.println("Visitor registered successfully");
    }

    public void checkInVisitor() {
        String contact = InputManager.getString("Enter visitor's contact: ");
        Visitor existingVisitor = getVisitorByContact(contact);
        if (existingVisitor == null) {
            System.out.println("Visitor not found");
            return;
        }
        if (visitorLogDAO.getVisitorLogByVisitorId(existingVisitor) != null) {
            System.out.println("Visitor has already checked in");
            return;
        }
        VisitorLog visitorLog = new VisitorLog(existingVisitor, LocalDateTime.now());
        visitorLogDAO.save(visitorLog);
        System.out.println("Visitor checked in successfully");
    }

    public void checkOutVisitor() {
        String contact = InputManager.getString("Enter visitor's contact: ");
        Visitor existingVisitor = getVisitorByContact(contact);
        if (existingVisitor == null) {
            System.out.println("Visitor not found");
            return;
        }
        VisitorLog visitorLog = visitorLogDAO.getVisitorLogByVisitorId(existingVisitor);
        if (visitorLog == null) {
            System.out.println("Visitor has not checked in");
            return;
        }
        visitorLog.setCheckoutTime(LocalDateTime.now());
        visitorLogDAO.update(visitorLog);
        System.out.println("Visitor checked out successfully");
    }

    public void listVisitors() {
        System.out.println("Visitors:");
        System.out.println("id\tName\tContact\tPurpose");
        visitorDAO.getAllRecords().forEach(visitor -> {
            System.out.println(visitor.getId() + "\t" + visitor.getName() + "\t" + visitor.getContact() + "\t" + visitor.getPurpose());
        });
    }

    public void deleteVisitor() {
        listVisitors();
        String contact = InputManager.getString("Enter the contact of visitor to delete: ");
        Visitor existingVisitor = getVisitorByContact(contact);
        if (existingVisitor == null) {
            System.out.println("Visitor not found");
            return;
        }
        VisitorLog visitorLog = visitorLogDAO.getVisitorLogByVisitorId(existingVisitor);
        if (visitorLog != null) {
            visitorLogDAO.delete(visitorLog);
        }
        visitorDAO.delete(existingVisitor);
        System.out.println("Visitor deleted successfully");
    }

    public Visitor getVisitorByContact(String contact) {
        return visitorDAO.getVisitorByContact(contact);
    }

}
