package com.uep.wap.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "answers")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "content")
    private String content;

    @Column(name = "upvotes")
    private int upvotes;

    @Column(name = "created_at")
    private long createdAt;

    @Column(name = "last_edited")
    private long lastEdited;

    @JsonIgnoreProperties({"questions", "answers"})
    @ManyToOne
    @JoinColumn(name = "creator_id")
    private User creator;

    @JsonIgnoreProperties("answers")
    @ManyToOne
    @JoinColumn(name = "parent_question_id")
    private Question parentQuestion;

    public Answer() {
    }

    public Answer(String content, User creator, int upvotes, long createdAt, long lastEdited, Question parentQuestion) {
        this.content = content;
        this.creator = creator;
        this.createdAt = createdAt;
        this.lastEdited = lastEdited;
        this.parentQuestion = parentQuestion;
        this.upvotes = upvotes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public long getLastEdited() {
        return lastEdited;
    }

    public void setLastEdited(long lastEdited) {
        this.lastEdited = lastEdited;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public Question getParentQuestion() {
        return parentQuestion;
    }

    public void setParentQuestion(Question parentQuestion) {
        this.parentQuestion = parentQuestion;
    }

    public int getUpvotes() {
        return upvotes;
    }

    public void setUpvotes(int upvotes) {
        this.upvotes = upvotes;
    }
}


