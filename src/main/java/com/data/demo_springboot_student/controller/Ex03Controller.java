package com.data.demo_springboot_student.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller

public class Ex03Controller {
    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("message", "Hello, Spring Boot API!");
        return "ex03";
    }
}
