package edu.el.content.controller;

import edu.el.content.model.Content;
import edu.el.content.model.Course;
import edu.el.content.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Content findContentCourseById(@PathVariable Long id, @PathVariable Long contentId) {
        return courseService.findContentsForCourse(id, contentId);
    }
}
