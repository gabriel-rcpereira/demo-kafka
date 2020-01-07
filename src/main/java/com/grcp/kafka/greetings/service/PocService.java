package com.grcp.kafka.greetings.service;

import com.grcp.kafka.greetings.stream.PocStream;
import com.grcp.kafka.greetings.model.PocVo;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

@RequiredArgsConstructor
@Service
public class PocService {

    private final PocStream stream;

    public void sendMessage(final PocVo vo) {
        MessageChannel messageChannel = stream.outbound();
        messageChannel.send(MessageBuilder
                .withPayload(vo)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .build());
    }
}
