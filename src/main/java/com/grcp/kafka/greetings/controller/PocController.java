package com.grcp.kafka.greetings.controller;

import com.grcp.kafka.greetings.model.PocRequest;
import com.grcp.kafka.greetings.model.PocVo;
import com.grcp.kafka.greetings.service.PocService;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneOffset;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
public class PocController {

    private final PocService service;

    @PostMapping("/poc")
    public ResponseEntity<Void> postMessage(@RequestBody PocRequest request){
        service.sendMessage(buildVo(request));
        return ResponseEntity.accepted().build();
    }

    private PocVo buildVo() {
        return PocVo.builder()
                .timestamp(LocalDate.now().toEpochSecond(LocalTime.now(), ZoneOffset.UTC))
                .message("send message")
                .build();
    }

    private PocVo buildVo(PocRequest request) {
        return PocVo.builder()
                .timestamp(LocalDate.now().toEpochSecond(LocalTime.now(), ZoneOffset.UTC))
                .message(request.getMessage())
                .build();
    }
}
