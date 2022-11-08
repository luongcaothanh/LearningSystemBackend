package com.hcmut.learningsystemserverrest.service;

import com.hcmut.learningsystemserverrest.repository.ManagerRepository;
import com.hcmut.learningsystemserverrest.service.dto.EmployeeInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerService {
    @Autowired
    private ManagerRepository managerRepository;

    public EmployeeInfoDTO getManagerInfo(String personID) {
        return managerRepository.getManagerInfo(personID);
    }
}
