package com.design.spare.part.management.objects;

public class SparePart {
	private String type;
	private String sparePartID;//= modelnumber_type;
	private int qty;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSparePartID() {
		return sparePartID;
	}
	public void setSparePartID(String sparePartID) {
		this.sparePartID = sparePartID;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	@Override
	public String toString() {
		return "sparePart [type=" + type + ", sparePartID=" + sparePartID + ", qty=" + qty + "]";
	}
	
}
