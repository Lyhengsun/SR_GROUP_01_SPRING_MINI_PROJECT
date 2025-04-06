package com.example.gamified_habit_tracker.controller;

import com.example.gamified_habit_tracker.model.dto.response.ApiResponse;
import com.example.gamified_habit_tracker.model.entity.FileMetaData;
import com.example.gamified_habit_tracker.service.FileService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

@RestController
@RequestMapping("api/v1/files")
@RequiredArgsConstructor
public class FileController {

    private final FileService fileService;

    @PostMapping(value = "/upload-file",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ApiResponse<FileMetaData>> uploadFile(@RequestParam("file") MultipartFile file) {
        ApiResponse<FileMetaData> apiResponse = ApiResponse.<FileMetaData>builder()
                .success(true)
                .message("File uploaded successfully! Metadata of the uploaded file is returned.")
                .status(HttpStatus.CREATED)
                .payload(fileService.uploadFile(file))
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }

    @SneakyThrows
    @GetMapping("/preview-file/{file-name}")
    public ResponseEntity<?> getFileByFileName(@PathVariable("file-name") String fileName) {

        InputStream inputStream = fileService.getFileByFileName(fileName);

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.IMAGE_JPEG)
                .body(inputStream.readAllBytes());
    }


}
