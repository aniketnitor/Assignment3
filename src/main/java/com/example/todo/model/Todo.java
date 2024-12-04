package com.example.todo.model;

import java.util.UUID;

public class Todo {
    private UUID id;
    private String title;
    private String description;
    private String user;
    private boolean completed;

    public Todo() {
        this.id = UUID.randomUUID();
    }

    public Todo(String title, String description, String user) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.description = description;
        this.user = user;
        this.completed = false;
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getUser() { return user; }
    public void setUser(String user) { this.user = user; }
    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }
}