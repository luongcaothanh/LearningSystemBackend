package com.hcmut.learningsystemserverrest.domain;

import com.hcmut.learningsystemserverrest.domain.compositeId.SubclassId;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "SubClass")
public class Subclass {
    @EmbeddedId
    private SubclassId subclassId;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "CSemester", referencedColumnName = "Semester", insertable = false, updatable = false),
            @JoinColumn(name = "CYear", referencedColumnName = "ClassYear", insertable = false, updatable = false),
            @JoinColumn(name = "CType", referencedColumnName = "ClassType", insertable = false, updatable = false),
            @JoinColumn(name = "CSubjectID", referencedColumnName = "SubjectID", insertable = false, updatable = false)
    })
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Class aClass;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "LecturerID", referencedColumnName = "EmployeeID", nullable = false)
    private Lecturer lecturer;

    public SubclassId getSubclassId() {
        return subclassId;
    }

    public void setSubclassId(SubclassId subclassId) {
        this.subclassId = subclassId;
    }

    public Class getaClass() {
        return aClass;
    }

    public void setaClass(Class aClass) {
        this.aClass = aClass;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }
}
