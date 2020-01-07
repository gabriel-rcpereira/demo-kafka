package com.grcp.kafka.greetings.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PocVo {

    private long timestamp;
    private String message;
}
