package com.uep.wap.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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

    @JsonIgnoreProperties("creator")
    @OneToMany(mappedBy = "creator", cascade = CascadeType.ALL)
    private List<Question> questions;

    @JsonIgnoreProperties("creator")
    @OneToMany(mappedBy = "creator", cascade = CascadeType.ALL)
    private List<Question> answers;

    public User() {
    }

    public User(int id) {
        this.id = id;
    }

    public User(String username, String email, String role) {
        this.role = role;
        this.username = username;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public List<Question> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Question> answers) {
        this.answers = answers;
    }
}