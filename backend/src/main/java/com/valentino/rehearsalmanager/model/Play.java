package com.valentino.rehearsalmanager.model;



import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
public class Play {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;

	private String description;
    private LocalDate premiereDate;

    @OneToMany(mappedBy = "play")
    @JsonManagedReference

    private List<Character> characters;

    @OneToMany(mappedBy = "play")
    private List<Rehearsal> rehearsals;
    
    /**
    @OneToMany(mappedBy = "play")
    private List<Script> scripts;

    @OneToMany(mappedBy = "play")
    private List<Scene> scenes;
    **/
    public Play() {}

    public Play(String title, String author, String description, LocalDate premiereDate) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.premiereDate = premiereDate;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    
    public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public LocalDate getPremiereDate() { return premiereDate; }
    public void setPremiereDate(LocalDate premiereDate) { this.premiereDate = premiereDate; }

    public List<Character> getCharacters() { return characters; }
    public void setCharacters(List<Character> characters) { this.characters = characters; }

    public List<Rehearsal> getRehearsals() { return rehearsals; }
    public void setRehearsals(List<Rehearsal> rehearsals) { this.rehearsals = rehearsals; }
}

    /**
    public List<Script> getScripts() { return scripts; }
    public void setScripts(List<Script> scripts) { this.scripts = scripts; }

    public List<Scene> getScenes() { return scenes; }
    public void setScenes(List<Scene> scenes) { this.scenes = scenes; }
}
    **/
