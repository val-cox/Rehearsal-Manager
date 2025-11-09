package com.valentino.rehearsalmanager.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import com.valentino.rehearsalmanager.model.Assignment;
import com.valentino.rehearsalmanager.service.AssignmentService;

@RestController
@RequestMapping("/assignments")
public class AssignmentController {

    private final AssignmentService assignmentService;

    public AssignmentController(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    @GetMapping("/all")
    public List<Assignment> getAllAssignments() {
        return assignmentService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Assignment> getAssignmentById(@PathVariable Long id) {
        return assignmentService.findById(id);
    }

    @PostMapping("/add")
    public Assignment addAssignment(@RequestBody Assignment assignment) {
        return assignmentService.save(assignment);
    }

    @PutMapping("/update/{id}")
    public Assignment updateAssignment(@PathVariable Long id, @RequestBody Assignment assignment) {
        assignment.setId(id);
        return assignmentService.save(assignment);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAssignment(@PathVariable Long id) {
        assignmentService.deleteById(id);
    }
}
