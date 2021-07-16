package com.wpn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

//ensure that we can this app from tomcat
@SpringBootApplication
public class SpringOauth2RestMongoApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SpringOauth2RestMongoApplication.class, args);
	}

}
