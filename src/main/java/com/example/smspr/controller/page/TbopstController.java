package com.example.smspr.controller.page;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/tbpost") // HTTP 요청을 특정
@Controller
public class TbopstController {


    // {} 안에 path variable 넣어서 Request
    @GetMapping("/{page}")
    public String page(@PathVariable String page) {
        return "tbpost/" + page;
        
    }

    @GetMapping("/{page}/{id}")
    public String page(@PathVariable String page, @PathVariable String id) {
        return "tbpost/" + page;
    }
}
