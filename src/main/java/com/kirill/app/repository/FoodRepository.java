package com.kirill.app.repository;

import com.kirill.app.models.Food;
import org.hibernate.Query;
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
 * @since 17.11.2015
 */
@Component
@Repository
public class FoodRepository {

    private final SessionFactory sessionFactory;

    @Autowired
    public FoodRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public void create (Food food){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(food);
        session.getTransaction().commit();
    }

    public void update (Food food){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(food);
        session.getTransaction().commit();
    }

    public void delete (Food food){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(food);
        session.getTransaction().commit();
    }

    public List<Food> getAll(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Food> allFoodList = session.createQuery("from Food ").list();
        session.getTransaction().commit();
        return allFoodList;
    }

    public List<Food> getByName(Food food){
        String itemName = food.getTitle();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("FROM Food F WHERE F.title LIKE  :name").setString("name", itemName);
        session.getTransaction().commit();
        List result = query.list();
        return result;
    }
}
