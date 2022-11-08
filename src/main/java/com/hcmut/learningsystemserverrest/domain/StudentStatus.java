package com.hcmut.learningsystemserverrest.domain;

import com.hcmut.learningsystemserverrest.domain.compositeId.StudentStatusId;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "StudentStatus")
public class StudentStatus {
    @EmbeddedId
    private StudentStatusId studentStatusId;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "StudentID", referencedColumnName = "StudentID", insertable = false, updatable = false)
    private Student student;

    public StudentStatusId getStudentStatusId() {
        return studentStatusId;
    }

    public void setStudentStatusId(StudentStatusId studentStatusId) {
        this.studentStatusId = studentStatusId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
