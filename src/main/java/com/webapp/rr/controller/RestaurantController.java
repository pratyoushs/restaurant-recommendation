package com.webapp.rr.controller;

import com.webapp.rr.domain.Restaurant;
import com.webapp.rr.domain.RestaurantDetails;
import com.webapp.rr.repo.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Pratyoush on 12/30/2016.
 */
@Controller
public class RestaurantController {
    @Autowired
    RestaurantRepository restaurantRepository;

    @RequestMapping(value = "/restaurants", method = RequestMethod.GET)
    public String restaurant(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model){
        //return restaurantRepository.getRestaurantDetails();
        model.addAttribute("list", restaurantRepository.getRestaurantDetails());
        return "restaurants";
    }

    @RequestMapping(value = "/restaurant/{id}", method = RequestMethod.GET)
    public String restaurant(Model model, @PathVariable String id){
        String ratingval = null;
        model.addAttribute("list", restaurantRepository.getRestaurantInfo(id));
        model.addAttribute("ratingval", ratingval);
        return "restaurant";
    }

    @RequestMapping(value = "/friendrecommendations/{id}", method = RequestMethod.GET)
    public String friendrecommendations(Model model, @PathVariable String id){
        model.addAttribute("list", restaurantRepository.getFriendRecommendedRestaurants(id));
        return "friendrecommendations";
    }

    @RequestMapping(value = "/recommendations/{id}", method = RequestMethod.GET)
    public String recommendations(Model model, @PathVariable String id){
        model.addAttribute("list", restaurantRepository.getRestaurantRecommendations(id));
        return "recommendations";
    }

    @RequestMapping(value = "/restaurant/giverating/{id}", method = RequestMethod.POST)
    public String dummy(@RequestParam("ratingval") String ratingval, @PathVariable String id, Model model){
        model.addAttribute("ratingval", ratingval);
        System.out.println("ratingval " + ratingval);
        restaurantRepository.giveRating("2", id, ratingval);
        return "dummy";
    }
}
