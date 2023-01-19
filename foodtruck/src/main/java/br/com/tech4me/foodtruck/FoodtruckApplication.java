package br.com.tech4me.foodtruck;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FoodtruckApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodtruckApplication.class, args);
	}

}
