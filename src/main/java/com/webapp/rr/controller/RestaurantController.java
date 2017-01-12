package com.webapp.rr.controller;

import com.webapp.rr.domain.*;
import com.webapp.rr.repo.RestaurantRepository;
import com.webapp.rr.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
        model.addAttribute("restaurantSearch", new RestaurantSearch());
        model.addAttribute("list", restaurantRepository.getRestaurantDetails());
        return "restaurants";
    }

    @RequestMapping(value = {"/restaurants"}, method = RequestMethod.POST)
    public String restaurant(@ModelAttribute RestaurantSearch restaurantSearch, Model model){
        String restaurantName = (".*")+(restaurantSearch.getRestaurantName() == null ? "" : restaurantSearch.getRestaurantName()+(".*"));
        String cuisine = (".*")+(restaurantSearch.getCuisineType() == null ? "" : restaurantSearch.getCuisineType()+(".*"));
        String state = (".*")+(restaurantSearch.getState() == null ? "" : restaurantSearch.getState()+(".*"));
        String rating = (".*") + (restaurantSearch.getRating() == null? "" : restaurantSearch.getRating());
        model.addAttribute("list", restaurantRepository.getRestaurantDetails(
                restaurantName, cuisine, state, rating));
        return "restaurants";
    }
    @RequestMapping(value = "/restaurant/{rid}", method = RequestMethod.GET)
    public String restaurant(Model model, @PathVariable String rid){
        String ratingval = null;
        model.addAttribute("list", restaurantRepository.getRestaurantInfo(rid));
        model.addAttribute("ratingval", ratingval);
        return "restaurant";
    }

    @RequestMapping(value = "/friendrecommendations", method = RequestMethod.GET)
    public String friendrecommendations(Model model, HttpServletRequest httpServletRequest){
        model.addAttribute("restaurantSearch", new RestaurantSearch());
        model.addAttribute("list", restaurantRepository.getFriendRecommendedRestaurants(httpServletRequest.getRemoteUser()));
        return "friendrecommendations";
    }

    @RequestMapping(value = "/friendrecommendations", method = RequestMethod.POST)
    public String friendrecommendations(@ModelAttribute RestaurantSearch restaurantSearch, Model model,HttpServletRequest httpServletRequest){
        String restaurantName = (".*")+(restaurantSearch.getRestaurantName() == null ? "" : restaurantSearch.getRestaurantName()+(".*"));
        String cuisine = (".*")+(restaurantSearch.getCuisineType() == null ? "" : restaurantSearch.getCuisineType()+(".*"));
        String state = (".*")+(restaurantSearch.getState() == null ? "" : restaurantSearch.getState()+(".*"));
        String rating = (".*") + (restaurantSearch.getRating() == null? "" : restaurantSearch.getRating());
        model.addAttribute("list", restaurantRepository.getFriendRecommendedRestaurants(httpServletRequest.getRemoteUser(), restaurantName, cuisine, state, rating));
        return "friendrecommendations";
    }

    @RequestMapping(value = "/recommendations", method = RequestMethod.GET)
    public String recommendations(Model model, HttpServletRequest httpServletRequest){
        model.addAttribute("restaurantSearch", new RestaurantSearch());
        model.addAttribute("list", restaurantRepository.getRestaurantRecommendations(httpServletRequest.getRemoteUser()));
        return "recommendations";
    }

    @RequestMapping(value = "/recommendations", method = RequestMethod.POST)
    public String recommendations(@ModelAttribute RestaurantSearch restaurantSearch, Model model, HttpServletRequest httpServletRequest){
        String restaurantName = (".*")+(restaurantSearch.getRestaurantName() == null ? "" : restaurantSearch.getRestaurantName()+(".*"));
        String cuisine = (".*")+(restaurantSearch.getCuisineType() == null ? "" : restaurantSearch.getCuisineType()+(".*"));
        String state = (".*")+(restaurantSearch.getState() == null ? "" : restaurantSearch.getState()+(".*"));
        String rating = (".*") + (restaurantSearch.getRating() == null? "" : restaurantSearch.getRating());
        model.addAttribute("list", restaurantRepository.getRestaurantRecommendations(
                httpServletRequest.getRemoteUser(), restaurantName, cuisine, state, rating));
        return "recommendations";
    }


    @RequestMapping(value = "/restaurant/giverating/{id}", method = RequestMethod.POST)
    public String dummy(@RequestParam("ratingval") String ratingval, @PathVariable String id, Model model, HttpServletRequest httpServletRequest){
        model.addAttribute("ratingval", ratingval);
        System.out.println("ratingval " + ratingval);
        restaurantRepository.giveRating(httpServletRequest.getRemoteUser(), id, ratingval);
        return "dummy";
    }
}
