package com.valentino.rehearsalmanager.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import com.valentino.rehearsalmanager.model.Actor;
import com.valentino.rehearsalmanager.service.ActorService;

@RestController
@RequestMapping("/actors")
public class ActorController {

    private final ActorService actorService;

    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping("/all")
    public List<Actor> getAllActors() {
        return actorService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Actor> getActorById(@PathVariable Long id) {
        return actorService.findById(id);
    }

    @PostMapping("/add")
    public Actor addActor(@RequestBody Actor actor) {
        return actorService.save(actor);
    }

    @PutMapping("/update/{id}")
    public Actor updateActor(@PathVariable Long id, @RequestBody Actor updatedActor) {
        updatedActor.setId(id);
        return actorService.save(updatedActor);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteActor(@PathVariable Long id) {
        actorService.deleteById(id);
    }
}
