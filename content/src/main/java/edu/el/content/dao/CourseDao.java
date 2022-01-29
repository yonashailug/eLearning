package edu.el.content.dao;

import edu.el.content.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseDao extends JpaRepository<Course, Long> {
    List<Course> findCourseByOwner(Long id);
}
