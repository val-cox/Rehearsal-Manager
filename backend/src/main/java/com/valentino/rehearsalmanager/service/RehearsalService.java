package com.valentino.rehearsalmanager.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.valentino.rehearsalmanager.model.Rehearsal;
import com.valentino.rehearsalmanager.repository.RehearsalRepository;

@Service
public class RehearsalService {

    private final RehearsalRepository rehearsalRepository;

    public RehearsalService(RehearsalRepository rehearsalRepository) {
        this.rehearsalRepository = rehearsalRepository;
    }

    public List<Rehearsal> findAll() {
        return rehearsalRepository.findAll();
    }

    public Optional<Rehearsal> findById(Long id) {
        return rehearsalRepository.findById(id);
    }

    public Rehearsal save(Rehearsal rehearsal) {
        return rehearsalRepository.save(rehearsal);
    }

    public void deleteById(Long id) {
        rehearsalRepository.deleteById(id);
    }
}
