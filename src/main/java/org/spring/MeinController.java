package org.spring;


import org.spring.Models.Bakes;
import org.spring.Models.Users;
import org.spring.Repos.BakeRepository;
import org.spring.Repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MeinController {
    @Autowired
    private BakeRepository bakeRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("")
    public String mein(@RequestParam(name="name", required=false, defaultValue="user") String name,Model model){
        System.out.println(name);
        model.addAttribute("name", name);
        return "meinAndInfo/mainPage";
    }

    @GetMapping("/infoCompany")
    public String info(Model model){
        return "meinAndInfo/infoCompany";
    }

}
