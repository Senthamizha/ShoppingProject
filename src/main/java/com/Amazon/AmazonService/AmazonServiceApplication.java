package com.Amazon.AmazonService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(scanBasePackages =  "com.Amazon",exclude = HibernateJpaAutoConfiguration.class)
public class AmazonServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmazonServiceApplication.class, args);
	}

}
