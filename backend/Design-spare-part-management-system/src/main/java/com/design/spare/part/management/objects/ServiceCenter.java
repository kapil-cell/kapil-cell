package com.design.spare.part.management.objects;

import java.util.Map;

public class ServiceCenter {
private int serviceCenterId;
private int zoneId;
private Map<String,Integer> sparePartsInServiceCenter;


public int getServiceCenterId() {
	return serviceCenterId;
}
public void setServiceCenterId(int serviceCenterId) {
	this.serviceCenterId = serviceCenterId;
}
public int getZoneId() {
	return zoneId;
}
public void setZoneId(int zoneId) {
	this.zoneId = zoneId;
}
public Map<String, Integer> getSparePartsInServiceCenter() {
	return sparePartsInServiceCenter;
}
public void setSparePartsInServiceCenter(Map<String, Integer> sparePartsInServiceCenter) {
	this.sparePartsInServiceCenter = sparePartsInServiceCenter;
}
@Override
public String toString() {
	return "ServiceCenter [serviceCenterId=" + serviceCenterId + ", zoneId=" + zoneId + ", sparePartsInServiceCenter="
			+ sparePartsInServiceCenter + "]";
}

}
