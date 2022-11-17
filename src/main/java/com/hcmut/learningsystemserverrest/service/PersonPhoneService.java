package com.hcmut.learningsystemserverrest.service;

import com.hcmut.learningsystemserverrest.controller.customException.exception.MySqlException;
import com.hcmut.learningsystemserverrest.repository.PersonPhoneRepository;
import com.hcmut.learningsystemserverrest.service.dto.PersonPhoneDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class PersonPhoneService {
    @Autowired
    private PersonPhoneRepository personPhoneRepository;

    public void createPersonPhone(String personID, String phoneNumber) {
        try {
            personPhoneRepository.createPersonPhone(personID, phoneNumber);
        } catch (DataIntegrityViolationException ex) {
            throw new MySqlException(ex.getMessage());
        }
    }

    public PersonPhoneDTO getPersonPhone(String personID) {
        return personPhoneRepository.getPersonPhone(personID);
    }
}
