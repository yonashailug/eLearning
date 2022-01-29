package edu.el.content.service;

import edu.el.content.dao.CourseDao;
import edu.el.content.dto.ContentDto;
import edu.el.content.model.Content;
import edu.el.content.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class CourseService implements ICourse {

    @Autowired
    private CourseDao courseDao;

    @Override
    public List<Course> getAll() {
        return courseDao.findAll();
    }

    @Override
    public void add(Course course) {
        courseDao.save(course);
    }

    @Override
    public Course get(Long id) {
        return courseDao.findById(id).get();
    }

    @Override
    public void update(Course course) {
        courseDao.save(course);
    }

    @Override
    public void delete(long id) {
        courseDao.deleteById(id);
    }

    @Override
    public List<Content> findContentsForCourse(Long id) {
        return courseDao.findById(id).get().getContents();
    }

    @Override
    public Optional<Content> findContentsForCourse(Long id, Long contentId) {
        Optional<Course> course = courseDao.findById(id);
        if (course.isEmpty()) return Optional.empty();

        return course.get().getContents().stream().filter(content -> content.getId() == contentId).findFirst();
    }

    @Override
    public Optional<Content> saveContent(Long id, Content content) {
        Optional<Course> course = courseDao.findById(id);
        if (course.isEmpty()) return Optional.empty();
        course.get().addContent(content);
        return Optional.of(content);
    }

    @Override
    public Optional<Content> deleteContentById(Long id, Long contentId) {
        Optional<Course> course = courseDao.findById(id);
        if (course.isEmpty()) return Optional.empty();

        Optional<Content> contentToDelete = course.get().getContents().stream().filter(content -> Objects.equals(content.getId(), contentId)).findFirst();
        course.get().getContents().remove(contentToDelete.get());
        return contentToDelete;
    }

    @Override
    public List<Course> findCourseByOwner(Long id) {
        return courseDao.findCourseByOwner(id);
    }

}
