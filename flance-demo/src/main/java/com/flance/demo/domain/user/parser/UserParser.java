package com.flance.demo.domain.user.parser;

import com.flance.demo.domain.user.model.domain.UserDo;
import com.flance.demo.domain.user.model.dto.UserDto;
import com.flance.demo.domain.user.model.po.User;
import com.flance.demo.domain.user.model.vo.UserVo;
import com.flance.jdbc.jpa.parser.BaseParser;
import org.springframework.stereotype.Component;

@Component
public class UserParser extends BaseParser<User, UserDto, UserVo, UserDo> {
}
