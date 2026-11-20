package com.bts.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bts.models.Bus;
import com.bts.models.BusImage;
import com.bts.models.Operator;

@Service
public class BusService {
	
	@Autowired
	private BusImageService busImageService;

	public void addBus(Bus bus, List<MultipartFile> images, Operator operator) {
		
		List<BusImage> busImages = new ArrayList<>();
		for(MultipartFile image : images) {
			BusImage busImage = new BusImage();
			busImage.setPath(null);
		}
		
	}
	
}
