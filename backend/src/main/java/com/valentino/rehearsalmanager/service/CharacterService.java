package com.valentino.rehearsalmanager.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.valentino.rehearsalmanager.model.Character;
import com.valentino.rehearsalmanager.repository.CharacterRepository;

@Service
public class CharacterService {

    private final CharacterRepository characterRepository;

    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    public List<Character> findAll() {
        return characterRepository.findAll();
    }

    public Optional<Character> findById(Long id) {
        return characterRepository.findById(id);
    }

    public Character save(Character character) {
        return characterRepository.save(character);
    }

    public void deleteById(Long id) {
        characterRepository.deleteById(id);
    }
}
