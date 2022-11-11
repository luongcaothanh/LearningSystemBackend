package com.hcmut.learningsystemserverrest.service.dto;

public class SubclassCreatedDTO {
    private String id;

    private String csemester;

    private String cYear;

    private String cType;

    private String csubjectID;

    private String lecturerID;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCsemester() {
        return csemester;
    }

    public void setCsemester(String csemester) {
        this.csemester = csemester;
    }

    public String getcYear() {
        return cYear;
    }

    public void setcYear(String cYear) {
        this.cYear = cYear;
    }

    public String getcType() {
        return cType;
    }

    public void setcType(String cType) {
        this.cType = cType;
    }

    public String getCsubjectID() {
        return csubjectID;
    }

    public void setCsubjectID(String csubjectID) {
        this.csubjectID = csubjectID;
    }

    public String getLecturerID() {
        return lecturerID;
    }

    public void setLecturerID(String lecturerID) {
        this.lecturerID = lecturerID;
    }
}
