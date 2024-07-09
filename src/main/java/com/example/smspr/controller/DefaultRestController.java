package com.example.smspr.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("")
@RestController
public class DefaultRestController {

    @GetMapping("/index")
    public String index(@RequestParam String test1, @RequestParam String test2){
        return "haha " + test1 + " " +test2;
    }

    @GetMapping("/add")
    public  String add(@RequestParam int test1, int test2){
        return (test1 + test2) +"" ;
    }
}
