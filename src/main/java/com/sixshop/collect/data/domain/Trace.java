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
public class Trace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String uuid;
    private Long mid;
    private boolean anonymous;
    private String event;
    private String device;
    @CreatedDate
    private LocalDateTime createdAt;

    @Builder
    public Trace(Long mid,String uuid, String event, boolean anonymous, String device) {
        this.mid = mid;
        this.uuid = uuid;
        this.event = event;
        this.anonymous = anonymous;
        this.device = device;
    }
}
