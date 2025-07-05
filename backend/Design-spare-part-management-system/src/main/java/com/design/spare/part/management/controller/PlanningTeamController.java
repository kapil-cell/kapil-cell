package com.design.spare.part.management.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.design.spare.part.management.objects.ServiceCenter;
import com.design.spare.part.management.repository.WarehouseRepository;
import com.design.spare.part.management.response.ServiceCenterResponse;
import com.design.spare.part.management.service.PlanningTeamService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/v1")
public class PlanningTeamController {
	private static final Logger log=LoggerFactory.getLogger(WarehouseRepository.class);
	
	@Autowired
	PlanningTeamService planningTeamService;
	
	@PostMapping(path="/spareParts/Planning.json")
	public ResponseEntity<ServiceCenterResponse> consumeSparePartsInWarehouseForServiceCenter(@RequestBody ServiceCenter serviceCenter){
		int id=0;
		ServiceCenterResponse response = new ServiceCenterResponse();
		try {
			id=planningTeamService.consumeInfoInWarehouseForServiceCenter(serviceCenter);
		} catch(Exception e) {
			log.error("Exception occurred while consuming info:"+e.getMessage());
		}
		if(id==1) {
			response.setSparePartsServiceCenter(serviceCenter);
			response.setCode(0);
			response.setMessage("Success");
			return new ResponseEntity<ServiceCenterResponse>(response, HttpStatus.OK);
		} else {
			response.setCode(4);
			response.setMessage("Information not consumed, error occurred");
			return new ResponseEntity<ServiceCenterResponse>(response,HttpStatus.BAD_REQUEST);
		}
		
	}
}
