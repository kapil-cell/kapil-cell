package com.design.spare.part.management.response;

import java.util.List;

import com.design.spare.part.management.objects.ServiceCenter;

public class ServiceCenterListResponse extends AbstractResponse{
List<ServiceCenter> serviceCenterList;

public List<ServiceCenter> getServiceCenterList() {
	return serviceCenterList;
}

public void setServiceCenterList(List<ServiceCenter> serviceCenter) {
	this.serviceCenterList = serviceCenter;
}

@Override
public String toString() {
	return "ServiceCenterListResponse [serviceCenter=" + serviceCenterList + ", getCode()=" + getCode() + ", getMessage()="
			+ getMessage() + "]";
}

}
