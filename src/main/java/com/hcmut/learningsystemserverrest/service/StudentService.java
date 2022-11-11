package com.hcmut.learningsystemserverrest.service;

import com.hcmut.learningsystemserverrest.controller.customException.exception.MySqlException;
import com.hcmut.learningsystemserverrest.domain.enumeration.GENDER;
import com.hcmut.learningsystemserverrest.repository.StudentRepository;
import com.hcmut.learningsystemserverrest.service.dto.StudentCreatedDTO;
import com.hcmut.learningsystemserverrest.service.dto.StudentInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<StudentInfoDTO> getAllStudent() {
        return studentRepository.getAllStudent();
    }

    public StudentInfoDTO getStudentInfo(String personID) {
        return studentRepository.getStudentInfo(personID);
    }

    public StudentCreatedDTO createStudent(String idCard, GENDER gender, String fName,
                                            String lName, LocalDate doB, String email,
                                            String studentID, String admissionYear, String facultyName,
                                            String username, String password) {
        try {
            String passwordEncode = passwordEncoder.encode(password);

            return studentRepository.createStudent(idCard,  gender.toString(),  fName, lName,  doB,  email,
                    studentID, admissionYear, facultyName, username,  passwordEncode);
        } catch (DataIntegrityViolationException ex) {
            throw new MySqlException(ex.getMessage());
        }
    }
}
