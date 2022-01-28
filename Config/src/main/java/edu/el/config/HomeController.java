package edu.el.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
public class HomeController {

    @Autowired
    private Environment env;


    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/")
    public String home() {
        // This is useful for debugging
        // When having multiple instance of gallery service running at different ports.
        // We load balance among them, and display which instance received the request.
        return "Hello from Gallery Service running at port: " + env.getProperty("local.server.port");
    }

    @GetMapping("/contents")
    public List<Content> getGallery() {

        // get list of available images
        List<Content> contents = restTemplate.getForObject("http://content/images/", List.class);

        return contents;
    }

}

