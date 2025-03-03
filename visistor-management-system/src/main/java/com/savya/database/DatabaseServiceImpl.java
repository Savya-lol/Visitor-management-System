package com.savya.database;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class DatabaseServiceImpl<T> implements DatabaseService<T> {
    protected static final SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    protected final Class<T> entityType;

    public DatabaseServiceImpl(Class<T> entityType) {
        this.entityType = entityType;
    }

    @Override
    public void save(T entity) {
        executeInsideTransaction(session -> session.persist(entity));
    }

    @Override
    public void update(T entity) {
        executeInsideTransaction(session -> session.merge(entity));
    }

    @Override
    public void delete(T entity) {
        executeInsideTransaction(session -> session.remove(entity));
    }

    @Override
    public T findById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(entityType, id);
        }
    }

    @Override
    public List<T> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from " + entityType.getSimpleName(), entityType).list();
        }
    }

    private void executeInsideTransaction(DatabaseOperation operation) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            operation.execute(session);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    @FunctionalInterface
    private interface DatabaseOperation {
        void execute(Session session);
    }
}
