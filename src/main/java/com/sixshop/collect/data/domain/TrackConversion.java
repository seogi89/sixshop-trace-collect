package com.sixshop.collect.data.domain;

import java.time.LocalDateTime;
import java.util.Map;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@NoArgsConstructor
@Setter
@Getter
@Entity
@EntityListeners(AuditingEntityListener.class)
public class TrackConversion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long mid;
    private String uuid;
    private Long customer;
    private String type;
    private String title;
    private String properties;
    private String page; // product, board
    private String ua;
    @CreatedDate
    private LocalDateTime createdAt;

    @Builder
    public TrackConversion(Long mid, String uuid, Long customer, String type, String title, String properties, String page,
        String ua) {
        this.mid = mid;
        this.uuid = uuid;
        this.customer = customer;
        this.type = type;
        this.title = title;
        this.properties = properties;
        this.page = page;
        this.ua = ua;
    }
}
