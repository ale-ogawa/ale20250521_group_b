// src/main/java/com/example/webapp/dto/Choice.java
package com.example.demo.entity;

public class Choice {
    private Long id;
    private String text;

    public Choice(Long id, String text) {
        this.id = id;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }
}