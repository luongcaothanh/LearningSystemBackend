package com.hcmut.learningsystemserverrest.domain;

import javax.persistence.*;

@Entity
@Table(name = "RoleT")
public class Role {
    @Id
    @Column(name = "RoleName", nullable = false, length = 32)
    private String roleName;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return this.roleName;
    }
}
