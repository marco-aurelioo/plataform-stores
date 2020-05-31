package com.platform.configservercustomer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServerCustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerCustomerApplication.class, args);
	}

}
