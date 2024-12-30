package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import Dto.UserDto;
import services.UserService;

@Controller
public class UserController {
    // @Autowired
    // UserDetailsService userDetailsService;

    @Autowired
    private UserService userService;

    // @Autowired
    // private UserRepository userRepository;

    @GetMapping("/index")
    public String index(){
		return "index";
	}

    @GetMapping("/register")
    public String getRegistrationPage(@ModelAttribute("user")UserDto userDto){
        return "register";
    }

    @PostMapping("/register")
    public String saveUser(@ModelAttribute("user") UserDto userDto, Model model) {
        userService.save(userDto);
        model.addAttribute("message", "Registered successfully");
		return "register";
	}

    @GetMapping("/login")
    public String login(){
        return "login";
    }





}
