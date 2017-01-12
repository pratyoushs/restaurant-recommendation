package com.webapp.rr.controller;

import com.webapp.rr.domain.UserDetails;
import com.webapp.rr.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Pratyoush on 1/7/2017.
 */
@Controller
public class UserController {
    @Autowired
    UserRepository userRepository;

    @RequestMapping(value="/users", method= RequestMethod.GET)
    public String getUsers(HttpServletRequest httpServletRequest, Model model){
        model.addAttribute("userDetails", new UserDetails());
        model.addAttribute("userFriendsList", userRepository.getAllFriends(httpServletRequest.getRemoteUser()));
        model.addAttribute("userList", userRepository.getAllOtherUsers(httpServletRequest.getRemoteUser()));
        return "users";
    }

    @RequestMapping(value="/users", method=RequestMethod.POST)
    public String getUsers(@ModelAttribute UserDetails userDetails, HttpServletRequest httpServletRequest, Model model){
        System.out.println(userDetails.getIsFriend() + " e " + userDetails.getEmail() + " f " + userDetails.getFirstName());
        if(userDetails.getIsFriend()){
            userRepository.addFriend(httpServletRequest.getRemoteUser(), userDetails.getEmail());
        }
        else{
            userRepository.deleteFriend(httpServletRequest.getRemoteUser(), userDetails.getEmail());
        }
        model.addAttribute("userDetails", new UserDetails());
        model.addAttribute("userFriendsList", userRepository.getAllFriends(httpServletRequest.getRemoteUser()));
        model.addAttribute("userList", userRepository.getAllOtherUsers(httpServletRequest.getRemoteUser()));
        return "users";
    }
}
