package com.flance.demo.domain.user.model.po;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.List;

/**
 * 用户
 * @author jhf
 */
@Data
@Entity
@Table(name = "DEMO_USER")
@DynamicInsert
@DynamicUpdate
public class User {

    @Id
    private String id;

    private String userName;

    private String password;

    @ManyToMany
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinTable(name = "DEMO_USER_ROLE",
            joinColumns = @JoinColumn(name = "USER_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID"))
    private List<Role> roles;

}
