package com.hcmut.learningsystemserverrest.service;

import com.hcmut.learningsystemserverrest.controller.customException.exception.MySqlException;
import com.hcmut.learningsystemserverrest.repository.TextbookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class TextbookService {
    @Autowired
    private TextbookRepository textbookRepository;

    public void createTextbook(String id, String textbookName, String publishingHouse,
                               String publishingYear, String category, String authorName) {
        try {
            textbookRepository.createTextbook(id, textbookName, publishingHouse, publishingYear, category, authorName);
        } catch (DataIntegrityViolationException ex) {
            throw new MySqlException(ex.getMessage());
        }
    }
}
