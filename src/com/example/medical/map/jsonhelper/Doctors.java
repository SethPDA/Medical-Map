package com.example.medical.map.jsonhelper;

import java.io.Serializable;
import java.util.ArrayList;
import com.example.medical.map.jsonhelper.DoctorsPOIName;

@SuppressWarnings("serial")
public class Doctors implements Serializable {

	private int ID;
	public String Name;
	public ArrayList<DoctorsPOIName> POIName;
	public String Phone;
	private String Picture;
	public String Speciality;
	public String Surname;

	

	public Doctors(String Name, int ID, String Surname, String Phone,
			ArrayList<DoctorsPOIName> POIName, String specialname, int specialid, String Speciality, String Picture) {
		super();
		this.Name = Name;
		this.Surname = Surname;
		this.ID = ID;
		this.Phone = Phone;
		this.Speciality = Speciality;
		this.Picture = Picture;
		this.POIName = POIName;
	}
	
	

	public String getSurname() {
		return Surname;
	}

	public void setSurrname(String Surname) {
		this.Surname = Surname;
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

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String Phone) {
		this.Phone = Phone;
	}


	public String getSpeciality() {
		return Speciality;
	}

	public void setSpeciality(String Speciality) {
		this.Speciality = Speciality;
	}



	public String getPicture() {
		return Picture;
	}

	public void setPicture(String Picture) {
		this.Picture = Picture;
	}

	public ArrayList<DoctorsPOIName> getPOIName() {
		return POIName;
	}

	public void setPOIName(ArrayList<DoctorsPOIName> POIName) {
		this.POIName = POIName;
	}
	
	



}
