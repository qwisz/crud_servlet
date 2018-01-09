package com.andersen.dao;

import com.andersen.HibernateWorker;
import com.andersen.idao.ProductDAO;
import com.andersen.model.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProductDAOImpl implements ProductDAO {

    private Session session;

    public ProductDAOImpl() {
        this.session = HibernateWorker.getSessionFactory().openSession();
    }

    @Override
    public Product findById(Long id) {
        Transaction transaction = session.beginTransaction();

        Product product = session.load(Product.class, id);

        return product;
    }

    public String read(Long id) {
        Transaction transaction = session.beginTransaction();

        Product product = session.load(Product.class, id);

        return product.toString();
    }

    public boolean update(Long id, Product entity) {
        Transaction transaction = session.beginTransaction();

        Product oldProd = session.get(Product.class, id);
        oldProd.setName(entity.getName());
        oldProd.setPrice(entity.getPrice());
        oldProd.setManufacture(entity.getManufacture());
        session.update(oldProd);
        transaction.commit();

        return oldProd != null;
    }

    public void delete(Long id) {
        Transaction transaction = session.beginTransaction();

        Product product = session.get(Product.class, id);
        session.delete(product);
        transaction.commit();
    }
}
