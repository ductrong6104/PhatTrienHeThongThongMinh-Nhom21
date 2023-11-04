package com.example.thuoctay.utils;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public class ResUtils {

    private static final String projectPath = System.getProperty("user.dir");
    private static final String imagePath = projectPath + "\\src\\main\\resources\\static\\images\\";

    public static String saveImage(MultipartFile file){
        if (!file.isEmpty()) {
            try {

                File uploadPath = new File(imagePath);
                if (!uploadPath.exists()) {
                    uploadPath.mkdirs();
                }
                String extesions = getExtensionFromFileName(file.getOriginalFilename());
                String fileName = UUID.randomUUID().toString() + extesions;
                File uploadedFile = new File(uploadPath, fileName);
                file.transferTo(uploadedFile);

                return fileName;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        } else {
            return null;
        }
    }

    public static String getExtensionFromFileName(String fileName) {
        String extension = "";
        if (fileName != null && fileName.contains(".")) {
            extension = fileName.substring(fileName.lastIndexOf("."));
        }
        return extension;
    }

    public static void deletFile(String fileName){
        File fileCanXoa = new File(imagePath + fileName);
        if (fileCanXoa.exists()) {
            fileCanXoa.delete();
        }
    }
}
