package com.sparta.global.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseUserEntity extends BaseEntity {
    @CreatedBy
    @Column(updatable = false, length=65)
    private String createdBy;

    @LastModifiedBy
    @Column(insertable = false, length = 65)
    private String updatedBy;

}
