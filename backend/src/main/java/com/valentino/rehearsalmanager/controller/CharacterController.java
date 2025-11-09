package com.valentino.rehearsalmanager.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import com.valentino.rehearsalmanager.model.Character;
import com.valentino.rehearsalmanager.service.CharacterService;

@RestController
@RequestMapping("/characters")
public class CharacterController {

    private final CharacterService characterService;

    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping("/all")
    public List<Character> getAllCharacters() {
        return characterService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Character> getCharacterById(@PathVariable Long id) {
        return characterService.findById(id);
    }

    @PostMapping("/add")
    public Character addCharacter(@RequestBody Character character) {
        return characterService.save(character);
    }

    @PutMapping("/update/{id}")
    public Character updateCharacter(@PathVariable Long id, @RequestBody Character character) {
        character.setId(id);
        return characterService.save(character);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCharacter(@PathVariable Long id) {
        characterService.deleteById(id);
    }
}
