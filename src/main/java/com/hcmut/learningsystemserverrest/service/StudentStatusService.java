package com.hcmut.learningsystemserverrest.service;

import com.hcmut.learningsystemserverrest.controller.customException.exception.MySqlException;
import com.hcmut.learningsystemserverrest.domain.enumeration.LEARNINGSTATUS;
import com.hcmut.learningsystemserverrest.repository.StudentStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class StudentStatusService {
    @Autowired
    private StudentStatusRepository studentStatusRepository;

    public void createStudentStatus(String studentID, String semester,
                                    LEARNINGSTATUS learningStatus) {
        try {
            studentStatusRepository.createStudentStatus(studentID, semester, learningStatus.toString(), 0);
        } catch (DataIntegrityViolationException ex) {
            throw new MySqlException(ex.getMessage());
        }
    }
}
