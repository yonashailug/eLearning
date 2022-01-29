package edu.hahu.enrollement.dao;

import edu.hahu.enrollement.model.Progress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgressDao extends JpaRepository<Progress, Long> {
}