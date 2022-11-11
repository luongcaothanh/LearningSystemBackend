package com.hcmut.learningsystemserverrest.service.dto;

import com.hcmut.learningsystemserverrest.domain.enumeration.LEARNINGSTATUS;

public class StudentStatusCreatedDTO {
    private String studentID;

    private String semester;

    private LEARNINGSTATUS learningStatus;

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public LEARNINGSTATUS getLearningStatus() {
        return learningStatus;
    }

    public void setLearningStatus(LEARNINGSTATUS learningStatus) {
        this.learningStatus = learningStatus;
    }
}
