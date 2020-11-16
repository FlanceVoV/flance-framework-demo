package com.flance.demo.domain.user.service;

import com.flance.demo.domain.user.model.dto.UserDto;
import com.flance.demo.domain.user.model.po.User;
import com.flance.jdbc.jpa.page.PageResponse;
import com.flance.jdbc.jpa.web.service.IBaseWebDomainService;
import com.flance.web.common.service.IService;

public interface UserService extends IBaseWebDomainService<User, UserDto, String> {

}
