package br.microservice.producer.controller;

import br.microservice.kafkalibrary.model.City;
import br.microservice.kafkalibrary.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.RoutingKafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class TestController {

//    @Autowired
//    private KafkaTemplate<String, String> kafkaTemplate;
//
//    @Autowired
//    private KafkaTemplate<String, Serializable> jsonKafkaTemplate;

    @Autowired
    private RoutingKafkaTemplate kafkaTemplate;

    @GetMapping("send")
    public void send() {
//        IntStream.range(0, 51)
//                .boxed()
//                .forEach(n -> kafkaTemplate.send("topic-1", "Número: " + n));
        kafkaTemplate.send("topic-1", "Teste do topic-1");
    }

//    @GetMapping("send-2")
//    public void send2() {
//        kafkaTemplate.send("my-topic", "Teste do my-topic");
//    }

    @GetMapping("send-person")
    public void sendPerson() {
//        jsonKafkaTemplate.send("person-topic", new Person("João", new Random().nextInt(50)));
        kafkaTemplate.send("person-topic", new Person("João", new Random().nextInt(50)));
    }

    @GetMapping("send-city")
    public void sendCity() {
//        jsonKafkaTemplate.send("city-topic", new City("Porto Alegre", "RS"));
        kafkaTemplate.send("city-topic", new City("Porto Alegre", "RS"));
    }

}
