package com.amogosms.config;

import com.amogosms.MessageDTO;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.support.serializer.JsonDeserializer;


import java.util.HashMap;
import java.util.Map;

public class KafkaConsumerConfig {

    //Definimos el server configurado en las properties
    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    //Definimos la configuracion para pasar al Consumer Factory
    public Map<String, Object> consumerConfig(){
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);

        return props;
    }

    //Definimos el Consumer Factory
    @Bean
    public ConsumerFactory<String, String> consumerFactory(){
        JsonDeserializer<String> stringJsonDeserializer = new JsonDeserializer<>();
        stringJsonDeserializer.addTrustedPackages("*");
//        return new DefaultKafkaConsumerFactory<>(
//                consumerConfig(),
//                new StringDeserializer(),
//                stringJsonDeserializer
//        );
        return new DefaultKafkaConsumerFactory<>(
                consumerConfig()
        );
    }

    //Definimos el Listener que va a sondear todos los registros de Kafka
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String,String>> factory(
            ConsumerFactory<String, String> consumerFactory){

        ConcurrentKafkaListenerContainerFactory<String, String> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory);

        return factory;
    }

}
