package com.example.demo.entity;

public class TestSession {
    private String sessionId;
    private Category category;
    private int currentNo;
    private int totalNo;
    private QuestionForm currentQuestion;
    
    public TestSession(String sessionId, Category category, int totalNo) {
        this.sessionId = sessionId;
        this.category = category;
        this.totalNo = totalNo;
        this.currentNo = 1;
    }

    public String getSessionId() {
        return sessionId;
    }

    public Category getCategory() {
        return category;
    }

    public int getCurrentNo() {
        return currentNo;
    }

    public int getTotalNo() {
        return totalNo;
    }

    public void incrementCurrentNo() {
        this.currentNo++;
    }
    
    public QuestionForm getCurrentQuestion() {
        return currentQuestion;
    }
    public void setCurrentQuestion(QuestionForm question) {
        this.currentQuestion = question;
    }

}