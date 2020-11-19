package com.flance.auth.domain.user.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.flance.auth.domain.role.entity.Role;
import com.flance.web.auth.model.BaseRole;
import com.flance.web.auth.model.BaseUser;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Table(name = "FLANCE_USER")
@Entity
@Data
@DynamicInsert
@DynamicUpdate
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class User extends BaseUser {

    @Id
    private String id;

    private String username;

    private String password;

    /** 身份证号 **/
    private String idNo;

    private Boolean accountNonExpired;

    private Boolean accountNonLocked;

    private Boolean credentialsNonExpired;

    private Boolean enabled;

    @ManyToMany(fetch=FetchType.EAGER)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinTable(name = "FLANCE_USER_ROLE",
            joinColumns = @JoinColumn(name = "USER_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID"))
    private List<Role> roles;

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public List<? extends BaseRole> getRoles() {
        return this.roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return super.getAllAuthorities();
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
