package org.spring;

import org.spring.Models.Roles;
import org.spring.Models.Users;
import org.spring.Repos.BakeRepository;
import org.spring.Repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;

@Controller
public class SingController {
    @Autowired
    private BakeRepository bakeRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String log(){
        return "logAndReg/login";
    }

    @GetMapping("/regis")
    public String reg(){
        System.out.println("GetReg");
        return "logAndReg/regis";
    }
    @PostMapping("regis")
    public String addUser(Users user, Model model){
        System.out.println("PostReg");
        Users userFromDB = userRepository.findByUsername(user.getUsername());
        if(userFromDB != null){
            model.addAttribute("message", "User is found!");
            return "reg";
        }
        System.out.println("TRUE");
        user.setActive(true);
        user.setRoles(Collections.singleton(Roles.USER));
        userRepository.save(user);
        return "redirect:login";
    }
}
