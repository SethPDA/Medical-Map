package com.example.medical.map.jsonhelper;

import java.io.Serializable;

@SuppressWarnings("serial")
public class DoctorsPOIName implements Serializable {

	private String Name;
	
	public DoctorsPOIName(String Name, int ID){
	
	this.Name = Name;
}

	public String getName() {
		return Name;
}

	public void setName(String name) {
		this.Name = name;
}

}