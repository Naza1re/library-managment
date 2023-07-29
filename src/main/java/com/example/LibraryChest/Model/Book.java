package com.example.LibraryChest.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "author")
    private String author;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Column(name = "population")
    private int population;

    public Book(String name, String author, User user, int population) {
        this.name = name;
        this.author = author;
        this.user = user;
        this.population = population;
    }

    public Book(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getPopulation() {
        return population;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", user='" + user + '\'' +
                ", population=" + population +
                '}';
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
