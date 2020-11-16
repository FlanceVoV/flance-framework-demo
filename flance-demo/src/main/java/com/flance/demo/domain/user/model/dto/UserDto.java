package com.flance.demo.domain.user.model.dto;

import com.flance.demo.domain.user.model.po.Role;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {

    private String id;

    private String userName;

    private String password;

    private List<Role> roles;

}
