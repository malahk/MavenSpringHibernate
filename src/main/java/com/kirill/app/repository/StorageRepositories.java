package com.kirill.app.repository;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Admin
 *
 * @author Admin
 * @since 10.11.2015
 */
public class StorageRepositories {

    private AnimalRepository animalRepository;

    @Autowired
    public StorageRepositories() {

       SessionFactory sessionFactory;

        try {
//             Create the SessionFactory from hibernate.cfg.xml
            sessionFactory = new Configuration().configure().buildSessionFactory();

        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }

        this.animalRepository = new AnimalRepository(sessionFactory);

    }

    public AnimalRepository getAnimalRepository() {
        return animalRepository;
    }

}
