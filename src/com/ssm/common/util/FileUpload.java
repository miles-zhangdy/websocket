package com.ssm.common.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class FileUpload {  
	  
    public static final String FILE_PATH = "/upload/";  
  
    //文件上传  
    public static String uploadFile(MultipartFile file, HttpServletRequest request) throws IOException {  
      //  String fileName = file.getOriginalFilename(); 
        String uploadName = UuidUtils.get32UUID();
        File tempFile = new File(FILE_PATH, uploadName);  
        if (!tempFile.getParentFile().exists()) {  
            tempFile.getParentFile().mkdir();  
        }  
        if (!tempFile.exists()) {  
            tempFile.createNewFile();  
        }  
        file.transferTo(tempFile);  
        return "/download?fileName=" + tempFile.getName();  
    }  
  
    public static File getFile(String fileName) {  
        return new File(FILE_PATH, fileName);  
    }  
} 
