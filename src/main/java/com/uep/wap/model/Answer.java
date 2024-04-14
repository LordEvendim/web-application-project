package com.uep.wap.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "answers")
public class Answer {
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

    @ManyToOne
    @JoinColumn(name = "parent_question_id")
    private Question parentQuestion;

    public Answer() {
    }

    public Answer(String content, User creator, long createdAt, long lastEdited, Question parentQuestion) {
        this.content = content;
        this.creator = creator;
        this.createdAt = createdAt;
        this.lastEdited = lastEdited;
        this.parentQuestion = parentQuestion;
    }
}


