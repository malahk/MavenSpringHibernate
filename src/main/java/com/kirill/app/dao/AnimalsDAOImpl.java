package com.kirill.app.dao;

import com.kirill.app.connector.Connector;
import com.kirill.app.models.Animals;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin
 *
 * @author Admin
 * @since 14.11.2015
 */
public class AnimalsDAOImpl implements AnimalDao{

    public static final String CREATE_ANIMAL = "insert animals set id = ?, type = ?, name = ?, price = ?";
    public static final String GET_ALL = "select * from animals";
    public static final String GET_BY_ID = "select * from animals where id = ?";
    public static final String UPDATE_ANIMAL = "update animals set type = ?, name = ?, price = ?";
    public static final String DELETE_ANIMAL = "delete from animals where id = ?";

    private static Connection connection;

    public AnimalsDAOImpl () {
        connection = Connector.getConn();
    }

    @Override
    public boolean create(Animals animal) {

        boolean result = false;

        try {
            PreparedStatement createAnimal = connection.prepareStatement(CREATE_ANIMAL, Statement.RETURN_GENERATED_KEYS);
            createAnimal.setInt(1, animal.getId());
            createAnimal.setString(2, animal.getType());
            createAnimal.setString(3, animal.getName());
            createAnimal.setInt(4, animal.getPrice());
            result = createAnimal.execute();

            ResultSet createdAnimalsRS = createAnimal.getGeneratedKeys();
            while (createdAnimalsRS.next()){
                animal.setId(createdAnimalsRS.getInt(1));
            }
            createAnimal.close();

        } catch (SQLException e){
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public List<Animals> getAll() {

        ArrayList<Animals> animalsList = new ArrayList<Animals>();
        try
        {
            Statement getAll  = connection.createStatement();
            ResultSet allAnimalsRS = getAll.executeQuery(GET_ALL);
            Animals animal;

            while (allAnimalsRS.next())
            {
                animal = new Animals();

                Integer id = allAnimalsRS.getInt(1);
                String type = allAnimalsRS.getString(2);
                String name = allAnimalsRS.getString(3);
                Integer price = allAnimalsRS.getInt(4);

                animal.setId(id);
                animal.setName(name);
                animal.setPrice(price);

                animal.setType(type);

                animalsList.add(animal);
            }
            getAll.close();

        } catch (SQLException e){
            e.printStackTrace();
        }

        return animalsList;
    }

    @Override
    public Animals getAnimal(Integer id) {
        Animals animal = new Animals();
        try {
            PreparedStatement getById = connection.prepareStatement(GET_BY_ID);
            getById.setInt(1, id);
            ResultSet getAnimalRS = getById.executeQuery();

            while (getAnimalRS.next())
            {
                String type = getAnimalRS.getString(2);
                String name = getAnimalRS.getString(3);
                Integer price = getAnimalRS.getInt(4);

                animal.setId(id);
                animal.setType(type);
                animal.setName(name);
                animal.setPrice(price);
            }
            getById.close();

        } catch (SQLException e){
            e.printStackTrace();
        }

        return animal;
    }

    @Override
    public boolean update(Animals animal) {
        boolean result = false;

        try {
            PreparedStatement updateAnimal = connection.prepareStatement(UPDATE_ANIMAL);
            updateAnimal.setString(1, animal.getType());
            updateAnimal.setString(2, animal.getName());
            updateAnimal.setInt(3, animal.getPrice());

            result = updateAnimal.execute();
            updateAnimal.close();
        } catch (SQLException e){
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public boolean delete(Animals animal) {
        boolean result = false;

        try {
            PreparedStatement deleteAnimal = connection.prepareStatement(DELETE_ANIMAL);
            deleteAnimal.setInt(1, animal.getId());

            result = deleteAnimal.execute();
            deleteAnimal.close();
        } catch (SQLException e){
            e.printStackTrace();
        }

        return result;
    }
}
