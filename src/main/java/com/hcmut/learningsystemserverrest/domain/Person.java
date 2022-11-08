package com.hcmut.learningsystemserverrest.domain;

import com.hcmut.learningsystemserverrest.domain.enumeration.GENDER;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Person")
public class Person {
    @Id
    @Column(name = "IDCard", nullable = false, length = 16)
    private String idCard;

    @Column(name = "Gender", nullable = false, length = 16)
    @Enumerated(EnumType.STRING)
    private GENDER gender;

    @Column(name = "FName", nullable = false, length = 16)
    private String fName;

    @Column(name = "LName", nullable = false, length = 64)
    private String lName;

    @Column(name = "DoB", nullable = false)
    private LocalDate doB;

    @Column(name = "Email", length = 64)
    private String email;

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public GENDER getGender() {
        return gender;
    }

    public void setGender(GENDER gender) {
        this.gender = gender;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public LocalDate getDoB() {
        return doB;
    }

    public void setDoB(LocalDate doB) {
        this.doB = doB;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
