package com.twschool.practice.domain;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class controller {
    @PostMapping("/games/guess-numbers")
    public Map<String,String> guess(@RequestBody Map<String,String> requestBody){
    Map<String ,String > paramer=new HashMap<>();
    paramer.put("input",requestBody.get("number"));
    paramer.put("result","4A0B");
    return paramer;
    }
}


