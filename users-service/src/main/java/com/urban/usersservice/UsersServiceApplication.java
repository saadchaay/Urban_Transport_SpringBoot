package com.urban.usersservice;

import com.urban.usersservice.dtos.transporter.TransporterInputDto;
import com.urban.usersservice.dtos.transporter.TransporterOutputDto;
import com.urban.usersservice.entities.Transporter;
import com.urban.usersservice.mappers.TransporterMapper;
import com.urban.usersservice.models.Vehicle;
import com.urban.usersservice.repos.TransporterRepository;
import com.urban.usersservice.services.restClient.VehicleRestClientService;
import com.urban.usersservice.utils.KeycloakUtil;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class UsersServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsersServiceApplication.class, args);
	}

//	@Bean
	CommandLineRunner start(){
		return args -> {
			TransporterInputDto transporter = TransporterInputDto
					.builder()
					.name("saad")
					.phone("+212615207417")
					.email("saad@gmail.com")
					.identity("BK675034")
					.address("Bouskoura")
					.picture("my_picture")
					.password("my_password")
					.build();
			KeycloakUtil.createKeycloakTransporterWithRole(transporter, transporter.getPassword());
//			Transporter saveOne = tranRepos.save(transporter);
//			System.out.println(saveOne);
		};
	}
}
