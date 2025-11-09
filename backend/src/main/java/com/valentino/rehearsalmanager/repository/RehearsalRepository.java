package com.valentino.rehearsalmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.valentino.rehearsalmanager.model.Rehearsal;

public interface RehearsalRepository extends JpaRepository<Rehearsal, Long> {}
