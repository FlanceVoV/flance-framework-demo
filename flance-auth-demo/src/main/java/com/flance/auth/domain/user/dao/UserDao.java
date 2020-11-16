package com.flance.auth.domain.user.dao;

import com.flance.auth.domain.user.entity.User;
import com.flance.jdbc.jpa.dao.BaseDao;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import java.util.Optional;

public interface UserDao extends BaseDao<User, String> {

}
