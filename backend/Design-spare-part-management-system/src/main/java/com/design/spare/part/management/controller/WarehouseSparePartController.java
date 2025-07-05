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
import com.design.spare.part.management.objects.Warehouse;
import com.design.spare.part.management.repository.WarehouseRepository;
import com.design.spare.part.management.response.ServiceCenterResponse;
import com.design.spare.part.management.response.WarehouseListResponse;
import com.design.spare.part.management.response.WarehouseResponse;
import com.design.spare.part.management.service.SparePartService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/v1")
public class WarehouseSparePartController {
	private static final Logger log=LoggerFactory.getLogger(WarehouseRepository.class);
	@Autowired
	SparePartService sparePartService;
	
	
	@PostMapping(path="/spareParts/Warehouse/add.json")
	public ResponseEntity<WarehouseResponse> addSparePartsInWarehouse(@RequestBody Warehouse warehouse){
		int id =0;
		WarehouseResponse response = new WarehouseResponse();

		try {
			id = sparePartService.addInfoInWarehouse(warehouse);

		} catch(Exception e) {
			log.error("Exception occurred while adding info:"+e.getMessage());
		}
		response.setWarehouse(warehouse);

		if(id==1) {
			response.setCode(0);
			response.setMessage("Success");
			return new ResponseEntity<WarehouseResponse>(response, HttpStatus.OK);
		} else if(id==2) {
			response.setCode(4);
			response.setMessage("Already added in ZoneId");
			return new ResponseEntity<WarehouseResponse>(response, HttpStatus.BAD_REQUEST);
		} else {
			response.setCode(4);
			response.setMessage("Information not added, error occurred");
			return new ResponseEntity<WarehouseResponse>(response,HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@PutMapping(path="/spareParts/Warehouse/update.json")
	public ResponseEntity<WarehouseResponse> updateSparePartsInWarehouse(@RequestBody Warehouse warehouse){
		int id=0;		
		WarehouseResponse response = new WarehouseResponse();

		try {
			id=sparePartService.updateInfoInWarehouse(warehouse);
		} catch(Exception e) {
			log.error("Exception occurred while updating info:"+e.getMessage());
		}
		if(id==1) {
			response.setWarehouse(warehouse);
			response.setCode(0);
			response.setMessage("Success");
			return new ResponseEntity<WarehouseResponse>(response, HttpStatus.OK);
		} else {
			response.setCode(4);
			response.setMessage("Information not added, error occurred");
			return new ResponseEntity<WarehouseResponse>(response,HttpStatus.BAD_REQUEST);
		} 
		
	}
	@PutMapping(path="/spareParts/Warehouse/consume.json")
	public ResponseEntity<ServiceCenterResponse> consumeSparePartsInServiceCenter(@RequestBody ServiceCenter serviceCenter){
		int id=0;
		ServiceCenterResponse response = new ServiceCenterResponse();
		try {
			id=sparePartService.consumeInfoInWarehouse(serviceCenter);
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
	
	@GetMapping(path="/spareParts/Warehouse.json")
	public ResponseEntity<WarehouseListResponse> getInfoFromWarehouses(){
		WarehouseListResponse response = new WarehouseListResponse();
		List<Warehouse> warehouseList = new ArrayList<>();
		try {
			warehouseList=sparePartService.getInfoFromWarehouses();
		} catch(Exception e) {
			log.error("Exception occurred while updating info:"+e.getMessage());
		}
		response.setWarehouseList(warehouseList);
		response.setCode(0);
		response.setMessage("Success");
		return new ResponseEntity<WarehouseListResponse>(response, HttpStatus.OK);
		
		
	}
}
