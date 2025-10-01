package com.sparta.global.infrastructure.repository;

import com.sparta.global.domain.entity.CodeValue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CodeValueRepository extends JpaRepository<CodeValue, String> {
}
