package com.example.medical.map.jsonhelper;

import android.annotation.SuppressLint;
import java.io.Serializable;

@SuppressLint("ParserError")
@SuppressWarnings("serial")
public class HospitalsSpecialities implements Serializable {

	public String Name;
	public int ID;

	public HospitalsSpecialities(String Name, int ID, String IsSpecial,
			String Logo, String Phone, String Remark, String Schedule) {
		super();
		this.Name = Name;
		this.ID = ID;

	}

	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public int getId() {
		return ID;
	}

	public void setId(int ID) {
		this.ID = ID;
	}
	
	public String toString(){
		
		return this.getName();
	}

}
