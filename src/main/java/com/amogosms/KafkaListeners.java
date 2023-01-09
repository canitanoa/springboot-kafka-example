package com.amogosms;

import org.apache.kafka.common.protocol.Message;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

//Va a consumir los mensajes de los topicos de Kafka
@Component
public class KafkaListeners {

    @KafkaListener(
            topics = "amigosms", groupId = "groupId"
    )
    void listener(String data){
        System.out.println("Listener recived: " + data + " !!!!!");
    }

}
