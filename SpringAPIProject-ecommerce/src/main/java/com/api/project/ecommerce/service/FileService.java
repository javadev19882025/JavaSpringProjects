package com.api.project.ecommerce.service;

import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;

/**
 * Service interface for handling file operations.
 */
public interface FileService {
    
    /**
     * Uploads an image file to the specified path.
     *
     * @param path The directory path where the file should be stored.
     * @param file The image file to be uploaded.
     * @return The file name or file path after successful upload.
     * @throws IOException If an error occurs during file upload.
     */
    String uploadImage(String path, MultipartFile file) throws IOException;

}
