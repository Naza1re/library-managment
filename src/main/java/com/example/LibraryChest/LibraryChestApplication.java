package com.example.LibraryChest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.example.LibraryChest.Model")
public class LibraryChestApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryChestApplication.class, args);
	}

}
