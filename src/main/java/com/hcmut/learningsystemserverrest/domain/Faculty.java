package com.hcmut.learningsystemserverrest.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Faculty")
public class Faculty {
    @Id
    @Column(name = "FacultyName", nullable = false, length = 64)
    private String facultyName;

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }
}
