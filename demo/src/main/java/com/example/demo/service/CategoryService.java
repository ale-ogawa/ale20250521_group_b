package com.example.demo.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Category;

@Service
public class CategoryService {

    public List<Category> getAll() {
        return Arrays.asList(Category.values());
    }
}