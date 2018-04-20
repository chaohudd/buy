package com.buy.core;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class indexController {
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}