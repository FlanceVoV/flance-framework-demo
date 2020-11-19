package com.flance.gateway.client.fallback;

import com.flance.web.gateway.client.AuthClient;
import com.flance.web.gateway.client.UserResourceClient;
import com.flance.web.gateway.client.fallback.AuthClientFallBack;
import com.flance.web.gateway.client.fallback.UserResourceClientFallBack;
import feign.hystrix.FallbackFactory;

/**
 * authClient fallback，可以继承
 * @author jhf
 */
public class GatewayUserResourceClientFallBack extends UserResourceClientFallBack implements FallbackFactory<UserResourceClient> {


}
