package com.amogosms.config;

import com.amogosms.MessageDTO;
import org.apache.kafka.clients.producer.ProducerConfig;


import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;


import java.util.HashMap;
import java.util.Map;

public class KafkaProducerConfig {

    //Definimos el server configurado en las properties
    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    //Definimos la configuracion para pasar al Producer Factory
    public Map<String, Object> producerConfig(){
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

        return props;
    }

    //Definimos el Producer Factory, que es el responsable de creal la instancia del Producer
    @Bean
    public ProducerFactory<String, String> producerFactory(){
        return new DefaultKafkaProducerFactory<>(producerConfig());
    }

    //Definimos la forma en que vamos a enviar los mensajes con el KafkaTemplate
    @Bean
    public KafkaTemplate<String, String> kafkaTemplate(
            ProducerFactory<String, String> producerFactory){
        return new KafkaTemplate<>(producerFactory);
    }



}
