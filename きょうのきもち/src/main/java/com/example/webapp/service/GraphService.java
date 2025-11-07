package com.example.webapp.service;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.webapp.entity.Graph;
import com.example.webapp.repository.GraphMapper;

@Service
public class GraphService {

    @Autowired
    private GraphMapper graphMapper;

    public List<Integer> getFeelingsByMonth(String yearMonth) {
        List<Graph> all = graphMapper.getUserdiaries();
        List<Integer> result = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");

        for (Graph g : all) {
            if (g.getDate().format(formatter).equals(yearMonth)) {
                result.add(g.getFeeling());
            }
        }

        return result;
    }
}