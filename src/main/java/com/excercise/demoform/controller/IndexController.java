package com.excercise.demoform.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
   

    @GetMapping("/")
    public String  index(){
        return "index";
    }

    @GetMapping("index.html")
    public String goHomePage(){
        return "index";
    }
    
    @GetMapping("/shop.html")
    public String shop(){
        return "shop";
    }

    @GetMapping("/cart.html")
    public String getCartPage(){
        return "cart";
    }

    @GetMapping ("/blog.html")
    public String goToBlogPage(){
        return "blog";
    }
    @GetMapping("/contact.html")
    public String goToContactPage(){
        return "contact";
    }
    
    @GetMapping("/aboutus.html")
    public String aboutUsPage(){
        return "aboutus";
    }
   
}
