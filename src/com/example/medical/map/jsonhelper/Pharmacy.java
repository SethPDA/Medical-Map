package com.example.medical.map.jsonhelper;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Pharmacy implements Serializable {

	public String Name;
	public int ID;
	public Boolean IsSpecial;
	public String Logo;
	public String Phone;
	public String Remark;
	public String Type;
	public PharmacyAddress Address;
	private ArrayList<PharmacySpecialities> Specialities;
	private HospitalsSchedule Schedule;
	public int Rating;
	public double Latitude;
	public double Longitude;

	public Pharmacy(String Name, int ID, Boolean IsSpecial, String Logo,
			String Phone, String Remark, HospitalsSchedule Schedule,
			String Type, PharmacyAddress Address,
			ArrayList<PharmacySpecialities> Specialities, int Rating,
			int Latitude, int Longitude) {
		super();
		this.Name = Name;
		this.ID = ID;
		this.IsSpecial = IsSpecial;
		this.Logo = Logo;
		this.Phone = Phone;
		this.Remark = Remark;
		this.Type = Type;
		this.Schedule = Schedule;
		this.Address = Address;
		this.Specialities = Specialities;
		this.Rating = Rating;
		this.Latitude = Latitude;
		this.Longitude = Longitude;
	}

	public int getLongitude() {
		return (int) (Longitude * 1E6);
	}

	public void setLongitude(double longitude) {
		Longitude = longitude;
	}

	public int getLatitude() {
		return (int) (Latitude * 1E6);
	}

	public void setLatitude(double latitude) {
		Latitude = latitude;
	}

	public int getRating() {
		return Rating;
	}

	public void setRating(int rating) {
		Rating = rating;
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

	public Boolean getIsSpecial() {
		return IsSpecial;
	}

	public void setIsSpecial(Boolean IsSpecial) {
		this.IsSpecial = IsSpecial;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String Phone) {
		this.Phone = Phone;
	}

	public String getLogo() {
		return Logo;
	}

	public void setLogo(String Logo) {
		this.Logo = Logo;
	}

	public String getRemark() {
		return Remark;
	}

	public void setRemark(String Remark) {
		this.Remark = Remark;
	}

	public HospitalsSchedule getSchedule() {
		return Schedule;
	}

	public void setSchedule(HospitalsSchedule Schedule) {
		this.Schedule = Schedule;
	}

	public String getType() {
		return Type;
	}

	public void setType(String Type) {
		this.Type = Type;
	}

	public PharmacyAddress getAddress() {
		return Address;
	}

	public void setAddress(PharmacyAddress Address) {
		this.Address = Address;
	}

	public ArrayList<PharmacySpecialities> getSpecialities() {
		return Specialities;
	}

	public void setSpecialities(ArrayList<PharmacySpecialities> Specialities) {
		this.Specialities = Specialities;
	}

	@Override
	public String toString() {
		return "Pharmacy [Name=" + Name + ", ID=" + ID + ", IsSpecial="
				+ IsSpecial + ", Logo=" + Logo + ", Phone=" + Phone
				+ ", Remark=" + Remark + ", Schedule=" + Schedule + ", Type="
				+ Type + ", Address=" + Address + ", Specialities="
				+ Specialities + "]";
	}

}
