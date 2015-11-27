package com.kirill.app.repository;

import com.kirill.app.models.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Kirill Malah
 *
 * @author Kirill Malah
 * @since 19-Nov-15
 */
@Repository
public class UserRepository {

    private SessionFactory sessionFactory;

    @Autowired
    public UserRepository(LocalSessionFactoryBean sessionFactory) {
        this.sessionFactory = sessionFactory.getObject();
    }

    @Transactional
    public void create (User user){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
    }

    public void update (User user){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
    }

    public void delete (User user){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(user);
        session.getTransaction().commit();
    }

    public List<User> getAll(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<User> allUsersList = session.createQuery("from User ").list();
        session.getTransaction().commit();
        return allUsersList;
    }

    public List<User> getById(User user){
        Integer userId = user.getId();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("FROM User U WHERE U.id LIKE  :id").setInteger("id", userId);
        session.getTransaction().commit();
        List result = query.list();
        return result;
    }

    public List<User> getByLogin(User user){
        String userLogin = user.getLogin();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("FROM User U WHERE U.login LIKE  :login").setString("login", userLogin);
        session.getTransaction().commit();
        List result = query.list();
        return result;
    }
}
