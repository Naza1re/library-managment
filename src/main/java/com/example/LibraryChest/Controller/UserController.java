package com.example.LibraryChest.Controller;

import com.example.LibraryChest.DataBaseOperations.BookDB;
import com.example.LibraryChest.DataBaseOperations.UserDB;
import com.example.LibraryChest.Model.Book;
import com.example.LibraryChest.Model.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/users")
    public String showUsers( Model model){
        Session session = UserDB.getSession();
        session.beginTransaction();
        List<User> users = session.createQuery("FROM User", User.class).list();
        model.addAttribute("users", users);
        session.getTransaction().commit();
        return "users";

    }
    @GetMapping("/user/details/{id}")
    public String showUserDetails(@PathVariable Long id, Model model) {
        Session session = UserDB.getSession();
        session.beginTransaction();

        User user = session.get(User.class, id);
        model.addAttribute("user", user);

        Query<Book> query = session.createQuery("FROM Book WHERE user = :user", Book.class);
        query.setParameter("user", user);
        List<Book> books = query.list();
        model.addAttribute("books", books);

        session.getTransaction().commit();
        return "user-details";
    }
}
