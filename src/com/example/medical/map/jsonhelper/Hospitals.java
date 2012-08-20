package com.example.medical.map.jsonhelper;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Hospitals implements Serializable {

	public String Name;
	public int ID;
	public Boolean IsSpecial;
	public String Logo;
	public String Phone;
	public String Remark;
	public String Type;
	public HospitalsAddress Address;
	private ArrayList<HospitalsSpecialities> Specialities;
	private HospitalsSchedule Schedule;
	public int Rating;
	public double Latitude;
	public double Longitude;

	public Hospitals(String Name, int ID, Boolean IsSpecial, String Logo,
			String Phone, String Remark, HospitalsSchedule Schedule,
			String Type, HospitalsAddress Address,
			ArrayList<HospitalsSpecialities> Specialities, int Latitude,
			int Longitude, int Rating) {
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

	public HospitalsAddress getAddress() {
		return Address;
	}

	public void setAddress(HospitalsAddress Address) {
		this.Address = Address;
	}

	public ArrayList<HospitalsSpecialities> getSpecialities() {
		return Specialities;
	}

	public void setSpecialities(ArrayList<HospitalsSpecialities> Specialities) {
		this.Specialities = Specialities;
	}

	public int getLatitude() {
		return (int) (Latitude * 1E6);
	}

	public void setLatitude(double Latitude) {
		this.Latitude = Latitude;
	}

	public int getLongitude() {
		return (int) (Longitude * 1E6);
	}

	public void setLongitude(double Longitude) {
		this.Longitude = Longitude;
	}

	@Override
	public String toString() {
		return "Hospitals [Name=" + Name + ", ID=" + ID + ", IsSpecial="
				+ IsSpecial + ", Logo=" + Logo + ", Phone=" + Phone
				+ ", Remark=" + Remark + ", Type=" + Type + ", Address="
				+ Address + ", Specialities=" + Specialities + "]";
	}

}
