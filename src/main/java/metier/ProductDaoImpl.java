package metier;

import dao.IDao;
import entities.Product;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional // <= transactions pour toutes les méthodes
public class ProductDaoImpl implements IDao<Product> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean create(Product product) {
        sessionFactory.getCurrentSession().save(product);
        return true;
    }

    @Override
    public boolean delete(Product product) {
        sessionFactory.getCurrentSession().delete(product);
        return true;
    }

    @Override
    public boolean update(Product product) {
        sessionFactory.getCurrentSession().update(product);
        return true;
    }

    @Override
    @Transactional(readOnly = true)
    public Product findById(int id) {
        return sessionFactory.getCurrentSession().get(Product.class, id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return sessionFactory.getCurrentSession()
                .createQuery("from Product", Product.class)
                .list();
    }
}
