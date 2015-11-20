package com.kirill.app.repository;

import com.kirill.app.models.Role;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
public class RoleRepository {

    private final SessionFactory sessionFactory;

    @Autowired
    public RoleRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public void create (Role role){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(role);
        session.getTransaction().commit();
    }

    public void update (Role role){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(role);
        session.getTransaction().commit();
    }

    public void delete (Role role){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(role);
        session.getTransaction().commit();
    }

    public List<Role> getAll(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Role> allRoleList = session.createQuery("from Role ").list();
        session.getTransaction().commit();
        return allRoleList;
    }

    public List<Role> getById(Role role){
        Integer roleId = role.getId();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("FROM Role R WHERE R.id LIKE  :id").setInteger("id", roleId);
        session.getTransaction().commit();
        List result = query.list();
        return result;
    }
}

