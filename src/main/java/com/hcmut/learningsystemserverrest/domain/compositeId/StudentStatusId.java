package com.hcmut.learningsystemserverrest.domain.compositeId;

import com.hcmut.learningsystemserverrest.domain.enumeration.LEARNINGSTATUS;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class StudentStatusId implements Serializable {
    private static final long serialVersionUID = -6609671381939347287L;
    @Column(name = "StudentID", columnDefinition = "char(7)", nullable = false)
    private String studentID;

    @Column(name = "Semester", columnDefinition = "char(3)", nullable = false)
    private String semester;

    @Column(name = "LearningStatus", nullable = false, length = 64)
    @Enumerated(EnumType.STRING)
    private LEARNINGSTATUS learningStatus;

    @Column(name = "RegisteredCreditsNo", nullable = false)
    private Integer registeredCreditsNo;

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

    public Integer getRegisteredCreditsNo() {
        return registeredCreditsNo;
    }

    public void setRegisteredCreditsNo(Integer registeredCreditsNo) {
        this.registeredCreditsNo = registeredCreditsNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        StudentStatusId entity = (StudentStatusId) o;
        return Objects.equals(this.studentID, entity.studentID) &&
                Objects.equals(this.registeredCreditsNo, entity.registeredCreditsNo) &&
                Objects.equals(this.semester, entity.semester) &&
                Objects.equals(this.learningStatus, entity.learningStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentID, registeredCreditsNo, semester, learningStatus);
    }

}
