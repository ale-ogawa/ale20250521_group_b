package com.example.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.webapp.service.GraphService;

@RestController
@RequestMapping("/api/graph")
public class GraphApiController {

    @Autowired
    private GraphService graphService;

    @GetMapping("/feeling")
    public List<Integer> getFeelingsByMonth(@RequestParam String month) {
        return graphService.getFeelingsByMonth(month);
    }
}