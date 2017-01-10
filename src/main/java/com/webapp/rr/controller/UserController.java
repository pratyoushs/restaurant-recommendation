package com.webapp.rr.controller;

import com.webapp.rr.domain.UserDetails;
import com.webapp.rr.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Pratyoush on 1/7/2017.
 */
@Controller
public class UserController {
    @Autowired
    UserRepository userRepository;

    @RequestMapping(value="/users/{id}", method= RequestMethod.GET)
    public String getUsers(@PathVariable String id, Model model){
        model.addAttribute("userDetails", new UserDetails());
        model.addAttribute("userFriendsList", userRepository.getAllFriends(id));
        model.addAttribute("userList", userRepository.getAllOtherUsers(id));
        return "users";
    }

    @RequestMapping(value="/users/{id}", method=RequestMethod.POST)
    public String getUsers(@ModelAttribute UserDetails userDetails, @PathVariable String id, Model model){
        System.out.println(userDetails.getIsFriend() + " e " + userDetails.getEmail() + " f " + userDetails.getFirstName());
        if(userDetails.getIsFriend()){
            userRepository.addFriend("2", userDetails.getEmail());
        }
        else{
            userRepository.deleteFriend("2", userDetails.getEmail());
        }
        model.addAttribute("userDetails", new UserDetails());
        model.addAttribute("userFriendsList", userRepository.getAllFriends(id));
        model.addAttribute("userList", userRepository.getAllOtherUsers(id));
        return "users";
    }
}
