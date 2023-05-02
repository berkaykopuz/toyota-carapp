package com.toyota.carapp;

import com.toyota.carapp.log.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class CarappApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarappApplication.class, args);
		Log.logWarning("application is starting..");
	}

}
