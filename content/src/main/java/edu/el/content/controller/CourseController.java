package edu.el.content.controller;

import edu.el.content.model.Content;
import edu.el.content.model.Course;
import edu.el.content.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public List<Course> getAll() {
        return courseService.getAll();
    }

    @PostMapping
    public void save(@RequestBody Course course) {
        courseService.add(course);
    }

    @GetMapping("/{id}")
    public Course get(@PathVariable long id) {
        return courseService.get(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Course course) {
        courseService.update(course);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        courseService.delete(id);
    }

    @GetMapping("/{id}/contents")
    public List<Content> findContentsForCourse(@PathVariable Long id) {
        return courseService.findContentsForCourse(id);
    }

    @GetMapping("/{id}/contents/{contentId}")
    public ResponseEntity<Content> findContentCourseById(@PathVariable Long id, @PathVariable Long contentId) {
        Optional<Content> content = courseService.findContentsForCourse(id, contentId);
        if (content.isEmpty()) return ResponseEntity.notFound().build();

        return ResponseEntity.of(content);
    }

    @PostMapping("/{id}/contents")
    public ResponseEntity<Content> saveContent(@Valid @RequestBody Content content, BindingResult result, @PathVariable Long id) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }
        Optional<Content> savedContent = courseService.saveContent(id, content);
        return ResponseEntity.of(savedContent);
    }


    @DeleteMapping("/{id}/contents/{contentId}")
    public ResponseEntity<Content> deleteContentById(@PathVariable Long id, @PathVariable Long contentId) {
        Optional<Content> deletedContent = courseService.deleteContentById(id, contentId);
        if (deletedContent.isEmpty()) return ResponseEntity.notFound().build();

        return ResponseEntity.of(deletedContent);
    }

    @GetMapping("/users/{id}")
    private List<Course> findCourseByOwner(@PathVariable Long id) {
        return courseService.findCourseByOwner(id);
    }
}
