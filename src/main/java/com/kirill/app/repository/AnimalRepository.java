package com.kirill.app.repository;

import com.kirill.app.models.Animals;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Admin
 *
 * @author Admin
 * @since 10.11.2015
 */
public class AnimalRepository {

    @Autowired
    private final SessionFactory sessionFactory;

    public AnimalRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void create (Animals animal){
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(animal);
        session.getTransaction().commit();
    }

    public void update (Animals animal){
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.update(animal);
        session.getTransaction().commit();
    }

    public void delete (Animals animal){
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.delete(animal);
        session.getTransaction().commit();
    }

    public List<Animals> getAll(){
        Session session = sessionFactory.getCurrentSession();
        session.getTransaction();
        List<Animals> allAnimalsList = session.createQuery("from Animals ").list();
        session.getTransaction().commit();
        return allAnimalsList;
    }
}
