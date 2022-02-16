package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication//(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan(value = {"com.ttl"})
@EnableTransactionManagement
public class LibraryFirstVarApplication {
	public static void main(String[] args) {
		SpringApplication.run(LibraryFirstVarApplication.class, args);
	}
}