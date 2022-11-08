package com.hcmut.learningsystemserverrest.domain;

import com.hcmut.learningsystemserverrest.domain.enumeration.ROLE;

import javax.persistence.*;

@Entity
@Table(name = "RoleT")
public class Role {
    @Id
    @Column(name = "RoleName", nullable = false, length = 32)
    @Enumerated(EnumType.STRING)
    private ROLE roleName;

    public ROLE getRoleName() {
        return roleName;
    }

    public void setRoleName(ROLE roleName) {
        this.roleName = roleName;
    }
}
