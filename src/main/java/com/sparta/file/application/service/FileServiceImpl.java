package com.sparta.file.application.service;

import com.sparta.file.domain.constant.FileStatus;
import com.sparta.file.infrastructure.repository.FileInfoRepository;
import com.sparta.file.presentation.dto.FileInfoResponse;
import com.sparta.file.presentation.dto.FileUploadRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

    private final FileInfoRepository repository;

    @Override
    public List<FileInfoResponse> upload(MultipartFile[] files, FileUploadRequest requestDto) {

        

        return List.of();
    }

    @Override
    public FileInfoResponse get(Long seq) {
        return null;
    }

    @Override
    public List<FileInfoResponse> getList(String gid, String location, FileStatus status) {
        return List.of();
    }

    @Override
    public FileInfoResponse deleteFile(Long seq) {
        return null;
    }

    @Override
    public List<FileInfoResponse> deleteFiles(String gid, String location) {
        return List.of();
    }
}
