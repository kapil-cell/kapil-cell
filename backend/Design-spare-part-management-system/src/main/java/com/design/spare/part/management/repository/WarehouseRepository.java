package com.design.spare.part.management.repository;
import com.design.spare.part.management.objects.ServiceCenter;
import com.design.spare.part.management.objects.Warehouse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class WarehouseRepository {
	private static final Logger log=LoggerFactory.getLogger(WarehouseRepository.class);
	
	Map<Integer,Warehouse> zonalsparepartmap=new HashMap<>();
	
	
	
	public int addSparePartsInfoInWarehouse(Warehouse warehouse) {
		int zoneId = warehouse.getZoneID();
		if(zonalsparepartmap.containsKey(zoneId)) {
			log.info("Already added info for zoneID:"+zoneId);
			return 2;
		}
		zonalsparepartmap.put(zoneId, warehouse);
		log.info("Successfully added info in zoneID"+zoneId);
		return 1;
	}
	
	public int updateSparePartsInfoInWarehouse(Warehouse warehouse){
		int zoneId = warehouse.getZoneID();
		if(!zonalsparepartmap.containsKey(zoneId)) {
			log.error("not found zoneID: "+zoneId);
			return 0;
		}
		log.info("Updating info for zoneID"+zoneId);
		Warehouse warehouseInZonalMap = zonalsparepartmap.get(zoneId);
		warehouseInZonalMap.setSpareParts(warehouse.getSpareParts());
		zonalsparepartmap.put(zoneId, warehouseInZonalMap);
		log.info("Updated successfully for zoneID"+zoneId);
		return 1;
	}
	
	public void deleteSparePartsInfoInWarehouse(int zoneId) throws Exception {
		
		if(!zonalsparepartmap.containsKey(zoneId)) {
			throw new Exception("No information found for zoneID:"+zoneId);
		}
		
		zonalsparepartmap.remove(zoneId);
		log.info("Successfully deleted info in zoneID"+zoneId);
	}

	public List<Warehouse> getInfoFromWarehouses() {
		List<Warehouse> ls = new ArrayList<>();
		for (Map.Entry<Integer,Warehouse> entry : zonalsparepartmap.entrySet()) {
			ls.add(entry.getValue()); 
		}
		return ls;
	}

	public int consumeSparePartsInWarehouse(ServiceCenter serviceCenter) {
		int zid= serviceCenter.getZoneId();
		if(!zonalsparepartmap.containsKey(zid)) {
			log.error("not found zoneID: "+zid);
			return 0;
		}
		Warehouse available=new Warehouse();
		available=zonalsparepartmap.get(zid);
		Map<String,Integer> availableParts;
		availableParts=available.getSpareParts();
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
}
