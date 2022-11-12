package com.hcmut.learningsystemserverrest.service;

import com.hcmut.learningsystemserverrest.controller.customException.exception.MySqlException;
import com.hcmut.learningsystemserverrest.domain.enumeration.LEARNINGSTATUS;
import com.hcmut.learningsystemserverrest.repository.StudentStatusRepository;
import com.hcmut.learningsystemserverrest.service.dto.StudentStatusDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<StudentStatusDTO> getStatusOfStudent(String studentID) {
        return studentStatusRepository.getStatusOfStudent(studentID);
    }

    public StudentStatusDTO getStudentStatusOfSemester(String studentID, String semester) {
        return studentStatusRepository.getStudentStatusOfSemester(studentID, semester);
    }

    public void updateStudentStatus(String studentID, String semester, LEARNINGSTATUS learningStatus) {
        try {
            if (learningStatus.toString().equals("Learning")) {
                studentStatusRepository.learningStudentStatus(studentID, semester);
            } else if (learningStatus.toString().equals("Stop")) {
                studentStatusRepository.stopStudentStatus(studentID, semester);
            } else {
                studentStatusRepository.postponeStudentStatus(studentID, semester);
            }
        } catch (DataIntegrityViolationException ex) {
            throw new MySqlException(ex.getMessage());
        }
    }
}
