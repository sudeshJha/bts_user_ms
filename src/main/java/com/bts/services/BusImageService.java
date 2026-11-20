package com.bts.services;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bts.utils.FileUtil;

@Service
public class BusImageService {
	
	@Value("${file.upload.directory}")
	private String uploadDirectory;
	
	@Autowired
	private FileUtil fileUtil; 
	
	public void uploadImage(MultipartFile image, Long userId) {
		
		String uploadPath = uploadDirectory + File.separator + userId + File.separator + "bus";
		
		fileUtil.fileUpload(uploadPath, image);
		
	}
}
