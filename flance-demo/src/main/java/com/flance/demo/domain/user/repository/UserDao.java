package com.flance.demo.domain.user.repository;

import com.flance.demo.domain.user.model.po.User;
import com.flance.jdbc.jpa.dao.BaseDao;
import org.springframework.stereotype.Repository;

/**
 * 用户dao
 * @author jhf
 */
@Repository
public interface UserDao extends BaseDao<User, String> {
}
