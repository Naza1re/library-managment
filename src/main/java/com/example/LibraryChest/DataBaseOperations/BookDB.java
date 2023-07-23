package com.example.LibraryChest.DataBaseOperations;

import com.example.LibraryChest.Model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BookDB {

    public static Session getSession(){
        SessionFactory factory = null;

             factory = new Configuration()
                    .configure("hibernate.config.xml")
                    .addAnnotatedClass(Book.class)
                    .buildSessionFactory();


        Session session = factory.getCurrentSession();
        return session;
    }



}
