package com.design.spare.part.management.response;

import com.design.spare.part.management.objects.Warehouse;

public class WarehouseResponse extends AbstractResponse{
	
	Warehouse warehouse;

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	@Override
	public String toString() {
		return "WarehouseResponse [warehouse=" + warehouse + ", getCode()=" + getCode() + ", getMessage()="
				+ getMessage()+ "]";
	}
	
	
	
	
	
}
