package edu.hahu.enrollement.service;

import edu.hahu.enrollement.model.Enrollment;

import java.util.List;

public interface IEnrollmentService {
    public List<Enrollment> findAll();
    public Enrollment findById(Long id);
    public Enrollment save(Enrollment enrollment);
    public void update(Enrollment enrollment);
    public void deleteById(Long id);
    List<Object> getCoursesByUser(Long id);
}
