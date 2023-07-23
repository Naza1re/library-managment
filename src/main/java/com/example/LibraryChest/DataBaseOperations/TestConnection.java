package com.example.LibraryChest.DataBaseOperations;


import com.example.LibraryChest.Model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestConnection {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.config.xml")
                .addAnnotatedClass(Book.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            Book book = new Book("Философия JAVA", "Брюс Эккель", "Никита Михалков", 22);
            session.beginTransaction();


            Book book1 = session.get(Book.class,2);
            session.getTransaction().commit();
            System.out.println(book1);

        }
        finally {
            factory.close();

        }
    }







}
