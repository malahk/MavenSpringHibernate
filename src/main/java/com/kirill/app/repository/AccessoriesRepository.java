package com.kirill.app.repository;

import com.kirill.app.models.Accessories;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Admin
 *
 * @author Admin
 * @since 17.11.2015
 */
@Repository
public class AccessoriesRepository {
    private SessionFactory sessionFactory;

    @Autowired
    public AccessoriesRepository(LocalSessionFactoryBean sessionFactory) {
        this.sessionFactory = sessionFactory.getObject();
    }

    @Transactional
    public void create (Accessories accessorie){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(accessorie);
        session.getTransaction().commit();
    }

    public void update (Accessories accessorie){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(accessorie);
        session.getTransaction().commit();
    }

    public void delete (Accessories accessorie){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(accessorie);
        session.getTransaction().commit();
    }

    public List<Accessories> getAll(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Accessories> allAccessoriesList = session.createQuery("from Accessories ").list();
        session.getTransaction().commit();
        return allAccessoriesList;
    }
}
