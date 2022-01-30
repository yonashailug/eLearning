package edu.hahu.auth;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class HomeController {

    @GetMapping("/hello")
    public String hello(){
        return "Hello from Authentication micro-service";
    }
}
