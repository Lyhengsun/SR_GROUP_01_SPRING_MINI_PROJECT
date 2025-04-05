package com.example.gamified_habit_tracker.service;

import com.example.gamified_habit_tracker.model.entity.FileMetaData;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {

    FileMetaData uploadFile(MultipartFile file);

    Resource getFileByFileName(String fileName);
}
