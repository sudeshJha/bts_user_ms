package com.bts.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bts.dtos.ApiResponse;
import com.bts.dtos.BusDto;
import com.bts.dtos.BusLayoutDto;
import com.bts.dtos.DeckTypeDto;
import com.bts.dtos.SeatLayoutTypeDto;
import com.bts.models.Bus;
import com.bts.models.DeckType;
import com.bts.models.Operator;
import com.bts.models.SeatLayout;
import com.bts.models.SeatLayoutType;
import com.bts.services.BusService;
import com.bts.services.OperatorService;
import com.bts.services.SeatLayoutService;

@RestController
public class BusRestController {
	
	@Autowired
	private OperatorService operatorService;
	
	@Autowired
	private SeatLayoutService seatLayoutService; 
	
	@Autowired
	private BusService busService;

	@PostMapping("/add_bus")
	public ApiResponse<?> addOperatorBus(@ModelAttribute BusDto busDto, Authentication authentication){
		
		Operator operator= operatorService.getOperatorByEmail(authentication.getName());
		
		if(operator == null) {
			return new ApiResponse<>("Invalid user request.");
		}
		
		Bus bus = busDto.getEntity();
		
		SeatLayoutType seatLayoutType = SeatLayoutType.valueOf(busDto.getBusLayout().getSeatLayoutType().getCode());
		DeckType deckType = DeckType.valueOf(busDto.getBusLayout().getDeckType().getCode());
		
		
		SeatLayout seatLayout = seatLayoutService.getSeatLayoutBySeatLayoutTypeAndDeckType(seatLayoutType, deckType);

		if(seatLayout == null) {
			return new ApiResponse<>("Invalid bus layout.");
		}
		
		bus.getBusLayout().setSeatLayout(seatLayout);
		
        busService.addBus(bus, busDto.getImages(), operator);
        
        return new ApiResponse<>("Bus added successfully");
	}
}
