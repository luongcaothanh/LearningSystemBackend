package com.hcmut.learningsystemserverrest.service.dto;

import com.hcmut.learningsystemserverrest.domain.enumeration.LEARNINGSTATUS;

public interface StudentStatusDTO {
    String getStudentID();

    String getSemester();

    LEARNINGSTATUS getLearningStatus();

    Integer getRegisteredCreditsNo();
}
