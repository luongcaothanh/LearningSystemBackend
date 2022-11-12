package com.hcmut.learningsystemserverrest.service.dto;

import com.hcmut.learningsystemserverrest.domain.enumeration.SUBJECTSTATUS;

public interface ClassDTO {
    String getSemester();

    String getClassYear();

    String getClassType();

    String getSubjectID();

    String getSubjectName();

    Integer getCreditsNo();

    SUBJECTSTATUS getSubjectStatus();

    String getFacultyName();

    String getLecturerID();
}
