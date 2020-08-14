package com.sixshop.collect.web.dto;

import com.sixshop.collect.data.domain.Trace;
import lombok.Getter;

@Getter
public class TraceRequest {

    private Long mid;
    private Long customer;
    private String uuid;
    private String oid;
    private String event;
    private String page;
    private String device;

    public Trace toEntity() {
        return Trace.builder()
            .mid(mid)
            .customer(customer)
            .uuid(uuid)
            .oid(oid)
            .event(event)
            .page(page)
            .device(device)
            .build();
    }

}
