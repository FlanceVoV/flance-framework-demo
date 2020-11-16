package com.flance.auth.interfaces;

import com.flance.auth.domain.user.entity.User;
import com.flance.web.auth.utils.TokenUtils;
import com.flance.web.common.request.WebResponse;
import com.flance.web.common.utils.ResponseBuilder;
import com.flance.web.security.service.SecurityUserDetailsService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 用户信息接口
 * @author jhf
 */
@RestController
@RequestMapping("/api/user")
public class UserInfoController {

    @Resource
    SecurityUserDetailsService<User> securityUserDetailsService;


    @GetMapping("/userInfo")
    public WebResponse getUserInfo(HttpServletRequest request) {
        String token = TokenUtils.getTokenByRequest(request);
        if (StringUtils.isEmpty(token)) {
            return ResponseBuilder.getFail(WebResponse.builder().resultMsg("无法获取token！").build());
        }
        try {
            if (TokenUtils.isExp(token)) {
                return ResponseBuilder.getFail(WebResponse.builder().resultMsg("token已经过期！").build());
            }
            Map<String, Object> map = TokenUtils.decode(token);
            String userId = map.get("id").toString();
            User user = securityUserDetailsService.getUserByUserId(userId);
            return ResponseBuilder.getSuccess(WebResponse.builder().singleResult(user).build());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBuilder.getFail(WebResponse.builder().resultMsg("token解析失败！[ " +e.getMessage() + "]").build());
        }
    }


}
