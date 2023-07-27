package com.example.LibraryChest.Controller;

import com.example.LibraryChest.DataBaseOperations.BookDB;
import com.example.LibraryChest.Model.User;
import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @GetMapping("/add-user")
    public String showAddUserPage(Model model) {
        model.addAttribute("user", new User());
        return "add-user";
    }
    @PostMapping("/add-user")
    public String addUser(@ModelAttribute User user){
        Session session = BookDB.getSession();
        session.beginTransaction();
        session.saveOrUpdate(user);
        session.getTransaction().commit();
        return "redirect:/book/add";
    }






}
