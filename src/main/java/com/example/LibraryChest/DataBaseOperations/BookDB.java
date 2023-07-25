package com.example.LibraryChest.DataBaseOperations;

import com.example.LibraryChest.Model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BookDB {

    public static Session getSession(){
        SessionFactory factory = new Configuration()
                    .configure("hibernate.config.xml")
                    .addAnnotatedClass(Book.class)
                    .buildSessionFactory();


        Session session = factory.getCurrentSession();
        return session;
    }
    public static Book getBookById(Long id){
        Session session = getSession();
        session.beginTransaction();
        Book book = session.get(Book.class,id);
        return book;
    }
    public static boolean getStatusOfBook(){
        return true;
    }



}
