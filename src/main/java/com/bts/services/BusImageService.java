package com.bts.services;

import java.io.File;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bts.models.BusImage;
import com.bts.repos.BusImageRepo;
import com.bts.utils.FileUtil;

@Service
public class BusImageService {
	
	@Value("${file.upload.directory}")
	private String uploadDirectory;
	
	@Autowired
	private BusImageRepo busImageRepo;
	
	@Autowired
	private FileUtil fileUtil; 
	
	public String uploadImage(MultipartFile image, Long userId, Long busId) {
		
		String uploadPath = Paths.get(uploadDirectory, String.valueOf(userId), "buses", String.valueOf(busId)).toString();
		
		fileUtil.fileUpload(uploadPath, image);
		
		String filePath = uploadPath + File.separator + image.getOriginalFilename();
		
		fileUtil.fileUpload(uploadPath, image);
		
		return filePath;
	}
	
	public void save(MultipartFile image, BusImage busImage,Long userId, Long busId) {
		
		String filePath = uploadImage(image, userId, busId);
		
		busImage.setPath(filePath);
		
		busImageRepo.save(busImage);
	}
}
