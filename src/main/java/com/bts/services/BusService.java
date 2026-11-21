package com.bts.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bts.models.Bus;
import com.bts.models.BusImage;
import com.bts.models.Operator;
import com.bts.repos.BusRepo;

import jakarta.transaction.Transactional;

@Service
public class BusService {
	
	@Autowired
	private BusImageService busImageService;
	
	@Autowired
	private BusRepo busRepo;

	@Transactional
	public void addBus(Bus bus, List<MultipartFile> images, Operator operator) {
		
		bus.setOperator(operator);
		Bus savedBus = busRepo.save(bus);
		
		
		List<BusImage> busImages = new ArrayList<>();
		for(MultipartFile image : images) {
			BusImage busImage = new BusImage();
			busImage.setBus(savedBus);
			
			busImageService.save(image, busImage,operator.getUser().getUserId(), savedBus.getBusId());
		}
		
	}
	
}
