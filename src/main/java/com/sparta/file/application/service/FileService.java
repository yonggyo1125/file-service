package com.sparta.file.application.service;

import com.sparta.file.domain.constant.FileStatus;
import com.sparta.file.presentation.dto.FileInfoResponse;
import com.sparta.file.presentation.dto.FileUploadRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileService {
    // 파일 업로드 처리
    List<FileInfoResponse> upload(MultipartFile[] files, FileUploadRequest requestDto);

    // 단일 파일 조회
    FileInfoResponse get(Long seq);

    /**
     * 파일 목록 조회
     * @param gid : 그룹 ID
     * @param location : 그룹 내에서 위치
     * @param status : ALL, UNDONE, DONE
     * @return 업로드를 성공한 파일 목록 정보
     */
    List<FileInfoResponse> getList(String gid, String location, FileStatus status);

    // 파일 등록번호로 삭제
    FileInfoResponse deleteFile(Long seq);

    // 파일 목록 삭제, gid, location
    List<FileInfoResponse> deleteFiles(String gid, String location);
}
