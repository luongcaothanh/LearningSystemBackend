package com.hcmut.learningsystemserverrest.domain;

import com.hcmut.learningsystemserverrest.domain.compositeId.PersonPhoneId;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "PersonPhone")
public class PersonPhone {
    @EmbeddedId
    private PersonPhoneId personPhoneId;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "PersonID", referencedColumnName = "IDCard", insertable = false, updatable = false)
    private Person person;

    public PersonPhoneId getPersonPhoneId() {
        return personPhoneId;
    }

    public void setPersonPhoneId(PersonPhoneId personPhoneId) {
        this.personPhoneId = personPhoneId;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
