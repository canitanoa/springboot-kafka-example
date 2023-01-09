package com.amogosms.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    //Definimos el nombre del Topico
    @Bean
    public NewTopic amigosmsTopic(){
        return TopicBuilder.name("amigosms")
                .build();
    }

}
