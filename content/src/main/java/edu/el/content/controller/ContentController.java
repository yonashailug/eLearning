package edu.el.content.controller;

import edu.el.content.model.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController

public class ContentController {


    @Autowired
    private Environment env;

    @RequestMapping("/contents")
    public List<Content> getImages() {
        List<Content> contents = Arrays.asList(
                new Content(1L, "Treehouse of Horror V"),
                new Content(2L, "The Town"));
        return contents;
    }



}
