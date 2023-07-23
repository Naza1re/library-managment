package com.example.LibraryChest.Controller;

import com.example.LibraryChest.Model.Book;
import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.LibraryChest.DataBaseOperations.BookDB;

import java.util.List;

@Controller
public class LibraryController {
    @GetMapping("/")
    public String homePage(Model model) {
        return "main";
    }
    @GetMapping("/about")
    public String about(){
        return "about";
    }
    @Transactional
    @GetMapping("/books")
    public String showAllBooks(Model model) {
        Session session = BookDB.getSession();
        session.beginTransaction();
        List<Book> books = session.createQuery("FROM Book", Book.class).list();
        model.addAttribute("books", books);
        session.getTransaction().commit();
        return "books";
    }





}
