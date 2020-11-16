package com.flance.demo.domain.user.model.vo;

import com.flance.demo.domain.user.model.po.Role;
import lombok.Data;

import java.util.List;

@Data
public class UserVo {

    private String id;

    private String userName;

    private String password;

    private List<Role> roles;

}
