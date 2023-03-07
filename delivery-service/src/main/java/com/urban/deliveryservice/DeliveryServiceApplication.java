package com.urban.deliveryservice;

import com.urban.deliveryservice.entities.Delivery;
import com.urban.deliveryservice.repos.DeliveryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
public class DeliveryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeliveryServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(DeliveryRepository repository){
		return args -> {
			repository.saveAll(List.of(
					Delivery.builder()
							.departure("Morocco, Casa")
							.destination("Germany, FrankFort")
							.price(2000.21)
							.build()
			));
		};
	}
}
