package com.savya.database.dao;

import org.hibernate.Session;

import com.savya.database.DatabaseServiceImpl;
import com.savya.database.entities.User;

public class UserDAO extends DatabaseServiceImpl<User> {
    public UserDAO() {
        super(User.class);
    }

    public User findByUsername(String username) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM User WHERE username = :username", User.class)
                    .setParameter("username", username)
                    .uniqueResult();
        }
    }
}
