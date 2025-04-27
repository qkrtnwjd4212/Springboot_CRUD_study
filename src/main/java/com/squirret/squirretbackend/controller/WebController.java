package com.squirret.squirretbackend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("name", "root");
        model.addAttribute("img", "image/hi.jpg");
        return "hello";
    }

}
