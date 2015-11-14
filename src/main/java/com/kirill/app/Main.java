package com.kirill.app;

import com.kirill.app.models.Animals;
import com.kirill.app.repository.AnimalRepository;
import com.kirill.app.repository.StorageRepositories;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin
 *
 * @author Admin
 * @since 10.11.2015
 */
public class Main {
    public static void main (String[] args){

        StorageRepositories sr = new StorageRepositories();
        System.out.println("session created");
        String type = "Cat";
        String name = "Barsik";
        Integer price = 200;
        Animals animal = new Animals();
        animal.setType(type);
        animal.setName(name);
        animal.setPrice(price);
        AnimalRepository animalRepository = sr.getAnimalRepository();
        System.out.println("repo get");
        animalRepository.create(animal);
        System.out.println("animal created");
        List<Animals> animalsList = new ArrayList<Animals>(animalRepository.getAll());
        System.out.println(animalsList);





    }
}
