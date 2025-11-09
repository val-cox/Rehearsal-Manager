package com.valentino.rehearsalmanager.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

@Entity
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate assignedDate;

    @ManyToOne
    @JoinColumn(name = "actor_id")
    @JsonIgnoreProperties({"assignments", "participations"})
    private Actor actor;

    @OneToOne
    @JoinColumn(name = "character_id")
    @JsonIgnoreProperties({"assignment", "play"})
    private Character character;

    public Assignment() {}

    public Assignment(LocalDate assignedDate, Actor actor, Character character) {
        this.assignedDate = assignedDate;
        this.actor = actor;
        this.character = character;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDate getAssignedDate() { return assignedDate; }
    public void setAssignedDate(LocalDate assignedDate) { this.assignedDate = assignedDate; }

    public Actor getActor() { return actor; }
    public void setActor(Actor actor) { this.actor = actor; }

    public Character getCharacter() { return character; }
    public void setCharacter(Character character) { this.character = character; }
}
