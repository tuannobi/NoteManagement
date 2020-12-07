package com.tuno.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/web")
public class WebController {
    @GetMapping("/demo")
    @ResponseBody
    public String getHello(){
        return "Hello World";
    }
}
