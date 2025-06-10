package com.kb.starbucks.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@Component, @Service, @Repository,

@Controller
//@RestController
public class WelcomeController {
    @GetMapping("/welcome")
    public String a(){
//        return "WELCOME";
        return "/a.jsp";
    }
}
