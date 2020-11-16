package com.flance.demo.domain.user.model.po;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 权限
 * @author jhf
 */
@Data
@Entity
@Table(name = "DEMO_AUTH")
public class Auth {

    @Id
    private String id;

}
