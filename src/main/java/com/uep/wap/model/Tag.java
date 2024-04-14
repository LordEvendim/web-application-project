package com.uep.wap.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tags")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "tags")
    private List<Question> questions;

    public Tag() {
    }

    public Tag(String name, List<Question> questions) {
        this.name = name;
        this.questions = questions;
    }
}


