package com.example.LibraryChest.DataBaseOperations;

import com.example.LibraryChest.Model.Book;
import com.example.LibraryChest.Model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class UserDB {

    public static Session getSession(){
        SessionFactory factory = new Configuration()
                .configure("hibernate.config.xml")
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Book.class) // Add the Book class here
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
    public static User getUserByName(String ownerName) {
        Session session = getSession();
        try {
            session.beginTransaction();

            // Используем HQL для получения пользователя по имени владельца
            Query<User> query = session.createQuery("from User where name = :name", User.class);
            query.setParameter("name", ownerName);
            User user = query.uniqueResult();

            session.getTransaction().commit();
            return user;
        } catch (Exception e) {
            // Обработка ошибок, если необходимо
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
        }
    }

}
