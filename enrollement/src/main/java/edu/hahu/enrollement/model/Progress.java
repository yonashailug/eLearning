package edu.hahu.enrollement.model;

import javax.persistence.*;

@Entity
@Table(name = "progress")
public class Progress {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private double percentage;
    @Column(nullable = false)
    private boolean finished;

    private Long lastContent;

    public Progress() {
    }

    public Progress(Long id, double percentage, boolean finished, Long lastContent) {
        this.id = id;
        this.percentage = percentage;
        this.finished = finished;
        this.lastContent = lastContent;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public Long getLastContent() {
        return lastContent;
    }

    public void setLastContent(Long lastContent) {
        this.lastContent = lastContent;
    }

    public boolean getFinished() {
        return finished;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}