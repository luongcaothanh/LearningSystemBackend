package com.hcmut.learningsystemserverrest.service;

import com.hcmut.learningsystemserverrest.controller.customException.exception.MySqlException;
import com.hcmut.learningsystemserverrest.repository.SubclassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class SubclassService {
    @Autowired
    private SubclassRepository subclassRepository;

    public void createSubclass(String id, String csemester, String cYear, String cType,
                               String csubjectID, String lecturerID) {
        try {
            subclassRepository.createSubclass(id, csemester, cYear, cType, csubjectID, lecturerID);
        } catch (DataIntegrityViolationException ex) {
            throw new MySqlException(ex.getMessage());
        }
    }
}
