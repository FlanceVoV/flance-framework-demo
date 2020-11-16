package com.flance.demo.domain.user.service.impl;

import com.flance.demo.domain.user.model.domain.UserDo;
import com.flance.demo.domain.user.model.dto.UserDto;
import com.flance.demo.domain.user.model.po.User;
import com.flance.demo.domain.user.model.vo.UserVo;
import com.flance.demo.domain.user.parser.UserParser;
import com.flance.demo.domain.user.repository.UserDao;
import com.flance.demo.domain.user.service.UserService;
import com.flance.jdbc.jpa.web.service.BaseWebDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 用户domainService
 * @author jhf
 */
@Service
public class UserServiceImpl extends BaseWebDomainService<User, UserDto, UserVo, UserDo, String> implements UserService {

    private UserParser userParser;

    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        super.setBaseDao(userDao);
        this.userDao = userDao;
    }

    @Autowired
    public void setUserParser(UserParser userParser) {
        this.userParser = userParser;
        super.setBaseParser(userParser);
    }
}
