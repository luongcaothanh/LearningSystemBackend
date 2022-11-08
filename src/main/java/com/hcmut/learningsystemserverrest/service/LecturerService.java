package com.hcmut.learningsystemserverrest.service;

import com.hcmut.learningsystemserverrest.repository.LecturerRepository;
import com.hcmut.learningsystemserverrest.service.dto.LecturerInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LecturerService {
    @Autowired
    private LecturerRepository lecturerRepository;

    public LecturerInfoDTO getLecturerInfo(String personID) {
        return lecturerRepository.getLecturerInfo(personID);
    }
}
