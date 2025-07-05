package com.design.spare.part.management.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.design.spare.part.management.objects.ServiceCenter;
import com.design.spare.part.management.repository.WarehouseRepository;
import com.design.spare.part.management.response.ServiceCenterListResponse;
import com.design.spare.part.management.response.ServiceCenterResponse;
import com.design.spare.part.management.service.SparePartsServiceCenter;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/v1")
public class ServiceCenterPartController {
	
	private static final Logger log=LoggerFactory.getLogger(WarehouseRepository.class);
	
	@Autowired
	SparePartsServiceCenter sparePartsServiceCenter;
	
	@PostMapping(path="/spareParts/ServiceCenter/add.json")
	public ResponseEntity<ServiceCenterResponse> addSparePartsInServiceCenter(@RequestBody ServiceCenter serviceCenter){
	
		int id =0;
		ServiceCenterResponse response = new ServiceCenterResponse();
		try {
			id = sparePartsServiceCenter.addInfoInServiceCenter(serviceCenter);

		} catch(Exception e) {
			log.error("Exception occurred while adding info:"+e.getMessage());
		}
		response.setSparePartsServiceCenter(serviceCenter);

		if(id==1) {
			response.setCode(0);
			response.setMessage("Success");
			return new ResponseEntity<ServiceCenterResponse>(response, HttpStatus.OK);
		} else if(id==2) {
			response.setCode(4);
			response.setMessage("Already added in ZoneId");
			return new ResponseEntity<ServiceCenterResponse>(response, HttpStatus.BAD_REQUEST);
		} else {
			response.setCode(4);
			response.setMessage("Information not added, error occurred");
			return new ResponseEntity<ServiceCenterResponse>(response,HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@PutMapping(path="/spareParts/ServiceCenter/update.json")
	public ResponseEntity<ServiceCenterResponse> updateSparePartsInServiceCenter(@RequestBody ServiceCenter serviceCenter){
		int id=0;		
		ServiceCenterResponse response = new ServiceCenterResponse();

		try {
			id=sparePartsServiceCenter.updateInfoInServiceCenter(serviceCenter);
		} catch(Exception e) {
			log.error("Exception occurred while updating info:"+e.getMessage());
		}
		if(id==1) {
			response.setSparePartsServiceCenter(serviceCenter);
			response.setCode(0);
			response.setMessage("Success");
			return new ResponseEntity<ServiceCenterResponse>(response, HttpStatus.OK);
		} else {
			response.setCode(4);
			response.setMessage("Information not added, error occurred");
			return new ResponseEntity<ServiceCenterResponse>(response,HttpStatus.BAD_REQUEST);
		} 
		
	}
	@PutMapping(path="/spareParts/ServiceCenter/consume.json")
	public ResponseEntity<ServiceCenterResponse> consumeSparePartsInServiceCenter(@RequestBody ServiceCenter serviceCenter){
		int id=0;
		ServiceCenterResponse response = new ServiceCenterResponse();
		try {
			id=sparePartsServiceCenter.consumeInfoInServiceCenter(serviceCenter);
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
	@PutMapping(path="/spareParts/ServiceCenter/addParts.json")
	public ResponseEntity<ServiceCenterResponse> addingSparePartsInServiceCenter(@RequestBody ServiceCenter serviceCenter){
		int id=0;
		ServiceCenterResponse response = new ServiceCenterResponse();
		try {
			id=sparePartsServiceCenter.addingInServiceCenter(serviceCenter);
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
	@GetMapping(path="/spareParts/ServiceCenter.json")
	public ResponseEntity<ServiceCenterListResponse> getInfoFromServiceCenter(){
		ServiceCenterListResponse response = new ServiceCenterListResponse();
		List<ServiceCenter> serviceCenterList = new ArrayList<>();
		try {
			serviceCenterList=sparePartsServiceCenter.getInfoFromServiceCenter();
		} catch(Exception e) {
			log.error("Exception occurred while updating info:"+e.getMessage());
		}
		response.setServiceCenterList(serviceCenterList);
		response.setCode(0);
		response.setMessage("Success");
		return new ResponseEntity<ServiceCenterListResponse>(response, HttpStatus.OK);
		
	}
	
}
