package com.sparta.file.domain.entity;

import com.sparta.file.presentation.dto.FileInfoResponse;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name="P_FILE_INFO", indexes = {
        @Index(name="idx_file_info_1", columnList = "gid,createdAt"),
        @Index(name="idx_file_info_2", columnList = "gid,location,createdAt")
})
public class FileInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;

    @Column(length=65, nullable = false)
    private String gid;

    @Column(length=45)
    private String location;

    @Column(length=150, nullable = false)
    private String fileName; // 업로드한 원본 파일명

    @Column(length=65)
    private String contentType; // 파일 형식 image/png ..

    @Column(length=45)
    private String extension; // 확장자

    private boolean done; // 그룹작업 완료 여부, true : 유지 시킬 필요가 있는 파일

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @CreatedBy
    @Column(length=65, updatable = false)
    private String createdBy;

    public static FileInfoResponse of(FileInfo fileInfo) {
        return null;
    }
}
