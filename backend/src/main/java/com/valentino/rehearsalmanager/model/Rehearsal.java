package com.valentino.rehearsalmanager.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

@Entity
public class Rehearsal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private String location;
    private String notes;

    @ManyToOne
    @JoinColumn(name = "play_id")
    @JsonIgnoreProperties({"characters", "rehearsals"})
    private Play play;

    @OneToMany(mappedBy = "rehearsal", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties({"rehearsal", "actor"})
    private List<RehearsalParticipation> participations;

    public Rehearsal() {}

    public Rehearsal(LocalDate date, LocalTime startTime, LocalTime endTime, String location, String notes, Play play) {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.location = location;
        this.notes = notes;
        this.play = play;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public LocalTime getStartTime() { return startTime; }
    public void setStartTime(LocalTime startTime) { this.startTime = startTime; }

    public LocalTime getEndTime() { return endTime; }
    public void setEndTime(LocalTime endTime) { this.endTime = endTime; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

    public Play getPlay() { return play; }
    public void setPlay(Play play) { this.play = play; }

    public List<RehearsalParticipation> getParticipations() { return participations; }
    public void setParticipations(List<RehearsalParticipation> participations) { this.participations = participations; }
}
