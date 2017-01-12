package com.webapp.rr.controller;

import com.webapp.rr.domain.User;
import com.webapp.rr.domain.UserDetails;
import com.webapp.rr.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Pratyoush on 1/10/2017.
 */
@Controller
public class Login {
    @Autowired
    UserRepository userRepository;
    @RequestMapping(value="/login", method= RequestMethod.GET)
    public String displayLoginPage(){
        return "login";
    }

    @RequestMapping(value="/registration", method=RequestMethod.GET)
    public String registration(Model model){
        model.addAttribute("userDetails", new UserDetails());
        return "registration";
    }
    @RequestMapping(value="/success", method=RequestMethod.POST)
    public String success(@ModelAttribute UserDetails userDetails){
        String userId = userRepository.getUserId();
        User user = new User(userDetails.getFirstName(), userDetails.getLastName(), userDetails.getEmail(),
                "address", "age", userDetails.getGender(), userId, userDetails.getUsername(), userDetails.getPassword());
        userRepository.save(user);
        return "redirect:login";
    }

    @RequestMapping(value="/signout", method=RequestMethod.GET)
    public String signout(){
        return "home";
    }
}
