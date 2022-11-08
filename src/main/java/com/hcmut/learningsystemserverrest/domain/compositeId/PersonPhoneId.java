package com.hcmut.learningsystemserverrest.domain.compositeId;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PersonPhoneId implements Serializable {
    private static final long serialVersionUID = 4738132759077272959L;
    @Column(name = "PersonID", nullable = false, length = 16)
    private String personID;

    @Column(name = "PhoneNumber", nullable = false, length = 16)
    private String phoneNumber;

    public String getPersonID() {
        return personID;
    }

    public void setPersonID(String personID) {
        this.personID = personID;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PersonPhoneId entity = (PersonPhoneId) o;
        return Objects.equals(this.phoneNumber, entity.phoneNumber) &&
                Objects.equals(this.personID, entity.personID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phoneNumber, personID);
    }

}
