package com.bts.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FileUtil {
	
	@Value("${file.upload.directory}")
	private String uploadDirectory;

	public void createUserDirectory(Long userId) {
		
		Path path = Paths.get(uploadDirectory + File.separator +userId.toString());
		
		try {
			Files.createDirectories(path);
		}catch(IOException exp) {
			System.out.println("User Directory " + userId + " already exsits");
		}
		
	}
	
	public boolean fileUpload() {
		return true;
	}
}
