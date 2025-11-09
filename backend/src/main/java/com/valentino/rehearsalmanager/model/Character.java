package com.valentino.rehearsalmanager.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

@Entity
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "play_id")
    @JsonBackReference
    private Play play;

    @OneToOne(mappedBy = "character")
    @JsonIgnoreProperties("character")
    private Assignment assignment;

    public Character() {}

    public Character(String name, String description, Play play) {
        this.name = name;
        this.description = description;
        this.play = play;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Play getPlay() { return play; }
    public void setPlay(Play play) { this.play = play; }

    public Assignment getAssignment() { return assignment; }
    public void setAssignment(Assignment assignment) { this.assignment = assignment; }
}
