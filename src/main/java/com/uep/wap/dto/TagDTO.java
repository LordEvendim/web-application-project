package com.uep.wap.dto;

import com.uep.wap.model.Question;

import java.util.List;

public class TagDTO {

    private String name;


    private List<Question> questions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
