package com.example.demo;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {	
		
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Bean
	public ExecutorService getExecutorService() {
		return Executors.newSingleThreadExecutor(); 
	}

}
