package com.hcmut.learningsystemserverrest.domain;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "AAOEmployee")
public class AAOEmployee {
    @Id
    @Column(name = "EmployeeID", columnDefinition = "char(10)", nullable = false)
    private String employeeID;

    @OneToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "EmployeeID", referencedColumnName = "EmployeeID")
    @MapsId("employeeID")
    private Employee employee;

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
