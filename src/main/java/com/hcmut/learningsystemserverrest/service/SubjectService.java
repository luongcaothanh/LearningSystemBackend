package com.hcmut.learningsystemserverrest.service;

import com.hcmut.learningsystemserverrest.controller.customException.exception.MySqlException;
import com.hcmut.learningsystemserverrest.domain.enumeration.SUBJECTSTATUS;
import com.hcmut.learningsystemserverrest.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;

    public void createSubject(String id, String subjectName, Integer creditsNo,
                              SUBJECTSTATUS subjectStatus, String facultyName, String lecturerID) {
        try {
            subjectRepository.createSubject(id, subjectName, creditsNo, subjectStatus.toString(), facultyName, lecturerID);
        } catch (DataIntegrityViolationException ex) {
            throw new MySqlException(ex.getMessage());
        }
    }

    public void createPrerequisite(String subjectID, String preSubjectID) {
        try {
            subjectRepository.createPrerequisite(subjectID, preSubjectID);
        } catch (DataIntegrityViolationException ex) {
            throw new MySqlException(ex.getMessage());
        }
    }
}
