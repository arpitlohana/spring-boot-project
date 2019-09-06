package com.example1.simplemavenproject1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.simple_maven_project.App;


@SpringBootApplication
public class SimpleMavenProject1Application {
	
	@Bean
	public App getApps() {
		return new App();
	}

	public static void main(String[] args) {
		SpringApplication.run(SimpleMavenProject1Application.class, args);
	}

}
