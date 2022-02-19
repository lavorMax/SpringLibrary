package com.ttl.controllers;

import org.springframework.stereotype.Controller;

@Controller
public class HomeController {

    public String index() {
        return "index";
    }
}