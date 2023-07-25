package com.example.LibraryChest.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    public User(String name, String dataOfRegistration) {
        this.name = name;
        this.dataOfRegistration = dataOfRegistration;
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

    public String getDataOfRegistration() {
        return dataOfRegistration;
    }

    public void setDataOfRegistration(String dataOfRegistration) {
        this.dataOfRegistration = dataOfRegistration;
    }

    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "dataofregistration")
    private String dataOfRegistration;
}
