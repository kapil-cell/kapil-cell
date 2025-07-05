package com.design.spare.part.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.design.spare.part.management.objects.ServiceCenter;
import com.design.spare.part.management.repository.ServiceCenterRepository;

@Service
public class SparePartsServiceCenter {

	@Autowired
	ServiceCenterRepository repository;

	public int addInfoInServiceCenter(ServiceCenter serviceCenter) {
		int id=repository.addSparePartsInfoInServiceCenter(serviceCenter);
		return id;
	}

	public int updateInfoInServiceCenter(ServiceCenter serviceCenter) {
		int id= repository.updateSparePartsInfoInServiceCenter(serviceCenter);
		
		return id;
	}

	public int consumeInfoInServiceCenter(ServiceCenter serviceCenter) {
int id= repository.consumeSparePartsInfoInServiceCenter(serviceCenter);
		
		return id;
	}

	public List<ServiceCenter> getInfoFromServiceCenter() {
		// TODO Auto-generated method stub
		return repository.getInfoFromServiceCenter();
	}

	public int addingInServiceCenter(ServiceCenter serviceCenter) {
		// TODO Auto-generated method stub
int id= repository.addingSparePartsInfoInServiceCenter(serviceCenter);
		
		return id;
	}
	
}
