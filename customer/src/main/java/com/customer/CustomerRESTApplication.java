package com.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableConfigServer
public class CustomerRESTApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerRESTApplication.class, args);
    }
}
