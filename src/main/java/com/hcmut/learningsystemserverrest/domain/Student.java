package com.hcmut.learningsystemserverrest.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Student")
public class Student {
    @Id
    @Column(name = "StudentID", columnDefinition="char(7)", nullable = false)
    private String studentID;

    @Column(name = "AdmissionYear", columnDefinition="char(4)", nullable = false)
    private String admissionYear;

    @OneToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "PersonID", referencedColumnName = "IDCard", nullable = false)
    private Person person;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "FacultyName", referencedColumnName = "FacultyName", nullable = false)
    private Faculty faculty;

    @ManyToMany
    @JoinTable(
            name = "AttendStudentSubclass",
            joinColumns = @JoinColumn(name = "StudentID"),
            inverseJoinColumns = {
                    @JoinColumn(name = "SCID", referencedColumnName = "ID", nullable = false),
                    @JoinColumn(name = "SCSemester", referencedColumnName = "CSemester", nullable = false),
                    @JoinColumn(name = "SCYear", referencedColumnName = "CYear", nullable = false),
                    @JoinColumn(name = "SCType", referencedColumnName = "CType", nullable = false),
                    @JoinColumn(name = "SCSubjectID", referencedColumnName = "CSubjectID", nullable = false)
            })
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Set<Subclass> subclasses = new HashSet<>();

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getAdmissionYear() {
        return admissionYear;
    }

    public void setAdmissionYear(String admissionYear) {
        this.admissionYear = admissionYear;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Set<Subclass> getSubclasses() {
        return subclasses;
    }

    public void setSubclasses(Set<Subclass> subclasses) {
        this.subclasses = subclasses;
    }
}
