package com.flance.gateway.client;

import com.flance.gateway.client.fallback.GatewayAuthClientFallBack;
import com.flance.web.gateway.client.AuthClient;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "flance-auth", path = "/permission", fallbackFactory = GatewayAuthClientFallBack.class)
public interface GatewayAuthClient extends AuthClient {

}
