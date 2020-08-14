package com.sixshop.collect.web.dto;

import com.sixshop.collect.data.domain.Conversion;
import com.sixshop.collect.data.domain.Trace;
import lombok.Getter;

@Getter
public class ConversionRequest {

    private Long mid;
    private String uuid;
    private Long customer;
    private Long reviewId;
    private String target; // post , picture
    private boolean photoReview;
    private String device;

    public Conversion toEntity() {
        return Conversion.builder()
            .mid(mid)
            .uuid(uuid)
            .customer(customer)
            .reviewId(reviewId)
            .target(target)
            .photoReview(photoReview)
            .device(device)
            .build();
    }

}
