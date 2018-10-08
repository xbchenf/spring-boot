package com.xbchen.springcloud.kafka;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

   private final Sender sender;

    public KafkaController(Sender sender) {
        this.sender = sender;
    }

  //  @Autowired
   // GreetingsSender greetingsSender;

    @GetMapping("/kafka")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void hello(@RequestParam("message") String message) {
        Message messagevo = new Message(System.currentTimeMillis(), message);
        sender.sendMessage(messagevo);
    }
}
