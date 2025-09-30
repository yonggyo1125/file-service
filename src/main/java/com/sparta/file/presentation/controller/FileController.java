package com.sparta.file.presentation.controller;

import com.sparta.file.presentation.dto.FileInfoResponse;
import com.sparta.file.presentation.dto.FileUploadRequest;
import jakarta.validation.Valid;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/v1/file")
public class FileController {

    @PostMapping("/upload")
    public List<FileInfoResponse> upload(@RequestPart(name="file", required = false) MultipartFile[] files, @Valid FileUploadRequest requestDto, Errors errors) {

        if (errors.hasErrors()) {

            return null; // 보류
        }

        // 파일 업로드 처리


        return null;
    }
}
