package com.hcmut.learningsystemserverrest.service;

import com.hcmut.learningsystemserverrest.controller.customException.exception.MySqlException;
import com.hcmut.learningsystemserverrest.domain.Faculty;
import com.hcmut.learningsystemserverrest.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyService {
    @Autowired
    private FacultyRepository facultyRepository;

    public List<Faculty> getAllFaculty() {
        return facultyRepository.getAllFaculty();
    }

    public Faculty createFaculty(String facultyName) {
        try {
            return facultyRepository.createFaculty(facultyName);
        } catch (DataIntegrityViolationException ex) {
            throw new MySqlException(ex.getMessage());
        }
    }
}
