package com.flance.gateway.client;

import com.flance.gateway.client.fallback.GatewayAuthClientFallBack;
import com.flance.web.gateway.client.UserResourceClient;
import com.flance.web.utils.feign.request.FeignRequest;
import com.flance.web.utils.feign.response.FeignResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户资源服务接口
 * @author jhf
 */
@FeignClient(name = "flance-auth", contextId = "userResource", path = "/api/user", fallbackFactory = GatewayAuthClientFallBack.class)
public interface GatewayUserResourceClient extends UserResourceClient {

}
