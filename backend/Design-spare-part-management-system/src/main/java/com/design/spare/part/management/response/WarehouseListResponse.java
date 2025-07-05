package com.design.spare.part.management.response;

import java.util.List;

import com.design.spare.part.management.objects.Warehouse;

public class WarehouseListResponse extends AbstractResponse{
	
	List<Warehouse> warehouseList;

	

	public List<Warehouse> getWarehouseList() {
		return warehouseList;
	}



	public void setWarehouseList(List<Warehouse> warehouseList) {
		this.warehouseList = warehouseList;
	}



	@Override
	public String toString() {
		return "WarehouseResponse [warehouseList=" + warehouseList + ", getCode()=" + getCode() + ", getMessage()="
				+ getMessage()+ "]";
	}
	
	
	
	
	
}
