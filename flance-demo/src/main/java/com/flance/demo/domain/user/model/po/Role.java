package com.flance.demo.domain.user.model.po;

import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.List;

/**
 * 角色
 * @author jhf
 */
@Data
@Entity
@Table(name = "DEMO_ROLE")
public class Role {

    @Id
    private String id;

    @ManyToMany
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinTable(name = "DEMO_ROLE_AUTH",
            joinColumns = @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "AUTH_ID", referencedColumnName = "ID"))
    private List<Auth> auths;

}
