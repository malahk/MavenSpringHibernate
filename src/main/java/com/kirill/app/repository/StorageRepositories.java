package com.kirill.app.repository;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by Admin
 *
 * @author Admin
 * @since 10.11.2015
 */
@Component
public class StorageRepositories {

    private AnimalRepository animalRepository;

    @Autowired
    public StorageRepositories(SessionFactory sessionFactory) {
        this.animalRepository = new AnimalRepository(sessionFactory);

    }

    public AnimalRepository getAnimalRepository() {
        return animalRepository;
    }

}
