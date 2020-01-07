package com.grcp.kafka.greetings.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.SubscribableChannel;

public interface PocStream {

    String INPUT = "poc-in";
    String OUTPUT = "poc-out";

    @Input(INPUT)
    SubscribableChannel inbound();

    @Output(OUTPUT)
    SubscribableChannel outbound();
}
