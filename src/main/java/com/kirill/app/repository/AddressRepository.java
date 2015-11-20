package com.kirill.app.repository;

import com.kirill.app.models.Address;
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
public class AddressRepository {

    private final SessionFactory sessionFactory;

    @Autowired
    public AddressRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public void create (Address address){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(address);
        session.getTransaction().commit();
    }

    public void update (Address address){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(address);
        session.getTransaction().commit();
    }

    public void delete (Address address){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(address);
        session.getTransaction().commit();
    }

    public List<Address> getAll(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Address> addressList = session.createQuery("from Address ").list();
        session.getTransaction().commit();
        return addressList;
    }

    public List<Address> getById(Address address){
        Integer addressId = address.getId();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("FROM Address A WHERE A.id LIKE  :id").setInteger("id", addressId);
        session.getTransaction().commit();
        List result = query.list();
        return result;
    }
}
