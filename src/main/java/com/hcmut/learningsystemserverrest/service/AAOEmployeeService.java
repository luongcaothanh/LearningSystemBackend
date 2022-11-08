package com.hcmut.learningsystemserverrest.service;

import com.hcmut.learningsystemserverrest.repository.AAOEmployeeRepository;
import com.hcmut.learningsystemserverrest.service.dto.EmployeeInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AAOEmployeeService {
    @Autowired
    private AAOEmployeeRepository aaoEmployeeRepository;

    public EmployeeInfoDTO getAAOInfo(String personID) {
        return aaoEmployeeRepository.getAAOInfo(personID);
    }
}
