package com.hcmut.learningsystemserverrest.service.dto;

import com.hcmut.learningsystemserverrest.domain.enumeration.SUBJECTSTATUS;

public interface SubjectDTO {
    String getID();

    String getSubjectName();

    Integer getCreditsNo();

    SUBJECTSTATUS getSubjectStatus();

    String getFacultyName();

    String getLecturerName();
}
