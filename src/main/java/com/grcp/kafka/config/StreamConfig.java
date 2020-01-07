package com.grcp.kafka.config;

import com.grcp.kafka.greetings.stream.PocStream;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(PocStream.class)
public class StreamConfig {


}
