package com.design.spare.part.management.objects;

import java.util.Map;

public class Warehouse {
	
private int warehouseID;
private String zone;
private int zoneID;
private Map<String,Integer> spareParts;//modelno_type,qt

public int getWarehouseID() {
	return warehouseID;
}
public void setWarehouseID(int warehouseID) {
	this.warehouseID = warehouseID;
}
public String getZone() {
	return zone;
}
public void setZone(String zone) {
	this.zone = zone;
}
public int getZoneID() {
	return zoneID;
}
public void setZoneID(int zoneID) {
	this.zoneID = zoneID;
}
public Map<String, Integer> getSpareParts() {
	return spareParts;
}
public void setSpareParts(Map<String, Integer> spareParts) {
	this.spareParts = spareParts;
}


@Override
public String toString() {
	return "Warehouse [warehouseID=" + warehouseID + ", zone=" + zone + ", zoneID=" + zoneID + ", spareParts="
			+ spareParts + "]";
}



}
