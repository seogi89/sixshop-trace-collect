package com.sixshop.collect.web.dto;

import com.sixshop.collect.data.domain.Trace;
import lombok.Getter;

@Getter
public class TraceRequest {

    private Long mid;
    private String uuid;
    private String event;
    private String device;
    private boolean anonymous;

    public Trace toEntity() {
        return Trace.builder()
            .mid(mid)
            .uuid(uuid)
            .event(event)
            .anonymous(anonymous)
            .device(device)
            .build();
    }

}
