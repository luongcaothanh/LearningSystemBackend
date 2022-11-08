package com.hcmut.learningsystemserverrest.service;

import com.hcmut.learningsystemserverrest.repository.EmployeeRepository;
import com.hcmut.learningsystemserverrest.service.dto.EmployeeInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<EmployeeInfoDTO> getAllEmployee() {
        return employeeRepository.getAllEmployee();
    }
}
