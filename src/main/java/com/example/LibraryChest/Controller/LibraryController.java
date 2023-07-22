package com.example.LibraryChest.Controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class LibraryController {
    public String mainPage(){
        return "index";
    }

}
