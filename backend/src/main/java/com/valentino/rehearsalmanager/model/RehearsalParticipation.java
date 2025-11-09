package com.valentino.rehearsalmanager.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

@Entity
public class RehearsalParticipation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean attended;
    private String comments;

    @ManyToOne
    @JoinColumn(name = "actor_id")
    @JsonIgnoreProperties({"participations"})
    private Actor actor;

    @ManyToOne
    @JoinColumn(name = "rehearsal_id")
    @JsonIgnoreProperties({"participations"})
    private Rehearsal rehearsal;

    public RehearsalParticipation() {}

    public RehearsalParticipation(boolean attended, String comments, Actor actor, Rehearsal rehearsal) {
        this.attended = attended;
        this.comments = comments;
        this.actor = actor;
        this.rehearsal = rehearsal;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public boolean isAttended() { return attended; }
    public void setAttended(boolean attended) { this.attended = attended; }

    public String getComments() { return comments; }
    public void setComments(String comments) { this.comments = comments; }

    public Actor getActor() { return actor; }
    public void setActor(Actor actor) { this.actor = actor; }

    public Rehearsal getRehearsal() { return rehearsal; }
    public void setRehearsal(Rehearsal rehearsal) { this.rehearsal = rehearsal; }
}
