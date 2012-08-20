package com.example.medical.map.jsonhelper;

import java.io.Serializable;

@SuppressWarnings("serial")
public class PharmacyAddress implements Serializable {

	public String City;
	public int ID;
	public int Number;
	public String Street;

	public PharmacyAddress(String City, int ID, String Street, int Number) {
		super();
		this.City = City;
		this.ID = ID;
		this.Street = Street;
		this.Number = Number;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String City) {
		this.City = City;
	}

	public int getId() {
		return ID;
	}

	public void setId(int ID) {
		this.ID = ID;
	}

	public String getStreet() {
		return Street;
	}

	public void setStreet(String Street) {
		this.Street = Street;
	}

	public int getNumber() {
		return Number;
	}

	public void setNumber(int Number) {
		this.Number = Number;
	}

}
