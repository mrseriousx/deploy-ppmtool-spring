package com.example.PPMToolSpring.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ForwardingController {
    @RequestMapping("/<any end point name>/{path:[^\\.]+}/**")
    public String forward(HttpServletRequest httpServletRequest) {
        return "forward:/index.html";
    }
}