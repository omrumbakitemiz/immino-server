package com.yazlab2proje1.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);

		Utilities utilities = new Utilities();

		try {
            utilities.GetLatLong();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
