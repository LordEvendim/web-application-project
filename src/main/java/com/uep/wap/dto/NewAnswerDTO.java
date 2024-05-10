package com.uep.wap.dto;

public class NewAnswerDTO {

    private String content;

    private int creatorId;

    private int parentQuestionId;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public int getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(int creatorId) {
        this.creatorId = creatorId;
    }

    public int getParentQuestionId() {
        return parentQuestionId;
    }

    public void setParentQuestion(int parentQuestionId) {
        this.parentQuestionId = parentQuestionId;
    }
}
