package com.uep.wap.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "content")
    private String content;

    @Column(name = "created_at")
    private long createdAt;

    @Column(name = "last_edited")
    private long lastEdited;

    @ManyToOne
    @JoinColumn(name = "creator_id")
    private User creator;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "question_tags",
            joinColumns = @JoinColumn(name = "question_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<Tag> tags;

    public Question() {
    }

    public Question(String content, User creator, long createdAt, long lastEdited, Category category, List<Tag> tags) {
        this.content = content;
        this.creator = creator;
        this.createdAt = createdAt;
        this.lastEdited = lastEdited;
        this.category = category;
        this.tags = tags;
    }
}


