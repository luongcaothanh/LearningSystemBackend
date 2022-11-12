package com.hcmut.learningsystemserverrest.service.dto;

import com.hcmut.learningsystemserverrest.domain.enumeration.GENDER;

import java.time.LocalDate;

public interface StudentInfoDTO {
    String getIdCard();

    GENDER getGender();

    String getfName();

    String getlName();

    LocalDate getDoB();

    String getEmail();

    String getStudentID();

    String getAdmissionYear();

    String getFacultyName();
}
