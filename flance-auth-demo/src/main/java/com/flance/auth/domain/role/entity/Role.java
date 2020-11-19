package com.flance.auth.domain.role.entity;

import com.flance.auth.domain.auth.entity.Auth;
import com.flance.web.auth.model.BaseAuthority;
import com.flance.web.auth.model.BaseRole;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "FLANCE_ROLE")
public class Role extends BaseRole {

    @Id
    private String id;

    private String code;

    private String name;

    @ManyToMany
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinTable(name = "FLANCE_ROLE_AUTH",
            joinColumns = @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "AUTH_ID", referencedColumnName = "ID"))
    private List<Auth> auths;

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public List<? extends BaseAuthority> getAuthorities() {
        return this.auths;
    }
}
