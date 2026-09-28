package com.bts.configs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import jakarta.annotation.PostConstruct;

@Configuration
public class FileUploadPathConfig {

	@Value("${file.upload.directory}")
	private String uploadDirectory;

	@PostConstruct
	public void createUploadDirectory() throws IOException{
		Path path = Paths.get(uploadDirectory);

		if(!Files.isDirectory(path)) {
			Files.createDirectories(path);
		}
	}
}
