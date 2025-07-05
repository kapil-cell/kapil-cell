package com.design.spare.part.management.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.design.spare.part.management.objects.ServiceCenter;

@Component
public class ServiceCenterRepository {
	private static final Logger log=LoggerFactory.getLogger(WarehouseRepository.class);
	
	Map<Integer,ServiceCenter> zonalsparepartmapservicecenter=new HashMap<>();
	
	public int addSparePartsInfoInServiceCenter(ServiceCenter serviceCenter) {
		int serviceCenterId = serviceCenter.getServiceCenterId();
		if(zonalsparepartmapservicecenter.containsKey(serviceCenterId)) {
			log.info("Already added info for serviceCenterId:"+serviceCenterId);
			return 2;
		}
		zonalsparepartmapservicecenter.put(serviceCenterId, serviceCenter);
		log.info("Successfully added info in serviceCenterId"+serviceCenterId);
		return 1;
	}

	public int updateSparePartsInfoInServiceCenter(ServiceCenter serviceCenter) {
		int sid= serviceCenter.getServiceCenterId();
		if(!zonalsparepartmapservicecenter.containsKey(sid)) {
			log.error("not found serviceCenterID: "+sid);
			return 0;
		}
		log.info("Updating info for serviceCenterID"+sid);
		ServiceCenter serviceCenterInZonalMap = zonalsparepartmapservicecenter.get(sid);
		serviceCenterInZonalMap.setSparePartsInServiceCenter(serviceCenter.getSparePartsInServiceCenter());
		zonalsparepartmapservicecenter.put(sid, serviceCenterInZonalMap);
		log.info("Updated successfully for zoneID"+sid);
		return 1;
	}

	public int consumeSparePartsInfoInServiceCenter(ServiceCenter serviceCenter) {
		int sid= serviceCenter.getServiceCenterId();
		if(!zonalsparepartmapservicecenter.containsKey(sid)) {
			log.error("not found serviceCenterID: "+sid);
			return 0;
		}
		ServiceCenter available=new ServiceCenter();
		available=zonalsparepartmapservicecenter.get(sid);
		Map<String,Integer> availableParts;
		availableParts=available.getSparePartsInServiceCenter();
		 Map<String,Integer> consumeParts;
		consumeParts=serviceCenter.getSparePartsInServiceCenter();
		int f=0;
		for (Map.Entry<String,Integer> entry : consumeParts.entrySet()) {
			String s=entry.getKey();
			int qt=entry.getValue();
			int aqt=availableParts.get(s);
			if(qt>aqt) {
				f=1;
			}
		}
		if(f==1) {
			log.error("not enough items ");
			return 0;
		}
		log.info("updating items");
		for (Map.Entry<String,Integer> entry : consumeParts.entrySet()) {
			String s=entry.getKey();
			int qt=entry.getValue();
			int aqt=availableParts.get(s);
			availableParts.put(s, aqt-qt);
		}
		log.info("items are updated");
		return 1;
	}

	public List<ServiceCenter> getInfoFromServiceCenter() {
		List<ServiceCenter> ls = new ArrayList<>();
		for (Map.Entry<Integer,ServiceCenter> entry : zonalsparepartmapservicecenter.entrySet()) {
			ls.add(entry.getValue()); 
		}
		return ls;
	}

	public int addingSparePartsInfoInServiceCenter(ServiceCenter serviceCenter) {
		int sid= serviceCenter.getServiceCenterId();
		if(!zonalsparepartmapservicecenter.containsKey(sid)) {
			log.error("not found serviceCenterID: "+sid);
			return 0;
		}
		ServiceCenter available=new ServiceCenter();
		available=zonalsparepartmapservicecenter.get(sid);
		Map<String,Integer> availableParts;
		availableParts=available.getSparePartsInServiceCenter();
		 Map<String,Integer> consumeParts;
		consumeParts=serviceCenter.getSparePartsInServiceCenter();

		log.info("updating items");
		for (Map.Entry<String,Integer> entry : consumeParts.entrySet()) {
			String s=entry.getKey();
			int qt=entry.getValue();
			if(availableParts.containsKey(s)){
			int aqt=availableParts.get(s);
			availableParts.put(s, aqt+qt);
			}
			else {
				availableParts.put(s, qt);
			}
		}
		log.info("items are updated");
		return 1;
	}
	
}
