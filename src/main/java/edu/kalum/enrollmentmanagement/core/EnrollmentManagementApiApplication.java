package edu.kalum.enrollmentmanagement.core;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EnrollmentManagementApiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EnrollmentManagementApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.print("Servicio levando en el puerto 9080");
	}
}
