package com.uep.wap.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private int id;
    @Column(name ="username")
    private String username;
    @Column(name ="email")
    private String email;

    @Column(name ="role")
    private String role;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private List<Question> questions;

    public void setId(int id){
        this.id = id;
    }
    public long getId(){
        return id;
    }
    public User(){}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public User(String username, String email, String role){
        this.role = role;
        this.username = username;
        this.email = email;
    }
}


