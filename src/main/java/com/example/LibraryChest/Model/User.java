package com.example.LibraryChest.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "id")

    private int id;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;
    @Column(name = "date")
    private String data;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User(String name, String email, String data) {
        this.name = name;
        this.email = email;
        this.data = data;
    }

    public String getName() {
        return name;
    }



    public User() {
    }

    public void setName(String name) {
        this.name = name;
    }
}


