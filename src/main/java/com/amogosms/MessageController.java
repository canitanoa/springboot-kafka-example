package com.amogosms;

import lombok.AllArgsConstructor;
import org.apache.kafka.common.protocol.Message;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/messages")
public class MessageController {

    private KafkaTemplate<String, String> kafkaTemplate;

    //Este método funciona como Producer, consume el kafkaTemplate que envia el mensaje al topico "amigosms"
    @PostMapping
    public void publish(@RequestBody MessageRequest request){

        MessageDTO messageDTO = new MessageDTO(request.message(), LocalDateTime.now());

        kafkaTemplate.send("amigosms", request.message());
    }
}
