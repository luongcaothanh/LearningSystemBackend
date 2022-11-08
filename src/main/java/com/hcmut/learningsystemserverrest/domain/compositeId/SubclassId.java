package com.hcmut.learningsystemserverrest.domain.compositeId;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SubclassId implements Serializable {
    private static final long serialVersionUID = -5251260470008369817L;
    @Column(name = "ID", nullable = false, length = 8)
    private String id;

    @Column(name = "CSemester", columnDefinition = "char(3)", nullable = false)
    private String cSemester;

    @Column(name = "CYear", nullable = false, length = 32)
    private String cYear;

    @Column(name = "CType", nullable = false, length = 32)
    private String cType;

    @Column(name = "CSubjectID", columnDefinition = "char(6)", nullable = false)
    private String cSubjectID;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCSemester() {
        return cSemester;
    }

    public void setCSemester(String cSemester) {
        this.cSemester = cSemester;
    }

    public String getCYear() {
        return cYear;
    }

    public void setCYear(String cYear) {
        this.cYear = cYear;
    }

    public String getCType() {
        return cType;
    }

    public void setCType(String cType) {
        this.cType = cType;
    }

    public String getCSubjectID() {
        return cSubjectID;
    }

    public void setCSubjectID(String cSubjectID) {
        this.cSubjectID = cSubjectID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        SubclassId entity = (SubclassId) o;
        return Objects.equals(this.cType, entity.cType) &&
                Objects.equals(this.cSubjectID, entity.cSubjectID) &&
                Objects.equals(this.cSemester, entity.cSemester) &&
                Objects.equals(this.id, entity.id) &&
                Objects.equals(this.cYear, entity.cYear);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cType, cSubjectID, cSemester, id, cYear);
    }

}
