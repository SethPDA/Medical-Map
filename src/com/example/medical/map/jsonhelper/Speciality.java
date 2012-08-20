package com.example.medical.map.jsonhelper;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Speciality implements Serializable {

	private String Name;
	private	int ID;
	private String Street;
	private String City;
	private int Number;
	
	public Speciality(String Name, int ID){
	
	this.Name = Name;
	this.ID = ID;
}

	public String getName() {
		return Name;
}

	public void setName(String name) {
		this.Name = name;
}

	public int getID() {
		return ID;
}
	public void setID(int id) {
		this.ID = id;
}

	@Override
	public String toString() {
		return "Speciality [Name=" + Name + ", ID=" + ID + "]";
}

	public String getStreet() {
		return Street;
	}

	public void setStreet(String street) {
		Street = street;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public int getNumber() {
		return Number;
	}

	public void setNumber(int number) {
		Number = number;
	}




}
