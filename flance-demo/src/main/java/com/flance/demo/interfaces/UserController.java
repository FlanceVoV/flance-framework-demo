package com.flance.demo.interfaces;

import com.flance.demo.domain.user.model.domain.UserDo;
import com.flance.demo.domain.user.model.dto.UserDto;
import com.flance.demo.domain.user.model.po.Role;
import com.flance.demo.domain.user.model.po.User;
import com.flance.demo.domain.user.model.vo.UserVo;
import com.flance.demo.domain.user.parser.UserParser;
import com.flance.demo.domain.user.service.UserService;
import com.flance.jdbc.jpa.web.controller.BaseWebController;
import com.flance.web.common.request.WebResponse;
import com.flance.web.common.utils.ResponseBuilder;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 复杂参数：{"EQ_object2.id":8,"ORLIKE_object2.prop1.name":"测试","ORLIKE_prop1":"测试2","ORLIKE_prop1":"测试2","AND":[["object2.prop1.name"],["prop1","prop2"],["object2.id"]],"page":1,"rows":10}
 */
@RestController
@RequestMapping("/api/user")
public class UserController extends BaseWebController<User, UserDto, UserVo, UserDo, String> {

    private UserService userService;

    private UserParser userParser;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
        super.setBaseWebDomainService(userService);
    }

    @Autowired
    public void setUserParser(UserParser userParser) {
        this.userParser = userParser;
        super.setBaseParser(userParser);
    }

    @PostMapping("/login")
    public WebResponse login(String userName, String password) {
        UserDto userDto = userService.findOneByProp("userName", userName);
        boolean loginResult = userParser.parseDto2Do(userDto).checkPassword(password);
        if (loginResult) {
            return ResponseBuilder.getSuccess(WebResponse.builder().singleResult(userParser.parseDto2Vo(userDto)).build());
        }
        return ResponseBuilder.getFail(WebResponse.builder().resultMsg("登录失败").build());
    }

    @GetMapping("/filterUserRole")
    public UserVo filterUserRole(HttpServletRequest request, String ... roleIds) {
        UserDto currentUser = getCurrentUser(request);
        UserDo userDo = userParser.parseDto2Do(currentUser);
        userDo.filterUserRoles(roleIds);
        UserDto userDto = userParser.parseDo2Dto(userDo);
        return userParser.parseDto2Vo(userDto);
    }

    @GetMapping("/batchInsertTest")
    public List<UserVo> batchInsert() {
        userService.insertBatch(getEntityManagerFactory(), getUserVoParam());
        List<User> users = userParser.parseListDto2Po(getUserVoParam());
        List<UserDto> userDtos = userParser.parseListPo2Dto(users);
        List<UserVo> userVos = userParser.parseListDto2Vo(userDtos);
        userDtos.get(0).setUserName("深拷贝验证");
        return userVos;
    }

    private UserDto getCurrentUser(HttpServletRequest request) {
        UserDto userDto = (UserDto) request.getSession().getAttribute("userDto");
        if (null == userDto) {
            userDto = new UserDto();
            userDto.setId("11111");
            List<Role> roles = new ArrayList<Role>(){{
                Role role1 = new Role();
                role1.setId("1");
                Role role2 = new Role();
                role2.setId("2");
                Role role3 = new Role();
                role3.setId("3");
                Role role4 = new Role();
                role4.setId("4");
                add(role1);
                add(role2);
                add(role3);
                add(role4);
            }};
            userDto.setRoles(roles);
        }
        request.getSession().setAttribute("userDto", userDto);
        return userDto;
    }

    private List<UserDto> getUserVoParam() {
        UserDto userDto1 = new UserDto();
        userDto1.setId("1");
        userDto1.setUserName("测试1");
        UserDto userDto2 = new UserDto();
        userDto2.setId("2");
        userDto2.setUserName("测试2");
        UserDto userDto3 = new UserDto();
        userDto3.setId("3");
        userDto3.setUserName("测试3");
        return Lists.newArrayList(userDto1, userDto2, userDto3);
    }
}
