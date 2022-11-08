package com.hcmut.learningsystemserverrest.service;

import com.hcmut.learningsystemserverrest.domain.Faculty;
import com.hcmut.learningsystemserverrest.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyService {
    @Autowired
    private FacultyRepository facultyRepository;

    public List<Faculty> getAllFaculty() {
        return facultyRepository.getAllFaculty();
    }
}
