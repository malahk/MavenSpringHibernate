package com.kirill.app;

import com.kirill.app.models.*;
import com.kirill.app.repository.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.print.DocFlavor;
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

        ApplicationContext context =
                new ClassPathXmlApplicationContext("dataBaseConfig.xml");

        StorageRepositories sr = (StorageRepositories) context.getBean("storageRepositories");

        FoodRepository foodRepository = sr.getFoodRepository();
        AnimalRepository animalRepository = sr.getAnimalRepository();
        AccessoriesRepository accessoriesRepository = sr.getAccessoriesRepository();
        AddressRepository addressRepository = sr.getAddressRepository();
        UserRepository userRepository = sr.getUserRepository();
        RoleRepository roleRepository = sr.getRoleRepository();

        /*
        System.out.println("Animal session is created");
        String type = "Cat";
        String name = "Barsik";
        Integer price = 200;
        Animals animal = new Animals();
        animal.setType(type);
        animal.setName(name);
        animal.setPrice(price);
        System.out.println("repo get");
        animalRepository.create(animal);
        System.out.println("animal created");
        List<Animals> animalsList = new ArrayList<Animals>(animalRepository.getAll());
        System.out.println(animalsList);
        System.out.println("all animals displayed");
        System.out.println(animalRepository.getByName(animal).toString());
        System.out.println("getByName animal displayed");

        System.out.println("Food session is created");
        String title = "meat";
        Integer weight = 400;
        Food food = new Food();
        food.setTitle(title);
        food.setWeight(weight);
        food.setPrice(price);
        System.out.println("repo get");
        foodRepository.create(food);
        System.out.println("food created");
        List<Food> foodList = new ArrayList<Food>(foodRepository.getAll());
        System.out.println(foodList);
        System.out.println("all food displayed");
        System.out.println(foodRepository.getByName(food).toString());
        System.out.println("getByName food displayed");
        */

        /*
        System.out.println("Accessories session is created");
        String title = "collar";
        Integer price = 400;
        Accessories accessories = new Accessories();
        accessories.setPrice(price);
        accessories.setTitle(title);
        System.out.println("repo get");
        accessoriesRepository.create(accessories);
        System.out.println("accessorie created");
        List<Accessories> allAccsList = new ArrayList<Accessories>(accessoriesRepository.getAll());
        System.out.println(allAccsList);
        System.out.println("all accs displayed");
        */

        System.out.println("User session is created");
        String firstName = "kirill";
        String lastName = "malah";
        String login = "test5";
        String password = "test2";
        String country = "Ukraine!!!";
        String street = "Elm str666";
        Integer zipCode = 61072;
        String roleName = "ROLE_ADMIN4";
        Integer id = 1;
        User user = new User();
        Address address = new Address();
        address.setCountry(country);
        address.setStreet(street);
        address.setZipCode(zipCode);
        Role role = new Role();
        role.setRoleName(roleName);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setLogin(login);
        user.setPassword(password);
        user.setAddress(address);
        user.setRole(role);
        System.out.println("repo get");
        roleRepository.create(role);
        addressRepository.create(address);
        userRepository.create(user);
        System.out.println("user created");
        List<User> allUsersList = new ArrayList<User>(userRepository.getAll());
        System.out.println(allUsersList);
        System.out.println("all users displayed");
        List<User> userGetByLogin = new ArrayList<User>(userRepository.getByLogin(user));
        System.out.println("user getted by login");
/*        List<User> userGetById = new ArrayList<User>(userRepository.getById(user));
        System.out.println(userGetById);
        System.out.println("getById displayed");*/






    }
}
