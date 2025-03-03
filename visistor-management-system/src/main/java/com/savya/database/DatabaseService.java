package com.savya.database;
import java.util.List;

public interface DatabaseService<T> {
    void save(T entity);

    void update(T entity);

    void delete(T entity);

    T findById(int id);

    List<T> findAll();
}
