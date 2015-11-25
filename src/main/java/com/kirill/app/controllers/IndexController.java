package com.kirill.app.controllers;

import com.kirill.app.models.Accessories;
import com.kirill.app.models.Animals;
import com.kirill.app.models.Food;
import com.kirill.app.repository.AccessoriesRepository;
import com.kirill.app.repository.AnimalRepository;
import com.kirill.app.repository.FoodRepository;
//import com.kirill.app.repository.StorageRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Admin
 *
 * @author Admin
 * @since 10.11.2015
 */
@Controller
public class IndexController {

/*
    //don't foget about import
    @Autowired
    private StorageRepositories sr;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView allProductsList() {
        List<Animals> animalsList = sr.getAnimalRepository().getAll();
        List<Food> foodList = sr.getFoodRepository().getAll();
        List<Accessories> accsList = sr.getAccessoriesRepository().getAll();
        ModelAndView mav = new ModelAndView("index");
        mav.addObject(animalsList);
        mav.addObject(accsList);
        mav.addObject(foodList);

        return mav;
    }*/

    @Autowired
    private AnimalRepository animalRepository;
    @Autowired
    private AccessoriesRepository accessoriesRepository;
    @Autowired
    private FoodRepository foodRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView allProductsList() {
        List<Animals> animalsList = animalRepository.getAll();
        List<Food> foodList = foodRepository.getAll();
        List<Accessories> accsList = accessoriesRepository.getAll();
        ModelAndView mav = new ModelAndView("index");
        mav.addObject(animalsList);
        mav.addObject(accsList);
        mav.addObject(foodList);

        return mav;
    }
}
