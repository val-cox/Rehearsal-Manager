package com.valentino.rehearsalmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.valentino.rehearsalmanager.model.Assignment;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {}
