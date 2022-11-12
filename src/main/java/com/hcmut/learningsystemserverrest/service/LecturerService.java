package com.hcmut.learningsystemserverrest.service;

import com.hcmut.learningsystemserverrest.controller.customException.exception.MySqlException;
import com.hcmut.learningsystemserverrest.domain.enumeration.GENDER;
import com.hcmut.learningsystemserverrest.repository.LecturerRepository;
import com.hcmut.learningsystemserverrest.service.dto.EmployeeCreatedDTO;
import com.hcmut.learningsystemserverrest.service.dto.LecturerInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LecturerService {
    @Autowired
    private LecturerRepository lecturerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public LecturerInfoDTO getLecturerInfo(String personID) {
        return lecturerRepository.getLecturerInfo(personID);
    }

    public EmployeeCreatedDTO createLecturer(String idCard, GENDER gender, String fName,
                                            String lName, LocalDate doB, String email,
                                            String employeeID, String facultyName,
                                            String username, String password){
        try {
            String passwordEncode = passwordEncoder.encode(password);

            return lecturerRepository.createLecturer(idCard,  gender.toString(),  fName, lName,  doB,  email,
                    employeeID,  facultyName, username,  passwordEncode);
        } catch (DataIntegrityViolationException ex) {
            throw new MySqlException(ex.getMessage());
        }
    }

    public List<LecturerInfoDTO> getAllLecturer() {
        return lecturerRepository.getAllLecturer();
    }

    public List<LecturerInfoDTO> getLecturerOfFaculty(String facultyName) {
        try {
            return lecturerRepository.getLecturerOfFaculty(facultyName);
        } catch (DataIntegrityViolationException ex) {
            throw new MySqlException(ex.getMessage());
        }
    }
}
