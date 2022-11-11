package com.hcmut.learningsystemserverrest.service.dto;

import com.hcmut.learningsystemserverrest.domain.enumeration.SUBJECTSTATUS;

public class SubjectCreatedDTO {
    private String id;

    private String subjectName;

    private Integer creditsNo;

    private SUBJECTSTATUS subjectStatus;

    private String facultyName;

    private String lecturerID;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Integer getCreditsNo() {
        return creditsNo;
    }

    public void setCreditsNo(Integer creditsNo) {
        this.creditsNo = creditsNo;
    }

    public SUBJECTSTATUS getSubjectStatus() {
        return subjectStatus;
    }

    public void setSubjectStatus(SUBJECTSTATUS subjectStatus) {
        this.subjectStatus = subjectStatus;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public String getLecturerID() {
        return lecturerID;
    }

    public void setLecturerID(String lecturerID) {
        this.lecturerID = lecturerID;
    }
}
