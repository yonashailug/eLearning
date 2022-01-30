package edu.hahu.auth;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/test")
public class AuthController {

    @PostMapping
    public String test() {
        System.out.println("called.");
        return "Auth service";
    }
}
