package com.valentino.rehearsalmanager.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.valentino.rehearsalmanager.model.Actor;
import com.valentino.rehearsalmanager.repository.ActorRepository;

@Service
public class ActorService {

    private final ActorRepository actorRepository;

    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    public List<Actor> findAll() {
        return actorRepository.findAll();
    }

    public Optional<Actor> findById(Long id) {
        return actorRepository.findById(id);
    }

    public Actor save(Actor actor) {
        return actorRepository.save(actor);
    }

    public void deleteById(Long id) {
        actorRepository.deleteById(id);
    }
}
