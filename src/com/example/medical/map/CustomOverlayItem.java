package com.example.medical.map;

import com.example.medical.map.jsonhelper.Hospitals;
import com.example.medical.map.jsonhelper.Pharmacy;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.OverlayItem;

public class CustomOverlayItem extends OverlayItem {

	Hospitals hospitals;
	Pharmacy pharmacy;

	public CustomOverlayItem(Hospitals hospitals) {
		super(new GeoPoint((int) (hospitals.Latitude * 1E6),
				(int) (hospitals.Longitude * 1E6)), hospitals.Name,
				hospitals.Type);
		this.hospitals = hospitals;
		this.pharmacy =null;

	}
	
	public CustomOverlayItem(Pharmacy pharmacy) {
		super(new GeoPoint((int) (pharmacy.Latitude * 1E6),
				(int) (pharmacy.Longitude * 1E6)), pharmacy.Name,
				pharmacy.Type);
		this.hospitals = null;
		this.pharmacy = pharmacy;

	}
	

	public String getImageURL() {
	
		if(hospitals!=null)
		{
			return hospitals.getLogo();
		}else
		{
			return pharmacy.getLogo();
		}
		

	}

	public Hospitals getHospitals() {
		return hospitals;
	}

	public Pharmacy getPharmacy() {
		return pharmacy;
	}
	
	
	
}
