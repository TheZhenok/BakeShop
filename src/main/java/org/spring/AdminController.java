package org.spring;

import org.spring.Models.Bakes;
import org.spring.Repos.BakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {
    @Autowired
    private BakeRepository bakeRepository;

    @GetMapping("/admin")
    public String mein(Model model){
        System.out.println("Hello");
        Iterable<Bakes> all = bakeRepository.findAll();
        model.addAttribute("all", all);
        return "adminPages/CRUDListAndInfo";
    }

    @PostMapping("/admin")
    public String enterNameBake(@RequestParam("name") String name, @RequestParam("price") int price, Model model){
        System.out.println("POST");
        Bakes bakes = new Bakes(name, price);
        bakeRepository.save(bakes);
        Iterable<Bakes> all = bakeRepository.findAll();
        model.addAttribute("all", all);
        return "adminPages/CRUDListAndInfo";
    }
}
