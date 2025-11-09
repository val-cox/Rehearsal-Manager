package com.valentino.rehearsalmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.valentino.rehearsalmanager.model.Character;

public interface CharacterRepository extends JpaRepository<Character, Long> {}
