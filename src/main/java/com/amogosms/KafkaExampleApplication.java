package com.amogosms;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

import java.time.LocalDateTime;

@SpringBootApplication
public class KafkaExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaExampleApplication.class, args);
	}


	//TEST:
	//Definimos un CommandLineRuner para enviar un evento al topico creado:
	@Bean
	CommandLineRunner commandLineRunner(KafkaTemplate<String, String> kafkaTemplate){

//		MessageDTO messageDTO = new MessageDTO("Mensaje enviado a", LocalDateTime.now());

		return args -> {
			kafkaTemplate.send("amigosms", "Mensaje enviado a las " + LocalDateTime.now());
		};
	}
	// Para provar el mensaje guardado en el topico ejecutar desde una terminal el kafka-console-consumer.bat
	// que trae los paquetes de kafka.
	// desde el dir raiz donde esta intalado el server de kafka:
	// .\bin\windows\kafka-console-consumer.bat --topic amigosms --from-beginning --bootstrap-server localhost:9092

}
