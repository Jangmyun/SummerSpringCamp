package com.example.smspr.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("")
@Controller
public class DefaultPageController {

    // 2024 07 09
    @GetMapping({"" , "/" , "index"})
    public String index() {
        return "redirect:/index";
    }

    // 2024 07 10
    @GetMapping("/page1")
    public String page1(){
        return "page1";
    }
}
