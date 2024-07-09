package com.example.smspr.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RequestMapping("/api")
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

    @GetMapping("/login")
    public Map<String, Object> login(@RequestParam Map<String,Object> params){
        boolean result = false;
        String msg = "";
        if("admin".equals(params.get("id"))){
            if("abcd".equals(params.get("pw"))){
                result = true;
                msg = "정상 로그인";
            }else {
                msg = "Wrong PW";
            }
        }else {
            msg = "Wrong ID";
        }

        Map<String, Object> returnData = new HashMap<>();
        returnData.put("result", result);
        returnData.put("msg",msg);

        return returnData;
    }
}
