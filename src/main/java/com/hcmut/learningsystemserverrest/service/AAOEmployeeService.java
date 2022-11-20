package com.hcmut.learningsystemserverrest.service;

import com.hcmut.learningsystemserverrest.controller.customException.exception.MySqlException;
import com.hcmut.learningsystemserverrest.domain.enumeration.GENDER;
import com.hcmut.learningsystemserverrest.repository.AAOEmployeeRepository;
import com.hcmut.learningsystemserverrest.service.dto.EmployeeCreatedDTO;
import com.hcmut.learningsystemserverrest.service.dto.EmployeeInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AAOEmployeeService {
    @Autowired
    private AAOEmployeeRepository aaoEmployeeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public EmployeeInfoDTO getAAOInfo(String personID) {
        return aaoEmployeeRepository.getAAOInfo(personID);
    }

    public EmployeeCreatedDTO createAAOEmployee(String idCard, GENDER gender, String fName,
                                                String lName, LocalDate doB, String email,
                                                String employeeID, String facultyName,
                                                String username, String password){
        try {
            String passwordEncode = passwordEncoder.encode(password);

            return aaoEmployeeRepository.createAAOEmployee(idCard, gender.toString(), fName, lName,  doB,  email,
                    employeeID,  facultyName, username,  passwordEncode);
        } catch (DataIntegrityViolationException ex) {
            throw new MySqlException(ex.getMessage());
        }
    }

    public List<EmployeeInfoDTO> getAllAAOEmployee() {
        return aaoEmployeeRepository.getAllAAOEmployee();
    }
}
