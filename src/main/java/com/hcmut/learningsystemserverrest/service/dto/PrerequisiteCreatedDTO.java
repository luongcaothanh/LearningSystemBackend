package com.hcmut.learningsystemserverrest.service.dto;

public class PrerequisiteCreatedDTO {
    private String subjectID;

    private String preSubjectID;

    public String getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(String subjectID) {
        this.subjectID = subjectID;
    }

    public String getPreSubjectID() {
        return preSubjectID;
    }

    public void setPreSubjectID(String preSubjectID) {
        this.preSubjectID = preSubjectID;
    }
}
