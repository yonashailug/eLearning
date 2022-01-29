package edu.hahu.enrollement.model;

import javax.persistence.*;

@Entity
@Table(name = "progress")
public class Progress {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}