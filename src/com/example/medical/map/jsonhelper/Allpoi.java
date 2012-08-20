package com.example.medical.map.jsonhelper;

import java.io.Serializable;
import com.example.medical.map.jsonhelper.Speciality;

@SuppressWarnings("serial")
public class Allpoi implements Serializable {

	public String Name;
	private int ID;
	public String Phone;
	public String IsSpecial;
	public String Logo;
	public String Type;
	private Speciality Specialities;

	public Allpoi(String Name, int ID, String Phone, Speciality Specialities, String Logo, String IsSpecial, String Type) {
		super();
		this.Name = Name;
		this.ID = ID;
		this.Phone = Phone;
		this.Specialities = Specialities;
		this.IsSpecial = IsSpecial;
		this.Logo = Logo;
		this.Type = Type;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		this.Name = name;
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

	public Speciality getSpeciality() {
		return Specialities;
	}

	public void setSpeciality(Speciality Specialities) {
		this.Specialities = Specialities;
	}
	
	public String getIsSpecial() {
		return IsSpecial;
	}

	public void setIsSpecial(String IsSpecial) {
		this.IsSpecial = IsSpecial;
	}
	
	public String getLogo() {
		return Logo;
	}

	public void setLogo(String Logo) {
		this.Logo = Logo;
	}
	
	public String getType() {
		return Type;
	}

	public void setType(String type) {
		this.Type = type;
	}

	@Override
	public String toString() {
		return "Doctors [Name=" + Name + ", ID="
				+ ID + ", IsSpecial=" + IsSpecial + ", Logo=" + Logo + ", Type=" + Type + "]";
	}

}
