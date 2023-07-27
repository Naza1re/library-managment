package com.example.LibraryChest.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    public User(String name) {
        this.name = name;
    }
    public User(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;

}
