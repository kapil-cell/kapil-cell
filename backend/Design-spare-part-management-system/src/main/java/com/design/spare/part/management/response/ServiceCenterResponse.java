package com.design.spare.part.management.response;

import com.design.spare.part.management.objects.ServiceCenter;


public class ServiceCenterResponse extends AbstractResponse {
	ServiceCenter serviceCenter;

	public ServiceCenter getSparePartsServiceCenter() {
		return serviceCenter;
	}

	public void setSparePartsServiceCenter(ServiceCenter serviceCenter) {
		this.serviceCenter = serviceCenter;
	}

	@Override
	public String toString() {
		return "ServiceCenterResponse [sparePartsServiceCenter=" + serviceCenter + ", getCode()=" + getCode()
				+ ", getMessage()=" + getMessage() + "]";
	}
	
}
