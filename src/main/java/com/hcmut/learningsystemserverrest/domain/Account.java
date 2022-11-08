package com.hcmut.learningsystemserverrest.domain;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "AccountT")
public class Account {
    @Id
    @Column(name = "Username", nullable = false, length = 32)
    private String username;

    @Column(name = "Password", nullable = false, length = 64)
    private String password;

    @OneToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "PersonID", referencedColumnName = "IDCard", nullable = false)
    private Person person;

    @ManyToMany
    @JoinTable(
            name = "HaveAccountRole",
            joinColumns = @JoinColumn(name = "Username", referencedColumnName = "Username", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "RoleName", referencedColumnName = "RoleName", nullable = false))
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<Role> roles = new HashSet<>();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
