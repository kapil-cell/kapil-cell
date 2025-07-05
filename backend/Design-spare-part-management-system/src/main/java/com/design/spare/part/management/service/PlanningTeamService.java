package com.design.spare.part.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.design.spare.part.management.objects.ServiceCenter;
import com.design.spare.part.management.repository.ServiceCenterRepository;
import com.design.spare.part.management.repository.WarehouseRepository;
@Service
public class PlanningTeamService {

	@Autowired
	ServiceCenterRepository serviceCenterRepo;
	@Autowired
	WarehouseRepository warehouseRepo;


	public int consumeInfoInWarehouseForServiceCenter(ServiceCenter serviceCenter) {
		// TODO Auto-generated method stub
		int id=0;
		id=warehouseRepo.consumeSparePartsInWarehouse(serviceCenter);
		if(id==0) {
			return 0;
		}
		id=serviceCenterRepo.addingSparePartsInfoInServiceCenter(serviceCenter);
		return id;
	}
}
