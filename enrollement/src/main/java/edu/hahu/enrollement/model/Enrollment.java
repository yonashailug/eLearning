package edu.hahu.enrollement.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "enrollment")
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    private Long courseId;

    @NotNull
    @Positive
    private Long traineeId;

    @OneToOne(cascade = CascadeType.ALL)
    private Progress progress;

    public Enrollment() {}

    public Enrollment(Long courseId, Long traineeId) {
        this.courseId = courseId;
        this.traineeId = traineeId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Long getTraineeId() {
        return traineeId;
    }

    public void setTraineeId(Long traineeId) {
        this.traineeId = traineeId;
    }
}