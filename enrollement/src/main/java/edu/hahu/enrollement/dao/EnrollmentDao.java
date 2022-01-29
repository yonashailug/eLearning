package edu.hahu.enrollement.dao;

import edu.hahu.enrollement.model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentDao extends JpaRepository<Enrollment , Long> {
}
