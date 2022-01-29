package edu.el.content.service;

import edu.el.content.dao.CourseDao;
import edu.el.content.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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

}
