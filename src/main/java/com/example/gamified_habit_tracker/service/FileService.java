package com.example.gamified_habit_tracker.service;

import com.example.gamified_habit_tracker.model.entity.FileMetaData;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

public interface FileService {

    FileMetaData uploadFile(MultipartFile file);

    InputStream getFileByFileName(String fileName);
}
