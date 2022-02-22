package com.elo7.explorandomarteapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ExplorandoMarteApiApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ExplorandoMarteApiApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ExplorandoMarteApiApplication.class, args);
	}

}
