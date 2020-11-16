package com.flance.gateway.client.fallback;

import com.flance.web.gateway.client.AuthClient;
import com.flance.web.gateway.client.fallback.AuthClientFallBack;
import feign.hystrix.FallbackFactory;

/**
 * authClient fallback，可以继承
 * @author jhf
 */
public class GatewayAuthClientFallBack extends AuthClientFallBack implements FallbackFactory<AuthClient> {


}
