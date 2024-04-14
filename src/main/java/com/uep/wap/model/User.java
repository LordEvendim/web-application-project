package com.uep.wap.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "username")
    private String username;
    @Column(name = "email")
    private String email;

    @Column(name = "role")
    private String role;

    @OneToMany(mappedBy = "creator", cascade = CascadeType.ALL)
    private List<Question> questions;

    @OneToMany(mappedBy = "creator", cascade = CascadeType.ALL)
    private List<Question> answers;

    public User() {
    }

    public User(String username, String email, String role) {
        this.role = role;
        this.username = username;
        this.email = email;
    }
}


