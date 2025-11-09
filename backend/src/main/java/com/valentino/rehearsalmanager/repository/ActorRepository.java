package com.valentino.rehearsalmanager.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.valentino.rehearsalmanager.model.Actor;

public interface ActorRepository extends JpaRepository<Actor, Long> {
    // You can add custom queries later, e.g.:
    // List<Actor> findByName(String name);
}
