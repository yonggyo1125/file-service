package com.sparta.global.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Data;

@Data
@Entity
public class CodeValue {
    @Id
    @Column(name="_code")
    private String code;

    @Lob
    private String value;
}
