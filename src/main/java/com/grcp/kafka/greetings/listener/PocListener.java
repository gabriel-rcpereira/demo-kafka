package com.grcp.kafka.greetings.listener;

import com.grcp.kafka.greetings.model.PocVo;
import com.grcp.kafka.greetings.stream.PocStream;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
public class PocListener {

    @StreamListener(PocStream.INPUT)
    public void handleStream(PocVo vo) {
        System.out.println(vo.getMessage());
    }
}
