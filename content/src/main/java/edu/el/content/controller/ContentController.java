package edu.el.content.controller;

import edu.el.content.model.Content;
import edu.el.content.service.ContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contents")
@RequiredArgsConstructor
public class ContentController {

    private final ContentService contentService;

    @GetMapping
    public List<Content> getAll() {
        return contentService.getAll();
    }

    @PostMapping
    public void save(@RequestBody Content content) {
        contentService.add(content);
    }

    @GetMapping("/{id}")
    public Content get(@PathVariable long id) {
        return contentService.get(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Content content) {
        contentService.update(content);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        contentService.delete(id);
    }

}
