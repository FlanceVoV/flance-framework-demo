package com.flance.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(basePackages = {"com.flance"})
@EnableJpaRepositories(basePackages = {"com.flance.demo.domain","com.flance.components.fastdfs.domain","com.flance.components.form.domain"})
@EntityScan(basePackages = {"com.flance.demo.domain","com.flance.components.fastdfs.domain","com.flance.components.form.domain"})
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
