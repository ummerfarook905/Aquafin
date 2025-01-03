package com.example.aquafin.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.aquafin.Dto.UserDto;
import com.example.aquafin.services.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/register")
    public String getRegistrationPage(@ModelAttribute("user") UserDto userDto){
        return "register";
    }

    @PostMapping("/register")
    public String getRegistrationPage(
         @ModelAttribute("user") UserDto userDto,
        Model model){
            if(userService.hasErrors()){
                model.addAttribute("error", "Please check your input");
                return "register";
            }
            try{
                userService.save(userDto);
                model.addAttribute("success", "Registration successful! Please login.");
                return "login";
            }
            catch(Exception e){
                model.addAttribute("error", "Registration failed: " + e.getMessage());
                return "register";

            }

        }

    // @PostMapping("/register")
    // public String getRegistartionPage(@ModelAttribute("user")UserDto userDto,Model model){
    //     userService.save(userDto);
    //     model.addAttribute("message","Registered successfully");
    //     return "register";
    // }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "error/access-denied";
    }



}
