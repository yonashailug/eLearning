package edu.hahu.enrollement.service;

import edu.hahu.enrollement.model.Enrollment;

import java.util.List;
import java.util.Optional;

public interface IEnrollmentService {
    public List<Enrollment> findAll();

    public Enrollment findById(Long id);

    public Optional<Enrollment> save(Enrollment enrollment);

    public void update(Enrollment enrollment);

    public void deleteById(Long id);

    List<Object> getCoursesByUser(Long id);
}
