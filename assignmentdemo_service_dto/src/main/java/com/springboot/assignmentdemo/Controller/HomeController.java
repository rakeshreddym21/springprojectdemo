package com.springboot.assignmentdemo.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/admin")
    public String showAdmin()
    {
        return "admin";
    }
    @RequestMapping("/showMyLoginPage")
    public String showLogin()
    {
        return "loginPage";
    }
    @RequestMapping("/access-denied")
    public String accessDenied()
    {
        return "accessDenied";
    }
}
