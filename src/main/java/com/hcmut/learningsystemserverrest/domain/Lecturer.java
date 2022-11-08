package com.hcmut.learningsystemserverrest.domain;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "Lecturer")
public class Lecturer {
    @Id
    @Column(name = "EmployeeID", columnDefinition = "char(10)",nullable = false)
    private String employeeID;

    @OneToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "EmployeeID", referencedColumnName = "EmployeeID")
    @MapsId("employeeID")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "ManagerID", referencedColumnName = "EmployeeID")
    private Manager manager;

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

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
}
