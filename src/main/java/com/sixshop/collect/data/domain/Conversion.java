package com.sixshop.collect.data.domain;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@NoArgsConstructor
@Setter
@Getter
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Conversion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long mid;
    private String uuid;
    private Long customer;
    private Long productId;
    private Long reviewId;
    private String target; // post , picture
    private boolean photoReview;
    private String device;
    @CreatedDate
    private LocalDateTime createdAt;

    @Builder
    public Conversion(Long mid, String uuid, Long customer, Long productId, Long reviewId, String target, boolean photoReview, String device) {
        this.mid = mid;
        this.uuid = uuid;
        this.customer = customer;
        this.productId = productId;
        this.reviewId = reviewId;
        this.target = target;
        this.photoReview = photoReview;
        this.device = device;
    }


}
