package com.hcmut.learningsystemserverrest.controller;

import com.hcmut.learningsystemserverrest.repository.EmployeeRepository;
import com.hcmut.learningsystemserverrest.service.dto.EmployeeInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/employee")
    public List<EmployeeInfoDTO> getAllEmployee() {
        return employeeRepository.getAllEmployee();
    }
}
