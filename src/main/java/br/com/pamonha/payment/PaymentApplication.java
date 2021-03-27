package br.com.pamonha.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class PaymentApplication {
     public static boolean flag = true;

	public static void main(String[] args) {
		SpringApplication.run(PaymentApplication.class, args);
	}


}
/*
docker-compose up -d --build
docker-compose down
*/