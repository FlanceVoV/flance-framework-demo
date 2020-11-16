package com.flance.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 用户中心（认证服务器 + 用户资源服务器）
 * 此demo把认证服务和用户服务合并在一起作为用户中心服务器，可以分离。
 * 此demo jpa-web模块为简化用法
 * @author jhf
 */
@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(value = "com.flance")
public class AuthApplication {

    public static void main(String[] args) {
        createClientSecret();
        SpringApplication.run(AuthApplication.class, args);
//        RsaUtil.generateKeyPair("flance.public", "flance.private");
    }

    private static void createClientSecret() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("123456"));
    }

}
