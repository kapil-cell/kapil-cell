package com.design.spare.part.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.design.spare.part.management.objects.ServiceCenter;
import com.design.spare.part.management.objects.Warehouse;
import com.design.spare.part.management.repository.WarehouseRepository;

@Service
public class SparePartService {

	@Autowired
	WarehouseRepository repository;
	
	public int addInfoInWarehouse(Warehouse warehouse) {
		warehouse.setWarehouseID(warehouse.getZoneID());
		int id=repository.addSparePartsInfoInWarehouse(warehouse);
		return id;
	}

	public int updateInfoInWarehouse(Warehouse warehouse)  {

		int id= repository.updateSparePartsInfoInWarehouse(warehouse);
		
		return id;
	}

	public List<Warehouse> getInfoFromWarehouses() {
		// TODO Auto-generated method stub
		return repository.getInfoFromWarehouses();
	}

	public int consumeInfoInWarehouse(ServiceCenter serviceCenter) {
int id= repository.consumeSparePartsInWarehouse(serviceCenter);
		
		return id;
	}

}
