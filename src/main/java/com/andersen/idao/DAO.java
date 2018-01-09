package com.andersen.idao;

import com.andersen.HibernateWorker;
import com.andersen.model.Model;
import org.hibernate.Session;
import org.hibernate.Transaction;

public interface DAO<T extends Model> {

    default boolean save(T entity) {
        Long id = null;

        Session session = HibernateWorker.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        id = (Long) session.save(entity);
        transaction.commit();

        return id != null;
    }

    T findById(Long id);

    String read(Long id);

    boolean update(Long id, T entity);

    void delete(Long id);
}
