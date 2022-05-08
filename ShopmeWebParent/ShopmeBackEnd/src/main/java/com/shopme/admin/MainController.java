package com.shopme.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("")
    public String viewHomePage(){
        return "index";
    }
}
//MainController - this is a Spring MVC controller class, so we use this annotation @Controller here
//And the handler method that will handle the HTTP GET request to the homepage of this application.
