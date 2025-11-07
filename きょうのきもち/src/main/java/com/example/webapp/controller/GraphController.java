package com.example.webapp.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GraphController {

    @GetMapping("/graph")
    public String showGraph(Model model) {
        List<Map<String, String>> monthOptions = new ArrayList<>();
        LocalDate current = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");

        for (int i = 0; i < 36; i++) {
            String value = current.format(formatter);
            String label = current.format(DateTimeFormatter.ofPattern("yyyy年M月"));
            monthOptions.add(Map.of("value", value, "label", label));
            current = current.minusMonths(1);
        }

        model.addAttribute("monthOptions", monthOptions);
        return "graph";
    }
}