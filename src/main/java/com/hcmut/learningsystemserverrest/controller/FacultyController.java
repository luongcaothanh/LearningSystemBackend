package com.hcmut.learningsystemserverrest.controller;

import com.hcmut.learningsystemserverrest.domain.Faculty;
import com.hcmut.learningsystemserverrest.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FacultyController {
    @Autowired
    private FacultyRepository facultyRepository;

    @GetMapping("/faculty")
    public List<Faculty> getAllFaculty() {
        return facultyRepository.getAllFaculty();
    }
}
