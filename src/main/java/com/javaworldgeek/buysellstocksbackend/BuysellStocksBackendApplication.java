package com.javaworldgeek.buysellstocksbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class BuysellStocksBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BuysellStocksBackendApplication.class, args);
	}

}
