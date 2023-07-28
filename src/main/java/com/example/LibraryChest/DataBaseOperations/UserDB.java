package com.example.LibraryChest.DataBaseOperations;

import com.example.LibraryChest.Model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UserDB {

    public static Session getSession(){
        SessionFactory factory = new Configuration()
                .configure("hibernate.config.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory();


        Session session = factory.getCurrentSession();
        return session;
    }
    public static User getUserById(Long id) {
        Session session = getSession();
        User user = session.get(User.class, id);
        session.close();
        return user;
    }
}
