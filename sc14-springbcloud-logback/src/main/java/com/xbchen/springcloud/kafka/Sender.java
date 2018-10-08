package com.xbchen.springcloud.kafka;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

@Service
public class Sender {

    private static Logger log = LoggerFactory.getLogger(Sender.class);

    private final kafkaStreams kafkaStreams;

    public Sender(kafkaStreams kafkaStreams) {
        this.kafkaStreams = kafkaStreams;
    }

    public void sendMessage(final Message msg) {
        log.info("Sending message {}", msg.toString());
        MessageChannel messageChannel = kafkaStreams.outboundGreetings();
        messageChannel.send(MessageBuilder
                .withPayload(msg)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .build());
    }
}
