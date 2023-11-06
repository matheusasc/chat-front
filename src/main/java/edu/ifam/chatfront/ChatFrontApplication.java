package edu.ifam.chatfront;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import edu.ifam.chatfront.model.Contato;

@SpringBootApplication
public class ChatFrontApplication {
	private static final Logger log = LoggerFactory.getLogger(ChatFrontApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ChatFrontApplication.class, args);
	}
}