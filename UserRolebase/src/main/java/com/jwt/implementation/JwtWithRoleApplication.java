package com.jwt.implementation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;



@SpringBootApplication
@EnableDiscoveryClient

public class JwtWithRoleApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtWithRoleApplication.class, args);
	}

}
