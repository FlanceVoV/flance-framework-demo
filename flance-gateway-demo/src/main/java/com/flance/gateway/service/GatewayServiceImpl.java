package com.flance.gateway.service;

import com.flance.web.gateway.handler.ResponseHandler;
import com.flance.web.gateway.service.GatewayService;

import com.flance.web.utils.feign.response.FeignResponse;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 实现网关鉴权自定义业务逻辑
 * 可以定义鉴权成功、失败后的逻辑
 * 可以包装参数，加解密参数等
 * @author jhf
 */
@Service
public class GatewayServiceImpl implements GatewayService {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain, FeignResponse response) {
        System.out.println("自定义业务逻辑：[" + response.toString() + "]");
        if (!response.getSuccess()) {
            return ResponseHandler.setResponse(response, exchange);
        }
        return chain.filter(exchange);
    }
}
