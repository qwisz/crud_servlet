package com.andersen.dao;

import com.andersen.HibernateWorker;
import com.andersen.idao.ManufactureDAO;
import com.andersen.model.Manufacture;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ManufactureDAOImpl implements ManufactureDAO {

    private Session session;

    public ManufactureDAOImpl() {
        this.session = HibernateWorker.getSessionFactory().openSession();
    }

    @Override
    public Manufacture findById(Long id) {
        Transaction transaction = session.beginTransaction();

        Manufacture manufacture = session.load(Manufacture.class, id);
        transaction.commit();
        return manufacture;
    }

    public String read(Long id) {
        Transaction transaction = session.beginTransaction();

        Manufacture manufacture = session.load(Manufacture.class, id);
        System.out.println(manufacture);
        transaction.commit();
        return "hehe";
    }

    public boolean update(Long id, Manufacture entity) {
        Transaction transaction = session.beginTransaction();

        Manufacture old = session.get(Manufacture.class, id);
        old.setName(entity.getName());
        old.setProducts(entity.getProducts());
        session.update(old);
        transaction.commit();

        return old != null;
    }

    public void delete(Long id) {
        Transaction transaction = session.beginTransaction();

        Manufacture manufacture = session.get(Manufacture.class, id);
        session.delete(manufacture);
        transaction.commit();
    }
}
