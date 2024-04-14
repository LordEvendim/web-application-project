package com.uep.wap.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Question> questions;

    public Category() {
    }

    public Category(String name, List<Question> questions) {
        this.name = name;
        this.questions = questions;
    }
}