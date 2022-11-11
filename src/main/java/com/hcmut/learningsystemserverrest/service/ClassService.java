package com.hcmut.learningsystemserverrest.service;

import com.hcmut.learningsystemserverrest.controller.customException.exception.MySqlException;
import com.hcmut.learningsystemserverrest.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class ClassService {
    @Autowired
    private ClassRepository classRepository;

    public void createClass(String semester, String classYear, String classType, String subjectID) {
        try {
            classRepository.createClass(semester, classYear, classType, subjectID);
        } catch (DataIntegrityViolationException ex) {
            throw new MySqlException(ex.getMessage());
        }
    }
}
