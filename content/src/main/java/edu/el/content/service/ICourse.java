package edu.el.content.service;

import edu.el.content.model.Content;
import edu.el.content.model.Course;

import java.util.List;
import java.util.Optional;

public interface ICourse {
    List<Course> getAll();

    void add(Course course);

    Course get(Long id);

    void update(Course course);

    void delete(long id);

    List<Content> findContentsForCourse(Long id);

    Optional<Content> findContentsForCourse(Long id, Long contentId);

    Optional<Content> saveContent(Long id, Content content);

    Optional<Content> deleteContentById(Long id, Long contentId);

    List<Course> findCourseByOwner(Long id);
}
