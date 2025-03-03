package com.savya.database.dao;

import org.hibernate.Session;

import com.savya.database.DatabaseServiceImpl;
import com.savya.database.entities.Visitor;
import com.savya.database.entities.VisitorLog;

public class VisitorLogDAO extends DatabaseServiceImpl<VisitorLog> {
    public VisitorLogDAO() {
        super(VisitorLog.class);
    }

    public VisitorLog getVisitorLogByVisitorId(Visitor visitor) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM VisitorLog vl WHERE vl.visitor = :visitor", VisitorLog.class)
                    .setParameter("visitor", visitor)
                    .uniqueResult();
        }
    }

    public void deleteAll() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.createQuery("DELETE FROM VisitorLog", VisitorLog.class).executeUpdate();
            session.getTransaction().commit();
        }
    }
}