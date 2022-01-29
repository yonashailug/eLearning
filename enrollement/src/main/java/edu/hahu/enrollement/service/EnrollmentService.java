package edu.hahu.enrollement.service;

import edu.hahu.enrollement.dao.EnrollmentDao;
import edu.hahu.enrollement.model.Enrollment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentService implements  IEnrollmentService {

    @Autowired
    private EnrollmentDao enrollmentDao;

    @Override
    public List<Enrollment> findAll() {
        return enrollmentDao.findAll();
    }

    @Override
    public Enrollment findById(Long id) {
        return enrollmentDao.getById(id);
    }

    @Override
    public Enrollment save(Enrollment enrollment) {
         return enrollmentDao.save(enrollment);
    }

    @Override
    public void update(Enrollment enrollment) {
        enrollmentDao.save(enrollment);
    }

    @Override
    public void deleteById(Long id) {
        enrollmentDao.deleteById(id);
    }
}
