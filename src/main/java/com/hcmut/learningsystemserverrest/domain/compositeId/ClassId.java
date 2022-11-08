package com.hcmut.learningsystemserverrest.domain.compositeId;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ClassId implements Serializable {
    private static final long serialVersionUID = -6573344168441934714L;
    @Column(name = "Semester", columnDefinition = "char(3)", nullable = false)
    private String semester;

    @Column(name = "ClassYear", nullable = false, length = 32)
    private String classYear;

    @Column(name = "ClassType", nullable = false, length = 32)
    private String classType;

    @Column(name = "SubjectID", columnDefinition = "char(6)", nullable = false)
    private String subjectID;

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getClassYear() {
        return classYear;
    }

    public void setClassYear(String classYear) {
        this.classYear = classYear;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public String getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(String subjectID) {
        this.subjectID = subjectID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ClassId entity = (ClassId) o;
        return Objects.equals(this.semester, entity.semester) &&
                Objects.equals(this.classYear, entity.classYear) &&
                Objects.equals(this.classType, entity.classType) &&
                Objects.equals(this.subjectID, entity.subjectID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(semester, classYear, classType, subjectID);
    }

}
