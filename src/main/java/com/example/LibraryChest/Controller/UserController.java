package com.example.LibraryChest.Controller;

import com.example.LibraryChest.DataBaseOperations.BookDB;
import com.example.LibraryChest.DataBaseOperations.UserDB;
import com.example.LibraryChest.Model.User;
import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @GetMapping ("/user/add")
    public String showAddUserForm(Model model) {
        model.addAttribute("user", new User());
        return "user-add";
    }

    @PostMapping("/user/add")
    public String addUser(@ModelAttribute User user) {
        Session session = UserDB.getSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        return "redirect:/user/add";
    }

    @GetMapping("/user/details/{id}")
    public String showUserDetails(@PathVariable Long id, Model model) {
        User user = UserDB.getUserById(id);
        model.addAttribute("user", user);
        return "user-details";
    }

    // Add other methods as needed for user-related operations
}
