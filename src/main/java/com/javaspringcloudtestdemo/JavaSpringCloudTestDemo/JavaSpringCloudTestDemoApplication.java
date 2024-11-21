package com.javaspringcloudtestdemo.JavaSpringCloudTestDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication (exclude = { DataSourceAutoConfiguration.class })
public class JavaSpringCloudTestDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaSpringCloudTestDemoApplication.class, args);
	}

}
