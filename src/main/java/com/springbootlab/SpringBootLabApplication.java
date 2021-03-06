package com.springbootlab;

import com.springbootlab.dao.ClientRepository;
import com.springbootlab.model.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringBootLabApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringBootLabApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringBootLabApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ClientRepository clientRepository) {
		return (args) -> {
			clientRepository.save(new Client("Rafael", "Fonseca"));
			clientRepository.save(new Client("Ana Gabriela", "Lopes"));
			clientRepository.save(new Client("Amora", "Lopes Fonseca"));

			// fetch all customers
			log.info("Clients found with findAll(): ");
			log.info("-------------------------------");
			List<Client> clients = clientRepository.findAll();
			clients.stream().forEach(client -> {
				System.out.println("Id: " + client.getId() + "Name: " + client.getName() + " Last Name: " + client.getLastName());
			});
			log.info("  ");

			// fetch an individual client by ID
//			Client client = clientRepository.getOne(1L);
//			log.info("Client found with getOne(1L):");
//			log.info("--------------------------------");
//			log.info(client.toString());
//			log.info("");

		};
	}


}
