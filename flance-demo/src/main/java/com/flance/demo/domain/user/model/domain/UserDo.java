package com.flance.demo.domain.user.model.domain;

import com.flance.demo.domain.user.model.po.Role;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户bo
 * 领域对象，处理业务逻辑
 * @author jhf
 */
@Data
public class UserDo {

    private String id;

    private String userName;

    private String password;

    private List<Role> roles;

    public void filterUserRoles(String ... roleIds) {
        List<Role> result = new ArrayList<>();
        if (null != roles && null != roleIds) {
            Arrays.asList(roleIds).forEach(roleId -> result.addAll(roles.stream().parallel().filter(role -> role.getId().equals(roleId)).collect(Collectors.toList())));
            setRoles(result);
        }
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

}
