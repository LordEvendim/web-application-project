package com.uep.wap.dto;

import com.uep.wap.model.Question;

import java.util.List;

public class UserDTO {

    private int id;

    private String username;

    private String email;


    private String role;


    private List<Question> questions;


    private List<Question> answers;

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
