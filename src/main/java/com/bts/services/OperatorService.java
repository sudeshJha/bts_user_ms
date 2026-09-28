package com.bts.services;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bts.models.Operator;
import com.bts.models.User;
import com.bts.repos.OperatorRepo;
import com.bts.utils.FileUtil;

@Service
public class OperatorService {
	
	@Value("${file.upload.directory}")
	private String uploadDirectory;
	
	@Autowired 
	private UserService userService;
	
	@Autowired
	private FileUtil fileUtil; 
	
	@Autowired
	private OperatorRepo operatorRepo;
	
	public Operator operatorSignup(Operator operator, MultipartFile license, MultipartFile banner) {

		User user = userService.userSignup(operator.getUser());
		operator.setUser(user);
		operator = operatorRepo.save(operator);
		
		String uploadPath = uploadDirectory + File.separator + user.getUserId(); 
	
//		upload license
		fileUtil.fileUpload(uploadPath, license);
		
//		upload banner
		if(banner != null && !banner.isEmpty()) {
			fileUtil.fileUpload(uploadPath, banner);
		}

		return operator;
	} 
}
