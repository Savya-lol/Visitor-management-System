package com.savya.database.dao;

import java.util.List;

import org.hibernate.Session;

import com.savya.database.DatabaseServiceImpl;
import com.savya.database.entities.Visitor;

public class VisitorDAO extends DatabaseServiceImpl<Visitor> {
    public VisitorDAO() {
        super(Visitor.class);
    }

    public List<Visitor> getAllRecords() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from " + entityType.getSimpleName(), entityType).list();
        }
    }

    public Visitor getVisitorByContact(String contact) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Visitor WHERE contact = :contact", Visitor.class)
                    .setParameter("contact", contact)
                    .uniqueResult();
        }
    }
}
