package com.xbchen.springcloud.kafka;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class Receiver {
    private static Logger logger = LoggerFactory.getLogger(Receiver.class);

    @StreamListener(kafkaStreams.INPUT)
    public void handleGreetings(@Payload Message msg) {
        logger.info("Stream Listener Received: {}", msg.toString());
    }
}
