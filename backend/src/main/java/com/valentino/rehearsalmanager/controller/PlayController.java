package com.valentino.rehearsalmanager.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import com.valentino.rehearsalmanager.model.Play;
import com.valentino.rehearsalmanager.service.PlayService;

@RestController
@RequestMapping("/plays")
public class PlayController {

    private final PlayService playService;

    public PlayController(PlayService playService) {
        this.playService = playService;
    }

    @GetMapping("/all")
    public List<Play> getAllPlays() {
        return playService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Play> getPlayById(@PathVariable Long id) {
        return playService.findById(id);
    }

    @PostMapping("/add")
    public Play addPlay(@RequestBody Play play) {
        return playService.save(play);
    }

    @PutMapping("/update/{id}")
    public Play updatePlay(@PathVariable Long id, @RequestBody Play play) {
        play.setId(id);
        return playService.save(play);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePlay(@PathVariable Long id) {
        playService.deleteById(id);
    }
}
