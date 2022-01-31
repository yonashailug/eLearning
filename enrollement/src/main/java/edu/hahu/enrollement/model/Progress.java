package edu.hahu.enrollement.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "progress")
@Getter
@Setter
public class Progress {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private double percentage;
    @Column(nullable = false)
    private boolean finished;

    @OneToOne(cascade = CascadeType.ALL)
    private Enrollment enrollment;

    private Long lastContent;

}