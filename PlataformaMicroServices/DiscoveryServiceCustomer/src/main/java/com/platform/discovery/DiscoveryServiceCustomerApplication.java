package com.platform.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@SpringBootApplication
@EnableEurekaServer
public class DiscoveryServiceCustomerApplication {

	public static void main(final String[] args) {
		
		 new SpringApplicationBuilder(DiscoveryServiceCustomerApplication.class)
        	//.web(WebApplicationType.REACTIVE)
        	.run(args);
		
	}

}
