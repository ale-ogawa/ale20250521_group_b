package com.example.demo.entity;

public enum Category {
    JAVA("Java"),
    JAVASCRIPT("JavaScript"),
    DB("DB"),
    SPRING("Spring");

    private final String displayName;


    Category(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
    
}