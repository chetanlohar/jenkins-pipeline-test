package io.brainstorm.jenkinspipelinetest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"io.brainstorm"})
public class JenkinsPipelineTestApplication {
	public static void main(String[] args) {
		SpringApplication.run(JenkinsPipelineTestApplication.class, args);
	}
}
