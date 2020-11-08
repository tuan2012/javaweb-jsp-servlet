package com.cxtuan.Model;

public class Comment extends Parent{
    private String content;
    private int userId;
    private int newId;

    public Comment(String content, int userId, int newId) {
        this.content = content;
        this.userId = userId;
        this.newId = newId;
    }

    public Comment() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getNewId() {
        return newId;
    }

    public void setNewId(int newId) {
        this.newId = newId;
    }
}
