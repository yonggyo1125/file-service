package com.sparta.file.infrastructure.repository;

import com.sparta.file.domain.entity.FileInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileInfoRepository extends JpaRepository<FileInfo, Long> {

}
