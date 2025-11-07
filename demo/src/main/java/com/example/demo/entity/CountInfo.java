package com.example.demo.entity;

public class CountInfo {
    private int current;
    private int total;

    public CountInfo(int current, int total) {
        this.current = current;
        this.total = total;
    }

    public int getCurrent() {
        return current;
    }

    public int getTotal() {
        return total;
    }
}