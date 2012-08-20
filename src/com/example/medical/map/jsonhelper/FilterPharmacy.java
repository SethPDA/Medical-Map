package com.example.medical.map.jsonhelper;

public class FilterPharmacy {
	
	String name;
	String address;
	String poiType;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPoiType() {
		return poiType;
	}
	public void setPoiType(String poiType) {
		this.poiType = poiType;
	}
	
	
	@Override
	public String toString() {
		return "filterHospital [name=" + name + ", address=" + address
				+ ", poiType=" + poiType + "]";
	}

}
