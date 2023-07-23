package com.example.LibraryChest.DataBaseOperations;

import com.example.LibraryChest.Model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BookDB {

    public static Session getSession(){
        SessionFactory factory = null;
        try {
             factory = new Configuration()
                    .configure("hibernate.config.xml")
                    .addAnnotatedClass(Book.class)
                    .buildSessionFactory();
        }
        finally
        {
            factory.close();
        }
        Session session = factory.getCurrentSession();
        return session;
    }

    public static Book returnBookById(int id){
        Session session = getSession();
        session.beginTransaction();
        session.getTransaction().commit();
        Book book = new Book("","","",0);
        return book;

    }
    public static void addBook(String name,String author){
        Session session = getSession();
        session.beginTransaction();
        Book book = new Book(name,author," ",0);
        session.save(book);
        session.getTransaction().commit();
    }

}
