package com.hcmut.learningsystemserverrest.domain;

import com.hcmut.learningsystemserverrest.domain.enumeration.SUBJECTSTATUS;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "SubjectT")
public class Subject {
    @Id
    @Column(name = "ID", columnDefinition = "char(6)", nullable = false)
    private String id;

    @Column(name = "SubjectName", nullable = false, length = 64)
    private String subjectName;

    @Column(name = "CreditsNo", nullable = false)
    private Integer creditsNo;

    @Column(name = "SubjectStatus", nullable = false, length = 16)
    @Enumerated(EnumType.STRING)
    private SUBJECTSTATUS subjectStatus;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "FacultyName", referencedColumnName = "FacultyName", nullable = false)
    private Faculty faculty;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "LecturerID", referencedColumnName = "EmployeeID", nullable = false)
    private Lecturer lecturer;

    @ManyToMany
    @JoinTable(
            name = "PrerequisiteSubject",
            joinColumns = @JoinColumn(name = "SubjectID", referencedColumnName = "ID", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "PreSubjectID", referencedColumnName = "ID", nullable = false))
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<Subject> subjects = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "HaveSubjectTextbook",
            joinColumns = @JoinColumn(name = "SubjectID", referencedColumnName = "ID", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "TextbookID", referencedColumnName = "ID", nullable = false))
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<Textbook> textbooks = new HashSet<>();

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

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }

    public Set<Textbook> getTextbooks() {
        return textbooks;
    }

    public void setTextbooks(Set<Textbook> textbooks) {
        this.textbooks = textbooks;
    }
}
