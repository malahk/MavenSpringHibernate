package com.kirill.app.dao;

import com.kirill.app.models.Animals;

import java.util.List;

/**
 * Created by Admin
 *
 * @author Admin
 * @since 14.11.2015
 */
public interface AnimalDao {

    boolean create(Animals animal);
    List<Animals> getAll();
    Animals getAnimal (Integer id);
    boolean update(Animals animal);
    boolean delete(Animals animal);
}
