package com.travel.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travel.entities.Detailed;
import com.travel.entities.Display;
import com.travel.entities.Hotel;
import com.travel.service.CustomService;
import com.travel.service.DetailedService;
import com.travel.service.DisplayService;
import com.travel.service.HotelService;

@RestController
public class displayPlan {
	
	@Autowired
	DisplayService service;
	
	@Autowired
	DetailedService detailService;
	
	@Autowired
	HotelService hotelService;
	
	@Autowired
	CustomService customService;
	
	
	@GetMapping("getPlans")
	public List<Display> getAllPlans(){
		
		return service.fetchAll();
		
	}
	
	@GetMapping("detailedPlan")
	public List<Detailed> getDetailedPlan(@RequestParam String plan) {
        List<Detailed> result = detailService.getData(plan);
        
       
        return result;
    }
	
	@GetMapping("getHotels")
	public List<Hotel> geAllHotels(){
		
		return hotelService.fetchHotels();		
		
	}
	
	@GetMapping("customPlan")
	public String customPlanTrip() {
		
		return customService.printCustomDetails();
		
	}

}
