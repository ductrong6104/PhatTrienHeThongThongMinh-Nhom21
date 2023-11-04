package com.example.thuoctay.front_end;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontEndController {
    @GetMapping("/admin")
    public String adminPage(){
        System.out.println("\n\n\nADMIN\n\n\n");
        return "admin";
    }
    @GetMapping("/")
    public String customerPage(){
        System.out.println("\n\n\nADMIN\n\n\n");
        return "customer";
    }
}
