package com.valentino.rehearsalmanager.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import com.valentino.rehearsalmanager.model.RehearsalParticipation;
import com.valentino.rehearsalmanager.service.RehearsalParticipationService;

@RestController
@RequestMapping("/participations")
public class RehearsalParticipationController {

    private final RehearsalParticipationService participationService;

    public RehearsalParticipationController(RehearsalParticipationService participationService) {
        this.participationService = participationService;
    }

    @GetMapping("/all")
    public List<RehearsalParticipation> getAllParticipations() {
        return participationService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<RehearsalParticipation> getParticipationById(@PathVariable Long id) {
        return participationService.findById(id);
    }

    @PostMapping("/add")
    public RehearsalParticipation addParticipation(@RequestBody RehearsalParticipation participation) {
        return participationService.save(participation);
    }

    @PutMapping("/update/{id}")
    public RehearsalParticipation updateParticipation(@PathVariable Long id, @RequestBody RehearsalParticipation participation) {
        participation.setId(id);
        return participationService.save(participation);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteParticipation(@PathVariable Long id) {
        participationService.deleteById(id);
    }
}
