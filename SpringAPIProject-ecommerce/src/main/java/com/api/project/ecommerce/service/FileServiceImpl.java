package com.api.project.ecommerce.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * Service implementation for file operations such as image upload.
 */
@Service
public class FileServiceImpl implements FileService {

    /**
     * Uploads an image to the specified directory.
     *
     * @param path The directory where the image should be stored.
     * @param file The image file to be uploaded.
     * @return The generated unique file name.
     * @throws IOException If an I/O error occurs during file upload.
     */
    @Override
    public String uploadImage(String path, MultipartFile file) throws IOException {
        
        // Get the original filename
        String originalFileName = file.getOriginalFilename();

        // Generate a unique identifier for the file
        String randomId = UUID.randomUUID().toString();

        // Create a new unique filename with the original file extension
        String fileName = randomId.concat(originalFileName.substring(originalFileName.lastIndexOf('.')));

        // Construct the full file path
        String filePath = Paths.get(path, fileName).toString();

        // Create the directory if it does not exist
        File folder = new File(path);
        if (!folder.exists()) {
            folder.mkdir();
        }

        // Copy the file to the specified location
        Files.copy(file.getInputStream(), Paths.get(filePath));

        // Return the generated unique filename
        return fileName;
    }
}
