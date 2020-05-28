package com.platform.routing;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class RoutingServiceCustomerApplication {

	public static void main(String[] args) {

		new SpringApplicationBuilder(RoutingServiceCustomerApplication.class)
				//.web(WebApplicationType.REACTIVE)
				.run(args);
	}

}
