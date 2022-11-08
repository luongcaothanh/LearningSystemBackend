package com.hcmut.learningsystemserverrest.domain;

import com.hcmut.learningsystemserverrest.domain.compositeId.ClassId;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "Class")
public class Class {
    @EmbeddedId
    private ClassId classId;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "SubjectID", referencedColumnName = "ID", insertable = false, updatable = false)
    private Subject subject;

    public ClassId getClassId() {
        return classId;
    }

    public void setClassId(ClassId classId) {
        this.classId = classId;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
