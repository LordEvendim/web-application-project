package com.uep.wap.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private int id;
    @Column(name ="content")
    private String content;

    @Column(name ="creator")
    private int creator;

    @Column(name ="createdAt")
    private long createdAt;

    @Column(name ="lastEdited")
    private long lastEdited;

    @Column(name ="category")
    private int category;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "question_tag",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "id"))
    private List<Tag> tags;

    @ManyToOne
    @JoinColumn(name = "asker_id")
    private User asker;

    public Question() {}

    public Question(String content, int creator, long createdAt, long lastEdited, int category, List<Tag> tags) {
        this.content = content;
        this.creator = creator;
        this.createdAt = createdAt;
        this.lastEdited = lastEdited;
        this.category = category;
        this.tags = tags;
    }
}


