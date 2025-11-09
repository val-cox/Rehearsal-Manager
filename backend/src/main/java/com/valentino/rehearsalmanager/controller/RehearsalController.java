package com.valentino.rehearsalmanager.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import com.valentino.rehearsalmanager.model.Rehearsal;
import com.valentino.rehearsalmanager.service.RehearsalService;

@RestController
@RequestMapping("/rehearsals")
public class RehearsalController {

    private final RehearsalService rehearsalService;

    public RehearsalController(RehearsalService rehearsalService) {
        this.rehearsalService = rehearsalService;
    }

    @GetMapping("/all")
    public List<Rehearsal> getAllRehearsals() {
        return rehearsalService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Rehearsal> getRehearsalById(@PathVariable Long id) {
        return rehearsalService.findById(id);
    }

    @PostMapping("/add")
    public Rehearsal addRehearsal(@RequestBody Rehearsal rehearsal) {
        return rehearsalService.save(rehearsal);
    }

    @PutMapping("/update/{id}")
    public Rehearsal updateRehearsal(@PathVariable Long id, @RequestBody Rehearsal rehearsal) {
        rehearsal.setId(id);
        return rehearsalService.save(rehearsal);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteRehearsal(@PathVariable Long id) {
        rehearsalService.deleteById(id);
    }
}
