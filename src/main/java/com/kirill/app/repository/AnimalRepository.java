package com.kirill.app.repository;

import com.kirill.app.models.Animals;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Admin
 *
 * @author Admin
 * @since 10.11.2015
 */
//@Component
@Repository
public class AnimalRepository {
/*
    private final SessionFactory sessionFactory;

    @Autowired
    public AnimalRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }*/
    //for Java config build
    @Autowired
    private SessionFactory sessionFactory;

    public AnimalRepository() {
    }

    public AnimalRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public void create (Animals animal){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(animal);
        session.getTransaction().commit();
    }

    public void update (Animals animal){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(animal);
        session.getTransaction().commit();
    }

    public void delete (Animals animal){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(animal);
        session.getTransaction().commit();
    }

    public List<Animals> getAll(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Animals> allAnimalsList = session.createQuery("from Animals ").list();
        session.getTransaction().commit();
        return allAnimalsList;
    }
}
