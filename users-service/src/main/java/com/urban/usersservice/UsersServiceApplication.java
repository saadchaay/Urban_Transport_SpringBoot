package com.urban.usersservice;

import com.urban.usersservice.entities.Transporter;
import com.urban.usersservice.models.Vehicle;
import com.urban.usersservice.repos.TransporterRepository;
import com.urban.usersservice.services.restClient.VehicleRestClientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class UsersServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsersServiceApplication.class, args);
	}

//	@Bean
	CommandLineRunner start(
			TransporterRepository tranRepos,
			VehicleRestClientService vehClServ){
		return args -> {
			Vehicle vehicle = vehClServ.getVehicle(1L);
			System.out.println(vehicle.getIdentify());
			Transporter transporter = Transporter
					.builder()
					.name("saad")
					.phone("+212615207417")
					.email("saad@gmail.com")
					.identity("BK675034")
					.address("Bouskoura")
					.picture("my_picture")
					.password("my_password")
					.vehicleId(vehicle.getId())
					.build();
			Transporter saveOne = tranRepos.save(transporter);
			System.out.println(saveOne);
		};
	}
}
