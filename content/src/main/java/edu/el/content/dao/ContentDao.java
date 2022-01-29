package edu.el.content.dao;

import edu.el.content.model.Content;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentDao extends JpaRepository<Content, Long> {
}
