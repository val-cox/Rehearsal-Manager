package com.valentino.rehearsalmanager.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.valentino.rehearsalmanager.model.RehearsalParticipation;
import com.valentino.rehearsalmanager.repository.RehearsalParticipationRepository;

@Service
public class RehearsalParticipationService {

    private final RehearsalParticipationRepository participationRepository;

    public RehearsalParticipationService(RehearsalParticipationRepository participationRepository) {
        this.participationRepository = participationRepository;
    }

    public List<RehearsalParticipation> findAll() {
        return participationRepository.findAll();
    }

    public Optional<RehearsalParticipation> findById(Long id) {
        return participationRepository.findById(id);
    }

    public RehearsalParticipation save(RehearsalParticipation participation) {
        return participationRepository.save(participation);
    }

    public void deleteById(Long id) {
        participationRepository.deleteById(id);
    }
}
