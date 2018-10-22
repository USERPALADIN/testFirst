package com.finch.demo;

import com.finch.demo.initializer.DataInitializer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication     {

	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean(initMethod = "init")
	public DataInitializer initializer() {
		return new DataInitializer();
	}
}
