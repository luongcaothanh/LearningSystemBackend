package com.hcmut.learningsystemserverrest.service.dto;

public class AttendSubclassCreatedDTO {
    private String studentID;

    private String scid;

    private String scSemester;

    private String scYear;

    private String scType;

    private String scSubjectID;

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getScid() {
        return scid;
    }

    public void setScid(String scid) {
        this.scid = scid;
    }

    public String getScSemester() {
        return scSemester;
    }

    public void setScSemester(String scSemester) {
        this.scSemester = scSemester;
    }

    public String getScYear() {
        return scYear;
    }

    public void setScYear(String scYear) {
        this.scYear = scYear;
    }

    public String getScType() {
        return scType;
    }

    public void setScType(String scType) {
        this.scType = scType;
    }

    public String getScSubjectID() {
        return scSubjectID;
    }

    public void setScSubjectID(String scSubjectID) {
        this.scSubjectID = scSubjectID;
    }
}
