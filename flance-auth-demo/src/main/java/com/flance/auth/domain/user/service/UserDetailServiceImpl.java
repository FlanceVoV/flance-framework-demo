package com.flance.auth.domain.user.service;

import com.flance.auth.domain.user.dao.UserDao;
import com.flance.auth.domain.user.entity.User;
import com.flance.web.security.service.SecurityUserDetailsService;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.criteria.*;
import java.util.Optional;

@Service
public class UserDetailServiceImpl implements SecurityUserDetailsService<User> {

    @Resource
    UserDao userDao;

    @Override
    public User getUserByUserName(String userName) {
        User user = new User();
        user.setUsername(userName);
        Optional<User> optional = userDao.findOne(getUsernameSpecification(userName));
        return optional.orElse(null);
    }

    @Override
    public User getUserByUserId(String userId) {
        return userDao.getOne(userId);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = new User();
        user.setUsername(s);
        Optional<User> optional = userDao.findOne(getUsernameSpecification(s));
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new UsernameNotFoundException("找不到用户！[" + s + "]");
        }
    }

    private Specification<User> getUsernameSpecification(String username) {
        return (Specification<User>) (root, criteriaQuery, criteriaBuilder) -> {
            //1.获取比较的属性
            //查询的式属性名，不是表的字段名
            Path<Object> queryUsername = root.get("username");
            //2.构造查询条件 ： select * from user where username = :username
            /**
             * 第一个参数：需要比较的属性（path对象）
             * 第二个参数：当前需要比较的取值
             */
            Predicate predicate = criteriaBuilder.equal(queryUsername, username);
            return predicate;
        };
    }
}
