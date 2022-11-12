package com.hcmut.learningsystemserverrest.service.dto;

import com.hcmut.learningsystemserverrest.domain.enumeration.GENDER;

import java.time.LocalDate;

public interface StudentOfSubclassDTO {
    String getSCID();

    String getSCSemester();

    String getSCYear();

    String getSCType();

    String getSCSubjectID();

    String getStudentID();

    String getFullName();

    GENDER getGender();

    LocalDate getDoB();

    String getEmail();

    String getFacultyName();
}
