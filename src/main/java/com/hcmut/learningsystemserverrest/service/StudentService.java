package com.hcmut.learningsystemserverrest.service;

import com.hcmut.learningsystemserverrest.repository.StudentRepository;
import com.hcmut.learningsystemserverrest.service.dto.StudentInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<StudentInfoDTO> getAllStudent() {
        return studentRepository.getAllStudent();
    }

    public StudentInfoDTO getStudentInfo(String personID) {
        return studentRepository.getStudentInfo(personID);
    }
}
