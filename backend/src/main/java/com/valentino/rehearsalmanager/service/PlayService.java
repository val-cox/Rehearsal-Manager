package com.valentino.rehearsalmanager.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.valentino.rehearsalmanager.model.Play;
import com.valentino.rehearsalmanager.repository.PlayRepository;

@Service
public class PlayService {

    private final PlayRepository playRepository;

    public PlayService(PlayRepository playRepository) {
        this.playRepository = playRepository;
    }

    public List<Play> findAll() {
        return playRepository.findAll();
    }

    public Optional<Play> findById(Long id) {
        return playRepository.findById(id);
    }

    public Play save(Play play) {
        return playRepository.save(play);
    }

    public void deleteById(Long id) {
        playRepository.deleteById(id);
    }
}
