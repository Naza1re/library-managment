package com.example.LibraryChest.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LibraryController {
    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("title", "Главная страница");
        return "main";
    }
    @GetMapping("/about")
    public String about(){
        return "about";
    }




}
