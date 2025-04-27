package com.squirret.squirretbackend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ApiController {

    @RestController
    @RequestMapping("/api")
    public class ApiController {

        @GetMapping("/name")
        public String name() {
            return "root";
        }
    }
}
